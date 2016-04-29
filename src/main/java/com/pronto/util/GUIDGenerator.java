package com.pronto.util;

import java.net.InetAddress;
import java.security.SecureRandom;

public class GUIDGenerator {
	public GUIDGenerator() throws GUIDException {

		try {
			StringBuffer stringbuffer = new StringBuffer();
			StringBuffer stringbuffer1 = new StringBuffer();
			seeder = new SecureRandom();
			InetAddress inetaddress = InetAddress.getLocalHost();
			byte abyte0[] = inetaddress.getAddress();
			String s = hexFormat(getInt(abyte0), 8);
			String s1 = hexFormat(hashCode(), 8);
			stringbuffer.append("-");
			stringbuffer1.append(s.substring(0, 4));
			stringbuffer.append(s.substring(0, 4));
			stringbuffer.append("-");
			stringbuffer1.append(s.substring(4));
			stringbuffer.append(s.substring(4));
			stringbuffer.append("-");
			stringbuffer1.append(s1.substring(0, 4));
			stringbuffer.append(s1.substring(0, 4));
			stringbuffer.append("-");
			stringbuffer1.append(s1.substring(4));
			stringbuffer.append(s1.substring(4));
			midValue = stringbuffer.toString();
			midValueUnformated = stringbuffer1.toString();
		} catch (Exception exception) {
			throw new GUIDException("error - failure to instantiate GUIDGenerator" + exception);
		}
	}

	private String getVal(String s) {
		int i = (int) System.currentTimeMillis() & 0xffffffff;
		int j = seeder.nextInt();
		return hexFormat(i, 8) + s + hexFormat(j, 8);
	}

	public String getUnformatedUUID() {
		return getVal(midValueUnformated);
	}

	public String getUUID() {
		return getVal(midValue);
	}

	private int getInt(byte abyte0[]) {
		int i = 0;
		int j = 24;
		for (int k = 0; j >= 0; k++) {
			int l = abyte0[k] & 0xff;
			i += l << j;
			j -= 8;
		}

		return i;
	}

	private String hexFormat(int i, int j) {
		String s = Integer.toHexString(i);
		return padHex(s, j) + s;
	}

	private String padHex(String s, int i) {
		StringBuffer stringbuffer = new StringBuffer();
		if (s.length() < i) {
			for (int j = 0; j < i - s.length(); j++)
				stringbuffer.append("0");

		}
		return stringbuffer.toString();
	}

	private SecureRandom seeder;
	private String midValue;
	private String midValueUnformated;
}
