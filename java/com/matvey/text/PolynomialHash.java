package com.matvey.text;

import static java.lang.Math.pow;
import static java.math.BigDecimal.valueOf;

import java.math.BigDecimal;

public class PolynomialHash {
	
	public static void main(String[] args) {
		System.out.println("Hash of Hello is " + getPolynomialHash("Hello"));// Hash of Hello is 892230904.0
	}

	public static BigDecimal getPolynomialHash(String string) {
		// String Polynomial Hash (Alphabet ABC based on ASCII)
		// H(S) = S[0] + S[1]*p^1 + S[2]*p^2 +...+S[|S| - 1]*p^|S| - 1 
		// where p - is number that greatest than number of letters in ABC (52 letters), so p starts from 52+1 = 53
		final int p = 53;
		var charArr = string.toCharArray(); 
		var result = valueOf(charArr[0]);
		
		for (int i = 1; i < charArr.length; i++) {
			result = result.add(valueOf(charArr[i] * pow(p, i)));
		}
		
		return result;
	}
}
