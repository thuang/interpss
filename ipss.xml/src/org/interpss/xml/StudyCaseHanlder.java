/*
 * @(#)StudyCaseHanlder.java   
 *
 * Copyright (C) 2006-2008 www.interpss.org
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
 * @Date 09/15/2008
 * 
 *   Revision History
 *   ================
 *
 */

package org.interpss.xml;

import org.interpss.schema.AclfAlgorithmXmlType;
import org.interpss.schema.AclfStudyCaseXmlType;
import org.interpss.schema.AcscFaultCategoryDataType;
import org.interpss.schema.AcscFaultDataType;
import org.interpss.schema.AcscFaultXmlType;
import org.interpss.schema.AcscStudyCaseXmlType;
import org.interpss.schema.DStabStudyCaseXmlType;
import org.interpss.schema.DclfBranchSensitivityXmlType;
import org.interpss.schema.DclfStudyCaseXmlType;
import org.interpss.schema.DynamicEventDataType;
import org.interpss.schema.GridComputingXmlType;
import org.interpss.schema.InterPSSDocument;


public class StudyCaseHanlder {
	private InterPSSDocument ipssXmlDoc;

	public StudyCaseHanlder(InterPSSDocument ipssXmlDoc) {
		this.ipssXmlDoc = ipssXmlDoc;
	}
	
	/**
	 * Get the Ipss Xml document
	 * 
	 * @return
	 */
	public InterPSSDocument getIpssXmlDoc() {
		return this.ipssXmlDoc;
	}
	
	/**
	 * Get the grid computing option record from the Ipss Xml document
	 * 
	 * @return
	 */
	public GridComputingXmlType getGridOption() {
		return this.ipssXmlDoc.getInterPSS().getRunStudyCase().getGridRunOption();
	}
	
	// Aclf Study Case
	// ===============
	
	/**
	 * Delete the study case
	 * 
	 * @param casename
	 * @return true if deleted
	 */
	public boolean deleteAclfStudyCase(String casename) {
		int cnt = 0;
		for (AclfStudyCaseXmlType scase : getAclfStudyCaseArray()) {
			if (scase.getRecName().equals(casename)) {
				this.ipssXmlDoc.getInterPSS().getRunStudyCase().getStandardRun().
					getRunAclfStudyCase().getAclfStudyCaseList().removeAclfStudyCase(cnt);
				return true;
			}
			cnt++;
		}
		return false;
	}
	
	/**
	 * add a new Aclf Study case
	 * 
	 * @param casename
	 * @return
	 */
	public boolean addNewAclfStudyCase(String casename) {
		AclfStudyCaseXmlType scase = this.ipssXmlDoc.getInterPSS().getRunStudyCase().
					getStandardRun().getRunAclfStudyCase().getAclfStudyCaseList().addNewAclfStudyCase();
		scase.setRecId(casename.replaceAll(" ", "_"));
		scase.setRecName(casename);
		scase.addNewAclfAlgorithm();
        scase.getAclfAlgorithm().setLfMethod(AclfAlgorithmXmlType.LfMethod.NR);
       	scase.getAclfAlgorithm().setTolerance(0.0001);
       	scase.getAclfAlgorithm().setMaxIterations(20);
       	scase.getAclfAlgorithm().setAccFactor(1.0);
       	scase.getAclfAlgorithm().setNonDivergent(true);
       	scase.getAclfAlgorithm().setInitBusVoltage(true);
       	scase.getAclfAlgorithm().setDisplaySummary(true);
		return true;
	}
	
	/**
	 * Get the AclfStudyCase record list
	 * 
	 * @return
	 */
	public AclfStudyCaseXmlType[] getAclfStudyCaseArray() {
		return this.ipssXmlDoc.getInterPSS().
				getRunStudyCase().getStandardRun().getRunAclfStudyCase().getAclfStudyCaseList().getAclfStudyCaseArray();
	}

	/**
	 * Get the AclfStudyCase record by the record name
	 * 
	 * @param recName
	 * @return
	 */
	public AclfStudyCaseXmlType getAclfStudyCase(String recName) {
		return 	(AclfStudyCaseXmlType)IpssXmlUtilFunc.getRecord(recName, getAclfStudyCaseArray());
	}
	
