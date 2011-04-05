/*
 * @(#)LineBranchRecord.java   
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
 * @Author Stephen Hau, Mike Zhou
 * @Version 1.0
 * @Date 02/11/2008
 * 
 *   Revision History
 *   ================
 *
 */
package org.ieee.odm.adapter.bpa.impl;

import org.ieee.odm.ODMObjectFactory;
import org.ieee.odm.common.ODMException;
import org.ieee.odm.common.ODMLogger;
import org.ieee.odm.model.aclf.AclfDataSetter;
import org.ieee.odm.model.aclf.AclfModelParser;
import org.ieee.odm.model.base.BaseDataSetter;
import org.ieee.odm.model.base.BaseJaxbHelper;
import org.ieee.odm.model.base.ModelStringUtil;
import org.ieee.odm.schema.BusXmlType;
import org.ieee.odm.schema.CurrentUnitType;
import org.ieee.odm.schema.LengthUnitType;
import org.ieee.odm.schema.LineBranchXmlType;
import org.ieee.odm.schema.LoadflowBusXmlType;
import org.ieee.odm.schema.YUnitType;
import org.ieee.odm.schema.YXmlType;
import org.ieee.odm.schema.ZUnitType;

public class LineBranchRecord {
	public static void processBranchData(final String str,	AclfModelParser parser)  throws ODMException {	
		final double baseMVA = parser.getAclfNet().getBasePower().getValue();
		// symmetry line data
		if(str.startsWith("L ")){
			// parse the branch input line str
			final String[] strAry = getBranchDataFields(str);
			
			// symetry  branch
			final String branchType=strAry[0];

			final String modCode =strAry[1];
			final String owner=strAry[2];
			
			final String fid =  strAry[3];
			final String tid =  strAry[6];
			ODMLogger.getLogger().fine("Branch data loaded, from-Bus, to-Bus: " + fid + ", " + tid);

			// set cirId, if not specified, set to 1
			String cirId="";
			if(!strAry[8].equals("")){
				cirId = strAry[8];
			}
			else{
				cirId="1";
			}			
			
			LineBranchXmlType branchRec = null;
			try {
				branchRec = parser.createLineBranch(fid, tid, cirId);
			} catch (Exception e) {
				ODMLogger.getLogger().severe("branch data error, " + e.toString());
				return;
			}
			
			// TODO owner code
			
			double fVol=0.0;
			double tVol=0.0;
			if(!strAry[4].equals("")){
				fVol= new Double(strAry[4]).doubleValue();
			}
			if(!strAry[7].equals("")){
				tVol= new Double(strAry[4]).doubleValue();
			}
			
//			// measure location for power interchange, 1--from side, 2- to side
//			//set transfer power measured location in tie line data 
//			int measureLocation=0;
//			if(!strAry[5].equals("")){
//				measureLocation= new Integer(strAry[5]).intValue();
//				try{
//					if(measureLocation==1){
//						PSSNetworkXmlType.TieLineList.Tieline tieLine=parser.addNewBaseCaseTieline();
//						// set tieline data
//						tieLine.addNewMeteredBus().setName(fid);
//						tieLine.addNewNonMeteredBus().setName(tid);	
//						
//						BusRecordXmlType busRecFrom=XBeanParserHelper.findBusRecord(fid, baseCaseNet);
//						busRecFrom.getZoneNumber();
//						NetAreaXmlType areaFrom=XBeanParserHelper.
//						  getAreaRecordByZone(busRecFrom.getZoneNumber(), baseCaseNet);
//						tieLine.setMeteredArea(areaFrom.getName());
//						
//						BusRecordXmlType busRecTo=XBeanParserHelper.findBusRecord(tid, baseCaseNet);
//						busRecTo.getZoneNumber();
//						NetAreaXmlType areaTo=XBeanParserHelper.
//						  getAreaRecordByZone(busRecTo.getZoneNumber(), baseCaseNet);
//						tieLine.setNonMeteredArea(areaTo.getName());
//						// to do: set area number
//						
//					}
//					else{
//						PSSNetworkXmlType.TieLineList.Tieline tieLine=parser.addNewBaseCaseTieline();
//
//						tieLine.addNewMeteredBus().setName(tid);
//						tieLine.addNewNonMeteredBus().setName(fid);					
//						XBeanParserHelper.findBusRecord(fid, baseCaseNet).getZoneNumber();
//						
//						BusRecordXmlType busRecFrom=XBeanParserHelper.findBusRecord(tid, baseCaseNet);
//						busRecFrom.getZoneNumber();
//						NetAreaXmlType areaFrom=XBeanParserHelper.
//						  getAreaRecordByZone(busRecFrom.getZoneNumber(), baseCaseNet);
//						tieLine.setMeteredArea(areaFrom.getName());
//						
//						BusRecordXmlType busRecTo=XBeanParserHelper.findBusRecord(fid, baseCaseNet);
//						busRecTo.getZoneNumber();
//						NetAreaXmlType areaTo=XBeanParserHelper.
//						  getAreaRecordByZone(busRecTo.getZoneNumber(), baseCaseNet);
//						tieLine.setNonMeteredArea(areaTo.getName());						
//					}
//				} catch (final Exception e){
//					e.printStackTrace();
//				}
//			}
			
			branchRec.setId(ModelStringUtil.formBranchId(fid, tid, cirId));			
			
			String multiSectionId="";
			if(!strAry[9].equals("")){
				multiSectionId = strAry[9];
				//set multiSection data if necessary
				// TODO
			}			
			
			//if currentRating!=0.0,set rated current
			double currentRating=0.0;
			if(!strAry[10].equals("")){
				currentRating = new Double(strAry[10]).doubleValue();
				AclfDataSetter.setBranchRatingLimitData(branchRec.getRatingLimit(),
						currentRating, CurrentUnitType.AMP);
				
			}	
			
			/*
			 * Set branch r,x,b
			 * ================
			 */
			double rpu=0.0, xpu=0.0001, halfGpu=0.0, halfBpu=0.0;
			if(!strAry[12].equals("")){
				rpu = new Double(strAry[12]).doubleValue();
				if(rpu>1.0){
					rpu=rpu/100000;
				}
				rpu=ModelStringUtil.getNumberFormat(rpu);
			}
			
			if(!strAry[13].equals("")){
				xpu = new Double(strAry[13]).doubleValue();
				if(xpu>1.0){
					xpu=xpu/100000;
				}
				xpu=ModelStringUtil.getNumberFormat(xpu);
			}
			
			if(!strAry[14].equals("")){
				halfGpu = new Double(strAry[14]).doubleValue();
				if(halfGpu>1.0){
					halfGpu=halfGpu/100000;
				}
			}
			
			if(!strAry[15].equals("")){
				halfBpu = new Double(strAry[15]).doubleValue();
				if(halfBpu>10.0){
					halfBpu=halfBpu/100000;
				}
			}
			
			if(rpu!=0.0||xpu!=0.0||halfGpu!=0.0||halfBpu!=0.0){
				AclfDataSetter.setLineData(branchRec, rpu, xpu,
						ZUnitType.PU, 2*halfGpu, 2*halfBpu, YUnitType.PU);;
			}
   		    
			//branch length
			double length=0.0;
			if(!strAry[16].equals("")){
				AclfDataSetter.setLineLength(branchRec.getLineInfo(), 
						length, LengthUnitType.MILE);
			}			

			// if there is a description, set
			String desc= "";
			if(!strAry[17].equals("")){
				desc= strAry[17];
				BaseJaxbHelper.addNVPair(branchRec.getNvPairList(), "branch description", desc);
			}			
		}
		/**
		 * transform the shunt Var at the end(s) of a branch to a shuntY, 
		 * and add it to the corresponding bus.
		 */
		else if(str.startsWith("L+")){
			final String[] strAry = getBranchDataFields(str);
			final String fid =  strAry[3];
			final String tid =  strAry[6]; 
			if(!strAry[9].equals("")){
			final double fromShuntVar=new Double(strAry[9]).doubleValue();
			double fShuntVar=ModelStringUtil.getNumberFormat(fromShuntVar/baseMVA); // x(pu)=Var/baseMVA
			if(fShuntVar!=0.0){
				LoadflowBusXmlType fromBus=parser.getAclfBus(fid);
				YXmlType shuntY=null;
				if(fromBus.getShuntY()!=null) shuntY=fromBus.getShuntY();
				else shuntY =BaseDataSetter.createYValue(0,0,YUnitType.PU);
				fromBus.setShuntY(BaseDataSetter.createYValue(shuntY.getRe(), shuntY.getIm()-fShuntVar,YUnitType.PU));
			}
			}
			if(!strAry[10].equals("")){
			final double toShuntVar=new Double(strAry[10]).doubleValue();
			double tShuntVar=ModelStringUtil.getNumberFormat(toShuntVar/baseMVA);

			if(tShuntVar!=0.0){
				LoadflowBusXmlType toBus=parser.getAclfBus(tid);
				YXmlType shuntY=null;
				if(toBus.getShuntY()!=null) shuntY=toBus.getShuntY();
				else shuntY =BaseDataSetter.createYValue(0,0,YUnitType.PU);
				toBus.setShuntY(BaseDataSetter.createYValue(shuntY.getRe(), shuntY.getIm()-tShuntVar,YUnitType.PU));
			}
			}
			
		}
		else{
			throw new ODMException("Only type L or L+ branch is allowed");
		}
	}	
	


