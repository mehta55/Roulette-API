package com.nagarro.util;

import org.apache.log4j.Logger;

import com.nagarro.dto.PlayRequest;

public class RouletteUtil {

	final static Logger LOG = Logger.getLogger(RouletteUtil.class);

	public static int getRouletteNumber() {
		
		LOG.info("Generating roulette number.");

		return generateRouletteNumber();
	}

	public static int getResult(int rouletteNumber, PlayRequest playRequest) {
		int betResult = 0;

		if (rouletteNumber >= 1 && rouletteNumber <= 12) {
			betResult += RouletteReturns.FIRST_TWELVE_RETURN * playRequest.getFirstTwelveBet();
		}

		if (rouletteNumber >= 13 && rouletteNumber <= 24) {
			betResult += RouletteReturns.SECOND_TWELVE_RETURN * playRequest.getSecondTwelveBet();
		}

		if (rouletteNumber >= 25 && rouletteNumber <= 36) {
			betResult += RouletteReturns.THIRD_TWELVE_RETURN * playRequest.getThirdTwelveBet();
		}

		if (rouletteNumber == 0) {
			betResult += RouletteReturns.ZERO_RETURN * playRequest.getZeroBet();
		}

		if (rouletteNumber >= 1 && rouletteNumber <= 18) {
			betResult += RouletteReturns.FIRST_HALF_RETURN * playRequest.getFirstHalfBet();
		}

		if (rouletteNumber >= 19 && rouletteNumber <= 36) {
			betResult += RouletteReturns.SECOND_HALF_RETURN * playRequest.getSecondHalfBet();
		}

		if (rouletteNumber % 2 == 0) {
			betResult += RouletteReturns.EVEN_RETURN * playRequest.getEvenBet();
		}

		if (rouletteNumber % 2 != 0) {
			betResult += RouletteReturns.ODD_RETURN * playRequest.getOddBet();
		}

		return betResult;
	}

	private static int generateRouletteNumber() {
		int rounds = 20;
		int noOfDigits;
		int random;
		int[] randoms = new int[rounds];

		while (rounds-- > 0) {
			noOfDigits = (int) (Math.random() * 10);
			random = (int) (Math.random() * (Math.pow(10, noOfDigits)));
			randoms[rounds] = random;
		}

		return getRandom(randoms) % 37;

	}

	private static int getRandom(int[] arr) {
		int maxLength = arr.length % 2 == 0 ? arr.length / 2 + 1 : arr.length / 2 + 2;
		return getRandom(arr, maxLength, 0, 0, 0, 0, 0);
	}

	private static int getRandom(int[] arr, int maxLength, int index, int length1, int sum1, int length2, int sum2) {

		if (length1 == maxLength || length2 == maxLength) {
			return Integer.MAX_VALUE;
		}

		if (index == arr.length) {

			if (Math.abs(length2 - length1) < 2) {
				return Math.abs(sum1 - sum2);
			}

			return Integer.MAX_VALUE;
		}

		return Math.min(getRandom(arr, maxLength, index + 1, length1 + 1, sum1 + arr[index], length2, sum2),
				getRandom(arr, maxLength, index + 1, length1, sum1, length2 + 1, sum2 + arr[index]));
	}

}
