 /*
  * @(#)NBStabilizerPanel.java   
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

package org.interpss.editor.ui.edit.trans.dstab;
  
import java.awt.Component;
import java.util.Vector;

import javax.swing.JDialog;

import org.interpss.editor.data.dstab.DStabMachData;
import org.interpss.editor.form.InitDataUtil;
import org.interpss.editor.jgraph.ui.edit.IFormDataPanel;
import org.interpss.ui.ICustomPluginEditor;

import com.interpss.common.util.IpssLogger;
import com.interpss.dstab.mach.MachineController;
import com.interpss.simu.util.SimuSpringAppCtxUtil;
 
public class NBStabilizerPanel extends javax.swing.JPanel implements IFormDataPanel {
	private static final long serialVersionUID = 1;
	private JDialog parent = null;

    private DStabMachData machData = null;
	private MachineController controller = null;

	public void initPanel(JDialog aParent) {
		parent = aParent;
	}
    
	public void init(Object netContainer, Object aMachData) {
		IpssLogger.getLogger().info("NBStabilizerPanel init() called");
		machData = (DStabMachData)aMachData;
	    catyListComboBox.setModel(new javax.swing.DefaultComboBoxModel(
	    		SimuSpringAppCtxUtil.getStabilizerCategoryList()));	
	    typeListComboBox.setModel(new javax.swing.DefaultComboBoxModel(
	    		SimuSpringAppCtxUtil.getStabilizerNameList()));	
		if (machData.getHasPss()) {
			controller = SimuSpringAppCtxUtil.getStabilizer(machData.getPssData().getTypeName());
		}    
	}
	
	private void setEditPanel(String typeName) {
		MachineController aController = SimuSpringAppCtxUtil.getStabilizer(typeName);
   		if (controller == null || aController.getClass() != controller.getClass()) {
   			IpssLogger.getLogger().info("NBStabilizerPanel create a new controller class, " + aController.getName());
   			controller = aController;
   		  	InitDataUtil.initDStabControllerData(machData.getPssData(), typeName, controller);
   		}	
   		controller.setData(machData.getPssData().getDataXmlStr(), controller.getDataClass());
   		controller.setScripts(machData.getPssData().getScripts());
		dataPanel.removeAll();
		dataPanel.repaint();
		dataPanel.add((Component)controller.getEditPanel());
	}
	
    public boolean setForm2Editor()  {
		IpssLogger.getLogger().info("NBStabilizerPanel setForm2Editor() called");
		
		String typeName = machData.getPssData().getTypeName();
		//System.out.println("----->curent pss type name: " + typeName);
		if (typeName != null && !typeName.trim().equals("")) {
			// TODO: we need check typename collision here
	    	typeListComboBox.setSelectedItem(typeName);
		}
		else 
			typeListComboBox.setSelectedIndex(0);
		
		typeName = (String)typeListComboBox.getSelectedItem();
    	setEditPanel(typeName);  // a new controller instance is always created

    	((ICustomPluginEditor)controller.getEditPanel()).setData2Editor("");

		return true;
	}
    
    public boolean saveEditor2Form(Vector<String> errMsg) throws Exception {
		IpssLogger.getLogger().info("NBStabilizerPanel saveEditor2Form() called");

		boolean ok = true;
		
   		machData.getPssData().setTypeName((String)typeListComboBox.getSelectedItem());
   		machData.getPssData().setClassName(controller.getClass().getName());
		
    	if (!((ICustomPluginEditor)controller.getEditPanel()).saveEditorData(errMsg)) {
    		ok = false;
    	}
    	machData.getPssData().setDataXmlStr(controller.getDataXmlString());
    	machData.getPssData().setScripts(controller.getScripts());

		return ok;
    }
    
    /** Creates new form AclfEditPanel */
    public NBStabilizerPanel() {
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        selectPanel = new javax.swing.JPanel();
        catyLabel = new javax.swing.JLabel();
        catyListComboBox = new javax.swing.JComboBox();
        typeLabel = new javax.swing.JLabel();
        typeListComboBox = new javax.swing.JComboBox();
        dataPanel = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        selectPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 20));

        catyLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        catyLabel.setText("Category");
        selectPanel.add(catyLabel);

        catyListComboBox.setFont(new java.awt.Font("Dialog", 0, 12));
        catyListComboBox.setName("typeListComboBox");
        catyListComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                catyListComboBoxActionPerformed(evt);
            }
        });

        selectPanel.add(catyListComboBox);

        typeLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        typeLabel.setText("     Type");
        selectPanel.add(typeLabel);

        typeListComboBox.setFont(new java.awt.Font("Dialog", 0, 12));
        typeListComboBox.setName("typeListComboBox");
        typeListComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeListComboBoxActionPerformed(evt);
            }
        });

        selectPanel.add(typeListComboBox);

        add(selectPanel, java.awt.BorderLayout.NORTH);

        add(dataPanel, java.awt.BorderLayout.CENTER);

    }// </editor-fold>//GEN-END:initComponents

    private void catyListComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_catyListComboBoxActionPerformed
    	String catyName = (String)catyListComboBox.getSelectedItem();
	    if (catyName.equals("All")) {
	    	typeListComboBox.setModel(new javax.swing.DefaultComboBoxModel(
		    		SimuSpringAppCtxUtil.getStabilizerNameList()));	
	    }
	    else {
	    	typeListComboBox.setModel(new javax.swing.DefaultComboBoxModel(
		    		SimuSpringAppCtxUtil.getStabilizerNameList(catyName)));	
	    }
    	parent.pack();
    }//GEN-LAST:event_catyListComboBoxActionPerformed

    private void typeListComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeListComboBoxActionPerformed
    	String typeName = (String)typeListComboBox.getSelectedItem();
    	setEditPanel(typeName);
    	parent.pack();
    }//GEN-LAST:event_typeListComboBoxActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel catyLabel;
    private javax.swing.JComboBox catyListComboBox;
    private javax.swing.JPanel dataPanel;
    private javax.swing.JPanel selectPanel;
    private javax.swing.JLabel typeLabel;
    private javax.swing.JComboBox typeListComboBox;
    // End of variables declaration//GEN-END:variables
}
