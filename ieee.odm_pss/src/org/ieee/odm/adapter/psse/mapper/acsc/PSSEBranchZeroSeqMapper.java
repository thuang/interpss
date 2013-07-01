package org.ieee.odm.adapter.psse.mapper.acsc;

import org.ieee.odm.adapter.psse.PSSEAdapter.PsseVersion;
import org.ieee.odm.adapter.psse.mapper.aclf.BasePSSEDataMapper;
import org.ieee.odm.adapter.psse.parser.acsc.PSSEBranchZeroSeqDataParser;
import org.ieee.odm.common.ODMException;
import org.ieee.odm.model.AbstractModelParser;
import org.ieee.odm.model.acsc.AcscModelParser;

public class PSSEBranchZeroSeqMapper extends BasePSSEDataMapper{
    
	public PSSEBranchZeroSeqMapper(PsseVersion ver) {
		super(ver);
		this.dataParser = new PSSEBranchZeroSeqDataParser(ver);
	}
	
	
	/*
	 * Format: 
	 * I, J, ICKT, RLINZ, XLINZ, BCHZ, GI, BI, GJ, BJ
	 * 
	 * I    Bus number of one end of the branch.
       J    Bus number of the other end of the branch.
      ICKT  One- or two-character branch circuit identifier; a non-transformer branch with circuit
            identifier ICKT between buses I and J must be in the working case. ICKT = 1 by
            default.
     RLINZ  Zero sequence branch resistance; entered in pu on system base MVA and bus
            voltage base. RLINZ = 0.0 by default.
     XLINZ  Zero sequence branch reactance; entered in pu on system base MVA and bus
            voltage base. Any branch for which RLINZ and XLINZ are both 0.0 is treated as
            open in the zero sequence network. XLINZ = 0.0 by default.
     BCHZ   Total zero sequence branch charging susceptance; entered in pu. BCHZ = 0.0 by
            default.
            
     GI,BI  Complex zero sequence admittance of the line connected shunt at the bus I end of
            the branch; entered in pu. GI + jBI = 0.0 by default.
     GJ,BJ  Complex zero sequence admittance of the line connected shunt at the bus J end of
            the branch; entered in pu. GJ + jBJ = 0.0 by default.    
            
               
     NOTE:
     any non-transformer branch for which no data record of this category is entered is treated as open in the zero sequence
     network (i.e., the zero sequence impedance is set to zero).  
            
	 */
	
	public void procLineString(String lineStr, AcscModelParser parser) throws ODMException {
		this.dataParser.parseFields(lineStr);
		
		/*
		 * I, J, ICKT, RLINZ, XLINZ, BCHZ, GI, BI, GJ, BJ
		 */
		int i = dataParser.getInt("I");
		int j = dataParser.getInt("J");
	    final String fbusId = AbstractModelParser.BusIdPreFix+i;
	    final String tbusId = AbstractModelParser.BusIdPreFix+j;
	    
	    String cirId = dataParser.getString("ICKT");
	    
	    double r0= dataParser.getDouble("RLINZ");
	    double x0= dataParser.getDouble("XLINZ");
	    
	    double BCHZ =dataParser.getDouble("BCHZ");
        double GI   =dataParser.getDouble("GI");
        double BI   =dataParser.getDouble("BI");
        double GJ   =dataParser.getDouble("GJ");
        double BJ   =dataParser.getDouble("BJ");
        
        
	    
	}

}
