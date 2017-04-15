package com.practice.ds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

import com.practive.util.Utility;

public class TreePrograms {

	public static void main(String args[]) {

		 mirrorTrees();
		 mirrorTreesDynamicInput();

		levelOrder(com.practive.util.Utility.createMaxHeapTree());
		levelOrderWithAlternateReverse(Utility.createSampleTree2());

		leftView(Utility.createSampleTree());
		rightView(Utility.createSampleTree2());

		borderOfTree();

		topViewOfTree(Utility.createSampleTree2());

		System.out.println(heightOfTree(Utility.createSampleTree2()));

		System.out.println(diameterOfTree(Utility.createSampleTree())[1]);

	}

	private static void levelOrderWithAlternateReverse(Node root) {
		Stack<Node> stack1 = new Stack<>();
		Stack<Node> stack2 = new Stack<>();
		stack1.push(root);
		while (!stack1.isEmpty() || !stack2.isEmpty()) {
			
			while(!stack1.isEmpty()) {
				Node node = stack1.pop();
				System.out.println(node.getData());
				if (node.getLeft() != null) {
					stack2.add(node.getLeft());
				}
				if (node.getRight() != null) {
					stack2.add(node.getRight());
				}
			}
			
			while(!stack2.isEmpty()) {
				Node node = stack2.pop();
				System.out.println(node.getData());
				if (node.getLeft() != null) {
					stack1.add(node.getLeft());
				}
				if (node.getRight() != null) {
					stack1.add(node.getRight());
				}
			}
		}
	}

	private static int[] diameterOfTree(Node root) {
		int[] heightAndDiameterArray = { 0, 0 };

		if (root != null) {
			int[] lHeightAndDiameter = diameterOfTree(root.getLeft());
			int[] rHeightAndDiameter = diameterOfTree(root.getRight());

			heightAndDiameterArray[0] = Utility.max(lHeightAndDiameter[0], rHeightAndDiameter[0]) + 1;
			int leftDiameter = lHeightAndDiameter[1];
			int rightDiameter = rHeightAndDiameter[1];
			int rootDiameter = lHeightAndDiameter[0] + rHeightAndDiameter[0] + 1;
			heightAndDiameterArray[1] = Utility.max(rootDiameter, leftDiameter, rightDiameter);
		}

		return heightAndDiameterArray;
	}

	private static int heightOfTree(Node root) {
		int l = 0, r = 0;
		if (root == null)
			return 0;
		l += heightOfTree(root.getLeft());
		r += heightOfTree(root.getRight());
		return Utility.max(l, r) + 1;
	}

	private static void topViewOfTree(Node root) {
		Hashtable<Integer, List<Integer>> mapOfDistAndNodes = new Hashtable<>();
		List<Integer> sameDistNodes = null;
		Queue<TopBottomViewNode> q = new LinkedList<TopBottomViewNode>();

		TopBottomViewNode topBottomViewRoot = new TopBottomViewNode();
		topBottomViewRoot.setNode(root);
		topBottomViewRoot.setHorizantalDistance(0);
		q.add(topBottomViewRoot);

		TopBottomViewNode topBottomViewNode, temp;
		while (!q.isEmpty()) {
			topBottomViewNode = q.poll();

			if (!mapOfDistAndNodes.containsKey(topBottomViewNode.getHorizantalDistance())) {
				sameDistNodes = new ArrayList<Integer>();
				sameDistNodes.add(topBottomViewNode.getNode().getData());
				mapOfDistAndNodes.put(topBottomViewNode.getHorizantalDistance(), sameDistNodes);
			} else {
				sameDistNodes = mapOfDistAndNodes.get(topBottomViewNode.getHorizantalDistance());
				sameDistNodes.add(topBottomViewNode.getNode().getData());
				mapOfDistAndNodes.put(topBottomViewNode.getHorizantalDistance(), sameDistNodes);
			}

			Node left = topBottomViewNode.getNode().getLeft();
			if (left != null) {
				temp = new TopBottomViewNode();
				temp.setNode(left);
				temp.setHorizantalDistance(topBottomViewNode.getHorizantalDistance() - 1);
				q.add(temp);
			}

			Node right = topBottomViewNode.getNode().getRight();
			if (right != null) {
				temp = new TopBottomViewNode();
				temp.setNode(right);
				temp.setHorizantalDistance(topBottomViewNode.getHorizantalDistance() + 1);
				q.add(temp);
			}
		}
		Set<Integer> hds = mapOfDistAndNodes.keySet();
		for (Integer i : hds) {
			System.out.print(mapOfDistAndNodes.get(i).get(0) + " ");
		}
	}

