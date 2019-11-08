package com.nagarro.dto;

/**
 * This class is used to receive the body of play request from the roulette
 * Application (Angular). Object of this class will contain the betting details
 * of customer that will be used to process the result of bet.
 * 
 * 
 * @author sahilmehta02
 *
 */
public class PlayRequest {

	int firstTwelveBet;
	int secondTwelveBet;
	int thirdTwelveBet;
	int zeroBet;
	int firstHalfBet;
	int secondHalfBet;
	int evenBet;
	int oddBet;
	int totalBet;

	public PlayRequest() {

	}

	public int getTotalBet() {
		return this.totalBet = this.firstTwelveBet + this.secondTwelveBet + this.thirdTwelveBet + this.zeroBet
				+ this.firstHalfBet + this.secondHalfBet + this.evenBet + this.oddBet;
	}

	public int getFirstTwelveBet() {
		return firstTwelveBet;
	}

	public void setFirstTwelveBet(int firstTwelveBet) {
		this.firstTwelveBet = firstTwelveBet;
	}

	public int getSecondTwelveBet() {
		return secondTwelveBet;
	}

	public void setSecondTwelveBet(int secondTwelveBet) {
		this.secondTwelveBet = secondTwelveBet;
	}

	public int getThirdTwelveBet() {
		return thirdTwelveBet;
	}

	public void setThirdTwelveBet(int thirdTwelveBet) {
		this.thirdTwelveBet = thirdTwelveBet;
	}

	public int getZeroBet() {
		return zeroBet;
	}

	public void setZeroBet(int zeroBet) {
		this.zeroBet = zeroBet;
	}

	public int getFirstHalfBet() {
		return firstHalfBet;
	}

	public void setFirstHalfBet(int firstHalfBet) {
		this.firstHalfBet = firstHalfBet;
	}

	public int getSecondHalfBet() {
		return secondHalfBet;
	}

	public void setSecondHalfBet(int secondHalfBet) {
		this.secondHalfBet = secondHalfBet;
	}

	public int getEvenBet() {
		return evenBet;
	}

	public void setEvenBet(int evenBet) {
		this.evenBet = evenBet;
	}

	public int getOddBet() {
		return oddBet;
	}

	public void setOddBet(int oddBet) {
		this.oddBet = oddBet;
	}

	@Override
	public String toString() {
		return "PlayRequest [firstTwelveBet=" + firstTwelveBet + ", secondTwelveBet=" + secondTwelveBet
				+ ", thirdTwelveBet=" + thirdTwelveBet + ", zeroBet=" + zeroBet + ", firstHalfBet=" + firstHalfBet
				+ ", secondHalfBet=" + secondHalfBet + ", evenBet=" + evenBet + ", oddBet=" + oddBet + ", totalBet="
				+ getTotalBet() + "]";
	}

}
