package com.practice.design;

public class RegularParkingSpace extends ParkingSpace {

	/**
	 * return regular price
	 */
	@Override
	public double getAmount() {
		return 0;
	}

	@Override
	public ParkingTicket issueParkingTicket() {
		return null;
	}

	@Override
	public int getParkingSpace() {return 0;}


	
}
