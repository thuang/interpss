package org.interpss.sample.acsc;

import static com.interpss.core.funcImpl.AcscFunction.*;

import org.apache.commons.math3.complex.Complex;
import org.interpss.numeric.datatype.Unit.UnitType;

import com.interpss.CoreObjectFactory;
import com.interpss.common.datatype.UnitHelper;
import com.interpss.core.aclf.AclfBranchCode;
import com.interpss.core.acsc.AcscBranch;
import com.interpss.core.acsc.AcscBus;
import com.interpss.core.acsc.AcscNetwork;
import com.interpss.core.acsc.BusScCode;
import com.interpss.core.acsc.SequenceCode;
import com.interpss.core.acsc.XfrConnectCode;
import com.interpss.core.acsc.adpter.AcscPSXformer;
import com.interpss.core.acsc.adpter.AcscXformer;

/**
 * This class was generated by a SmartGuide.
 *
 */

public class AcscInputUtilFunc {
	/**
	 * Add a contributing bus to the network object
	 * 
	 * @param net
	 * @param busId
	 * @param baseVolt
	 * @param noArea
	 * @param noZone
	 * @param r1
	 * @param x1
	 * @param r2
	 * @param x2
	 * @param r0
	 * @param x0
	 * @param zUnit
	 * @param gCode
	 * @param rg
	 * @param xg
	 * @param gzUnit
	 * @return
	 */
	public static AcscBus addScContributeBusTo(AcscNetwork net, String busId, String name,
				double baseVolt, int noArea, int noZone,
				double r1,    double x1,
				double r2,    double x2,
				double r0,    double x0, UnitType zUnit,   
				String   gCode, double rg, double xg, UnitType gzUnit) {
		AcscBus bus = CoreObjectFactory.createAcscBus(busId, net);
		//net.addBus(bus);	
		bus.setName(name);
		bus.setScCode(BusScCode.CONTRIBUTE);
		bus.setBaseVoltage(baseVolt, UnitType.Volt );
		bus.setScZ(new Complex(r1, x1), SequenceCode.POSITIVE, zUnit);
		bus.setScZ(new Complex(r2, x2), SequenceCode.NEGATIVE, zUnit);
		bus.setScZ(new Complex(r0, x0), SequenceCode.ZERO, zUnit);
		bus.getGrounding().setCode(Str2ScGroundCode.f(gCode));
		bus.getGrounding().setZ(new Complex(rg,xg), gzUnit, bus.getBaseVoltage(), net.getBaseKva());
		return bus;
	}

	/**
	 * Add a non-contributing bus to the network object
	 * 
	 * @param net
	 * @param id
	 * @param baseV
	 * @param noArea
	 * @param noZone
	 * @return
	 */
	public static AcscBus addScNonContributeBusTo(AcscNetwork net, String id, String name,
						double baseV, int noArea, int noZone) {
		AcscBus bus = CoreObjectFactory.createAcscBus(id, net);
		//net.addBus(bus);
		bus.setName(name);
		bus.setScCode(BusScCode.NON_CONTRI);
		bus.setBaseVoltage(baseV, UnitType.Volt );
		bus.setScZ(new Complex(0.0, 1.0e10), SequenceCode.POSITIVE);
		bus.setScZ(new Complex(0.0, 1.0e10), SequenceCode.NEGATIVE);
		bus.setScZ(new Complex(0.0, 1.0e10), SequenceCode.ZERO);
		return bus;
	}
	
	/**
	 * Add a line branch to the network object
	 * 
	 * @param net
	 * @param branchFromBusId
	 * @param branchToBusId
	 * @param r1
	 * @param x1
	 * @param r0
	 * @param x0
	 * @param zUnit
	 * @param msg
	 * @return
	 */
	public static AcscBranch addAcscLineBranchTo(AcscNetwork net, String branchFromBusId, String branchToBusId, String name,
			double r1,	double x1, double r0, double x0, UnitType zUnit) {
		AcscBranch branch = CoreObjectFactory.createAcscBranch();
		branch.setName(name);
		net.addBranch(branch, branchFromBusId, branchToBusId);
		branch.setBranchCode(AclfBranchCode.LINE);
		double baseVolt = branch.getFromAclfBus().getBaseVoltage(); 
		branch.setZ( UnitHelper.zConversion(new Complex(r1,x1), baseVolt, net.getBaseKva(), zUnit, UnitType.PU));
		branch.setZ0( UnitHelper.zConversion(new Complex(r0,x0), baseVolt, net.getBaseKva(), zUnit, UnitType.PU));
		return branch;
	}

