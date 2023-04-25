package com.gl.dsa.lab3.qsn2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PairSumBST {
	Node rootNode;

	PairSumBST(Node root) {
		this.rootNode = root;
	}

	public Node insert(Node root, int key) {
		Node newNode = new Node(key);
		if (root == null) {
			root = newNode;
			this.rootNode = root; 
			return root;
		}

		Node parentNode = null;
		Node tempNode = root;

		while (tempNode != null) {
			parentNode = tempNode;
			if (tempNode.data == key) {
				System.out.println("Node " + key + " already exists..");
				return root;
			} else if (key< tempNode.data) {
				tempNode = tempNode.leftNode;
			} else {
				tempNode = tempNode.rightNode;
			}
		}

		if (key < parentNode.data) {
			parentNode.leftNode = newNode;
		} else if (key > parentNode.data) {
			parentNode.rightNode = newNode;
		}
		this.rootNode = root; 
		return root;

	}
	public void inorder(Node root) {

		if (root == null) {
			return;
		}
		inorder(root.leftNode);
		System.out.print(root.data + " ");
		inorder(root.rightNode);
	}

	public void pairFinding(Node root, int sum) {

		Set<Integer> set = new HashSet<Integer>();
		System.out.println("Sum = " + sum);
		if (!getPairRecursive(root, sum, set)) {
			System.out.println("No pairs found..");
		}
	}

	public boolean getPairRecursive(Node root, int sum, Set<Integer> set) {
		boolean pair_Found = false;
		if (root == null) {
			return false;
		}

		boolean leftPair_Found = getPairRecursive(root.leftNode, sum, set);
		boolean rightPair_Found = getPairRecursive(root.rightNode, sum, set);

		if (set.contains(sum - root.data)) {
			System.out.println("Pair is: " + "(" + (sum - root.data) + "," + root.data + ")");
			pair_Found = true;
		}
		set.add(root.data);
		return pair_Found || leftPair_Found || rightPair_Found;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int[] array = { 40, 20, 60, 10, 30, 50, 70 };

		Node root = null;

		PairSumBST bst = new PairSumBST(root);

		for (int i = 0; i < array.length; i++) {
			root = bst.insert(root, array[i]);
		}

		int sumsmation = 130;
		//int sumsmation = 200; // for negative result
		bst.pairFinding(root, sumsmation);

		scanner.close();
	}

}

class Node {
	int data;
	Node leftNode;
	Node rightNode;

	Node(int data) {
		this.data = data;
		this.leftNode = null;
		this.rightNode = null;
	}
}
