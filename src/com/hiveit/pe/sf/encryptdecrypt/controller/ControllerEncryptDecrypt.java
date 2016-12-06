package com.hiveit.pe.sf.encryptdecrypt.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.hiveit.pe.eai.encryptdecrypt.bean.EncryptDecryptRequest;
import com.hiveit.pe.eai.encryptdecrypt.bean.EncryptDecryptResponse;
import com.hiveit.pe.eai.encryptdecrypt.util.PropertiesExterno;
import com.hiveit.pe.sf.encryptdecrypt.model.ModelEncryptDecrypt;
import com.hiveit.pe.sf.encryptdecrypt.view.JFEncryptDecrypt;

public class ControllerEncryptDecrypt implements ActionListener {
	JFEncryptDecrypt viewEncryptDecrypt = new JFEncryptDecrypt();
	ModelEncryptDecrypt modelEncryptDecrypt = new ModelEncryptDecrypt();
	PropertiesExterno propertiesExterno = new PropertiesExterno();
	
	public ControllerEncryptDecrypt(JFEncryptDecrypt viewEncryptDecrypt, ModelEncryptDecrypt modelEncryptDecrypt){
		this.viewEncryptDecrypt = viewEncryptDecrypt;
		this.modelEncryptDecrypt = modelEncryptDecrypt;		
		this.viewEncryptDecrypt.comboBox.addActionListener(this);
		this.viewEncryptDecrypt.btnExecute.addActionListener(this);
		deshabilitarCasillas();
	}
	
	public void actionPerformed(ActionEvent e){
		EncryptDecryptResponse response = null;				
		try {
			response = new EncryptDecryptResponse();
			EncryptDecryptRequest request = new EncryptDecryptRequest();
				
			if(e.getSource() == viewEncryptDecrypt.comboBox){
				habilitarCasillas();								
			}
			if(e.getSource() == viewEncryptDecrypt.btnExecute){
				
				if(validarcampos()==true){	
					request.setTypeOpc(viewEncryptDecrypt.comboBox.getSelectedItem().toString());
					request.setCodEncrypt(viewEncryptDecrypt.txtCodEncrypt.getText());
					request.setKey(viewEncryptDecrypt.txtKey.getText().getBytes());														
					response = modelEncryptDecrypt.modelEncryptDecrypt(request);
					String rpta= response.getCodRpta();
					if(!rpta.isEmpty() && rpta != null){
						JOptionPane.showMessageDialog(null, response.getMsgRpta());
						viewEncryptDecrypt.txtCodEncrypted.setText(response.getCodEncrypted());
					}
					
				}
			}
								
		} catch (Exception ex) {				
			JOptionPane.showMessageDialog(null,response.getMsgRpta());
		}

	}
	protected void habilitarCasillas() {
	    boolean enabled = false;
		if(viewEncryptDecrypt.comboBox.getSelectedItem().equals(propertiesExterno.getOpcEncryt())){
			enabled = true;
			viewEncryptDecrypt.txtCodEncrypt.setEnabled(enabled);
			viewEncryptDecrypt.txtCodDecrypt.setEnabled(false);
			viewEncryptDecrypt.txtKey.setEnabled(false);
			limpiarCasillas();
		    viewEncryptDecrypt.txtCodEncrypt.requestFocus();
		}else if(viewEncryptDecrypt.comboBox.getSelectedItem().equals(propertiesExterno.getOpcDecrypt())){
			enabled = true;
			viewEncryptDecrypt.txtCodEncrypt.setEnabled(false);
			viewEncryptDecrypt.txtCodDecrypt.setEnabled(enabled);
			viewEncryptDecrypt.txtKey.setEnabled(enabled);
			limpiarCasillas();
		    viewEncryptDecrypt.txtCodDecrypt.requestFocus();
		}  
	}
    private void limpiarCasillas(){
        viewEncryptDecrypt.txtCodEncrypt.setText("");
        viewEncryptDecrypt.txtCodDecrypt.setText("");
        viewEncryptDecrypt.txtKey.setText("");
        viewEncryptDecrypt.txtCodEncrypted.setText("");
    }
    private boolean validarcampos(){
    	boolean flag=true;
    	if(viewEncryptDecrypt.txtCodEncrypt.getText().equals("") || viewEncryptDecrypt.txtCodEncrypt.getText().equals("")){
    		JOptionPane.showMessageDialog(null, "Error en el aplicativo: " + "Ingresar valor en los campos");
    		viewEncryptDecrypt.txtCodEncrypt.requestFocus();
    		flag=false;
    	}
    	return flag;
    }
    private void deshabilitarCasillas() {
		viewEncryptDecrypt.txtCodEncrypt.setEnabled(false);
		viewEncryptDecrypt.txtCodDecrypt.setEnabled(false);
		viewEncryptDecrypt.txtKey.setEnabled(false);
	}
}