	/**
	 * Add a xfr branch to the network object
	 * 
	 * @param net
	 * @param branchFromBusId
	 * @param branchToBusId
	 * @param r1
	 * @param x1
	 * @param r0
	 * @param x0
	 * @param zUnit
	 * @param fromConCode
	 * @param fromRg
	 * @param fromXg
	 * @param toConCode
	 * @param toRg
	 * @param toXg
	 * @param zgUnit
	 * @param msg
	 * @return
	 */
	public static AcscBranch addAcscXformerBranchTo(AcscNetwork net, String branchFromBusId, String branchToBusId, String name,
			double r1,	double x1, double r0, double x0, UnitType zUnit, 
			XfrConnectCode fromConCode, double fromRg, double fromXg,
			XfrConnectCode toConCode, double toRg, double toXg, UnitType zgUnit) {
		AcscBranch branch = CoreObjectFactory.createAcscBranch();
		branch.setName(name);
		branch.setBranchCode(AclfBranchCode.XFORMER);
		net.addBranch(branch, branchFromBusId, branchToBusId);
  		double baseVolt = branch.getFromAclfBus().getBaseVoltage() > branch.getToAclfBus().getBaseVoltage() ?
		           branch.getFromAclfBus().getBaseVoltage() : branch.getToAclfBus().getBaseVoltage();
		branch.setZ( UnitHelper.zConversion(new Complex(r1,x1), baseVolt, net.getBaseKva(), zUnit, UnitType.PU));
		branch.setZ0( UnitHelper.zConversion(new Complex(r0,x0), baseVolt, net.getBaseKva(), zUnit, UnitType.PU));
		AcscXformer xfr = AcscXfrAptr.f(branch);
		xfr.setFromConnectGroundZ(fromConCode, new Complex(fromRg,fromXg), zgUnit);
		xfr.setToConnectGroundZ(toConCode, new Complex(toRg,toXg), zgUnit);
		return branch;
	}

	/**
	 * Add a PSXfr branch to the network object
	 * 
	 * @param net
	 * @param branchFromBusId
	 * @param branchToBusId
	 * @param r1
	 * @param x1
	 * @param r0
	 * @param x0
	 * @param zUnit
	 * @param fromAng
	 * @param toAng
	 * @param angUnit
	 * @param fromConCode
	 * @param fromRg
	 * @param fromXg
	 * @param toConCode
	 * @param toRg
	 * @param toXg
	 * @param zgUnit
	 * @param msg
	 * @return
	 */
	public static AcscBranch addAcscPSXfromerBranchTo(AcscNetwork net, String branchFromBusId, String branchToBusId, String name,
			double r1,	double x1, double r0, double x0, UnitType zUnit, 
			double fromAng, double toAng, UnitType angUnit,
			XfrConnectCode fromConCode, double fromRg, double fromXg,
			XfrConnectCode toConCode, double toRg, double toXg, UnitType zgUnit) {
		AcscBranch branch = CoreObjectFactory.createAcscBranch();
		branch.setName(name);
		branch.setBranchCode(AclfBranchCode.XFORMER);
		net.addBranch(branch, branchFromBusId, branchToBusId);
  		double baseVolt = branch.getFromAclfBus().getBaseVoltage() > branch.getToAclfBus().getBaseVoltage() ?
		           branch.getFromAclfBus().getBaseVoltage() : branch.getToAclfBus().getBaseVoltage();
		branch.setZ( UnitHelper.zConversion(new Complex(r1,x1), baseVolt, net.getBaseKva(), zUnit, UnitType.PU));
		branch.setZ0( UnitHelper.zConversion(new Complex(r0,x0), baseVolt, net.getBaseKva(), zUnit, UnitType.PU));
		AcscPSXformer xfr = AcscPSXfrAptr.f(branch);
		xfr.setFromAngle(fromAng, angUnit);
		xfr.setToAngle(toAng, angUnit);
		xfr.setFromConnectGroundZ(fromConCode, new Complex(fromRg,fromXg), zgUnit);
		xfr.setToConnectGroundZ(toConCode, new Complex(toRg,toXg), zgUnit);
		return branch;
	}
}