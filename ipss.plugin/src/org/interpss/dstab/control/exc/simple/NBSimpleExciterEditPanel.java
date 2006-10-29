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

package org.interpss.dstab.control.exc.simple;

import java.util.Vector;

import com.interpss.common.ui.IControllerEditor;
import com.interpss.common.ui.SwingInputVerifyUtil;
import com.interpss.common.util.Num2Str;

public class NBSimpleExciterEditPanel extends javax.swing.JPanel implements IControllerEditor {
	private static final long serialVersionUID = 1;

	// define data to be edited
	SimpleExciterData _data;

    /** Creates new form FaultLocDataPanel */
    public NBSimpleExciterEditPanel() {
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
		_data = ((SimpleExciter)controller).getData();
	}
	
	/**
	*	Set controller data to the editor
	*
	* @return false if there is any problem
	*/
    public boolean setData2Editor() {
  	    kaTextField.setText(Num2Str.toStr(_data.getKa(), "#0.00"));
  	    taTextField.setText(Num2Str.toStr(_data.getTa(), "#0.000"));
  	    vrmaxTextField.setText(Num2Str.toStr(_data.getVrmax(), "#0.00"));
  	    vrminTextField.setText(Num2Str.toStr(_data.getVrmin(), "#0.00"));
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
    	
		if (SwingInputVerifyUtil.within(this.kaTextField, 1.0, 1000.0, errMsg, 
				"Ka is out of the range [1.0, 1000.0]"))
			_data.setKa(SwingInputVerifyUtil.getDouble(kaTextField));

		if (SwingInputVerifyUtil.within(this.taTextField, 0.001, 10.0, errMsg,
				"Ta is out of the range [0.001, 10]"))
			_data.setTa(SwingInputVerifyUtil.getDouble(taTextField));

    	if (SwingInputVerifyUtil.within(this.vrmaxTextField, 0.0, 20.0, errMsg,
    			"Vrmax is out of the range [0.0, 20.0]"))
    		_data.setVrmax(SwingInputVerifyUtil.getDouble(vrmaxTextField));

    	if (SwingInputVerifyUtil.within(this.vrminTextField, -20.0, 0.0d, errMsg,
    		"Vrmin is out of the range [-20.0, 0.0]"))
    		_data.setVrmin(SwingInputVerifyUtil.getDouble(vrminTextField));
		
    	return errMsg.size() == 0;
	}
    
	/** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        kaLabel = new javax.swing.JLabel();
        kaTextField = new javax.swing.JTextField();
        taLabel = new javax.swing.JLabel();
        taTextField = new javax.swing.JTextField();
        vrmaxLabel = new javax.swing.JLabel();
        vrmaxTextField = new javax.swing.JTextField();
        vrminLabel = new javax.swing.JLabel();
        vrminTextField = new javax.swing.JTextField();

        setLayout(new java.awt.GridBagLayout());

        kaLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        kaLabel.setText("Ka(pu)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 30, 5, 20);
        add(kaLabel, gridBagConstraints);

        kaTextField.setColumns(5);
        kaTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        kaTextField.setText("10.0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        add(kaTextField, gridBagConstraints);

        taLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        taLabel.setText("Ta(s)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 50, 5, 20);
        add(taLabel, gridBagConstraints);

        taTextField.setColumns(5);
        taTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        taTextField.setText("0.05");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        add(taTextField, gridBagConstraints);

        vrmaxLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        vrmaxLabel.setText("Vrmax(pu)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 30, 5, 20);
        add(vrmaxLabel, gridBagConstraints);

        vrmaxTextField.setColumns(5);
        vrmaxTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        vrmaxTextField.setText("10.0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        add(vrmaxTextField, gridBagConstraints);

        vrminLabel.setFont(new java.awt.Font("Dialog", 0, 12));
        vrminLabel.setText("Vrmin(pu)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 50, 5, 20);
        add(vrminLabel, gridBagConstraints);

        vrminTextField.setColumns(5);
        vrminTextField.setFont(new java.awt.Font("Dialog", 0, 12));
        vrminTextField.setText("0.0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        add(vrminTextField, gridBagConstraints);

    }// </editor-fold>//GEN-END:initComponents
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel kaLabel;
    private javax.swing.JTextField kaTextField;
    private javax.swing.JLabel taLabel;
    private javax.swing.JTextField taTextField;
    private javax.swing.JLabel vrmaxLabel;
    private javax.swing.JTextField vrmaxTextField;
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