	private static String[] getBranchDataFields(final String str) {
		final String[] strAry = new String[20];
		// line type
		strAry[0] = ModelStringUtil.getStringReturnEmptyString(str,1, 2).trim();
		// change
        strAry[1] = ModelStringUtil.getStringReturnEmptyString(str,3, 3).trim();
        //ower
		strAry[2] = ModelStringUtil.getStringReturnEmptyString(str,4, 6).trim();
		
		//----to process the Chinese characters in the fromBus name, if any.
		String tem=ModelStringUtil.getStringReturnEmptyString(str,7, 14).trim();
		int chnCharNum1=ModelStringUtil.getChineseCharNum(tem);
		
		//from bus name
		strAry[3] = ModelStringUtil.getStringReturnEmptyString(str,7, 14-chnCharNum1).trim();
		//from bus basekV
		strAry[4] = ModelStringUtil.getStringReturnEmptyString(str,15-chnCharNum1, 18-chnCharNum1).trim();
		//meter
		strAry[5] = ModelStringUtil.getStringReturnEmptyString(str,19-chnCharNum1, 19-chnCharNum1).trim();
		
		//---to process the Chinese characters in the toBus name, if any.
		tem=ModelStringUtil.getStringReturnEmptyString(str,20-chnCharNum1, 27-chnCharNum1).trim();
		int chnCharNum2=ModelStringUtil.getChineseCharNum(tem);
		
		//to bus name
		strAry[6] = ModelStringUtil.getStringReturnEmptyString(str,20-chnCharNum1, 27-chnCharNum1-chnCharNum2).trim();
		
		//--- replace all the Chinese Characters, since they are not used in the following processing.
		String str2=ModelStringUtil.replaceChineseChar(str);
		
		//to bus baseKV
		strAry[7] = ModelStringUtil.getStringReturnEmptyString(str2,28, 31).trim();
		// circuit ID
		strAry[8] = ModelStringUtil.getStringReturnEmptyString(str2,32, 32).trim();
		
		if(strAry[0].equals("L")){ 
		  // no use
		  strAry[9] = ModelStringUtil.getStringReturnEmptyString(str2,33, 33).trim();
		  // current rating(ampacity)
		  strAry[10] = ModelStringUtil.getStringReturnEmptyString(str2,34, 37).trim();
		  // no use
		  strAry[11] = ModelStringUtil.getStringReturnEmptyString(str2,38, 38).trim();
		  // R
		  strAry[12] = ModelStringUtil.getStringReturnEmptyString(str2,39, 44).trim();
		  // X
		  strAry[13] = ModelStringUtil.getStringReturnEmptyString(str2,45, 50).trim();
		  //G/2
		  strAry[14] = ModelStringUtil.getStringReturnEmptyString(str2,51, 56).trim();
		  //B/2
		  strAry[15] = ModelStringUtil.getStringReturnEmptyString(str2,57, 62).trim();
	    }
		else if(strAry[0].equals("L+")){ //processing Branch Shunt Var Data Fields
			
			if(str2.length()>38){// get the shunt Var at the fromBus side
			     strAry[9] = ModelStringUtil.getStringReturnEmptyString(str2,34, 38).trim();
			} else
				 strAry[9] = ModelStringUtil.getStringReturnEmptyString(str2,34, str2.length()).trim();
			// there is shunt Var at the toBus side
			if(str2.length()>48)
			   strAry[10] = ModelStringUtil.getStringReturnEmptyString(str2,44, 48).trim();
			else strAry[10] = ModelStringUtil.getStringReturnEmptyString(str2,44, str2.length()).trim();
		}
		if(strAry[0].equals("L")){
			//line length
			strAry[16] = ModelStringUtil.getStringReturnEmptyString(str2,63, 66).trim();
			strAry[17] = ModelStringUtil.getStringReturnEmptyString(str2,67, 74).trim();
		}else{
			strAry[16] = ModelStringUtil.getStringReturnEmptyString(str2,63, 67).trim();
			strAry[17] = ModelStringUtil.getStringReturnEmptyString(str2,69, 74).trim();
		}
		// date of first put into use
		strAry[18] = ModelStringUtil.getStringReturnEmptyString(str2,75, 77).trim();	
		// date of out of service
		strAry[19] = ModelStringUtil.getStringReturnEmptyString(str2,78, 80).trim();		
//         
		return strAry;
    }
//	private static String[] getBranchShuntVarDataFields(String str) {
//		final String[] strAry = new String[8];
//		// Branch record type
//		strAry[0] = ModelStringUtil.getStringReturnEmptyString(str,1, 2).trim();
//		// from bus name and basekV
//		strAry[1] = ModelStringUtil.getStringReturnEmptyString(str,7, 14).trim();
//		strAry[2] = ModelStringUtil.getStringReturnEmptyString(str,15, 18).trim();
//		// to bus name and basekV
//		strAry[3] = ModelStringUtil.getStringReturnEmptyString(str,20, 27).trim();
//		strAry[4] = ModelStringUtil.getStringReturnEmptyString(str,28, 31).trim();
//		strAry[5] = ModelStringUtil.getStringReturnEmptyString(str,32, 32).trim();
//		// shunt Var at the fromBus side
//		if(str.length()>38)
//		     strAry[6] = ModelStringUtil.getStringReturnEmptyString(str,34, 38).trim();
//		else
//			 strAry[6] = ModelStringUtil.getStringReturnEmptyString(str,34, str.length()).trim();
//		// shunt Var at the toBus side
//		if(str.length()>44){
//		   strAry[7] = ModelStringUtil.getStringReturnEmptyString(str,44, str.length()).trim();
//		}
//		return strAry;
//	}
}

