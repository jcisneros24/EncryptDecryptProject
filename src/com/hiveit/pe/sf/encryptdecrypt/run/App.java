package com.hiveit.pe.sf.encryptdecrypt.run;

import com.hiveit.pe.sf.encryptdecrypt.controller.ControllerEncryptDecrypt;
import com.hiveit.pe.sf.encryptdecrypt.model.ModelEncryptDecrypt;
import com.hiveit.pe.sf.encryptdecrypt.view.JFEncryptDecrypt;

public class App {

	public static void main(String[] args) {
		JFEncryptDecrypt viewEncryptDecrypt = new JFEncryptDecrypt();
		ModelEncryptDecrypt modelEncryptDecrypt = new ModelEncryptDecrypt();
		ControllerEncryptDecrypt controllerEncryptDecrypt = new ControllerEncryptDecrypt(viewEncryptDecrypt, modelEncryptDecrypt);
		viewEncryptDecrypt.setVisible(true);
		viewEncryptDecrypt.setLocationRelativeTo(null);
	}

}
