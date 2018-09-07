package com.nacreav.navarathrikolu.util;

import java.text.MessageFormat;
import java.util.ResourceBundle;

public final class ResourceUtil {
	private static final ResourceBundle CONSTANT_BUNDLE = ResourceBundle.getBundle("constants");

	public static String getConstantString(ResourceKeys key) {
		return CONSTANT_BUNDLE.getString(key.toString());
	}

	public static String getConstantString(ResourceKeys key, Object ...args) {
		return MessageFormat.format(getConstantString(key), args);
	}
}
