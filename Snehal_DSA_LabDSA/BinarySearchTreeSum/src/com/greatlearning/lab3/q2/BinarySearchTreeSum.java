package com.greatlearning.lab3.q2;

import java.util.HashSet;
import java.util.Set;

public class BinarySearchTreeSum {
	public static class Node {
		private int data;
		private Node left;
		private Node right;

		public Node(int data) {
			this.data = data;
		}

		public int data() {
			return this.data;
		}

		public Node left() {
			return this.left;
		}

		public Node right() {
			return this.right;
		}

	}

	private Node root;

	public BinarySearchTreeSum(int data) {
		this.root = new Node(data);
	}

	public void insert(int data) {
		if (this.root == null) {
			this.root = new Node(data);
		}
		insert(this.root, data);

	}

	private Node insert(Node node, int data) {
		if (node == null) {
			node = new Node(data);
			return node;
		}
		if (data < node.data()) {
			node.left = insert(node.left(), data);
		} else {
			node.right = insert(node.right(), data);
		}
		return node;
	}

	public Set<Integer> findSumPair(int sum) {
		Set<Integer> values = new HashSet<>();
		Set<Integer> pair = new HashSet<>();
		traversePreOrder(this.root, sum, values, pair);
		return pair;
	}

	private boolean traversePreOrder(Node node, int sum, Set<Integer> collectedValues, Set<Integer> pair) {
		if (node == null)
			return false;
		int nodeData = node.data();
		if (collectedValues.contains(sum - nodeData)) {
			pair.add(nodeData);
			pair.add(sum - nodeData);
			return true;
		}
		collectedValues.add(nodeData);
		if ((node.left() != null && traversePreOrder(node.left(), sum, collectedValues, pair))
				|| (node.right() != null && traversePreOrder(node.right(), sum, collectedValues, pair))) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		BinarySearchTreeSum bst = new BinarySearchTreeSum(40);
		bst.insert(20);
		bst.insert(10);
		bst.insert(30);
		bst.insert(60);
		bst.insert(50);
		bst.insert(70);
		Set<Integer> pair = bst.findSumPair(130);
		if (pair.isEmpty()) {
			System.out.println("nodes are not found");
		} else {
			System.out.println("Pair is " + pair);
		}
	}
}
