package com.pronto.util;

import java.io.File;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.shiro.crypto.hash.Sha1Hash;

public class Util {

	private final static Logger logger = Logger.getLogger(Util.class.getName());

	public static final char[] HEX_CHARS = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', '0', '1', '2', '3', '4', '5', '6',
			'7', '8', '9' };

	public static final char[] SECURE_CHARS = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
			'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
			'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3',
			'4', '5', '6', '7', '8', '9', '!', '@', '$' };

	public static String generate() {
		return generate(HEX_CHARS, 8);
	}

	public static String generate(final int length) {
		return generate(HEX_CHARS, length);
	}

	public static String generate(final char[] characters, final int length) {

		return RandomStringUtils.random(length, characters);
	}

	public static String generateRandom(int length) {
		String password = "";
		BigDecimal bigDecimal = new BigDecimal(Math.random());

		bigDecimal = bigDecimal.movePointRight(length);
		password = bigDecimal.setScale(0, BigDecimal.ROUND_UP).toString();

		bigDecimal = bigDecimal.movePointRight(length - password.length());
		password = bigDecimal.setScale(0, BigDecimal.ROUND_UP).toString();

		return password;
	}

	public static String generateRandom(int minLength, int maxLength) {
		Random rand = new Random();

		int length = minLength + rand.nextInt(maxLength - minLength + 1);

		return generate(SECURE_CHARS, length);
	}

	public static boolean setPassword(String password, byte[] passwordSalt, String encodedPassword) {
		if (password != null) {
			password = new Sha1Hash(password, passwordSalt).toString();
		}

		if (password.equals(encodedPassword))
			return true;
		else
			return false;

	}

	public static String getUUID() {
		String uuid = null;
		try {
			GUIDGenerator gen = new GUIDGenerator();
			uuid = gen.getUnformatedUUID();
		} catch (GUIDException e) {
			e.printStackTrace();
		}

		return uuid;
	}

	/**
	 * Gets the directory of the executing JAR.
	 * 
	 * @param aType
	 * @return the directory of the running jar
	 */
	public static File getBaseDir(Object aType) {
		URL dir = aType.getClass().getResource("/" + aType.getClass().getName().replaceAll("\\.", "/") + ".class");
		File dbDir = new File(System.getProperty("user.dir"));

		try {
			if (dir.toString().startsWith("jar:")) {
				dir = new URL(dir.toString().replaceFirst("^jar:", "").replaceFirst("/[^/]+.jar!.*$", ""));
				dbDir = new File(dir.toURI());
			}
		} catch (MalformedURLException e) {
			logger.log(Level.WARNING, e.getMessage(), e);
		} catch (URISyntaxException e) {
			logger.log(Level.WARNING, e.getMessage(), e);
		}
		return dbDir;
	}
}