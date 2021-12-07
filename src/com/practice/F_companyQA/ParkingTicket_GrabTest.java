package com.practice.F_companyQA;

public class ParkingTicket_GrabTest {

	public static void main(String[] args) {
		System.out.println(solution("10:00", "13:21"));
	}

	public static int solution(String E, String L) {
        String[] eArray = E.split(":");
        String[] lArray = L.split(":");
        int res = 0;
        int startHour = Integer.parseInt(eArray[0]);
        int startMin = Integer.parseInt(eArray[1]);
        int endHour = Integer.parseInt(lArray[0]);
        int endMin = Integer.parseInt(lArray[1]);
        int totalTimeInMins = 0;
        if(startHour == endHour) {
        	totalTimeInMins += endMin-startMin;
        } else if(endHour > startHour){
        	totalTimeInMins += 60 - startMin;
        	int k = startHour+1;
        	for(int i=endHour; i>k; i--) {
        		totalTimeInMins += 60;
        	}
        	totalTimeInMins += endMin;
        }
        
        if(totalTimeInMins > 0) {
        	res = 2;
        	int totHoursBillable = totalTimeInMins/60;
            if(totalTimeInMins % 60 != 0) {
            	totHoursBillable++;
            }
            if(totHoursBillable > 1) {
            	res += 3;
            	totHoursBillable--;
            } 
            
            if(totHoursBillable > 0) {
            	res += totHoursBillable*4;
            }
            
        }
		return res;
    }
}
