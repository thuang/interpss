/**
 * <copyright>
 * 	Copyright www.interpss.com 2005
 * </copyright>
 * 
 * A JPanel for editing the model's data. It implements the IControllerEditor interface, which will be called from
 * the parent editor dialog.
 * 
 * @author  mzhou
 */

package org.interpss.dstab.control.exc.ieee.y1968.type1;

import java.util.Vector;

import org.interpss.dstab.control.base.EditUtilFunct;

import com.interpss.common.ui.IControllerEditor;

public class NBIeee1968Type1EditPanel extends javax.swing.JPanel implements IControllerEditor {
	private static final long serialVersionUID = 1;

	// define data to be edited
	Ieee1968Type1ExciterData _data;

    /** Creates new form FaultLocDataPanel */
    public NBIeee1968Type1EditPanel() {
        initComponents();
        // init the field to the default values
        _data = new Ieee1968Type1ExciterData();
        setData2Editor();
        
        // associate the editing fields with the verifier class defined at the end of this calss
  		DataVerifier verifier = new DataVerifier();
  	    kaTextField.setInputVerifier(verifier);
  	    taTextField.setInputVerifier(verifier);
  	    vrmaxTextField.setInputVerifier(verifier);
  	    vrminTextField.setInputVerifier(verifier);
  	    keTextField.setInputVerifier(verifier);
  	    teTextField.setInputVerifier(verifier);
  	    e1TextField.setInputVerifier(verifier);
  	    seE1TextField.setInputVerifier(verifier);
  	    e2TextField.setInputVerifier(verifier);
  	    seE2TextField.setInputVerifier(verifier);
  	    kfTextField.setInputVerifier(verifier);
  	    tfTextField.setInputVerifier(verifier);
    }
    
    /**
     * Init the editor panel, which will be called from its parent editor
     */
	public void init(Object controller) {
		// init the data object from the bus object being edited
		_data = ((Ieee1968Type1Exciter)controller).getData();
	}
	
	/**
	*	Set controller data to the editor
	*
	* @return false if there is any problem
	*/
    public boolean setData2Editor() {
    	EditUtilFunct.setTextFiled(kaTextField, 	_data.getKa(), "#0.00");
    	EditUtilFunct.setTextFiled(taTextField, 	_data.getTa(), "#0.000");
    	EditUtilFunct.setTextFiled(vrmaxTextField, 	_data.getVrmax(), "#0.00");
    	EditUtilFunct.setTextFiled(vrminTextField, 	_data.getVrmin(), "#0.00");
    	EditUtilFunct.setTextFiled(keTextField, 	_data.getKe(), "#0.00");
    	EditUtilFunct.setTextFiled(teTextField, 	_data.getTe(), "#0.000");
    	EditUtilFunct.setTextFiled(e1TextField, 	_data.getE1(), "#0.000");
    	EditUtilFunct.setTextFiled(seE1TextField, 	_data.getSeE1(), "#0.000");
    	EditUtilFunct.setTextFiled(e2TextField, 	_data.getE2(), "#0.000");
    	EditUtilFunct.setTextFiled(seE2TextField, 	_data.getSeE2(), "#0.000");
    	EditUtilFunct.setTextFiled(kfTextField, 	_data.getKf(), "#0.00");
    	EditUtilFunct.setTextFiled(tfTextField, 	_data.getTf(), "#0.000");

    	return true;
	}
    
	/**
	*	Save editor screen data to the controller data object
	*
	* @param errMsg error messages during the saving process.
	* @return false if there is any problem
	*/
    public boolean saveEditorData(Vector errMsg) throws Exception {
    	errMsg.clear();
    	
    	EditUtilFunct.saveTextField(_data, kaTextField, "ka", errMsg);
    	EditUtilFunct.saveTextField(_data, taTextField, "ta", errMsg);
    	EditUtilFunct.saveTextField(_data, vrmaxTextField, "vrmax", errMsg);
    	EditUtilFunct.saveTextField(_data, vrminTextField, "vrmin", errMsg);
    	EditUtilFunct.saveTextField(_data, keTextField, "ke", errMsg);
    	EditUtilFunct.saveTextField(_data, teTextField, "te", errMsg);
    	EditUtilFunct.saveTextField(_data, e1TextField, "e1", errMsg);
    	EditUtilFunct.saveTextField(_data, seE1TextField, "seE1", errMsg);
    	EditUtilFunct.saveTextField(_data, e2TextField, "e2", errMsg);
    	EditUtilFunct.saveTextField(_data, seE2TextField, "seE2", errMsg);
    	EditUtilFunct.saveTextField(_data, kfTextField, "kf", errMsg);
    	EditUtilFunct.saveTextField(_data, tfTextField, "tf", errMsg);

    	return errMsg.size() == 0;
	}
    
