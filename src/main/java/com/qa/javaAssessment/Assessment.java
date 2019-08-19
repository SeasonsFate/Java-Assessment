package com.qa.javaAssessment;

import java.util.ArrayList;
import java.util.Collections;

public class Assessment {

	// Given a string, return a string where
	// for every char in the original string,
	// there are three chars.

	// multChar("The") ==> "TTThhheee"
	// multChar("AAbb") ==> "AAAAAAbbbbbb"
	// multChar("Hi-There") ==> "HHHiii---TTThhheeerrreee"

	public String multChar(String input) {
		String word = "";
		for (int i = 0; i < input.length(); i++) {
			word += input.substring(i, i + 1);
			word += input.substring(i, i + 1);
			word += input.substring(i, i + 1);
		}
		return word;
	}

	// Return the string (backwards) that is between the first and last appearance
	// of "bert"
	// in the given string, or return the empty string "" if there is not 2
	// occurances of "bert" - Ignore Case

	// getBert("bertclivebert") ==> "evilc"
	// getBert("xxbertfridgebertyy") ==> "egdirf"
	// getBert("xxBertfridgebERtyy") ==> "egdirf"
	// getBert("xxbertyy") ==> ""
	// getBert("xxbeRTyy") ==> ""
	public static void main(String[] args) {
		System.out.println(getBert("bertxdbert"));
	}

	public static String getBert(String input) {
		String word = "";
		input = input.toLowerCase();

		int bert1 = input.indexOf("bert") + "bert".length();
		int bert2 = input.lastIndexOf("bert");
		if (input.indexOf("bert") == bert2) {
			return "";
		}

		word = input.substring(bert1, bert2);

		String word1 = "";
		for (int i = word.length(); i > 0; i--) {
			word1 += word.substring(i - 1, i);
		}
		return word1;
	}

	// Given three ints, a b c, one of them is small, one is medium and one is
	// large. Return true if the three values are evenly spaced, so the
	// difference between small and medium is the same as the difference between
	// medium and large. Do not assume the ints will come to you in a reasonable
	// order.

	// evenlySpaced(2, 4, 6) ==> true
	// evenlySpaced(4, 6, 2) ==> true
	// evenlySpaced(4, 6, 3) ==> false
	// evenlySpaced(4, 60, 9) ==> false

	public boolean evenlySpaced(int a, int b, int c) { // 4 60 9
		int[] list = new int[3];

		if (a > b && a > c) {
			if (b > c) {
				list[2] = a;
				list[1] = b;
				list[0] = c;
			} else {
				list[2] = a;
				list[1] = c;
				list[0] = b;

			}

		}

		if (b > c && b > a) {
			if (a > c) {
				list[2] = b;
				list[1] = a;
				list[0] = c;
			} else {
				list[2] = b;
				list[1] = c;
				list[0] = a;
			}
		}

		int diffab = list[0] - list[1];
		// int diffac = a - c;
		int diffbc = list[1] - list[2];
		if (diffab < 0) {
			diffab = -diffab;
		}
		/*
		 * if (diffac < 0) { diffac = -diffac; }
		 */
		if (diffbc < 0) {
			diffbc = -diffbc;
		}

		if (diffab == diffbc) {
			return true;
		} else {
			return false;
		}
	}

	// Given a string and an int n, return a string that removes n letters from the
	// 'middle' of the string.
	// The string length will be at least n, and be odd when the length of the input
	// is odd.

	// nMid("Hello", 3) ==> "Ho"
	// nMid("Chocolate", 3) ==> "Choate"
	// nMid("Chocolate", 1) ==> "Choclate"

	public String nMid(String input, int a) {
		String word = "";

		int mid = (input.length() / 2); // for "hello" = 2
		int rem = a / 2; // for a = 3 a/2 = 1
		word += input.substring(0, mid - rem);
		word += input.substring(mid + rem + 1);

		return word;
	}