//else if(str.startsWith("E")){
//final String[] strAry = getBranchDataFields(str,adapter);
//// symetry  branch
//final String branchType=strAry[0];
//
//final String modCode =strAry[1];
//final String owner=strAry[2];
//
//final String fid = strAry[3];
//final String tid = strAry[6];
//ODMLogger.getLogger().fine("Branch data loaded, from-Bus, to-Bus: " + fid + ", " + tid);
//
//if(!fid.equals("")){
//	branchRec.addNewFromBus().setIdRef(fid);
//}
//if(!tid.equals("")){
//	branchRec.addNewToBus().setIdRef(tid);
//}
//
//double fVol=0.0;
//double tVol=0.0;
//if(!strAry[4].equals("")){
//	fVol= new Double(strAry[4]).doubleValue();
//}
//if(!strAry[7].equals("")){
//	tVol= new Double(strAry[4]).doubleValue();
//}			
// measure location for power interchange, 1--from side, 2- to side
//set transfer power measured location in tie line data 
//int measureLocation=0;
//if(!strAry[5].equals("")){
//	measureLocation= new Integer(strAry[5]).intValue();
//	try{
//		if(measureLocation==1){
//			PSSNetworkXmlType.TieLineList.Tieline tieLine=parser.addNewBaseCaseTieline();
//
//			// set tieline data
//			tieLine.addNewMeteredBus().setName(fid);
//			tieLine.addNewNonMeteredBus().setName(tid);	
//			
//			BusRecordXmlType busRecFrom=XBeanParserHelper.findBusRecord(fid, baseCaseNet);
//			busRecFrom.getZoneNumber();
//			NetAreaXmlType areaFrom=XBeanParserHelper.
//			  getAreaRecordByZone(busRecFrom.getZoneNumber(), baseCaseNet);
//			tieLine.setMeteredArea(areaFrom.getName());
//			
//			BusRecordXmlType busRecTo=XBeanParserHelper.findBusRecord(tid, baseCaseNet);
//			busRecTo.getZoneNumber();
//			NetAreaXmlType areaTo=XBeanParserHelper.
//			  getAreaRecordByZone(busRecTo.getZoneNumber(), baseCaseNet);
//			tieLine.setNonMeteredArea(areaTo.getName());
//			// to do: set area number
//			
//		}else{
//			PSSNetworkXmlType.TieLineList.Tieline tieLine=parser.addNewBaseCaseTieline();
//
//			tieLine.addNewMeteredBus().setName(tid);
//			tieLine.addNewNonMeteredBus().setName(fid);					
//			XBeanParserHelper.findBusRecord(fid, baseCaseNet).getZoneNumber();
//			
//			BusRecordXmlType busRecFrom=XBeanParserHelper.findBusRecord(tid, baseCaseNet);
//			busRecFrom.getZoneNumber();
//			NetAreaXmlType areaFrom=XBeanParserHelper.
//			  getAreaRecordByZone(busRecFrom.getZoneNumber(), baseCaseNet);
//			tieLine.setMeteredArea(areaFrom.getName());
//			
//			BusRecordXmlType busRecTo=XBeanParserHelper.findBusRecord(fid, baseCaseNet);
//			busRecTo.getZoneNumber();
//			NetAreaXmlType areaTo=XBeanParserHelper.
//			  getAreaRecordByZone(busRecTo.getZoneNumber(), baseCaseNet);
//			tieLine.setNonMeteredArea(areaTo.getName());						
//		}
//	}catch (final Exception e){
//		e.printStackTrace();
//	}
//	
//}

