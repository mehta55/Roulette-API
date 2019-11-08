package com.nagarro.services;

import com.nagarro.dto.AdjustAmountResponse;
import com.nagarro.dto.BlockAmountResponse;
import com.nagarro.dto.CustomerResponse;
import com.nagarro.dto.LeaderBoardResponse;
import com.nagarro.dto.LoginResponse;
import com.nagarro.dto.PlayRequest;
import com.nagarro.dto.PlayResponse;

/**
 * This interface offers services to the RouletteResource.
 * 
 * @author sahilmehta02
 *
 */
public interface RouletteService {

	/**
	 * This method accepts customer ID in parameter and requests Administrator
	 * Application for customer login.
	 * 
	 * @param customerId Unique ID of customer
	 * @return LoginResponse that has success property that determines whether login
	 *         was successful or not.
	 */
	public LoginResponse loginCustomer(String customerId);

	/**
	 * This method accepts customer ID in parameter and requests Administrator
	 * Application for customer details.
	 * 
	 * @param customerId Unique ID of customer
	 * @return CustomerResponse that has success status, customer's name and balance
	 *         in it.
	 */
	public CustomerResponse getCustomer(String customerId);

	/**
	 * This method accepts customer ID and amount to be blocked. It requests
	 * Administrator Application for blocking blockAmount from customer's balance.
	 * 
	 * @param customerId  Unique ID of customer
	 * @param blockAmount Amount to be blocked
	 * @return BlockAmountResponse that has success status and customer's updated
	 *         balance
	 */
	public BlockAmountResponse blockAmount(String customerId, int blockAmount);

	/**
	 * This method accepts customer ID and amount to be adjusted in parameter. It
	 * requests Administrator Application for adjusting adjustAmount from customer's
	 * balance.
	 * 
	 * @param customerId   Unique ID of customer
	 * @param adjustAmount Amount to be adjusted
	 * @return AdjustAmountResponse that has success status and customer's updated
	 *         balance.
	 */
	public AdjustAmountResponse adjustAmount(String customerId, int adjustAmount);

	/**
	 * This method requests Administrator Application for leaderboard.
	 * 
	 * @return LeaderBoardResponse that has a success status and top 5 customers
	 */
	public LeaderBoardResponse getLeaderBoard();

	/**
	 * This method accepts customer ID and play request object. PlayRequest object
	 * contains the bet details of the customer and is used to calculate the bet
	 * results. First, blockAmount method is called that blocks the customer's
	 * balance for the bet. Then, roulette number is generated. At last, bet result
	 * is evaluated using the roulette number and PlayRequest object and
	 * PlayResponse is prepared accordingly.
	 * 
	 * 
	 * @param customerId  Unique ID of customer
	 * @param playRequest contains betting details of the customer
	 * @return PlayResponse that has success status, roulette number, bet result and
	 *         updated balance.
	 */
	public PlayResponse play(String customerId, PlayRequest playRequest);
}
