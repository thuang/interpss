/*
 * @(#)BPADynamicRecord.java   
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
 * @Author Stephen Hau
 * @Version 1.0
 * @Date 02/11/2008
 * 
 *   Revision History
 *   ================
 *
 */

package org.ieee.pes.odm.pss.adapter.bpa;

import java.text.NumberFormat;

import org.ieee.cmte.psace.oss.odm.pss.schema.v1.ActivePowerUnitType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.BusRecordXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.ClassicMachineXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.EquiMachineXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.GeneratorXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.PSSNetworkXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.PostiveSequenceDataListXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.SubTransientMachineXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.TimePeriodUnitType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.TransientMachineXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.TransientSimulationXmlType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.VoltageUnitType;
import org.ieee.cmte.psace.oss.odm.pss.schema.v1.ZeroSequenceDataListXmlType;
import org.ieee.pes.odm.pss.model.ODMData2XmlHelper;
import org.ieee.pes.odm.pss.model.StringUtil;

public class BPADynamicGeneratorRecord {
	
	public static void processGeneratorData(String str,TransientSimulationXmlType tranSimu,
    		PSSNetworkXmlType baseCaseNet,BPAAdapter adapter){
    	
    	final String strAry[]=getGeneratorDataFields(str, adapter);
    	
    	PostiveSequenceDataListXmlType.GeneratorPostiveList.GerneratorPostive posGen=
			tranSimu.getDynamicDataList().getSequenceDataList().getPostiveSequenceDataList().
		                  getGeneratorPostiveList().addNewGerneratorPostive();
    	ZeroSequenceDataListXmlType.GeneratorZeroList.GeneratorZero zeroGen=tranSimu.getDynamicDataList().getSequenceDataList()
    	                  .getZeroSequenceDataList().getGeneratorZeroList().addNewGeneratorZero();    	
    	zeroGen.setZRZer(0);
    	zeroGen.setZXZer(0);
    	if(str.substring(0, 2).trim().equals("M")){
    		GeneratorXmlType gen=tranSimu.getDynamicDataList().getBusDynDataList().
	         getGeneratorDataList().addNewGenerator();
    		String busId=strAry[1];
    		gen.addNewLocatedBus().setName(busId);
    		posGen.addNewBusId().setName(busId);
    		zeroGen.addNewBusId().setName(busId);
    		double ratedVoltage=0.0;
    		if(!strAry[2].equals("")){
    			ratedVoltage= new Double(strAry[2]).doubleValue();
    			ODMData2XmlHelper.setVoltageData(gen.addNewBusRatedVoltage(), 
    					ratedVoltage, VoltageUnitType.KV);    		
    		}
    		gen.setGeneratorType(GeneratorXmlType.GeneratorType.SUBTRANS_MODEL);
    		SubTransientMachineXmlType subTranGen=gen.
    		                    addNewGeneratorModel().addNewSubTransientModel();
    		String genId="1";
    		if(!strAry[3].equals("")){
    			genId=strAry[3];    			
    		}
    		gen.addNewGenId().setName(genId);
    		posGen.addNewMacId().setName(genId);
    		zeroGen.addNewMacId().setName(genId);
    		String owner="";
    		if(!strAry[7].equals("")){
    			owner= strAry[7];
    		}
    		double xd11=StringUtil.getDouble(strAry[8], 0.0);  
    		
    		posGen.setZRPos(0.0);
    		posGen.setZXPos(xd11);
    	
    		subTranGen.setXd11(xd11);
    		double xq11=StringUtil.getDouble(strAry[9], 0.0);
    		subTranGen.setXq11(xq11);
    		double td011=StringUtil.getDouble(strAry[10], 0.0);
    		ODMData2XmlHelper.setTimePeriodData(subTranGen.addNewTd011(), 
					td011, TimePeriodUnitType.SEC);
    		double tq011=StringUtil.getDouble(strAry[11], 0.0);
    		ODMData2XmlHelper.setTimePeriodData(subTranGen.addNewTq011(), 
					tq011, TimePeriodUnitType.SEC);    		
    		
		}else if(str.substring(0, 2).trim().equals("MF")){
			
			String busId=strAry[1];
			String genId="1";			
			posGen.addNewBusId().setName(busId);
			posGen.addNewMacId().setName(genId);
			zeroGen.addNewMacId().setName(genId);
			zeroGen.addNewBusId().setName(busId);
    		if(!strAry[3].equals("")){
    			genId=strAry[3];    			
    		}
			GeneratorXmlType gen=ODMData2XmlHelper.getGeneratorRecord(tranSimu, busId, genId);
			// transient model
			if(gen!=null){
				SubTransientMachineXmlType subTranGen=gen
                .getGeneratorModel().getSubTransientModel();
				
				double pContri=StringUtil.getDouble(strAry[5], 0.0);
				double qContri=StringUtil.getDouble(strAry[6], 0.0);
			
				if(pContri<=1.0&&pContri!=0.0){
				   pContri=pContri*100;				
					gen.setPContribution(pContri);
				}
				if(qContri<=1.0&&qContri!=0.0){
					qContri=qContri*100;
					gen.setQContribution(qContri);
				}
				
								
				double Emws=StringUtil.getDouble(strAry[4], 0.0);
				
				double MvaBase=StringUtil.getDouble(strAry[7], baseCaseNet.getBasePower().getValue());
				
				ODMData2XmlHelper.setActivePower(subTranGen.addNewBasePower(), MvaBase, ActivePowerUnitType.MW);   
				double h=0.0;
				if(Emws!=0.0){
					h=Emws/MvaBase;
					NumberFormat ddf1= NumberFormat.getInstance();
					ddf1.setMaximumFractionDigits(4);
					h= new Double(ddf1.format(h)).doubleValue();
					subTranGen.setH(h);
				}
				
				double ra=StringUtil.getDouble(strAry[8], 0.0);
				subTranGen.setRa(ra);	    			
	    		
				double xd1=StringUtil.getDouble(strAry[9], 0.0);
				subTranGen.setXd1(xd1);	    			
	    		
				
	    		posGen.setZRPos(0.0);
	    		posGen.setZXPos(xd1);
				
				double xq1=StringUtil.getDouble(strAry[10], 0.0);
				subTranGen.setXq1(xq1);	    			
	    		
				double xd=StringUtil.getDouble(strAry[11], 0.0);
				subTranGen.setXd(xd);	    			
	    		
				double xq=StringUtil.getDouble(strAry[12], 0.0);
				subTranGen.setXq(xq);	    			
	    		
				double td01=StringUtil.getDouble(strAry[13], 0.0);
	    		ODMData2XmlHelper.setTimePeriodData(subTranGen.addNewTdo1(), 
	    					td01, TimePeriodUnitType.SEC);
	    		
	    		double tq01=StringUtil.getDouble(strAry[14], 0.0);
	    		ODMData2XmlHelper.setTimePeriodData(subTranGen.addNewTq01(), 
	    					tq01, TimePeriodUnitType.SEC);
	    		
	    		double xl=StringUtil.getDouble(strAry[15], 0.0);
				subTranGen.setXr(xl);	    			
	    		
				double E1=1.0, SE1=0.0;
				if(!strAry[16].equals("")){
					SE1=new Double(strAry[16]).doubleValue();					
				}
				subTranGen.setE1(1.0);
				subTranGen.setSE1(SE1);
				double E2=1.2, SE2=0.0;
				if(!strAry[17].equals("")){
					SE2=new Double(strAry[17]).doubleValue();					
				}
				subTranGen.setE2(1.2);
				subTranGen.setSE2(SE2);
				double D=2.0;
				if(!strAry[18].equals("")){
					D=new Double(strAry[18]).doubleValue();    			
			    }
				subTranGen.setD(D);
				
			}else if(gen==null){
				GeneratorXmlType newGen=tranSimu.getDynamicDataList().getBusDynDataList().
		         getGeneratorDataList().addNewGenerator();
				newGen.addNewLocatedBus().setName(busId);
				double ratedVoltage=0.0;
	    		if(!strAry[2].equals("")){
	    			ratedVoltage= new Double(strAry[2]).doubleValue();
	    			ODMData2XmlHelper.setVoltageData(newGen.addNewBusRatedVoltage(), 
	    					ratedVoltage, VoltageUnitType.KV);    		
	    		}
	    		if(!genId.equals("")){
	    			newGen.addNewGenId().setName(genId);
	    			posGen.addNewMacId().setName(genId);
	    			zeroGen.addNewMacId().setName(genId);
	    		}
	    		
	    		newGen.setGeneratorType(GeneratorXmlType.GeneratorType.TRANSIENT_MODEL);
	    		TransientMachineXmlType tranGen= newGen.addNewGeneratorModel().
	    		         addNewTransModel();
	    		
	    		double pContri=0.0,qContri=0.0;
				if(!strAry[5].equals("")){
					pContri=new Double(strAry[5]).doubleValue();
					if(pContri<=1.0&&qContri!=0.0){
						pContri=pContri*100;
					}
					newGen.setPContribution(pContri);
				}
				if(!strAry[6].equals("")){
					qContri=new Double(strAry[6]).doubleValue();
					if(qContri<=1.0&&qContri!=0.0){
						qContri=qContri*100;
					}
					newGen.setQContribution(qContri);
				}
				double Emws=0.0;
				if(!strAry[4].equals("")){
					Emws=new Double(strAry[4]).doubleValue();
				}
				double MvaBase=0.0;
				if(!strAry[7].equals("")){
					MvaBase=new Double(strAry[7]).doubleValue();
				}else {
					MvaBase=baseCaseNet.getBasePower().getValue();
				}
				ODMData2XmlHelper.setActivePower(tranGen.addNewBasePower(), MvaBase, ActivePowerUnitType.MW);   
				double h=0.0;
				if(Emws!=0.0){
					h=Emws/MvaBase;
					NumberFormat ddf1= NumberFormat.getInstance();
					ddf1.setMaximumFractionDigits(4);
					h= new Double(ddf1.format(h)).doubleValue();
					tranGen.setH(h);
				}
				
				double ra=StringUtil.getDouble(strAry[8], 0.0);
				tranGen.setRa(ra);	    			
	    		
				double xd1=StringUtil.getDouble(strAry[9], 0.0);
				tranGen.setXd1(xd1);	    			
	    		
				
	    		posGen.setZRPos(0.0);
	    		posGen.setZXPos(xd1);
				
				double xq1=StringUtil.getDouble(strAry[10], 0.0);
				tranGen.setXq1(xq1);	    			
	    		
				double xd=StringUtil.getDouble(strAry[11], 0.0);
				tranGen.setXd(xd);	    			
	    		
				double xq=StringUtil.getDouble(strAry[12], 0.0);
				tranGen.setXq(xq);	    			
	    		
				double td01=StringUtil.getDouble(strAry[13], 0.0);
	    		ODMData2XmlHelper.setTimePeriodData(tranGen.addNewTdo1(), 
	    					td01, TimePeriodUnitType.SEC);
	    		
	    		double tq01=StringUtil.getDouble(strAry[14], 0.0);
	    		ODMData2XmlHelper.setTimePeriodData(tranGen.addNewTq01(), 
	    					tq01, TimePeriodUnitType.SEC);
	    			    		
				double E1=1.0, SE1=0.0;
				if(!strAry[16].equals("")){
					SE1=new Double(strAry[16]).doubleValue();					
				}
				tranGen.setE1(1.0);
				tranGen.setSE1(SE1);
				double E2=1.2, SE2=0.0;
				if(!strAry[17].equals("")){
					SE2=new Double(strAry[17]).doubleValue();					
				}
				tranGen.setE2(1.2);
				tranGen.setSE2(SE2);
				double D=2.0;
				if(!strAry[18].equals("")){
					D=new Double(strAry[18]).doubleValue();    			
			    }
				tranGen.setD(D);
			}
			
		// classical model 	
		}else if(str.substring(0,2).trim().equals("MC")){
			
			GeneratorXmlType gen=tranSimu.getDynamicDataList().getBusDynDataList().
	         getGeneratorDataList().addNewGenerator();
			String busId=strAry[1];
			posGen.addNewBusId().setName(busId);
	   		gen.addNewLocatedBus().setName(busId);
	   		zeroGen.addNewBusId().setName(busId);
	   		double ratedVoltage=0.0;
	   		if(!strAry[2].equals("")){
	   			ratedVoltage= new Double(strAry[2]).doubleValue();
	   			ODMData2XmlHelper.setVoltageData(gen.addNewBusRatedVoltage(), 
	   					ratedVoltage, VoltageUnitType.KV);    		
	   		}
	   		gen.setGeneratorType(GeneratorXmlType.GeneratorType.CLASSICAL_MODEL);
	   		ClassicMachineXmlType claGen=gen.
	   		                    addNewGeneratorModel().addNewClassicalModel();
	   		String genId="1";
	   		if(!strAry[3].equals("")){
	   			genId=strAry[3];	   			
	   		}
	   		gen.addNewGenId().setName(genId);
	   		posGen.addNewMacId().setName(genId);
	   		zeroGen.addNewMacId().setName(genId);
	   		double Emws=0.0;
			if(!strAry[4].equals("")){
				Emws=new Double(strAry[4]).doubleValue();
			}
			// infinit bus
			double xd1=0.0;
			if(Emws==999999){
				claGen.setH(999999);				
				if(!strAry[9].equals("")){
					xd1=new Double(strAry[9]).doubleValue();
	    			claGen.setXd1(xd1);	    			
	    		}
			} else{
				double MvaBase=0.0;
				if(!strAry[7].equals("")){
					MvaBase=new Double(strAry[7]).doubleValue();
				}else {
					MvaBase=baseCaseNet.getBasePower().getValue();
				}
				double h=0.0;
				if(Emws!=0.0){
					h=Emws/MvaBase;
					NumberFormat ddf1= NumberFormat.getInstance();
					ddf1.setMaximumFractionDigits(4);
					h= new Double(ddf1.format(h)).doubleValue();
					claGen.setH(h);
				}	   		
		   		double pContri=0.0,qContri=0.0;
				if(!strAry[5].equals("")){
					pContri=new Double(strAry[5]).doubleValue();
					if(pContri<=1.0&&qContri!=0.0){
						pContri=pContri*100;
					}
					gen.setPContribution(pContri);
				}
				if(!strAry[6].equals("")){
					qContri=new Double(strAry[6]).doubleValue();
					if(qContri<=1.0&&qContri!=0.0){
						qContri=qContri*100;
					}
					gen.setQContribution(qContri);
				}
				
				ODMData2XmlHelper.setActivePower(claGen.addNewBasePower(), MvaBase, ActivePowerUnitType.MW);   
				if(!strAry[9].equals("")){
					xd1=new Double(strAry[9]).doubleValue();
	    			claGen.setXd1(xd1);
	    		}				
			}
			posGen.setZRPos(0.0);
    		posGen.setZXPos(xd1);
			double D=2.0;
			if(!strAry[18].equals("")){
				D=new Double(strAry[18]).doubleValue();    			
		    }
			claGen.setD(D);
   		
		}else if(str.substring(0, 2).trim().equals("LN")){
			
			String bus1="";
			double Vol1=0.0;
			if(!strAry[1].equals("")){
				bus1=strAry[1];
			}
			if(!strAry[2].equals("")){
				Vol1=new Double(strAry[2]).doubleValue();
			}
			if(!bus1.equals("")&&Vol1!=0.0){
				GeneratorXmlType gen=tranSimu.getDynamicDataList().getBusDynDataList()
				.getGeneratorDataList().addNewGenerator();
				gen.addNewLocatedBus().setName(bus1);
				ODMData2XmlHelper.setVoltageData(gen.addNewBusRatedVoltage(),
						Vol1, VoltageUnitType.KV);
				gen.setGeneratorType(GeneratorXmlType.GeneratorType.EQUI_GEN_UNIT);
				EquiMachineXmlType equiGen=gen.addNewGeneratorModel().addNewEquiGenUnit();
				BusRecordXmlType busRec=ODMData2XmlHelper.getBusRecord(bus1, baseCaseNet);
				if(busRec!=null){
					double pGen=busRec.getLoadflowData().getGenData().
					              getEquivGen().getPower().getRe();
					equiGen.setEquiPgen(pGen);
					equiGen.setPGenUnit(EquiMachineXmlType.PGenUnit.MVA);					
				}else{
					equiGen.setDCLineBus(true);
				}
				
				
			}
			String bus2="";
			double Vol2=0.0;
			if(!strAry[3].equals("")){
				bus2=strAry[3];
			}
			if(!strAry[4].equals("")){
				Vol2=new Double(strAry[4]).doubleValue();
			}
			String bus3="";
			double Vol3=0.0;
			if(!strAry[5].equals("")){
				bus3=strAry[5];
			}
			if(!strAry[6].equals("")){
				Vol3=new Double(strAry[6]).doubleValue();
			}
			String bus4="";
			double Vol4=0.0;
			if(!strAry[7].equals("")){
				bus4=strAry[7];
			}
			if(!strAry[8].equals("")){
				Vol4=new Double(strAry[8]).doubleValue();
			}
			String bus5="";
			double Vol5=0.0;
			if(!strAry[9].equals("")){
				bus5=strAry[9];
			}
			if(!strAry[10].equals("")){
				Vol5=new Double(strAry[10]).doubleValue();
			}
		}
    	   	
    	
    }
	
