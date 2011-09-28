/*
 * @(#)ModificationHelper.java   
 *
 * Copyright (C) 2006-2010 www.interpss.org
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
 * @Date 09/30/2011
 * 
 *   Revision History
 *   ================
 *
 */

package org.ieee.odm.model.modify;

import org.ieee.odm.model.IODMModelParser;
import org.ieee.odm.schema.ModifyRecordXmlType;
import org.ieee.odm.schema.OutageScheduleXmlType;

public class ModificationHelper {
	private IODMModelParser parser = null;
	
	public ModificationHelper (IODMModelParser parser) {
		this.parser = parser;
	}
	
	/**
	 * create an outage schedule modifyRecord
	 * 
	 * @return
	 */
	public OutageScheduleXmlType createOutageSchedule() {
		if (this.parser.getStudyCase().getModificationList() == null) {
			this.parser.getStudyCase().setModificationList(this.parser.getFactory().createStudyCaseXmlTypeModificationList());
		}
		OutageScheduleXmlType rec = this.parser.getFactory().createOutageScheduleXmlType();
		this.parser.getStudyCase().getModificationList().getModification().add(rec);
		return rec;
	}

	/**
	 * retrieve modifyRecord by id
	 * 
	 * @param id
	 * @return
	 */
	public ModifyRecordXmlType getModifyRecord(String id) {
		for ( ModifyRecordXmlType rec : this.parser.getStudyCase().getModificationList().getModification()) {
			if (rec.getId().equals(id))
				return rec;
		}
		return null;
	}
	
	public OutageScheduleXmlType getOutageSchedule(String id) {
		return (OutageScheduleXmlType)getModifyRecord(id);
	}
}
