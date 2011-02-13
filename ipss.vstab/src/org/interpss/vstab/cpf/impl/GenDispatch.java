package org.interpss.vstab.cpf.impl;

import java.util.HashMap;
import java.util.Hashtable;

import org.apache.commons.math.linear.ArrayRealVector;
import org.apache.commons.math.linear.RealVector;
import org.interpss.vstab.cpf.GenDispPattern.GenDispPtn;

import com.interpss.common.util.IpssLogger;
import com.interpss.core.aclf.AclfBus;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.net.Bus;
/**
 * This class is for power dispatching whenever power mismatch happens between Generation and Load in a network;
 * @author Tony Huang
 *
 */
public class GenDispatch {

    private int numofGen=0;
    private Hashtable<Integer,Double> genPmax; //=new Matrix(numofGen,2);
    private Hashtable<Integer,Double> genP0;
    private AclfNetwork net;
    private GenDispPtn ptn;
    private Hashtable<String,Double> customGenDispTbl;
    public GenDispatch(AclfNetwork net, GenDispPtn genDispPtn){
    	this.net=net;
    	this.ptn=genDispPtn;
    	initialize();
    }
    
	public  void genDispatch(double pMismatch){
		if(this.ptn==GenDispPtn.AGC){
			genDispByAGC(pMismatch);
		}
		else if (this.ptn==GenDispPtn.RESERVE_PROPORTION){
			genDispByResvProp(pMismatch);
		}
		else if(this.ptn==GenDispPtn.CUSTOM_SPECIFIC){
			genDispByCustSpec(pMismatch);
		}
	}
	public void genDispByAGC(double pMismatch){
		throw new UnsupportedOperationException();
	}
	public void genDispByCustSpec(double pMismatch){
		throw new UnsupportedOperationException();
	}
	public  void genDispByResvProp(double pMismatch){
	{
		/*
		 * 1.run power flow first,get the result ,here the gen P AND Q are needed
		 * 2.get the gen power reserve  .
		 * 3.generation dispatch according to the proportion of gen RESERVE of each gen.
		 */
		IpssLogger.getLogger().info("-- starting gen dispatch by Reservation-Proportion method-- ");

		double sumofDgenP=0;
		ArrayRealVector DgenP=new ArrayRealVector(numofGen);                                               
		AclfBus objbus =null ;
		int j=0;
		for(int i:this.genPmax.keySet()){
	    	 objbus =(AclfBus) net.getBusList().get(i);
	    	 
			    double deltaP=genPmax.get(i)-objbus.getGenP();
		        if (deltaP<=0){
		            objbus.setGenP(genPmax.get(i)); 
		            DgenP.setEntry(j, 0);
		        }
		        else {DgenP.setEntry(j,  deltaP) ;}
		        j++;
	     }  
      
		//sumofDgenP=sumOfElement(DgenP);
		sumofDgenP=DgenP.getL1Norm(); // get the sum of all element ,since all are positive
		j=0;
		for(int i:this.genPmax.keySet()){
			objbus =(AclfBus) net.getBusList().get(i);
	        	double DPi=DgenP.getEntry(j)/sumofDgenP*pMismatch;
	        	if (DgenP.getEntry(j)>0) { objbus.setGenP(genP0.get(i)+DPi);}
	        	j++;
	     }
		IpssLogger.getLogger().info("--end gen dispatch--");
	}
   }


	private void initialize(){
		this.genP0=new Hashtable<Integer, Double>(this.net.getNoBus());
		this.genPmax=new Hashtable<Integer, Double>(this.net.getNoBus());
		for(int i=0;i<this.net.getBusList().size();i++){
			AclfBus bus=(AclfBus)this.net.getBusList().get(i);
			if(bus.isGen()){
				this.genP0.put(i, bus.getGenP());
				this.genPmax.put(i,bus.getPGenLimit().getMax());
			}
			
		}
	}
	private int getNoGenBus(AclfNetwork net){
		int numGen=0;
		for (Bus bus:net.getBusList()){
			 AclfBus acbus=(AclfBus) bus;
			 if(acbus.isActive()&&acbus.isGen()){
				numGen++;
			 }
		}
		this.numofGen=numGen;
		return this.numofGen;
	}
}