	/**
	 * Get AclfStudyCase name array
	 * 
	 * @return
	 */
	public String[] getAclfStudyCaseNameArray() {
		return IpssXmlUtilFunc.getRecNameArray(getAclfStudyCaseArray());
	}

	// Dclf Study Case
	// ===============
	
	/**
	 * Delete the study case
	 * 
	 * @param casename
	 * @return true if deleted
	 */
	public boolean deleteDclfStudyCase(String casename) {
		int cnt = 0;
		for (DclfStudyCaseXmlType scase : getDclfStudyCaseArray()) {
			if (scase.getRecName().equals(casename)) {
				this.ipssXmlDoc.getInterPSS().getRunStudyCase().getStandardRun().
					getRunDclfStudyCase().getDclfStudyCaseList().removeDclfStudyCase(cnt);
				return true;
			}
			cnt++;
		}
		return false;
	}
	
	/**
	 * add a new Dclf Study case
	 * 
	 * @param casename
	 * @return
	 */
	public boolean addNewDclfStudyCase(String casename) {
		DclfStudyCaseXmlType scase = this.ipssXmlDoc.getInterPSS().getRunStudyCase().
					getStandardRun().getRunDclfStudyCase().getDclfStudyCaseList().addNewDclfStudyCase();
		scase.setRecId(casename.replaceAll(" ", "_"));
		scase.setRecName(casename);
		
		DclfBranchSensitivityXmlType tdFactor = scase.addNewPTransferDistFactor();
		tdFactor.addNewInjectBusList();
		tdFactor.getInjectBusList().addNewInjectBus();
		tdFactor.addNewWithdrawBusList();
		tdFactor.getWithdrawBusList().addNewWithdrawBus();		
		return true;
	}
	
	/**
	 * Get the DclfStudyCase record list
	 * 
	 * @return
	 */
	public DclfStudyCaseXmlType[] getDclfStudyCaseArray() {
		return this.ipssXmlDoc.getInterPSS().getRunStudyCase().getStandardRun().
					getRunDclfStudyCase().getDclfStudyCaseList().getDclfStudyCaseArray();
	}

	/**
	 * Get the DclfStudyCase record by the record name
	 * 
	 * @param recName
	 * @return
	 */
	public DclfStudyCaseXmlType getDclfStudyCase(String recName) {
		return 	(DclfStudyCaseXmlType)IpssXmlUtilFunc.getRecord(recName, getDclfStudyCaseArray());
	}
	
	/**
	 * Get AclfStudyCase name array
	 * 
	 * @return
	 */
	public String[] getDclfStudyCaseNameArray() {
		return IpssXmlUtilFunc.getRecNameArray(getDclfStudyCaseArray());
	}

	// Acsc Study Case
	// ===============
	
	/**
	 * Delete the study case
	 * 
	 * @param casename
	 * @return true if deleted
	 */
	public boolean deleteAcscStudyCase(String casename) {
		int cnt = 0;
		for (AcscStudyCaseXmlType scase : getAcscStudyCaseArray()) {
			if (scase.getRecName().equals(casename)) {
				this.ipssXmlDoc.getInterPSS().getRunStudyCase().getStandardRun().
					getRunAcscStudyCase().getAcscStudyCaseList().removeAcscStudyCase(cnt);
				return true;
			}
			cnt++;
		}
		return false;
	}
	
	/**
	 * add a new Acsc Study case
	 * 
	 * @param casename
	 * @return
	 */
	public boolean addNewAcscStudyCase(String casename) {
		AcscStudyCaseXmlType scase = this.ipssXmlDoc.getInterPSS().getRunStudyCase().
					getStandardRun().getRunAcscStudyCase().getAcscStudyCaseList().addNewAcscStudyCase();
		scase.setRecId(casename.replaceAll(" ", "_"));
		scase.setRecName(casename);
		
		scase.setBusAcscInitVolt(AcscStudyCaseXmlType.BusAcscInitVolt.UNIT_VOLT);
		scase.setMultiFactor(100.0);
		AcscFaultXmlType faultData = scase.addNewFaultData();
		setDefaultFaultData(faultData);
		return true;
	}
	
