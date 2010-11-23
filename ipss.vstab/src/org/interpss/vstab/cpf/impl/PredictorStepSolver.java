package org.interpss.vstab.cpf.impl;
import java.util.Iterator;

import org.apache.commons.math.complex.Complex;
import org.apache.commons.math.linear.ArrayRealVector;
import org.interpss.vstab.cpf.AbstractStepSolver;

import com.interpss.common.datatype.Vector_xy;
import com.interpss.common.exp.InterpssException;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.core.aclf.AclfBus;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.common.visitor.IAclfBusVisitor;
import com.interpss.core.net.Bus;
/**
 * A Solver for predictor Step, to calculate the tangent vector and to find a good initial guess for 
 * the corrector step.
 * 
 * @author Tony Huang
 *
 */

public class PredictorStepSolver extends AbstractStepSolver{
	protected boolean isCrossMPP=false;
	protected boolean stepSizeCntrl=false;
	private final double DEFAULT_STEP_SIZE=0.3;
	private double stepSize=DEFAULT_STEP_SIZE;
	private double oldStepSize=0;
	private CpfHelper cpfHelper=null;
	private ArrayRealVector deltaX_Lambda=null;
	/**
	 *  the constructor of the PredictorStepSolver class
	 * @param net
	 * @param msg
	 */
	public PredictorStepSolver(AclfNetwork net,IPSSMsgHub msg) {
		super(net, msg);
		cpfHelper=new CpfHelper(net,msg);
	}
	/**
	 * a step Solver, overrides the same method of AbstractStepSolver 
	 */
	@Override
    public boolean stepSolver() {
    	if(isStepSizeControl()) {
    		applyStepSizeControl();
    	}
    	else {
    		if(!calDeltaPredResult()) {
    			return false;
    		}
    		
    	}
    	updateBusVoltage();
    	return true;
    }
	/**
	 * To update voltage of all buses after successful solving, overrides the same method of AbstractStepSolver 
	 */
	@Override
    public void updateBusVoltage() {
		double x = this.stepSize;
		if(isStepSizeControl()) {
			x=this.stepSize-this.oldStepSize;
		}

		final double actualStep=x;
    	this.net.forEachAclfBus(new IAclfBusVisitor() {
			public void visit(AclfBus bus) {
			  if((!bus.isSwing())&bus.isActive()) {
				 Vector_xy v=augmentedJacobi.getBVect_xy(bus.getSortNumber());
				 double vang=bus.getVoltageAng();
				 double vmag=bus.getVoltageMag();
				 if(!bus.isGenPV()) {
					 vmag-=actualStep*vmag*v.y;
				  }
				 
				 vang-=actualStep*v.x;
				 bus.setVoltage(vmag,vang);
			  }
		  }		
    	});
    }
	/**
	 * calculate the tangent vector
	 * @return
	 */
    private boolean calDeltaPredResult() {
    
   	this.augmentedJacobi=cpfHelper.formAugmJacobiMatrix();

     //   set the [B] elements(right-hand side of Jacobian matrix) to [0,+-1] ,
     //   only the element corresponding to Continuous parameter is set to +1,or -1, depending on the slope of continuous parameter
   	
    int contParaSign=getContParaSign();  
    augmentedJacobi.setBi(new Complex(1*contParaSign,0),getSortNumofContParam());

     // solve Jau*[dx,dLamda]T=[0,+-1]
     
    try {
		if (!augmentedJacobi.luMatrixAndSolveEqn(this.tolerance, msg)) {
			return false;
		}
	} catch (InterpssException e) {
		e.printStackTrace();
	}
    
	// save tangent vector result to DeltaX_Lamba
 
    saveDeltaRslt2Vctr();
    
    return true;
    }
    

    public boolean isCrossMaxPwrPnt() {
    	// only sign of Lambda is used for judgment.
    	if(this.sortNumofContParam!=this.net.getNoBus()+1) {
    		if(deltaX_Lambda.getEntry(deltaX_Lambda.getDimension())<0)
    			return this.isCrossMPP=true;
    	}
    	return this.isCrossMPP=false;
    }
    private int getContParaSign() {
    	if(isCrossMaxPwrPnt()) {
    		return  +1;
    	}
    	else return -1;
    }
    private void saveDeltaRslt2Vctr() {
    	this.deltaX_Lambda=new ArrayRealVector(this.augmentedJacobi.getDimension()-1); // swing bus is included
    	int i=0;
    	for (Iterator localIterator = this.net.getBusList().iterator(); localIterator.hasNext(); ) { Bus b = (Bus)localIterator.next();
            i=b.getSortNumber();
            Vector_xy dv=this.augmentedJacobi.getBVect_xy(i);   
            this.deltaX_Lambda.setEntry(2*1-2, dv.x);
            this.deltaX_Lambda.setEntry(2*i-1, dv.y);
        }
    	i=this.augmentedJacobi.getDimension()-1; // lambda index 
    	double deltaL=this.augmentedJacobi.getBVect_xy(i).x;
        this.deltaX_Lambda.setEntry(i, deltaL);
    }
    protected boolean isStepSizeControl() {
    	return this.stepSizeCntrl;
    }
    public void enableStepSizeControl(boolean stepControl) {
    	this.stepSizeCntrl=stepControl;
    }
    private void applyStepSizeControl() {
    	this.oldStepSize=stepSize;
    	this.stepSize*=0.5; // cut to the half of last step size
    	
    }

}