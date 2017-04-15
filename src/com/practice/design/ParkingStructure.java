package com.practice.design;

import java.util.Hashtable;
import java.util.List;

public abstract class ParkingStructure {

	List<ParkingSpace> availableSpaces;
	TowingSystem tow;
	Hashtable<Vehicle, ParkingSpace> usedSpaces;
	
	public int calculatePayment(ParkingSpace ps) {
		return 0;
	}
	public abstract int getParkingSpace();
}
