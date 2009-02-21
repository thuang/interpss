 /*
  * @(#)SampleLoadflow.java   
  *
  * Copyright (C) 2006 www.interpss.org
  *
  * This program is free software; you can redistribute it and/or
  * modify it under the terms of the GNU LESSER GENERAL PUBLIC LICENSE
  * as published by the Free Software Foundation; either version 2.1
  * of the License, or (at your option) any later version.
  *
  * This program is distributed in the hope that it will be useful,
  * but WITHOUT ANY WARRANTY; without even the implied warranty of
  * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
  * GNU General Public License for more details.
  *
  * @Author Mike Zhou
  * @Version 1.0
  * @Date 09/15/2006
  * 
  *   Revision History
  *   ================
  *
  */

package org.interpss.sample.aclf;

import org.apache.commons.math.complex.Complex;
import org.interpss.display.AclfOutFunc;

import com.interpss.common.datatype.UnitType;
import com.interpss.core.aclf.AclfBranchCode;
import com.interpss.core.aclf.AclfGenCode;
import com.interpss.core.aclf.AclfLoadCode;
import com.interpss.core.aclfadj.AclfAdjNetwork;
import com.interpss.core.algorithm.AclfMethod;
import com.interpss.simu.dsl.IpssAclf;


public class SampleLoadflowDSL {
	public static void main(String args[]) {
		AclfAdjNetwork net = IpssAclf.createAclfNetwork("Sample AclfNetwork")
				.setBaseKva(100000.0)
				.getAclfNet();

		IpssAclf.addAclfBus("Bus1", "Bus 1", net)
				.setBaseVoltage(4000.0)
				.setGenCode(AclfGenCode.SWING)
				.setVoltage(1.0, UnitType.PU, 0.0, UnitType.Deg)
				.setLoadCode(AclfLoadCode.NON_LOAD);
	
		IpssAclf.addAclfBus("Bus2", "Bus 2", net)
				.setBaseVoltage(4000.0)
				.setGenCode(AclfGenCode.NON_GEN)
				.setLoadCode(AclfLoadCode.CONST_P)
				.setLoad(new Complex(1.0, 0.8), UnitType.PU);
	
		IpssAclf.addAclfBranch("Bus1", "Bus2", "Branch 1", net)
				.setBranchCode(AclfBranchCode.LINE)
				.setZ(new Complex(0.05, 0.1), UnitType.PU);
		
	  	// create the default loadflow algorithm
	  	IpssAclf.createLoadflowAlgorithm(net)
	  			.setLfMethod(AclfMethod.NR)
	  			.setTolerance(0.0001, UnitType.PU)
	  			.runLoadflow();

	  	// output loadflow calculation results
	  	System.out.println(AclfOutFunc.loadFlowSummary(net));
	}	
}
