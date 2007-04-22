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

import javax.swing.JTextField;

import org.interpss.dstab.control.base.BaseControllerData;
import org.interpss.dstab.control.base.EditUtilFunct;

import com.interpss.common.ui.IControllerEditor;
import com.interpss.common.ui.SwingInputVerifyUtil;
import com.interpss.common.util.Num2Str;

public class NBIeee1968Type1EditPanel extends javax.swing.JPanel implements IControllerEditor {
	private static final long serialVersionUID = 1;

	// define data to be edited
	Ieee1968Type1ExciterData _data;

    /** Creates new form FaultLocDataPanel */
    public NBIeee1968Type1EditPanel() {
        initComponents();

        // associate the editing fields with the verifier class defined at the end of this calss
  		DataVerifier verifier = new DataVerifier();
  	    kaTextField.setInputVerifier(verifier);
  	    taTextField.setInputVerifier(verifier);
  	    vrmaxTextField.setInputVerifier(verifier);
  	    vrminTextField.setInputVerifier(verifier);
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
    	//EditUtilFunct.setTextFiled(seE2TextField, 	_data.getSeE2(), "#0.000");
    	//EditUtilFunct.setTextFiled(kfTextField, 	_data.getKf(), "#0.00");
    	//EditUtilFunct.setTextFiled(tfTextField, 	_data.getTf(), "#0.000");

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
    	EditUtilFunct.saveTextField(_data, vrmaxTextField, "vramx", errMsg);
    	EditUtilFunct.saveTextField(_data, vrminTextField, "vramx", errMsg);
		
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
        vrminLabel2 = new javax.swing.JLabel();
        vrminTextField2 = new javax.swing.JTextField();
        keLabel2 = new javax.swing.JLabel();
        keTextField2 = new javax.swing.JTextField();
        teLabel2 = new javax.swing.JLabel();
        teTextField2 = new javax.swing.JTextField();

        kaLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        kaLabel.setText("Ka(pu)");

        kaTextField.setColumns(5);
        kaTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        kaTextField.setText("10.0");

        taLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        taLabel.setText("Ta(s)");

        taTextField.setColumns(5);
        taTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        taTextField.setText("0.05");

        vrmaxtaLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        vrmaxtaLabel.setText("Vrmax(pu)");

        vrmaxTextField.setColumns(5);
        vrmaxTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        vrmaxTextField.setText("10.0");

        vrminLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        vrminLabel.setText("Vrmin(pu)");

        vrminTextField.setColumns(5);
        vrminTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        vrminTextField.setText("10.0");

        keLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        keLabel.setText("Ke(pu)");

        keTextField.setColumns(5);
        keTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        keTextField.setText("0.0");

        teLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        teLabel.setText("Te(s)");

        teTextField.setColumns(5);
        teTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        teTextField.setText("0.05");

        e1Label.setFont(new java.awt.Font("Dialog", 0, 12));
        e1Label.setText("E1(pu)");

        e1TextField.setColumns(5);
        e1TextField.setFont(new java.awt.Font("Dialog", 0, 12));
        e1TextField.setText("10.0");

        seE1Label.setFont(new java.awt.Font("Dialog", 0, 12));
        seE1Label.setText("Se(E1)");

        seE1TextField.setColumns(5);
        seE1TextField.setFont(new java.awt.Font("Dialog", 0, 12));
        seE1TextField.setText("0.0");

        e2Label.setFont(new java.awt.Font("Dialog", 0, 12));
        e2Label.setText("E2(pu)");

        e2TextField.setColumns(5);
        e2TextField.setFont(new java.awt.Font("Dialog", 0, 12));
        e2TextField.setText("0.05");

        vrminLabel2.setFont(new java.awt.Font("Dialog", 0, 12));
        vrminLabel2.setText("Se(E2)");

        vrminTextField2.setColumns(5);
        vrminTextField2.setFont(new java.awt.Font("Dialog", 0, 12));
        vrminTextField2.setText("10.0");

        keLabel2.setFont(new java.awt.Font("Dialog", 0, 12));
        keLabel2.setText("Kf(pu)");

        keTextField2.setColumns(5);
        keTextField2.setFont(new java.awt.Font("Dialog", 0, 12));
        keTextField2.setText("0.0");

        teLabel2.setFont(new java.awt.Font("Dialog", 0, 12));
        teLabel2.setText("Tf(s)");

        teTextField2.setColumns(5);
        teTextField2.setFont(new java.awt.Font("Dialog", 0, 12));
        teTextField2.setText("0.05");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(49, 49, 49)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(kaLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                        .add(39, 39, 39)
                        .add(kaTextField)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED))
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(vrminLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                        .add(vrminLabel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .add(17, 17, 17)))
                                .add(20, 20, 20))
                            .add(layout.createSequentialGroup()
                                .add(e1Label, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)))
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(e1TextField)
                                    .add(vrminTextField2))
                                .add(2, 2, 2))
                            .add(vrminTextField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE))))
                .add(41, 41, 41)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(taLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED))
                    .add(layout.createSequentialGroup()
                        .add(keLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED))
                    .add(layout.createSequentialGroup()
                        .add(seE1Label, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(21, 21, 21))
                    .add(layout.createSequentialGroup()
                        .add(keLabel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)))
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(layout.createSequentialGroup()
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(keTextField))
                    .add(org.jdesktop.layout.GroupLayout.LEADING, taTextField)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, keTextField2)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, seE1TextField))
                .add(58, 58, 58)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(e2Label, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(45, 45, 45))
                    .add(layout.createSequentialGroup()
                        .add(teLabel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(57, 57, 57))
                    .add(teLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                    .add(vrmaxtaLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, vrmaxTextField)
                    .add(teTextField)
                    .add(e2TextField)
                    .add(teTextField2))
                .add(64, 64, 64))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(24, 24, 24)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(taTextField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(layout.createSequentialGroup()
                                        .add(12, 12, 12)
                                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                            .add(layout.createSequentialGroup()
                                                .add(2, 2, 2)
                                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                                    .add(layout.createSequentialGroup()
                                                        .add(1, 1, 1)
                                                        .add(keTextField))
                                                    .add(teLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                                                    .add(keLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE))
                                                .add(3, 3, 3))
                                            .add(layout.createSequentialGroup()
                                                .add(2, 2, 2)
                                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                                    .add(vrminLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                                                    .add(layout.createSequentialGroup()
                                                        .add(1, 1, 1)
                                                        .add(vrminTextField)))
                                                .add(3, 3, 3))))
                                    .add(layout.createSequentialGroup()
                                        .add(15, 15, 15)
                                        .add(teTextField)
                                        .add(3, 3, 3))))
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                .add(2, 2, 2)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                    .add(layout.createSequentialGroup()
                                        .add(1, 1, 1)
                                        .add(kaTextField))
                                    .add(taLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                                    .add(kaLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE))
                                .add(36, 36, 36)))
                        .add(18, 18, 18)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(e1TextField)
                            .add(seE1TextField)
                            .add(e1Label, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                            .add(seE1Label, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                            .add(e2Label, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                            .add(layout.createSequentialGroup()
                                .add(3, 3, 3)
                                .add(e2TextField)))
                        .add(22, 22, 22)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(keTextField2)
                            .add(vrminTextField2)
                            .add(keLabel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
                            .add(vrminLabel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
                            .add(teLabel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
                            .add(teTextField2)))
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(vrmaxTextField)
                            .add(vrmaxtaLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .add(124, 124, 124)))
                .add(21, 21, 21))
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
    private javax.swing.JLabel keLabel2;
    private javax.swing.JTextField keTextField;
    private javax.swing.JTextField keTextField2;
    private javax.swing.JLabel seE1Label;
    private javax.swing.JTextField seE1TextField;
    private javax.swing.JLabel taLabel;
    private javax.swing.JTextField taTextField;
    private javax.swing.JLabel teLabel;
    private javax.swing.JLabel teLabel2;
    private javax.swing.JTextField teTextField;
    private javax.swing.JTextField teTextField2;
    private javax.swing.JTextField vrmaxTextField;
    private javax.swing.JLabel vrmaxtaLabel;
    private javax.swing.JLabel vrminLabel;
    private javax.swing.JLabel vrminLabel2;
    private javax.swing.JTextField vrminTextField;
    private javax.swing.JTextField vrminTextField2;
    // End of variables declaration//GEN-END:variables

    // define data validation rules
	class DataVerifier extends javax.swing.InputVerifier {
    	public boolean verify(javax.swing.JComponent input) {
			if (input == null)
				return false;
       		try {
       			// data field verification rules
    			if ( input == kaTextField ||
             		 input == taTextField ||
             		 input == vrmaxTextField ||
             		 input == vrminTextField )
    	       		return SwingInputVerifyUtil.getDouble((javax.swing.JTextField)input) >= 0.0;
 	       	} catch (Exception e) {
 	    		return false;
 	       	}		
			return true;
        }
    }
}
