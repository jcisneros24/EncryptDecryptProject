package com.hiveit.pe.client.encryptdecrypt.run;

import javax.swing.JOptionPane;

import com.hiveit.pe.eai.encryptdecrypt.bean.EncryptDecryptRequest;
import com.hiveit.pe.eai.encryptdecrypt.service.EncryptDecryptImpl;
import com.hiveit.pe.eai.encryptdecrypt.util.PropertiesExterno;
import com.hiveit.pe.eai.encryptdecrypt.util.Utilitario;

public class App {

	public static void main(String[] args) {
		EncryptDecryptImpl excute = new EncryptDecryptImpl();
		EncryptDecryptRequest request = new EncryptDecryptRequest();
		byte[] key = Utilitario.llave();
		PropertiesExterno propertiesExterno = new PropertiesExterno();		
		request.setTypeTest(JOptionPane.showInputDialog( null,"Elija un tipo de operacion entre [encriptar = 1 / desencriptar = 2]",JOptionPane.QUESTION_MESSAGE));								
		try {
			if(request.getTypeTest().equals(propertiesExterno.getOpcEncryt())){
				request.setCodEncrypt(JOptionPane.showInputDialog( null,"Introduzca un valor a encriptar",JOptionPane.QUESTION_MESSAGE));
				request.setKey(key);
				excute.encryptDecrypt(request);
			}else if(request.getTypeTest().equals(propertiesExterno.getOpcDecrypt())){
				request.setCodDecrypt(JOptionPane.showInputDialog( null,"Introduzca un valor a desencriptar",JOptionPane.QUESTION_MESSAGE));
				String inKey= JOptionPane.showInputDialog(null,"Ingrese la llave de desencriptacion: ",JOptionPane.QUESTION_MESSAGE);
				request.setKey(inKey.getBytes());
				excute.encryptDecrypt(request);
			}else{
				JOptionPane.showMessageDialog(null,"Error en el tipo de operacion");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error en el flujo "+e);
		}
	}

}
