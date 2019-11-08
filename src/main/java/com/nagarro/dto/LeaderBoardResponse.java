package com.nagarro.dto;

/**
 * This class is used for sending response of GetLeaderboard Request. Success
 * property determines whether the request was successful or not. Rank 1-5
 * property are customers that hold these ranks respectively on the basis of
 * their balance.
 * 
 * @author sahilmehta02
 *
 */
public class LeaderBoardResponse {

	boolean success;
	private CustomerResponse rank1;
	private CustomerResponse rank2;
	private CustomerResponse rank3;
	private CustomerResponse rank4;
	private CustomerResponse rank5;
	private CustomerResponse rank6;
	private CustomerResponse rank7;
	private CustomerResponse rank8;
	private CustomerResponse rank9;
	private CustomerResponse rank10;

	public LeaderBoardResponse() {

	}

	public LeaderBoardResponse(boolean success) {
		this.success = success;
	}

	public CustomerResponse getRank1() {
		return rank1;
	}

	public void setRank1(CustomerResponse rank1) {
		this.rank1 = rank1;
	}

	public CustomerResponse getRank2() {
		return rank2;
	}

	public void setRank2(CustomerResponse rank2) {
		this.rank2 = rank2;
	}

	public CustomerResponse getRank3() {
		return rank3;
	}

	public void setRank3(CustomerResponse rank3) {
		this.rank3 = rank3;
	}

	public CustomerResponse getRank4() {
		return rank4;
	}

	public void setRank4(CustomerResponse rank4) {
		this.rank4 = rank4;
	}

	public CustomerResponse getRank5() {
		return rank5;
	}

	public void setRank5(CustomerResponse rank5) {
		this.rank5 = rank5;
	}

	public CustomerResponse getRank6() {
		return rank6;
	}

	public void setRank6(CustomerResponse rank6) {
		this.rank6 = rank6;
	}

	public CustomerResponse getRank7() {
		return rank7;
	}

	public void setRank7(CustomerResponse rank7) {
		this.rank7 = rank7;
	}

	public CustomerResponse getRank8() {
		return rank8;
	}

	public void setRank8(CustomerResponse rank8) {
		this.rank8 = rank8;
	}

	public CustomerResponse getRank9() {
		return rank9;
	}

	public void setRank9(CustomerResponse rank9) {
		this.rank9 = rank9;
	}

	public CustomerResponse getRank10() {
		return rank10;
	}

	public void setRank10(CustomerResponse rank10) {
		this.rank10 = rank10;
	}

}