	private static String[] getGeneratorDataFields ( final String str,BPAAdapter adapter) {
		final String[] strAry = new String[19];
		
		try{
			if(str.substring(0, 2).trim().equals("M")){
				
				strAry[0]=StringUtil.getStringReturnEmptyString(str,1, 2).trim();
				strAry[1]=StringUtil.getStringReturnEmptyString(str,4, 11).trim();
				strAry[2]=StringUtil.getStringReturnEmptyString(str,12, 15).trim();
				strAry[3]=StringUtil.getStringReturnEmptyString(str,16, 16).trim();
				strAry[4]=StringUtil.getStringReturnEmptyString(str,17, 21).trim();
				strAry[5]=StringUtil.getStringReturnEmptyString(str,23, 25).trim();
				strAry[6]=StringUtil.getStringReturnEmptyString(str,31, 32).trim();
				strAry[7]=StringUtil.getStringReturnEmptyString(str,34, 36).trim();
				strAry[8]=StringUtil.getStringReturnEmptyString(str,38, 42).trim();
				strAry[9]=StringUtil.getStringReturnEmptyString(str,43, 47).trim();
				strAry[10]=StringUtil.getStringReturnEmptyString(str,48, 51).trim();
				strAry[11]=StringUtil.getStringReturnEmptyString(str,52, 55).trim();			
				
			}else if(str.substring(0, 2).trim().equals("MC")||str.substring(0, 2).trim().equals("MF")){
				
				strAry[0]=StringUtil.getStringReturnEmptyString(str,1, 2).trim();
				strAry[1]=StringUtil.getStringReturnEmptyString(str,4, 11).trim();
				strAry[2]=StringUtil.getStringReturnEmptyString(str,12, 15).trim();
				strAry[3]=StringUtil.getStringReturnEmptyString(str,16, 16).trim();
				strAry[4]=StringUtil.getStringReturnEmptyString(str,17, 22).trim();
				strAry[5]=StringUtil.getStringReturnEmptyString(str,23, 25).trim();
				strAry[6]=StringUtil.getStringReturnEmptyString(str,26, 28).trim();
				strAry[7]=StringUtil.getStringReturnEmptyString(str,29, 32).trim();
				strAry[8]=StringUtil.getStringReturnEmptyString(str,33, 36).trim();
				strAry[9]=StringUtil.getStringReturnEmptyString(str,37, 41).trim();
				strAry[10]=StringUtil.getStringReturnEmptyString(str,42, 46).trim();
				strAry[11]=StringUtil.getStringReturnEmptyString(str,47, 51).trim();
				strAry[12]=StringUtil.getStringReturnEmptyString(str,52, 56).trim();
				strAry[13]=StringUtil.getStringReturnEmptyString(str,57, 60).trim();
				strAry[14]=StringUtil.getStringReturnEmptyString(str,61, 63).trim();
				strAry[15]=StringUtil.getStringReturnEmptyString(str,64, 68).trim();
				strAry[16]=StringUtil.getStringReturnEmptyString(str,69, 73).trim();
				strAry[17]=StringUtil.getStringReturnEmptyString(str,74, 77).trim();
				strAry[18]=StringUtil.getStringReturnEmptyString(str,78, 80).trim();
			}else if(str.substring(0, 2).trim().equals("LN")){
				
				strAry[0]=StringUtil.getStringReturnEmptyString(str,1, 2).trim();
				strAry[1]=StringUtil.getStringReturnEmptyString(str,4, 11).trim();
				strAry[2]=StringUtil.getStringReturnEmptyString(str,12, 15).trim();
				strAry[3]=StringUtil.getStringReturnEmptyString(str,19, 26).trim();
				strAry[4]=StringUtil.getStringReturnEmptyString(str,27, 30).trim();
				strAry[5]=StringUtil.getStringReturnEmptyString(str,34, 41).trim();
				strAry[6]=StringUtil.getStringReturnEmptyString(str,42, 45).trim();
				strAry[7]=StringUtil.getStringReturnEmptyString(str,50, 56).trim();
				strAry[8]=StringUtil.getStringReturnEmptyString(str,57, 60).trim();
				strAry[9]=StringUtil.getStringReturnEmptyString(str,64, 71).trim();
				strAry[10]=StringUtil.getStringReturnEmptyString(str,72, 75).trim();
			}
		}catch(Exception e){
			adapter.logErr(e.toString());
		}
		
			
		
		return strAry;
    }

}