	// Given a string, return the length of the largest "block" in the string.
	// A block is a run of adjacent chars that are the same.
	//
	// superBlock("hoopplla") ==> 2
	// superBlock("abbCCCddDDDeeEEE") ==> 3
	// superBlock("") ==> 0

	public int superBlock(String input) {
		if (input.equals("")) {
			return 0;
		}
		String prevChar = input.substring(0, 1);
		ArrayList<Integer> arrayCount = new ArrayList<Integer>();
		int count = 1;
		for (int i = 1; i < input.length(); i++) {
			String thisChar = input.substring(i, i + 1);
			if (thisChar.equals(prevChar)) {
				count++;
			} else {
				arrayCount.add(count);
				count = 1;
				prevChar = thisChar;
			}

		}

		return Collections.max(arrayCount);

	}

	// given a string - return the number of times "am" appears in the String
	// ignoring case -
	// BUT ONLY WHEN the word "am" appears without being followed or proceeded by
	// other letters
	//
	// amISearch("Am I in Amsterdam") ==> 1
	// amISearch("I am in Amsterdam am I?") ==> 2
	// amISearch("I have been in Amsterdam") ==> 0

	public int amISearch(String arg1) {
		ArrayList<String> sub = new ArrayList<String>();

		for (int i = 0; i < arg1.length() - 3; i++) {

			if (i > 0 && arg1.substring((i - 1), (i + 3)).equals(" am ")) {
				sub.add(arg1.substring(i, i + 2));
			} else if (i == 0 && arg1.substring(i, (i + 3)).equals("am ")) {
				sub.add(arg1.substring(i, i + 2));
			}

			if (arg1.substring(i, i + 3).equals("AM ")) {
				sub.add(arg1.substring(i, i + 2));
			}
			if (arg1.substring(i, i + 3).equals("Am ")) {
				sub.add(arg1.substring(i, i + 3));
			}

		}
		return sub.size();

	}
	// if (arg1.substring(i, i + 3).equals("am ".toUpperCase())) {;if
	// (arg1.substring(i, i + 3).equals("Am "))
	// given a number
	// if this number is divisible by 3 return "fizz"
	// if this number is divisible by 5 return "buzz"
	// if this number is divisible by both 3 and 5return "fizzbuzz"
	//
	// fizzBuzz(3) ==> "fizz"
	// fizzBuzz(10) ==> "buzz"
	// fizzBuzz(15) ==> "fizzbuzz"

	public String fizzBuzz(int arg1) {
		if (arg1 % 3 == 0 && arg1 % 5 == 0) {
			return "fizzbuzz";
		} else if (arg1 % 3 == 0 && arg1 % 5 != 0) {
			return "fizz";
		} else if(arg1 % 5 == 0 && arg1 % 3 != 0){
			return "buzz";
		} else {
			return "none";
		}

	}

	// Given a string split the string into the individual numbers present
	// then add each digit of each number to get a final value for each number
	// String example = "55 72 86"
	//
	// "55" will = the integer 10
	// "72" will = the integer 9
	// "86" will = the integer 14
	//
	// You then need to return the highest vale
	//
	// largest("55 72 86") ==> 14
	// largest("15 72 80 164") ==> 11
	// largest("555 72 86 45 10") ==> 15

	public int largest(String arg1) {
		ArrayList<Integer> numList = new ArrayList<Integer>();
		while (arg1.length() > 0) {
			if (arg1.contains(" ")) {
				int num = Integer.parseInt(arg1.substring(0, arg1.indexOf(" ")));
				numList.add(num);
				arg1 = arg1.substring(arg1.indexOf(" ") + 1);
				System.out.println("arg1: " + arg1);
			} else {
				int num = Integer.parseInt(arg1.substring(0));
				numList.add(num);
				break;
			}

		}

		ArrayList<Integer> arraySum = new ArrayList<Integer>();

		for (int x : numList) {
			int sum = 0;
			while (x > 0) {
				sum = sum + x % 10;
				x = x / 10;
			}
			arraySum.add(sum);
			System.out.println("sum: " + sum);

		}

		return Collections.max(arraySum);
	}
}
