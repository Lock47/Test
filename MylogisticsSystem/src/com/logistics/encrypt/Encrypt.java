package com.logistics.encrypt;

import java.security.MessageDigest;

//加密封装类
public abstract class Encrypt {
	public static final String KEY_SHA = "SHA";
	public static final String KEY_MD5 = "MD5";

	public static byte[] EncryptSHA(byte[] data) throws Exception {
		MessageDigest sha = MessageDigest.getInstance(KEY_SHA);
		sha.update(data);
		return sha.digest();
	}

	public static byte[] EncryptMD5(byte[] data) throws Exception {
		MessageDigest md5 = MessageDigest.getInstance(KEY_MD5);
		md5.update(data);
		return md5.digest();
	}
}
