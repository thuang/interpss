 /*
  * @(#)UCTE_ODMTest.java   
  *
  * Copyright (C) 2008 www.interpss.org
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
  * @Date 02/01/2008
  * 
  *   Revision History
  *   ================
  *
  */

package org.ieee.pes.odm.pss.test.ucte;

import static org.junit.Assert.assertTrue;

import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.ieee.cmte.psace.oss.odm.pss.schema.v1.ApparentPowerUnitType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.BranchRecordXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.BusRecordXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.CurrentUnitType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.LFBranchCodeEnumType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.LFGenCodeEnumType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.PSSNetworkXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.VoltageUnitType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.YUnitType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.ZUnitType;
import org.ieee.pes.odm.pss.adapter.IODMPSSAdapter;
import org.ieee.pes.odm.pss.adapter.ucte.UCTE_DEFAdapter;
import org.ieee.pes.odm.pss.model.ODMData2XmlHelper;
import org.junit.Test;

public class UCTE_ODMTest {
	@Test
	public void testCase1() throws Exception {
		final LogManager logMgr = LogManager.getLogManager();
		Logger logger = Logger.getLogger("IEEE ODM Logger");
		logger.setLevel(Level.INFO);
		logMgr.addLogger(logger);
		
		IODMPSSAdapter adapter = new UCTE_DEFAdapter(logger);
		assertTrue(adapter.parseInputFile("testdata/ucte/AusPower_TestCase_Xfr.uct"));
		
		PSSNetworkXmlType baseCaseNet = adapter.getModel().getBaseCase();
		assertTrue(baseCaseNet.getBusList().getBusArray().length == 18);
		assertTrue(baseCaseNet.getBranchList().getBranchArray().length == 30);
		
		// A1____1 is a load bus, voltage code 1 -> 380kv
		// A1    1                 0        280.000 .000000 .000000 .000000               
		BusRecordXmlType busRec = ODMData2XmlHelper.getBusRecord("A1____1", baseCaseNet);
		assertTrue(busRec.getBaseVoltage().getValue() == 380.0);
		assertTrue(busRec.getBaseVoltage().getUnit() == VoltageUnitType.KV);
		// if voltage not defined, it is equal to the base voltage
		assertTrue(busRec.getLoadflowData().getVoltage().getValue() == 380.0);
		assertTrue(busRec.getLoadflowData().getVoltage().getUnit() == VoltageUnitType.KV);
		assertTrue(busRec.getLoadflowData().getGenData() == null);
		assertTrue(busRec.getLoadflowData().getLoadData().getEquivLoad().getConstPLoad().getRe() == 280.0);
		assertTrue(busRec.getLoadflowData().getLoadData().getEquivLoad().getConstPLoad().getIm() == 0.0);
		assertTrue(busRec.getLoadflowData().getLoadData().getEquivLoad().getConstPLoad().getUnit() == ApparentPowerUnitType.MVA);
		assertTrue(busRec.getLoadflowData().getShuntY() == null);

		// A2____1 is a load bus
		// A2    1                 0        .000000 .000000 -150.00 .000000                
		busRec = ODMData2XmlHelper.getBusRecord("A2____1", baseCaseNet);
		assertTrue(busRec.getLoadflowData().getGenData().getCode() == LFGenCodeEnumType.PQ);
		assertTrue(busRec.getLoadflowData().getGenData().getEquivGen().getPower().getRe() == 150.0);
		assertTrue(busRec.getLoadflowData().getGenData().getEquivGen().getPower().getIm() == 0.0);
		assertTrue(busRec.getLoadflowData().getGenData().getEquivGen().getPower().getUnit() == ApparentPowerUnitType.MVA);
		assertTrue(busRec.getLoadflowData().getLoadData() == null);
		
		// B4____1 is a swing bus
		// B4    1                 3 405.00 70.0000 .000000 .000000 .000000                
		busRec = ODMData2XmlHelper.getBusRecord("B4____1", baseCaseNet);
		assertTrue(busRec.getLoadflowData().getVoltage().getValue() == 405.0);
		assertTrue(busRec.getLoadflowData().getVoltage().getUnit() == VoltageUnitType.KV);
		assertTrue(busRec.getLoadflowData().getAngle().getValue() == 0.0);
		assertTrue(busRec.getLoadflowData().getGenData().getCode() == LFGenCodeEnumType.SWING);
		assertTrue(busRec.getLoadflowData().getLoadData().getEquivLoad().getConstPLoad().getRe() == 70.0);
		assertTrue(busRec.getLoadflowData().getLoadData().getEquivLoad().getConstPLoad().getIm() == 0.0);
		assertTrue(busRec.getLoadflowData().getLoadData().getEquivLoad().getConstPLoad().getUnit() == ApparentPowerUnitType.MVA);

		// A1____1->A2____1 is a line
		// A1    1  A2    1  1 0 1.3600 19.350 240.9601    480 
		BranchRecordXmlType braRec = ODMData2XmlHelper.getBranchRecord("A1____1", "A2____1", "1", baseCaseNet);
		assertTrue(braRec.getLoadflowData().getCode() == LFBranchCodeEnumType.LINE); 
		assertTrue(braRec.getLoadflowData().getLineData().getZ().getRe() == 1.3600); 
		assertTrue(braRec.getLoadflowData().getLineData().getZ().getIm() == 19.350); 
		assertTrue(braRec.getLoadflowData().getLineData().getZ().getUnit() == ZUnitType.OHM); 
		assertTrue(braRec.getLoadflowData().getLineData().getTotalShuntY().getRe() == 0.0); 
		assertTrue(braRec.getLoadflowData().getLineData().getTotalShuntY().getIm() == 240.9601); 
		assertTrue(braRec.getLoadflowData().getLineData().getTotalShuntY().getUnit() == YUnitType.MICROMHO); 
		assertTrue(braRec.getLoadflowData().getRatingLimit().getCurrent().getValue() == 480.0); 
		assertTrue(braRec.getLoadflowData().getRatingLimit().getCurrent().getUnit() == CurrentUnitType.AMP); 
		
		// D1____1->D3____2 is a Xfr
		// D1    1  D3    2  1 0 400.  230.  600.0 .20000 15.000 -16.0000 5.0000   1000 
		braRec = ODMData2XmlHelper.getBranchRecord("D1____1", "D3____2", "1", baseCaseNet);
		assertTrue(braRec.getLoadflowData().getCode() == LFBranchCodeEnumType.TRANSFORMER); 
		assertTrue(braRec.getLoadflowData().getXformerData().getZ().getRe() == 0.20); 
		assertTrue(braRec.getLoadflowData().getXformerData().getZ().getIm() == 15.0); 
		assertTrue(braRec.getLoadflowData().getXformerData().getZ().getUnit() == ZUnitType.OHM); 		
		
		assertTrue(braRec.getLoadflowData().getXformerData().getFromTap().getValue() == 0.0); // from ratio not defined 
		assertTrue(braRec.getLoadflowData().getXformerData().getToTap().getValue() == 1.0); 

		assertTrue(braRec.getLoadflowData().getXformerData().getFromShuntY() == null); 
		assertTrue(braRec.getLoadflowData().getXformerData().getToShuntY().getRe() == 5.0); 
		assertTrue(braRec.getLoadflowData().getXformerData().getToShuntY().getIm() == -16.0); 
		assertTrue(braRec.getLoadflowData().getXformerData().getToShuntY().getUnit() == YUnitType.MICROMHO); 
		
		assertTrue(braRec.getLoadflowData().getXformerData().getRatingData().getFromRatedVoltage().getValue() == 400.0); 		
		assertTrue(braRec.getLoadflowData().getXformerData().getRatingData().getFromRatedVoltage().getUnit() == VoltageUnitType.KV); 		
		assertTrue(braRec.getLoadflowData().getXformerData().getRatingData().getToRatedVoltage().getValue() == 230.0); 		
		assertTrue(braRec.getLoadflowData().getXformerData().getRatingData().getToRatedVoltage().getUnit() == VoltageUnitType.KV); 		
		assertTrue(braRec.getLoadflowData().getXformerData().getRatingData().getRatedPower().getValue() == 600.0); 		
		assertTrue(braRec.getLoadflowData().getXformerData().getRatingData().getRatedPower().getUnit() == ApparentPowerUnitType.MVA); 		
		
		assertTrue(braRec.getLoadflowData().getRatingLimit().getCurrent().getValue() == 1000.0); 
	}
}

