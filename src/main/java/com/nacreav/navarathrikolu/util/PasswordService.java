package com.nacreav.navarathrikolu.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class PasswordService {

	private static final Logger LOGGER = LoggerFactory.getLogger(PasswordService.class);
	private static PasswordService instance;

	private PasswordService() { }

	public synchronized String encrypt(String plaintext) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA"); //step 2
		} catch (NoSuchAlgorithmException e) {
			LOGGER.error("SHA Algorithm Instance Exception => ", e);
		}

		try {
			md.update(plaintext.getBytes("UTF-8")); //step 3
		} catch (UnsupportedEncodingException e) {
			LOGGER.error("Encription Exception => ", e);
		}

		byte raw[] = md.digest(); //step 4
		String hash = Base64.encodeBase64String(raw); //step 5
		return hash; //step 6
	}

	public static synchronized PasswordService getInstance() { //step 1
		if (instance == null) {
			instance = new PasswordService();
		}
		return instance;
	}
}
