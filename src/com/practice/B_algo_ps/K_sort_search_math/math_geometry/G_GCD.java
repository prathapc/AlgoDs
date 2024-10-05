package com.practice.B_algo_ps.K_sort_search_math.math_geometry;

public class G_GCD {

	public static void main(String[] args) {
		int[] a = new int[]{2,3,6};
		int gcdResult = a[0];
		for(int i=1; i<a.length; i++) {
			gcdResult = gcd(a[i], gcdResult);
		}
		System.out.println("GCD is "+gcdResult);
		int mul = 1;
		for(int k=0; k<a.length; k++) {
			mul *= a[k];
		}
		System.out.println(("LCM is "+mul/gcdResult));
	}

	private static int gcd(int num, int result) {
		if(num == 0) {
			return result;
		}
		return gcd(result%num, num); 
	}

}
