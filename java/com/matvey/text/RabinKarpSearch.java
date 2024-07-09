package com.matvey.text;

import static com.matvey.text.PolynomialHash.getPolynomialHash;

import java.util.ArrayList;


public class RabinKarpSearch {

	public static void main(String[] args) {
		var result = rabinKarp("abckjkhjhhgd", "jh");
		var noResult = rabinKarp("abckjkhjhhgd", "jc");
		
		System.out.println("Is sub text found: "+!result.isEmpty()+". Starting Index in text: " + result); // Is sub text found: true. Starting Index and length in text: [7]
		System.out.println("Is sub text found: "+!noResult.isEmpty()); // Is sub text found: false
	}
	
	private static ArrayList<Integer> rabinKarp(String text, String subText) {
		var res = new ArrayList<Integer>();
		if (subText.isBlank() || text.isBlank() 
				|| subText.length() > text.length()) {
			System.err.println("No Result");
			return res;
		}
		
		final int p = 53; // 52 letters in ABC + 1
		long subTextHash = getPolynomialHash(subText).longValue();
		var textHashes = new ArrayList<Long>();
		
		for (int i = 1; i <= text.length(); i++) {
			textHashes.add(getPolynomialHash(text.substring(0, i)).longValue());
		}
		
		int i = 0;
		while (i + subText.length() - 1 < text.length()) {
			long subHash = textHashes.get(i + subText.length() - 1);
			
			if(i > 0) {
				subHash = subHash - textHashes.get(i-1).longValue();
			}
			if(subHash == subTextHash * Math.pow(p, i)) {
				res.add(i);
			}
			i++;
		}
		return res;
	}

}
