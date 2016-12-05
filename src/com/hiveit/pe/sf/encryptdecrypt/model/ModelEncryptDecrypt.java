package com.hiveit.pe.sf.encryptdecrypt.model;

import com.hiveit.pe.eai.encryptdecrypt.bean.EncryptDecryptRequest;
import com.hiveit.pe.eai.encryptdecrypt.bean.EncryptDecryptResponse;
import com.hiveit.pe.eai.encryptdecrypt.service.EncryptDecryptServiceImpl;

public class ModelEncryptDecrypt {
	EncryptDecryptServiceImpl encryptDecryptServiceImpl = new EncryptDecryptServiceImpl();
	
	public EncryptDecryptResponse modelEncryptDecrypt(EncryptDecryptRequest request){
		return encryptDecryptServiceImpl.encryptDecrypt(request);
	}
}
