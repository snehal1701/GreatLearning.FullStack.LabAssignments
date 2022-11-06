package com.greatlearning.lab3.q1;

import java.util.Scanner;
import java.util.Stack;

public class MatchingBrackets {

	public static boolean checkBrackets(String input) {
		Stack<Integer> stack = new Stack<>();
		String openingBrackets = "({[<";
		String closingBrackets = ")}]>";
		String brackets = openingBrackets + closingBrackets;

		for (char ch : input.toCharArray()) {
			if (!brackets.contains(ch + ""))// Character + "" converts it in to a String
			{
				continue;
			}
			int index = -1;
			if ((index = openingBrackets.indexOf(ch)) != -1) {
				stack.push(index);
				continue;
			}
			if (stack.isEmpty())// string Started with closing bracket
			{
				return false;
			}
			index = stack.pop();
			if (ch != closingBrackets.charAt(index)) {
				return false;
			}
		}
		return stack.isEmpty();

	}

	public static void main(String args[]) {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Enter the String input");
			String input = scanner.nextLine();
			Boolean check = checkBrackets(input);
			if (check) {
				System.out.println("The entered String has Balanced Brackets");
			} else {
				System.out.println("The entered String do not contain Balanced Brackets");
			}
		}
	}
}
