/*
 * @(#)NumericSpringFactory.java   
 *
 * Copyright (C) 2006-2011 www.interpss.org
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
 * @Date 12/15/2010
 * 
 *   Revision History
 *   ================
 *
 */

package org.interpss.spring;

import org.interpss.numeric.sparse.SparseEqnComplex;
import org.interpss.numeric.sparse.SparseEqnDouble;
import org.interpss.numeric.sparse.SparseEqnInteger;
import org.interpss.numeric.sparse.SparseEqnMatrix2x2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * for object creation from the Spring container. There are two methods - one for creating object
 * using its default implementation, and the other using user supplied Spring bean id
 * 
 * @author mzhou
 *
 */
public class NumericSpringFactory {
	private static final String DefaultSparseEqnIntegerId 		= "sparseEqnInteger";
	// use default sparse solver
	public static String DefaultSparseEqnDoubleId 		= "sparseEqnDouble";
	public static String DefaultSparseEqnMatrix2x2Id 	= "sparseEqnMatrix2x2";
	public static String DefaultSparseEqnComplexId 		= "sparseEqnComplex";

	public static void setDefualtSparseEqnSolver() {
		DefaultSparseEqnDoubleId 		= "sparseEqnDouble";
		DefaultSparseEqnMatrix2x2Id 	= "sparseEqnMatrix2x2";
		DefaultSparseEqnComplexId 		= "sparseEqnComplex";
	}

	public static void setNativeSparseEqnSolver() {
		DefaultSparseEqnDoubleId 		= "sparseEqnDoubleNative";
		DefaultSparseEqnMatrix2x2Id 	= "sparseEqnMatrix2x2Native";
		DefaultSparseEqnComplexId 	= "sparseEqnComplexNative";
	}

	/**
	 * Get the SparseEqnInteger(singleton) object from the SpringAppContext.
	 *  
	 * @return the SparseEqnInteger object
	 */
	public static SparseEqnInteger getSparseEqnInteger() {
		return getSparseEqnInteger(DefaultSparseEqnIntegerId);
	}
	public static SparseEqnInteger getSparseEqnInteger(String beanId) {
		setup();
		return (SparseEqnInteger) SpringAppCtx.getBean(beanId);
	}
	
	/**
	 * Get the SparseEqnDouble(singleton) object from the SpringAppContext.
	 *  
	 * @return the SparseEqnDouble object
	 */
	public static SparseEqnDouble getSparseEqnDouble() {
		return getSparseEqnDouble(DefaultSparseEqnDoubleId);
	}
	public static SparseEqnDouble getSparseEqnDouble(String beanId) {
		setup();
		return (SparseEqnDouble) SpringAppCtx.getBean(beanId);
	}
	
	/**
	 * Get the SparseEqnMatrix2x2(singleton) object from the SpringAppContext.
	 *  
	 * @return the SparseEqnDouble object
	 */
	public static SparseEqnMatrix2x2 getSparseEqnMatrix2x2() {
		return getSparseEqnMatrix2x2(DefaultSparseEqnMatrix2x2Id);
	}
	public static SparseEqnMatrix2x2 getSparseEqnMatrix2x2(String beanId) {
		setup();
		return (SparseEqnMatrix2x2) SpringAppCtx.getBean(beanId);
	}

	/**
	 * Get the SparseEqnComplex(singleton) object from the SpringAppContext.
	 *  
	 * @return the SparseEqnComplex object
	 */
	public static SparseEqnComplex getSparseEqnComplex() {
		return getSparseEqnComplex(DefaultSparseEqnComplexId);
	}
	public static SparseEqnComplex getSparseEqnComplex(String beanId) {
		setup();
		return (SparseEqnComplex) SpringAppCtx.getBean(beanId);
	}

	/*
	 * private area
	 */
	private static ApplicationContext SpringAppCtx = null;

	private static void setup() {
		if (SpringAppCtx == null) {
			// Set the SpringAppContext to all ApplicationContextAware objects.
			SpringAppCtx = new ClassPathXmlApplicationContext("org/interpss/spring/NumericSpringCtx.xml");
		}
	}	
}