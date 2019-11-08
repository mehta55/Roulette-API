package com.nagarro.dto;

/**
 * This class is used to send response for play Request received from the
 * Roulette Application (Angular). Success determines whether the play request
 * was processed successfully or not. RouletteNumber will determine the number
 * obtained after the spin. betResult is the amount lost or won by the customer.
 * Balance determines the updated balance of the customer after play request is
 * processed.
 * 
 * 
 * @author sahilmehta02
 *
 */
public class PlayResponse {

	boolean success;
	int rouletteNumber;
	int betResult;
	int balance;

	public PlayResponse() {

	}

	public PlayResponse(boolean success) {
		this.success = success;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public int getRouletteNumber() {
		return rouletteNumber;
	}

	public void setRouletteNumber(int rouletteNumber) {
		this.rouletteNumber = rouletteNumber;
	}

	public int getBetResult() {
		return betResult;
	}

	public void setBetResult(int betResult) {
		this.betResult = betResult;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

}
