package net.gpedro.faculdade.filinha.core.misc;

import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.digest.DigestUtils;

public class CryptoUtil {

	public static String toSha1(String value)
			throws UnsupportedEncodingException {
		return DigestUtils.sha1Hex(value.getBytes("UTF-8"));
	}
}