	private static void setDefaultFaultData(AcscFaultXmlType faultData) {
		faultData.setFaultType(AcscFaultDataType.BUS_FAULT);
		faultData.setFaultCategory(AcscFaultCategoryDataType.FAULT_3_P);
		faultData.addNewZLG();
		faultData.addNewZLL();
	}
	
	/**
	 * Get the AcscStudyCase record list
	 * 
	 * @return
	 */
	public AcscStudyCaseXmlType[] getAcscStudyCaseArray() {
		return this.ipssXmlDoc.getInterPSS().getRunStudyCase().getStandardRun().
					getRunAcscStudyCase().getAcscStudyCaseList().getAcscStudyCaseArray();
	}

	/**
	 * Get the AcscStudyCase record by the record name
	 * 
	 * @param recName
	 * @return
	 */
	public AcscStudyCaseXmlType getAcscStudyCase(String recName) {
		return 	(AcscStudyCaseXmlType)IpssXmlUtilFunc.getRecord(recName, getAcscStudyCaseArray());
	}
	
	/**
	 * Get AcscStudyCase name array
	 * 
	 * @return
	 */
	public String[] getAcscStudyCaseNameArray() {
		return IpssXmlUtilFunc.getRecNameArray(getAcscStudyCaseArray());
	}

	// DStab Study Case
	// ================
	
	/**
	 * Delete the study case
	 * 
	 * @param casename
	 * @return true if deleted
	 */
	public boolean deleteDStabStudyCase(String casename) {
		int cnt = 0;
		for (DStabStudyCaseXmlType scase : getDStabStudyCaseArray()) {
			if (scase.getRecName().equals(casename)) {
				this.ipssXmlDoc.getInterPSS().getRunStudyCase().getStandardRun().
					getRunDStabStudyCase().getDStabStudyCaseList().removeDStabStudyCase(cnt);
				return true;
			}
			cnt++;
		}
		return false;
	}
	
	/**
	 * add a new DStab Study case
	 * 
	 * @param casename
	 * @return
	 */
	public boolean addNewDStabStudyCase(String casename) {
		DStabStudyCaseXmlType scase = this.ipssXmlDoc.getInterPSS().getRunStudyCase().
					getStandardRun().getRunDStabStudyCase().getDStabStudyCaseList().addNewDStabStudyCase();
		scase.setRecId(casename.replaceAll(" ", "_"));
		scase.setRecName(casename);
		
		return true;
	}
	
	/**
	 * Get the DStabStudyCase record list
	 * 
	 * @return
	 */
	public DStabStudyCaseXmlType[] getDStabStudyCaseArray() {
		return this.ipssXmlDoc.getInterPSS().getRunStudyCase().getStandardRun().
					getRunDStabStudyCase().getDStabStudyCaseList().getDStabStudyCaseArray();
	}

	/**
	 * Get the DStabStudyCase record by the record name
	 * 
	 * @param recName
	 * @return
	 */
	public DStabStudyCaseXmlType getDStabStudyCase(String recName) {
		return 	(DStabStudyCaseXmlType)IpssXmlUtilFunc.getRecord(recName, getDStabStudyCaseArray());
	}
	
	/**
	 * Get DStabStudyCase name array
	 * 
	 * @return
	 */
	public String[] getDStabStudyCaseNameArray() {
		return IpssXmlUtilFunc.getRecNameArray(getDStabStudyCaseArray());
	}
	
	public static void setDefaultEventData(DStabStudyCaseXmlType.DynamicEventData.EventList.Event eventData) {
		eventData.setRecId("New_Dynamic_Event");
		eventData.setRecName("New Dynamic Event");
		eventData.setEventType(DynamicEventDataType.FAULT);
		eventData.setDurationSec(0.1);
		eventData.setPermanent(false);
		eventData.setStartTimeSec(0.0);
		setDefaultFaultData(eventData.getFault());
	}
}