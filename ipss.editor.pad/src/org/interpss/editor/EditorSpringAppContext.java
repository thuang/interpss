 /*
  * @(#)EditorSpringAppContext.java   
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

package org.interpss.editor;

import org.interpss.editor.app.AppContext;
import org.interpss.editor.coreframework.GPGraphpad;
import org.interpss.editor.jgraph.ui.app.IAppStatus;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.interpss.common.SpringAppContext;
import com.interpss.common.datatype.Constants;
import com.interpss.common.io.IProjectDataManager;
import com.interpss.common.io.IRefDataManager;
import com.interpss.common.io.ISimuRecManager;

public class EditorSpringAppContext extends SpringAppContext {
	/**
	 * Get the GEditor(singleton) from the SpringAppContext.
	 */
	public static GPGraphpad getGraphicEditor() {
		return (GPGraphpad)SpringAppCtx.getBean(Constants.SID_IpssGraphicEditor);
	}
	
	/**
	 * Get the AppContext(singleton) from the SpringAppContext.
	 */
	public static AppContext getAppContext() {
		return (AppContext)SpringAppCtx.getBean(Constants.SID_IpssAppContext);
	}

	/**
	 * Get the DB RefDataManager(singleton) object.
	 */
	public static IAppStatus getStatusPanel() {
		return (IAppStatus)SpringAppCtx.getBean(Constants.SID_StatusPanel);
	}

	/**
	 * Get the DB RefDataManager(singleton) object.
	 */
	public static IRefDataManager getRefDataManager() {
		return (IRefDataManager)SpringAppCtx.getBean(Constants.SID_RefDataManager);
	}

	/**
	 * Get the DB ProjectDataManager(singleton) object.
	 */
	public static IProjectDataManager getProjectDataManager() {
		return (IProjectDataManager)SpringAppCtx.getBean(Constants.SID_ProjectDataManager);
	}

	/**
	 * Get the DB SimuRecManager(singleton) object.
	 */
	public static ISimuRecManager getSimuRecManager() {
		return (ISimuRecManager)SpringAppCtx.getBean(Constants.SID_SimuRecManager);
	}

	/**
	 * Init the SpringFramework application context
	 */
	public static void springAppContextSetup() {
		// Set the SpringAppContext to all ApplicationContextAware objects.
		SpringAppContext.SpringAppCtx = new FileSystemXmlApplicationContext(SpringAppCtxConfigXmlFile);
	}	
}
