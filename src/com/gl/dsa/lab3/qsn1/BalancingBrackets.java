package com.gl.dsa.lab3.qsn1;

import java.util.Scanner;

import java.util.Stack;

public class BalancingBrackets {

	public static boolean isBalanced(String str) {

		char[] cArr = str.toCharArray();

		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < cArr.length; i++) {

			char character = cArr[i];

			switch (character) {
			case '[':
			case '{':
			case '(':
				stack.push(character);
				break;
			case ']':

				if (stack.isEmpty() || stack.pop() != '[') {
					return false;
				}
				break;

			case '}':
				if (stack.isEmpty() || stack.pop() != '{') {
					return false;

				}
				break;

			case ')':
				if (stack.isEmpty() || stack.pop() != '(') {
					return false;
				}
				break;

			default:
				return false;
			}
		}

		if (stack.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.println("Enter String of Brackets : ");
		String string = input.nextLine();

		if (isBalanced(string)) {
			System.out.println("The entered String has Balanced Brackets...");
		} else {
			System.out.println("The entered Strings do not contain Balanced Brackets...");
		}

		input.close();
	}

}



