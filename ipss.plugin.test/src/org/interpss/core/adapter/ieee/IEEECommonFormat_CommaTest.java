 /*
  * @(#)Test_IEEECommonFormat_Comma.java   
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

package org.interpss.core.adapter.ieee;

import static org.junit.Assert.assertTrue;

import org.interpss.BaseTestSetup;
import org.interpss.custom.IpssFileAdapter;
import org.junit.Test;

import com.interpss.common.datatype.UnitType;
import com.interpss.core.aclf.AclfBus;
import com.interpss.core.aclf.AclfNetwork;
import com.interpss.core.aclf.adpter.SwingBusAdapter;
import com.interpss.pssl.plugin.IpssAdapter;
import com.interpss.pssl.simu.IpssAclf;

public class IEEECommonFormat_CommaTest extends BaseTestSetup {
	@Test 
	public void testCase1() throws Exception {
		IpssFileAdapter adapter = IpssAdapter.importAclfNet()
					.setFormat(IpssAdapter.FileFormat.IEEECommonFormat)
					.getAdapter();
		
		AclfNetwork net = IpssAdapter.wrapAdapter(adapter)
					.setFilename("testData/ieee_format/ieee14_comma.ieee")
					.load();

		//System.out.println(adapter.getODMModelParser().toString());
		
	  	IpssAclf.createLoadflowAlgorithm(net)
					.runLoadflow();

		assertTrue((net.getBusList().size() == 14 && net.getBranchList().size() == 20));

	  	//System.out.println(net.net2String());
  		assertTrue(net.isLfConverged());		
  		AclfBus swingBus = (AclfBus)net.getBus("Bus1");
		SwingBusAdapter swing = (SwingBusAdapter)swingBus.getAdapter(SwingBusAdapter.class);
  		assertTrue(Math.abs(swing.getGenResults(UnitType.PU, net.getBaseKva()).getReal()-2.32393)<0.0001);
  		assertTrue(Math.abs(swing.getGenResults(UnitType.PU, net.getBaseKva()).getImaginary()+0.16549)<0.0001);
	}
}

