package com.kh.mybatis.common;

public class MyEncryptor implements EncryptorInter{
	
	/**
	 * 암호화 알고리즘
	 * @param 원본 비밀번호
	 * @return 암호화 된 비밀번호
	 */
	@Override
	public String enc(String data) {
		String result = "aaa" + data + "zzz";
		
		return result;
	}

}
