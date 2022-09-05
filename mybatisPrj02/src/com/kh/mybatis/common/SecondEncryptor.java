package com.kh.mybatis.common;

public class SecondEncryptor implements EncryptorInter{

	@Override
	public String enc(String data) {
		String result = data + "000";
		return result;
	}

}
