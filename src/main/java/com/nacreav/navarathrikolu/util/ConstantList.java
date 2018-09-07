package com.nacreav.navarathrikolu.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ConstantList {
	public static enum Keys {
		MENU_NAME, MENU_NAMESPACE, MENU_ACTION
	};
	private static List<Map<Keys, String>> menus = new ArrayList<>();
	
	static {
		setMenus();
	}
	
	public static List<Map<Keys, String>> getMenus() {
		return menus;
	}
	
	private static void setMenus() {
		Map<Keys, String> dashboard = new HashMap<>();
		dashboard.put(Keys.MENU_NAME, "Dashboard");
		dashboard.put(Keys.MENU_NAMESPACE, "/");
		dashboard.put(Keys.MENU_ACTION, "dashboard");
		
		Map<Keys, String> invoices = new HashMap<>();
		invoices.put(Keys.MENU_NAME, "Invoice");
		invoices.put(Keys.MENU_NAMESPACE, "/invoice/");
		invoices.put(Keys.MENU_ACTION, "init");
		
		Map<Keys, String> stocksView = new HashMap<>();
		stocksView.put(Keys.MENU_NAME, "Stocks");
		stocksView.put(Keys.MENU_NAMESPACE, "/stocks/");
		stocksView.put(Keys.MENU_ACTION, "view");
		
		
		Map<Keys, String> reportsView = new HashMap<>();
		reportsView.put(Keys.MENU_NAME, "Reports");
		reportsView.put(Keys.MENU_NAMESPACE, "/reports/");
		reportsView.put(Keys.MENU_ACTION, "view");
		
		Map<Keys, String> logout = new HashMap<>();
		logout.put(Keys.MENU_NAME, "Logout");
		logout.put(Keys.MENU_NAMESPACE, "/");
		logout.put(Keys.MENU_ACTION, "logout");
		
		
		menus.add(dashboard);
		menus.add(invoices);
		menus.add(stocksView);
		menus.add(reportsView);
		menus.add(logout);
	}
}
