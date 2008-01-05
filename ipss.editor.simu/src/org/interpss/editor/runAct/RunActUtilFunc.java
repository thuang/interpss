 /*
  * @(#)RunActUtilFunc.java   
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

package org.interpss.editor.runAct;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.interpss.editor.data.proj.ProjData;
import org.interpss.editor.jgraph.GraphSpringAppContext;
import org.interpss.editor.jgraph.ui.app.IAppSimuContext;
import org.interpss.editor.ui.IOutputTextDialog;
import org.interpss.editor.ui.UISpringAppContext;

import com.interpss.common.SpringAppContext;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.util.IpssLogger;
import com.interpss.core.aclfadj.AclfAdjNetwork;
import com.interpss.core.aclfadj.FunctionLoad;
import com.interpss.core.aclfadj.PQBusLimit;
import com.interpss.core.aclfadj.PSXfrPControl;
import com.interpss.core.aclfadj.PVBusLimit;
import com.interpss.core.aclfadj.RemoteQBus;
import com.interpss.core.aclfadj.RemoteQControlType;
import com.interpss.core.aclfadj.TapControl;
import com.interpss.core.net.Area;
import com.interpss.core.net.IRegulationDevice;
import com.interpss.dstab.DynamicSimuAlgorithm;
import com.interpss.dstab.util.IDStabSimuDatabaseOutputHandler;
import com.interpss.simu.SimuContext;

public class RunActUtilFunc {
	public static String AllControlDevices = "All Control Devices";
	
	public static Object[] getFunctionLoadList(AclfAdjNetwork adjNet, double tolerance, IPSSMsgHub msg) {
		List<String> list = new ArrayList<String>();
		list.add(AllControlDevices);
		for (int i = 0; i < adjNet.getFunctionLoadList().size(); i++) {
			FunctionLoad load = (FunctionLoad)adjNet.getFunctionLoadList().get(i);
			if (load.needAdjust(tolerance, adjNet.getBaseKva(), msg))
				list.add( load.getId() + " at " + load.getBus().getName());
		}
		return list.toArray();
	}

	public static Object[] getPVBusLimitList(AclfAdjNetwork adjNet, IPSSMsgHub msg) {
		List<String> list = new ArrayList<String>();
		list.add(AllControlDevices);
		for (int i = 0; i < adjNet.getPvBusLimitList().size(); i++) {
			PVBusLimit pvLimit = (PVBusLimit)adjNet.getPvBusLimitList().get(i);
			if (pvLimit.needAdjust(0.0, adjNet.getBaseKva(), msg))
				list.add( pvLimit.getId() + " at " + pvLimit.getBus().getName() +
					"(" + (pvLimit.isActive()?"on":"off") + ")");
		}
		return list.toArray();	
	}

	public static Object[] getPQBusLimitList(AclfAdjNetwork adjNet, IPSSMsgHub msg) {
		List<String> list = new ArrayList<String>();
		list.add(AllControlDevices);
		for (int i = 0; i < adjNet.getPqBusLimitList().size(); i++) {
			PQBusLimit pqLimit = (PQBusLimit)adjNet.getPqBusLimitList().get(i);
			if (pqLimit.needAdjust(0.0, adjNet.getBaseKva(), msg))
				list.add( pqLimit.getId() + " at " + pqLimit.getBus().getName() +
					"(" + (pqLimit.isActive()?"on":"off") + ")");
		}
		return list.toArray();	
	}

	public static Object[] getRemoteQBusList(AclfAdjNetwork adjNet, double tolerance, IPSSMsgHub msg) {
		List<String> list = new ArrayList<String>();
		list.add(AllControlDevices);
		for (int i = 0; i < adjNet.getRemoteQBusList().size(); i++) {
			RemoteQBus reQ = (RemoteQBus)adjNet.getRemoteQBusList().get(i);
			if (reQ.needAdjust(tolerance, adjNet.getBaseKva(), msg)) {
				if (reQ.getControlType() == RemoteQControlType.BUS_VOLTAGE)
					list.add( reQ.getId() + " at " + reQ.getBus().getName() +
							"-> Bus:" + reQ.getRemoteBus().getId());
				else
					list.add( reQ.getId() + " at " + reQ.getBus().getName() +
							"-> Branch:" + reQ.getRemoteBranch().getId());
			}	
		}
		return list.toArray();
	}

	public static Object[] getXfrTapControlList(AclfAdjNetwork adjNet, double tolerance, IPSSMsgHub msg) {
		List<String> list = new ArrayList<String>();
		list.add(AllControlDevices);
		for (int i = 0; i < adjNet.getTapControlList().size(); i++) {
			TapControl xfr = (TapControl)adjNet.getTapControlList().get(i);
			if (xfr.needAdjust(tolerance, adjNet.getBaseKva(), msg)) {
				list.add( xfr.getId() + " at " + xfr.getAclfBranch().getName());
			}	
		}
		return list.toArray();	
	}

	public static Object[] getPSXfrPControlList(AclfAdjNetwork adjNet, double tolerance, IPSSMsgHub msg) {
		List<String> list = new ArrayList<String>();
		list.add(AllControlDevices);
		for (int i = 0; i < adjNet.getPsXfrPControlList().size(); i++) {
			PSXfrPControl psXfr = (PSXfrPControl)adjNet.getPsXfrPControlList().get(i);
			if (psXfr.needAdjust(tolerance, adjNet.getBaseKva(), msg)) {
				list.add( psXfr.getId() + " at " + psXfr.getAclfBranch().getName());
			}	
		}
		return list.toArray();	
	}

	public static Object[] getInterareaPControlList(AclfAdjNetwork adjNet, IPSSMsgHub msg) {
		List<String> list = new ArrayList<String>();
		list.add(AllControlDevices);
		Iterator e = adjNet.getAreaList().iterator();
		while (e.hasNext()) {
			Area a = (Area)e.next();
			if (a.getRegDeviceList().size() > 0) {
				IRegulationDevice regDevice = (IRegulationDevice)a.getRegDeviceList().get(0);
				if (regDevice.needAdjustment(a, adjNet, msg))
					list.add( a.getNumber() + " name: " + a.getName());
			}
		}		
		return list.toArray();	
	}
	
	public static IDStabSimuDatabaseOutputHandler createDBOutputHandler(SimuContext simuCtx) {
		IDStabSimuDatabaseOutputHandler handler = (IDStabSimuDatabaseOutputHandler)simuCtx.getDynSimuAlgorithm().getSimuOutputHandler();
		IAppSimuContext appSimuCtx = GraphSpringAppContext.getIpssGraphicEditor().getCurrentAppSimuContext();
		ProjData projData = (ProjData)appSimuCtx.getProjData();
		// to avoid conflict with StudyCase name, we add " SimuRecord" to the SimuRecord case.
		try {
			if (!handler.init(projData.getProjectDbId(), projData.getDStabCaseName()+" SimuRecord"))
				return null;
		} catch (Exception e) {
			IpssLogger.logErr(e);
			SpringAppContext.getEditorDialogUtil().showErrMsgDialog("Error to Create DB SimuRecord", 
					e.toString() + "\nPlease contact InterPSS support");
		}
		return handler;
	}
	
	/**
	 * Display Aclf summary if selected by the user
	 * 
	 * @param simuCtx
	 */
	public static void displayAclfSummaryResult(SimuContext simuCtx) {
  		IOutputTextDialog dialog = UISpringAppContext.getOutputTextDialog("Loadflow Analysis Info");
  		dialog.display(simuCtx.getDynSimuAlgorithm());
	}	
	
	public static boolean checkDStabSimuData(DynamicSimuAlgorithm algo, IPSSMsgHub msg) {
		if (!algo.checkData(msg)) {
			IpssLogger.getLogger().warning("DStab simulation data checking failed");
			return false;
		}

		// dstab net data changed in the mapping process
		if (!algo.getDStabNet().checkData(msg)) {
			IpssLogger.getLogger().warning("DStab network data checking failed");
			return false;
		}		
		return true;
	}
}
