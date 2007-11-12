package org.interpss.core.grid.gridgain.util;

import java.util.Hashtable;
import java.util.List;

import com.interpss.common.SpringAppContext;
import com.interpss.common.exp.InterpssRuntimeException;
import com.interpss.common.msg.IPSSMsgHub;
import com.interpss.common.msg.IpssMessage;
import com.interpss.common.util.IpssLogger;
import com.interpss.dstab.datatype.DStabSimuAction;
import com.interpss.dstab.util.DStabOutFunc;
import com.interpss.dstab.util.IDStabSimuOutputHandler;

/**
 * DStab simulation result messages are resend to the master node
 * 
 * @author mzhou
 */

public class DStabSimuGridOutputHandler implements IDStabSimuOutputHandler {
	/**
	 * IPSSGridMsgHubImpl, a message router which routes message to the master node
	 */
	private IPSSMsgHub msgHub = null;
	
	public DStabSimuGridOutputHandler(IPSSMsgHub msgHub) {
		this.msgHub = msgHub;
	}
	
	/**
	 * DStab simulation messages are re-send to the node
	 */
	@Override
	public boolean onMsgEventStatus(IpssMessage event) {
		DStabSimuAction e = (DStabSimuAction)event;
		try {
			if (e.getType() == DStabSimuAction.PlotStepMachineStates) {
			   	Hashtable<String, Object> machStates = e.getHashtableData();
				String machId = (String)machStates.get(DStabOutFunc.OUT_SYMBOL_MACH_ID);
				if (!this.isOutputFilter() || this.getOutputVarIdList().contains("Machine - " + machId)) {
					msgHub.sendMsg(event);
				}
		   }
		   else if (e.getType() == DStabSimuAction.PlotStepBusStates) {
			   	Hashtable<String, Object> busStates = e.getHashtableData();
				String busId = (String)busStates.get(DStabOutFunc.OUT_SYMBOL_BUS_ID);
				if (!this.isOutputFilter()  || this.getOutputVarIdList().contains("Bus - " + busId)) {
					msgHub.sendMsg(event);
				}				
		   }
		   else if (e.getType() == DStabSimuAction.PlotStepScriptDynamicBusDeviceStates) {
			   	Hashtable<String, Object> deviceStates = e.getHashtableData();
				String deviceId = (String)deviceStates.get(DStabOutFunc.OUT_SYMBOL_BUS_DEVICE_ID);
				if (!this.isOutputFilter()  || this.getOutputVarIdList().contains(deviceId)) {
					msgHub.sendMsg(event);
				}
		   }
		} catch (Exception ex) {
			IpssLogger.logErr(ex);
			SpringAppContext.getEditorDialogUtil().showErrMsgDialog("InterPSS DB Access Error", 
					ex.toString() + "\n Please contact InterPSS support");
			return false;
		}
	   return true;
	}

	@Override
	public List<String> getOutputVarIdList() {
		return null;
	}

	@Override
	public boolean isOutputFilter() {
		return false;
	}

	@Override
	public void setOutputFilter(boolean b) {
	}

	@Override
	public void setOutputVarIdList(List<String> list) {
	}

	@Override
	public void onMsgEvent(IpssMessage e) {
		throw new InterpssRuntimeException("Programming error, DStabSimuGridOutputHandler.onMsgEvent() not implemnted");
	}
}
