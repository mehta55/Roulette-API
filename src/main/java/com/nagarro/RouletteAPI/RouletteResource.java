package com.nagarro.RouletteAPI;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.nagarro.dto.CustomerResponse;
import com.nagarro.dto.LeaderBoardResponse;
import com.nagarro.dto.LoginResponse;
import com.nagarro.dto.PlayRequest;
import com.nagarro.dto.PlayResponse;
import com.nagarro.services.RouletteServiceImpl;

/**
 * Root resource (exposed at "roulette" path) This resource will handle the
 * requests received from the Roulette Application (Angular).
 */
@Path("roulette")
public class RouletteResource {

	final static Logger LOG = Logger.getLogger(RouletteResource.class);

	@Autowired
	private RouletteServiceImpl rouletteServices;

	/**
	 * Method handling HTTP GET requests for /login/{customerId}. This method calls
	 * RouletteService's loginCustomer method.
	 *
	 * @return LoginResponse that will be returned as a application/json response.
	 */
	@GET
	@Path("/login/{customerId}")
	@Produces(MediaType.APPLICATION_JSON)
	public LoginResponse rouletteLogin(@PathParam("customerId") String customerId) {

		LOG.info("Recieved GET request for rouletteLogin for customerId : " + customerId);

		return rouletteServices.loginCustomer(customerId);
	}

	/**
	 * Method handling HTTP GET requests for /customer/{customerId}. This method
	 * calls RouletteService's getCustomer method to get the details of customer
	 * with customerId as the one received in request URL.
	 *
	 * @return CustomerResponse that will be returned as a application/json
	 *         response.
	 */
	@GET
	@Path("/customer/{customerId}")
	@Produces(MediaType.APPLICATION_JSON)
	public CustomerResponse getCustomer(@PathParam("customerId") String customerId) {

		LOG.info("Recieved GET request for getCustomer for customerId : " + customerId);

		return rouletteServices.getCustomer(customerId);
	}

	/**
	 * Method handling HTTP GET requests for /customer/{customerId}/play. This
	 * method calls RouletteService's play method to place bets and process the
	 * results of customer with customerId as the one received in request URL.
	 *
	 * @return PlayResponse that will be returned as a application/json response.
	 */
	@POST
	@Path("/customer/{customerId}/play")
	public PlayResponse play(@PathParam("customerId") String customerId, PlayRequest playRequest) {
		LOG.info("Recieved POST request for /play for customerId : " + customerId);

		return rouletteServices.play(customerId, playRequest);
	}

	/**
	 * Method handling HTTP GET requests for /leaderBoard. This method calls
	 * RouletteService's getLeaderBoard method to get the top players of Roulette
	 * Application.
	 *
	 * @return LeaderBoardResponse that will be returned as a application/json response.
	 */
	@GET
	@Path("/leaderBoard")
	@Produces(MediaType.APPLICATION_JSON)
	public LeaderBoardResponse getLeaderBoard() {
		LOG.info("Recieved GET request for getLeaderBoard");

		return rouletteServices.getLeaderBoard();

	}
}
