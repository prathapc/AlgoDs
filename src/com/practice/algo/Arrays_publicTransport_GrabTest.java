package com.practice.algo;

//TO-DO
public class Arrays_publicTransport_GrabTest {

	//1day pass=2
	//7day pass=7
	//30day pass=25
	public static void main(String[] args) {
		int days[] = {1,2,4,7,29,30};
		int passPlans[] = {1,7,30};
		int passCost[] = {2,7,10};
		System.out.println(solution(days));
		//System.out.println(mySolution(days, passPlans, passCost));
		
	}
	
	public static int mySolution(int[] days, int[] passPlans, int[] passCost) {
		int n = days.length;
		int m = passPlans.length;
		int[][] matrix = new int[m][n];
		for(int p=0; p<m; p++) {
			for(int q=0; q<31; q++) {
				if(q == 0) {
					matrix[p][q] = 0;
					continue;
				}
				if(p == 0) {
					matrix[p][q] = matrix[p][q-1]+passCost[p];
				} else {
					if(q-passPlans[p] > 0) {
						matrix[p][q] = passCost[p] + matrix[p][q-passPlans[q]];
					}
					
					if(q == 1) {
						matrix[p][q] = min(matrix[p-1][q], passCost[p]);
					} else if(q < passPlans[p]) {
						//matrix[p][q] = min();
					}
				}
			}
		}

		return matrix[m-1][n-1];
	}
	
	private static int min(int i, int j) {
		return i>=j ? j : i; 
	}
	
	public static int solution(int[] A) {
		return getNextTicketCost(0, A);
	}
	
	//{1,2,4,7,29,30};
	public static int getNextTicketCost(int n,int[] input){
		if(n< input.length){
			int sevenDayCost =7 +getNextTicketCost(moveTo7thday(n,input),input);	
			int onedayCost=2 +getNextTicketCost(n+1,input);	
			//int monthCost = 30 +getNextTicketCost(moveTo7thday(), input)
				return Math.min(onedayCost,sevenDayCost);
		}
	return 0;
	}
	
	public static int moveTo7thday(int firstDay,int[] input){
		int nextDay=firstDay+1;
		while(nextDay < input.length && input[nextDay]-input[firstDay] <7 ){
			nextDay++;
		}
		return nextDay;
	}

}
