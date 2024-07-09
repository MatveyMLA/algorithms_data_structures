package com.matvey.text;

import java.util.ArrayList;

public class KnuthMorrisPrattSearch {

	public static void main(String[] args) {
		var result = knuthMorrisPrattSearch("bbababbcbb", "bb");
		var noResult = knuthMorrisPrattSearch("bbababbcbb", "cc");
		
		System.out.println("Is sub text found: "+!result.isEmpty()+". Starting Index in text: " + result); // Is sub text found: true. Starting Index and length in text: [7]
		System.out.println("Is sub text found: "+!noResult.isEmpty()); // Is sub text found: false
	}
	
	
	private static ArrayList<Integer> knuthMorrisPrattSearch(String text, String subText) {
		var res = new ArrayList<Integer>();
		var prefix = prefix(subText);
		int j = 0;
		
		for (int i = 0; i < text.length(); i++) {
			while (j > 0 && text.charAt(i) != subText.charAt(j)) {
				j=prefix.get(j-1);
			}
			if(text.charAt(i) == subText.charAt(j)) {
				j++;
			}
			if(j == subText.length()) {
				res.add(i - subText.length() + 1);
				j--;
			}
		}
		return res;
	}
	
	private static ArrayList<Integer> prefix(String text) {
		var res = new ArrayList<Integer>();
		
		for (int i = 0; i < text.length(); i++) {
			res.add(0);
		}
		
		for (int i = 1; i < text.length(); i++) {
			
			int m = res.get(i-1);
			
			while (m>0 && text.charAt(i) != text.charAt(m)) {
				m = res.get(m-1);
			}
			
			if(text.charAt(i) == text.charAt(m)) {
				m+=1;
			}
			
			res.set(i, m);
		}
		return res;
	}
}
