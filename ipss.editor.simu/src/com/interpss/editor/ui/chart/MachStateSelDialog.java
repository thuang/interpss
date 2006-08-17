/*
 * MachStateSelDialog.java
 *
 * Created on March 12, 2006, 8:44 AM
 */

package com.interpss.editor.ui.chart;

import java.util.List;

import com.interpss.common.SpringAppContext;
import com.interpss.common.io.IProjectDataManager;
import com.interpss.common.io.ISimuRecManager;
import com.interpss.common.ui.WinUtilities;
import com.interpss.common.util.IpssLogger;
import com.interpss.editor.chart.ChartManager;

/**
 *
 * @author  mzhou
 */
public class MachStateSelDialog extends javax.swing.JDialog {
    private int caseId = 0;
    
    /** Creates new form MachStateSelDialog */
    public MachStateSelDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        WinUtilities.center(this);
        
        this.excRadioButton.setEnabled(false);
        this.excStateComboBox.setEnabled(false);
        this.govRadioButton.setEnabled(false);
        this.govStateComboBox.setEnabled(false);
        this.pssRadioButton.setEnabled(false);
        this.pssStateComboBox.setEnabled(false);
    }

    public void init(int aCaseId) {
		ISimuRecManager simuRecManager = SpringAppContext.getSimuRecManager();
        this.caseId = aCaseId;
	  	List list = simuRecManager.getElemIdStrList(this.caseId, ISimuRecManager.REC_TYPE_DStabMachineStates, IProjectDataManager.CaseType_DStabSimuRec);
		this.machListComboBox.setModel(new javax.swing.DefaultComboBoxModel(list.toArray()));
	    setStateComboList((String)this.machListComboBox.getSelectedItem());
    }
    
    private void setStateComboList(String machId) {
    	IpssLogger.getLogger().info("setStateComboList for machId: " + machId);
		this.machStateComboBox.setModel(new javax.swing.DefaultComboBoxModel(
				ChartManager.getStatesNameList(this.caseId, machId, ISimuRecManager.REC_TYPE_DStabMachineStates)));
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        buttonGroup1 = new javax.swing.ButtonGroup();
        machListLabel = new javax.swing.JLabel();
        machListComboBox = new javax.swing.JComboBox();
        plotButton = new javax.swing.JButton();
        closeButton = new javax.swing.JButton();
        statePanel = new javax.swing.JPanel();
        machStateComboBox = new javax.swing.JComboBox();
        machRadioButton = new javax.swing.JRadioButton();
        excStateComboBox = new javax.swing.JComboBox();
        excRadioButton = new javax.swing.JRadioButton();
        govRadioButton = new javax.swing.JRadioButton();
        govStateComboBox = new javax.swing.JComboBox();
        pssStateComboBox = new javax.swing.JComboBox();
        pssRadioButton = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Machine State Selection Dialog");
        machListLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        machListLabel.setText("Machine List");

        machListComboBox.setFont(new java.awt.Font("Dialog", 0, 10));
        machListComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        machListComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                machListComboBoxActionPerformed(evt);
            }
        });

        plotButton.setText("    Plot   ");
        plotButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plotButtonActionPerformed(evt);
            }
        });

        closeButton.setText("  Close  ");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        statePanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        machStateComboBox.setFont(new java.awt.Font("Dialog", 0, 10));
        machStateComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        buttonGroup1.add(machRadioButton);
        machRadioButton.setFont(new java.awt.Font("Dialog", 0, 12));
        machRadioButton.setSelected(true);
        machRadioButton.setText("Machine States");
        machRadioButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        machRadioButton.setMargin(new java.awt.Insets(0, 0, 0, 0));

        excStateComboBox.setFont(new java.awt.Font("Dialog", 0, 10));
        excStateComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        buttonGroup1.add(excRadioButton);
        excRadioButton.setFont(new java.awt.Font("Dialog", 0, 12));
        excRadioButton.setText("Exciter States");
        excRadioButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        excRadioButton.setMargin(new java.awt.Insets(0, 0, 0, 0));

        buttonGroup1.add(govRadioButton);
        govRadioButton.setFont(new java.awt.Font("Dialog", 0, 12));
        govRadioButton.setText("Governor States");
        govRadioButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        govRadioButton.setMargin(new java.awt.Insets(0, 0, 0, 0));

        govStateComboBox.setFont(new java.awt.Font("Dialog", 0, 10));
        govStateComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        pssStateComboBox.setFont(new java.awt.Font("Dialog", 0, 10));
        pssStateComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        buttonGroup1.add(pssRadioButton);
        pssRadioButton.setFont(new java.awt.Font("Dialog", 0, 12));
        pssRadioButton.setText("PSS States");
        pssRadioButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        pssRadioButton.setMargin(new java.awt.Insets(0, 0, 0, 0));

        org.jdesktop.layout.GroupLayout statePanelLayout = new org.jdesktop.layout.GroupLayout(statePanel);
        statePanel.setLayout(statePanelLayout);
        statePanelLayout.setHorizontalGroup(
            statePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, statePanelLayout.createSequentialGroup()
                .add(50, 50, 50)
                .add(statePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(machStateComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(machRadioButton))
                .add(46, 46, 46)
                .add(statePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(statePanelLayout.createSequentialGroup()
                        .add(excStateComboBox, 0, 88, Short.MAX_VALUE)
                        .add(49, 49, 49))
                    .add(statePanelLayout.createSequentialGroup()
                        .add(excRadioButton)
                        .add(58, 58, 58)))
                .add(statePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(govRadioButton)
                    .add(govStateComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 88, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(46, 46, 46)
                .add(statePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(pssStateComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 70, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(pssRadioButton))
                .add(39, 39, 39))
        );

        statePanelLayout.linkSize(new java.awt.Component[] {excStateComboBox, govStateComboBox, machStateComboBox, pssStateComboBox}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        statePanelLayout.setVerticalGroup(
            statePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(statePanelLayout.createSequentialGroup()
                .add(24, 24, 24)
                .add(statePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(statePanelLayout.createSequentialGroup()
                        .add(statePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(govRadioButton)
                            .add(pssRadioButton)
                            .add(excRadioButton))
                        .add(14, 14, 14)
                        .add(statePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(statePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                .add(excStateComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(govStateComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(pssStateComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 22, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                    .add(statePanelLayout.createSequentialGroup()
                        .add(machRadioButton)
                        .add(14, 14, 14)
                        .add(machStateComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap(144, Short.MAX_VALUE)
                .add(machListLabel)
                .add(35, 35, 35)
                .add(machListComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 162, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(282, 282, 282))
            .add(layout.createSequentialGroup()
                .add(230, 230, 230)
                .add(plotButton)
                .add(49, 49, 49)
                .add(closeButton)
                .addContainerGap(271, Short.MAX_VALUE))
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(statePanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        layout.linkSize(new java.awt.Component[] {closeButton, plotButton}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(28, 28, 28)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(machListComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(machListLabel))
                .add(17, 17, 17)
                .add(statePanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(34, 34, 34)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(closeButton)
                    .add(plotButton))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        this.setVisible(false);
        dispose();
    }//GEN-LAST:event_closeButtonActionPerformed

    private void plotButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plotButtonActionPerformed
    	if (machRadioButton.isSelected()) {
    		String state = (String)machStateComboBox.getSelectedItem();
    		String machId = (String)this.machListComboBox.getSelectedItem();
    		ChartManager.plotStateCurve(this.caseId, machId, state, "Not defined", ISimuRecManager.REC_TYPE_DStabMachineStates);
    	}
    }//GEN-LAST:event_plotButtonActionPerformed

    private void machListComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_machListComboBoxActionPerformed
	    setStateComboList((String)this.machListComboBox.getSelectedItem());
	}//GEN-LAST:event_machListComboBoxActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MachStateSelDialog(new javax.swing.JFrame(), true).setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton closeButton;
    private javax.swing.JRadioButton excRadioButton;
    private javax.swing.JComboBox excStateComboBox;
    private javax.swing.JRadioButton govRadioButton;
    private javax.swing.JComboBox govStateComboBox;
    private javax.swing.JComboBox machListComboBox;
    private javax.swing.JLabel machListLabel;
    private javax.swing.JRadioButton machRadioButton;
    private javax.swing.JComboBox machStateComboBox;
    private javax.swing.JButton plotButton;
    private javax.swing.JRadioButton pssRadioButton;
    private javax.swing.JComboBox pssStateComboBox;
    private javax.swing.JPanel statePanel;
    // End of variables declaration//GEN-END:variables
    
}
