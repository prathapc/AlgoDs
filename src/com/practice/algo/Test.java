package com.practice.algo;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Test {

	public static void main(String[] args) throws UnknownHostException {
		// TODO Auto-generated method stub
		InetAddress ip = InetAddress.getLocalHost();
		System.out.println(ip.getHostName());
		
		Double d1 = 1d;
		Double d2 = 1.0;
		if(null == d1)
		System.out.println(d1 == d2.doubleValue());
		else
			System.out.println("adsf");
		
	}

}
