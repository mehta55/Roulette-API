package com.nagarro.util;

public class URLGenerator {

	public static String getLoginURL(String customerId) {
		return "http://localhost:8080/casino_admin/login/" + customerId;
	}
	
	public static String getCustomerURL(String customerId) {
		return "http://localhost:8080/casino_admin/customer/" + customerId;
	}

	public static String getBlockAmountURL(String customerId, int blockAmount) {
		return "http://localhost:8080/casino_admin/customer/" + customerId + "/block_amount/" + blockAmount;
	}

	public static String getAdjustAmountURL(String customerId, int adjustAmount) {
		return "http://localhost:8080/casino_admin/customer/" + customerId + "/adjust_amount/" + adjustAmount;
	}
	
	public static String getLeaderBoardURL() {
		return "http://localhost:8080/casino_admin/leaderBoard";
	}
}
