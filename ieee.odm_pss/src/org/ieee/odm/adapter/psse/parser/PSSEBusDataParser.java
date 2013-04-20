/*
 * @(#)PSSEBusDataParser.java   
 *
 * Copyright (C) 2006-2013 www.interpss.org
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
 * @Date 04/11/2013
 * 
 *   Revision History
 *   ================
 *
 */

package org.ieee.odm.adapter.psse.parser;

import java.util.StringTokenizer;

import org.ieee.odm.adapter.psse.PsseVersion;
import org.ieee.odm.common.ODMException;

/**
 * Class for processing IEEE CDF bus data line string
 * 
 * @author mzhou
 *
 */
public class PSSEBusDataParser extends BasePSSEDataParser {
	public PSSEBusDataParser(PsseVersion ver) {
		super(ver);
	}	
	
	@Override public String[] getMetadata() {
		/* Format V26
		 * 
		 * 	I,    NAME        BASKV, IDE,  GL,      BL, AREA, ZONE, VM,      VA,      OWNER
		 */
		return new String[] {
		   //  0----------1----------2----------3----------4
			  "I",      "NAME",    "BASKV",    "IDE",     "GL",      
		   //  5          6          7          8          9
			  "BL",     "AREA",    "ZONE",     "VM",      "VA",
		   //  10       
			  "OWNER"
		};
	}
	
	@Override public void parseFields(final String str) throws ODMException {
		StringTokenizer st = new StringTokenizer(str,",");
		for (int i = 0; i < 11; i++)
			setValue(i, st.nextToken().trim());
	}
}