	/** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        kaLabel = new javax.swing.JLabel();
        kaTextField = new javax.swing.JTextField();
        taLabel = new javax.swing.JLabel();
        taTextField = new javax.swing.JTextField();
        vrmaxtaLabel = new javax.swing.JLabel();
        vrmaxTextField = new javax.swing.JTextField();
        vrminLabel = new javax.swing.JLabel();
        vrminTextField = new javax.swing.JTextField();
        keLabel = new javax.swing.JLabel();
        keTextField = new javax.swing.JTextField();
        teLabel = new javax.swing.JLabel();
        teTextField = new javax.swing.JTextField();
        e1Label = new javax.swing.JLabel();
        e1TextField = new javax.swing.JTextField();
        seE1Label = new javax.swing.JLabel();
        seE1TextField = new javax.swing.JTextField();
        e2Label = new javax.swing.JLabel();
        e2TextField = new javax.swing.JTextField();
        seE2Label = new javax.swing.JLabel();
        seE2TextField = new javax.swing.JTextField();
        kfLabel = new javax.swing.JLabel();
        kfTextField = new javax.swing.JTextField();
        tfLabel = new javax.swing.JLabel();
        tfTextField = new javax.swing.JTextField();

        kaLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        kaLabel.setText("Ka(pu)");

        kaTextField.setColumns(5);
        kaTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        kaTextField.setText("0.0");

        taLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        taLabel.setText("Ta(s)");

        taTextField.setColumns(5);
        taTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        taTextField.setText("0.0");

        vrmaxtaLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        vrmaxtaLabel.setText("Vrmax(pu)");

        vrmaxTextField.setColumns(5);
        vrmaxTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        vrmaxTextField.setText("0.0");

        vrminLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        vrminLabel.setText("Vrmin(pu)");

        vrminTextField.setColumns(5);
        vrminTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        vrminTextField.setText("0.0");

        keLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        keLabel.setText("Ke(pu)");

        keTextField.setColumns(5);
        keTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        keTextField.setText("0.0");

        teLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        teLabel.setText("Te(s)");

        teTextField.setColumns(5);
        teTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        teTextField.setText("0.0");

        e1Label.setFont(new java.awt.Font("Dialog", 0, 12));
        e1Label.setText("E1(pu)");

        e1TextField.setColumns(5);
        e1TextField.setFont(new java.awt.Font("Dialog", 0, 12));
        e1TextField.setText("0.0");

        seE1Label.setFont(new java.awt.Font("Dialog", 0, 12));
        seE1Label.setText("Se(E1)");

        seE1TextField.setColumns(5);
        seE1TextField.setFont(new java.awt.Font("Dialog", 0, 12));
        seE1TextField.setText("0.0");

        e2Label.setFont(new java.awt.Font("Dialog", 0, 12));
        e2Label.setText("E2(pu)");

        e2TextField.setColumns(5);
        e2TextField.setFont(new java.awt.Font("Dialog", 0, 12));
        e2TextField.setText("0.0");

        seE2Label.setFont(new java.awt.Font("Dialog", 0, 12));
        seE2Label.setText("Se(E2)");

        seE2TextField.setColumns(5);
        seE2TextField.setFont(new java.awt.Font("Dialog", 0, 12));
        seE2TextField.setText("0.0");

        kfLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        kfLabel.setText("Kf(pu)");

        kfTextField.setColumns(5);
        kfTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        kfTextField.setText("0.0");

        tfLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        tfLabel.setText("Tf(s)");

        tfTextField.setColumns(5);
        tfTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        tfTextField.setText("0.0");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(49, 49, 49)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(seE2Label, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, e1Label, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, vrminLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, kaLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(kaTextField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                    .add(seE2TextField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                    .add(vrminTextField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                    .add(e1TextField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE))
                .add(41, 41, 41)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(kfLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, taLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, keLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, seE1Label, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(kfTextField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(keTextField))
                    .add(taTextField)
                    .add(seE1TextField))
                .add(51, 51, 51)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(tfLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                    .add(e2Label, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                    .add(teLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                    .add(vrmaxtaLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(tfTextField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, vrmaxTextField)
                    .add(teTextField)
                    .add(e2TextField))
                .add(54, 54, 54))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(vrmaxTextField)
                            .add(vrmaxtaLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .add(13, 13, 13)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(teTextField)
                            .add(teLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .add(12, 12, 12)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(e2TextField)
                            .add(e2Label, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .add(14, 14, 14)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(tfTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(tfLabel)))
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(kaLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(taLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(taTextField)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, kaTextField))
                        .add(13, 13, 13)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(vrminLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(vrminTextField)
                            .add(keLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(keTextField))
                        .add(12, 12, 12)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(e1Label, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(e1TextField)
                            .add(seE1Label, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(seE1TextField))
                        .add(14, 14, 14)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                .add(kfTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(kfLabel))
                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                .add(seE2TextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(seE2Label)))))
                .add(17, 17, 17))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel e1Label;
    private javax.swing.JTextField e1TextField;
    private javax.swing.JLabel e2Label;
    private javax.swing.JTextField e2TextField;
    private javax.swing.JLabel kaLabel;
    private javax.swing.JTextField kaTextField;
    private javax.swing.JLabel keLabel;
    private javax.swing.JTextField keTextField;
    private javax.swing.JLabel kfLabel;
    private javax.swing.JTextField kfTextField;
    private javax.swing.JLabel seE1Label;
    private javax.swing.JTextField seE1TextField;
    private javax.swing.JLabel seE2Label;
    private javax.swing.JTextField seE2TextField;
    private javax.swing.JLabel taLabel;
    private javax.swing.JTextField taTextField;
    private javax.swing.JLabel teLabel;
    private javax.swing.JTextField teTextField;
    private javax.swing.JLabel tfLabel;
    private javax.swing.JTextField tfTextField;
    private javax.swing.JTextField vrmaxTextField;
    private javax.swing.JLabel vrmaxtaLabel;
    private javax.swing.JLabel vrminLabel;
    private javax.swing.JTextField vrminTextField;
    // End of variables declaration//GEN-END:variables

    // define data validation rules
	class DataVerifier extends javax.swing.InputVerifier {
    	public boolean verify(javax.swing.JComponent input) {
			if (input == null)
				return false;
       		try {
       			// data field verification rules
    			if ( input == kaTextField)
    				return EditUtilFunct.checkDataRange(input, _data, "ka");
    			if ( input == taTextField)
    				return EditUtilFunct.checkDataRange(input, _data, "ta");
    			if ( input == vrmaxTextField)
    				return EditUtilFunct.checkDataRange(input, _data, "vrmax");
    			if ( input == vrminTextField)
    				return EditUtilFunct.checkDataRange(input, _data, "vrmin");
    			if ( input == keTextField)
    				return EditUtilFunct.checkDataRange(input, _data, "ke");
    			if ( input == teTextField)
    				return EditUtilFunct.checkDataRange(input, _data, "te");
    			if ( input == e1TextField)
    				return EditUtilFunct.checkDataRange(input, _data, "e1");
    			if ( input == seE1TextField)
    				return EditUtilFunct.checkDataRange(input, _data, "seE1");
    			if ( input == e2TextField)
    				return EditUtilFunct.checkDataRange(input, _data, "e2");
    			if ( input == seE2TextField)
    				return EditUtilFunct.checkDataRange(input, _data, "seE2");
    			if ( input == kfTextField)
    				return EditUtilFunct.checkDataRange(input, _data, "kf");
    			if ( input == tfTextField)
    				return EditUtilFunct.checkDataRange(input, _data, "tf");
    			
 	       	} catch (Exception e) {
 	    		return false;
 	       	}		
			return true;
        }
    }
}
