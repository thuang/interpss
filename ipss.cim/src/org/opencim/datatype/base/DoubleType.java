 /*
  * @(#)DoubleType.java   
  *
  * Copyright (C) 2007 www.opencim.org
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
  * @Date 03/04/2007
  * 
  *   Revision History
  *   ================
  *
  */

package org.opencim.datatype.base;

public class DoubleType {
	private double value = 0.0;
	private String units = "";
	
	public DoubleType() {
	}

	public DoubleType(double value) {
		this.value = value;
	}
	
	public DoubleType(double value, String units) {
		this.value = value;
		this.units = units;
	}
	
	public String getUnits() {
		return units;
	}

	public void setUnits(String units) {
		this.units = units;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public String toString() {
		return "value, units: " + value + ", " + units;
	}
}