//// set cirId, if not specified, set to 1
//String cirId="";
//if(!strAry[8].equals("")){
//	cirId = strAry[8];
//	branchRec.setCircuitId(cirId);
//}
//else{
//	branchRec.setCircuitId("1");
//}			
//
//LoadflowBranchDataXmlType branchData = branchRec.addNewLoadflowData();
//
//branchRec.setId(ModelStringUtil.formBranchId(fid, tid, cirId));			
//branchData.setCode(LFBranchCodeEnumType.LINE);
//
//String multiSectionId="";
//if(!strAry[9].equals("")){
//	multiSectionId = strAry[9];
//	//set multiSection data if necessary
//}			
//
////if currentRating!=0.0,set rated current
//double currentRating=0.0;
//if(!strAry[10].equals("")){
//	currentRating = new Double(strAry[10]).doubleValue();
//	XBeanDataSetter.setBranchRatingLimitData(branchData.addNewBranchRatingLimit(), 
//			currentRating, CurrentUnitType.AMP);
//}			 
//double rpu=0.0, xpu=0.0001, G1pu=0.0, B1pu=0.0, G2pu=0.0, B2pu=0.0;
//if(!strAry[12].equals("")){
//	rpu = new Double(strAry[12]).doubleValue();
//}
//if(!strAry[13].equals("")){
//	xpu = new Double(strAry[13]).doubleValue();
//}
//if(!strAry[14].equals("")){
//	G1pu = new Double(strAry[14]).doubleValue();
//}
//if(!strAry[15].equals("")){
//	B1pu = new Double(strAry[15]).doubleValue();
//}
//if(!strAry[16].equals("")){
//	G2pu = new Double(strAry[16]).doubleValue();
//}
//if(!strAry[17].equals("")){
//	B2pu = new Double(strAry[17]).doubleValue();
//}
//ZXmlType z= branchData.addNewZ();
//XBeanDataSetter.setZValue(z, rpu, xpu, ZUnitType.PU);
//YXmlType y1 = branchData.addNewFromShuntY();
//YXmlType y2 = branchData.addNewToShuntY();
//XBeanDataSetter.setYData(y1, G1pu, B1pu, YUnitType.PU);
//XBeanDataSetter.setYData(y2, G2pu, B2pu, YUnitType.PU); 			
//}


