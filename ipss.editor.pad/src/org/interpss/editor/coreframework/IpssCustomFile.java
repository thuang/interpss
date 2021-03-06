package org.interpss.editor.coreframework;

import org.interpss.editor.jgraph.ui.app.IAppSimuContext;

public class IpssCustomFile {
	private IAppSimuContext appSimuContext;
	private String filePathName;

	/** 
	 * True if this documents graph model was modified since last save.
	 */
	protected boolean modified = false;

	public void setSimuAppContext(IAppSimuContext appSimuContext) {
		this.appSimuContext = appSimuContext;
	}

	public IAppSimuContext getSimuAppContext() {
		return appSimuContext;
	}

	public void setFilePathName(String filePathName) {
		this.filePathName = filePathName;
	}

	public String getFilePathName() {
		return filePathName;
	}

	/**
	 * @return the dirty
	 */
	public boolean isModified() {
		return modified;
	}

	/**
	 * @param dirty the dirty to set
	 */
	public void setModified(boolean dirty) {
		this.modified = dirty;
	}
}
