package com.nagarro.services;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import com.nagarro.dto.AdjustAmountResponse;
import com.nagarro.dto.BlockAmountResponse;
import com.nagarro.dto.CustomerResponse;
import com.nagarro.dto.LeaderBoardResponse;
import com.nagarro.dto.LoginResponse;
import com.nagarro.dto.PlayRequest;
import com.nagarro.dto.PlayResponse;
import com.nagarro.util.RouletteUtil;
import com.nagarro.util.URLGenerator;

@Service
public class RouletteServiceImpl implements RouletteService {

	final static Logger LOG = Logger.getLogger(RouletteServiceImpl.class);

	public LoginResponse loginCustomer(String customerId) {

		LOG.info("Requesting casino_admin for loginCustomer for customerId : " + customerId);

		RestTemplate restTemplate = new RestTemplate();
		LoginResponse loginResponse = new LoginResponse(false);

		try {
			loginResponse = restTemplate.getForObject(URLGenerator.getLoginURL(customerId), LoginResponse.class);
		} catch (ResourceAccessException exception) {
			LOG.error("Connection Refused by casino_admin. ");
		}

		return loginResponse;
	}

	public CustomerResponse getCustomer(String customerId) {

		LOG.info("Requesting casino_admin for getCustomer for customerId : " + customerId);

		RestTemplate restTemplate = new RestTemplate();
		CustomerResponse customerResponse = new CustomerResponse(false);

		try {
			customerResponse = restTemplate.getForObject(URLGenerator.getCustomerURL(customerId),
					CustomerResponse.class);
		} catch (ResourceAccessException exception) {
			LOG.error("Connection Refused by casino_admin. ");
		}

		return customerResponse;
	}

	public BlockAmountResponse blockAmount(String customerId, int blockAmount) {

		LOG.info("Requesting casino_admin for blockAmount : " + blockAmount + " for customerId : " + customerId);

		RestTemplate restTemplate = new RestTemplate();
		BlockAmountResponse blockAmountResponse = new BlockAmountResponse(false);

		try {
			blockAmountResponse = restTemplate.getForObject(URLGenerator.getBlockAmountURL(customerId, blockAmount),
					BlockAmountResponse.class);
		} catch (ResourceAccessException exception) {
			LOG.error("Connection Refused by casino_admin. ");
		}

		return blockAmountResponse;
	}

	public AdjustAmountResponse adjustAmount(String customerId, int adjustAmount) {

		LOG.info("Requesting casino_admin for adjustAmount : " + adjustAmount + " for customerId : " + customerId);

		RestTemplate restTemplate = new RestTemplate();
		AdjustAmountResponse adjustAmountResponse = new AdjustAmountResponse(false);

		try {
			adjustAmountResponse = restTemplate.getForObject(URLGenerator.getAdjustAmountURL(customerId, adjustAmount),
					AdjustAmountResponse.class);
		} catch (ResourceAccessException exception) {
			LOG.error("Connection Refused by casino_admin. ");
		}

		return adjustAmountResponse;
	}

	public PlayResponse play(String customerId, PlayRequest playRequest) {

		LOG.info("Evaluating playRequest for customerId : " + customerId + " and bets : " + playRequest);

		PlayResponse playResponse = new PlayResponse(false);
		int totalBet = playRequest.getTotalBet();

		BlockAmountResponse blockAmountResponse = blockAmount(customerId, totalBet);
		if (blockAmountResponse.isSuccess()) {

			int rouletteNumber = RouletteUtil.getRouletteNumber();
			int adjustAmount = RouletteUtil.getResult(rouletteNumber, playRequest);
			int betResult = adjustAmount - totalBet;
			AdjustAmountResponse adjustAmountResponse = adjustAmount(customerId, adjustAmount);

			if (adjustAmountResponse.isSuccess()) {
				playResponse.setSuccess(true);
				playResponse.setRouletteNumber(rouletteNumber);
				playResponse.setBetResult(betResult);
				playResponse.setBalance(adjustAmountResponse.getBalance());
			} else {
				LOG.info("Error occured while adjusting balance with adjustAmount : " + adjustAmount
						+ " for customerId : " + customerId);
			}
		} else {
			LOG.info("Insufficient balance for totalBet : " + totalBet + " for customerId : " + customerId);
		}

		return playResponse;
	}

	public LeaderBoardResponse getLeaderBoard() {

		LOG.info("Requesting casino_admin for Roulette Leaderboard");

		RestTemplate restTemplate = new RestTemplate();

		LeaderBoardResponse leaderBoardResponse = new LeaderBoardResponse(false);

		try {
			leaderBoardResponse = restTemplate.getForObject(URLGenerator.getLeaderBoardURL(),
					LeaderBoardResponse.class);
		} catch (ResourceAccessException exception) {
			LOG.error("Connection Refused by casino_admin. ");
		}

		return leaderBoardResponse;
	}

}