	private static void mirrorTreesDynamicInput() {
		Scanner scanner = new Scanner(System.in);
		int tc = scanner.nextInt();
		for (int i = 0; i < tc; i++) {
			int n = scanner.nextInt();
			int e = scanner.nextInt();
			Node root1 = readInput(e);
			Node root2 = readInput(e);
			System.out.println(isMirrorTree(root1, root2) == true ? 1 : 0);
		}

	}

	private static boolean isMirrorTree(Node root1, Node root2) {
		if (root1 == null && root2 == null) {
			return true;
		}
		if (root1 == null || root2 == null) {
			return false;
		}
		if (((root1.getData() == root2.getData()) && isMirrorTree(root1.getLeft(), root2.getRight())
				&& isMirrorTree(root1.getRight(), root2.getLeft()))) {
			return true;
		}
		return false;
	}

	private static Node readInput(int e) {
		Scanner scanner = new Scanner(System.in);

		Node root = null;
		Map<Integer, Node> existingNodes = new HashMap<Integer, Node>();
		for (int j = 0; j < e; j++) {
			int n1 = scanner.nextInt();
			int n2 = scanner.nextInt();

			Node node1 = null, node2 = null;
			if (existingNodes.containsKey(n1)) {
				node1 = existingNodes.get(n1);
			} else {
				node1 = new Node(n1);
				existingNodes.put(n1, node1);
			}
			if (existingNodes.containsKey(n2)) {
				node2 = existingNodes.get(n2);
			} else {
				node2 = new Node(n2);
				existingNodes.put(n2, node2);
			}
			if (node1.getLeft() == null) {
				node1.setLeft(node2);
			} else if (node1.getRight() == null) {
				node1.setRight(node2);
			}
			if (root == null) {
				root = node1;
			}
		}
		return root;
	}

	private static void borderOfTree() {
		Node root = Utility.createBinarySearchTree();

		printTree(root);

	}

	private static void mirrorTrees() {
		Node root1 = new Node(1);
		root1.setLeft(new Node(2));
		root1.setRight(new Node(3));
		Node root2 = new Node(1);
		root2.setLeft(new Node(3));
		root2.setRight(new Node(2));
		System.out.println(isMirrorTree(root1, root2));
	}

	private static void leftView(Node root) {
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		int currentCount = 0;
		int nextCount = 1;
		while (!q.isEmpty()) {
			Node node = q.poll();
			if (currentCount == 0) {
				System.out.print(node.getData() + " ");
				currentCount = nextCount;
				nextCount = 0;
			}

			Node left = node.getLeft();
			if (left != null) {
				q.add(left);
				nextCount++;
			}

			Node right = node.getRight();
			if (right != null) {
				q.add(right);
				nextCount++;
			}

			currentCount--;
		}
	}

	private static void rightView(Node root) {
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		Node prev = root;
		q.add(null);
		while (!q.isEmpty()) {
			Node node = q.poll();
			if (node == null) {
				System.out.println(prev.getData());
				if (q.peek() == null)
					break;
				q.add(null);
			} else {
				Node left = node.getLeft();
				if (left != null) {
					q.add(left);
				}
				Node right = node.getRight();
				if (right != null) {
					q.add(right);
				}
				prev = node;
			}

		}
	}

	public static void levelOrder(Node root) {
		Queue<Node> queue = new LinkedList<Node>();

		if (root != null) {
			queue.add(root);
		}
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			System.out.print(node.getData() + " ");
			if (node.getLeft() != null) {
				queue.add(node.getLeft());
			}
			if (node.getRight() != null) {
				queue.add(node.getRight());
			}
		}
	}

	private static void printTree(Node root) {
		if (root == null) {
			return;
		}
		printTree(root.getLeft());
		System.out.println(root.getData() + " ");
		printTree(root.getRight());
	}
}

class TopBottomViewNode {
	Node node;
	int horizantalDistance;

	public Node getNode() {
		return node;
	}

	public void setNode(Node node) {
		this.node = node;
	}

	public int getHorizantalDistance() {
		return horizantalDistance;
	}

	public void setHorizantalDistance(int horizantalDistance) {
		this.horizantalDistance = horizantalDistance;
	}

}