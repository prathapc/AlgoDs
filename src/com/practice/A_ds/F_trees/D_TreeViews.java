package com.practice.A_ds.F_trees;

import java.util.*;

import com.practice.B_algo_ps.K_sort_search_math.Utility;

public class D_TreeViews {

	public static void main(String args[]) {
		//leftView(Utility.createSampleTree());
		//leftView_Recursion(Utility.createSampleTree());

		rightSideView(TreeNode.deserialize("1,7,0,7,-8,null,null"));
		topViewOfTree(Utility.createSampleTree2());
		bottomViewOfTree(Utility.createSampleTree2());
	}

	private static void bottomViewOfTree(Node node) {
		Map<Integer, Integer> map = new TreeMap<>();
		bottomViewOfTreeUtil(node, map, 0);
		map.forEach((k, v) -> System.out.print(v + " "));
 	}

 	private static void bottomViewOfTreeUtil(Node node, Map<Integer, Integer> map, int hd) {
		if (node == null) {
			return;
		}
		map.put(hd, node.getVal());
		bottomViewOfTreeUtil(node.getLeft(), map, hd - 1);
		bottomViewOfTreeUtil(node.getRight(), map, hd + 1);
	}

	private static void topViewOfTree(Node node) {
		Map<Integer, Integer> map = new TreeMap<>();
		topViewOfTreeUtil(node, map, 0);
		map.forEach((k, v) -> System.out.print(map.get(k) + " "));
	}

	private static void topViewOfTreeUtil(Node node, Map<Integer, Integer> map, int hd) {
		if (node == null) {
			return;
		}
		if (!map.containsKey(hd)) {
			map.put(hd, node.getVal());
		}
		topViewOfTreeUtil(node.getLeft(), map, hd - 1);
		topViewOfTreeUtil(node.getRight(), map, hd + 1);
	}


	static int maxLevel = 0;
	private static void leftView_Recursion(Node node) {
		leftView_RecursionUtil(node, 1);
	}

	private static void leftView_RecursionUtil(Node node, int level) {
		if (node == null) {
			return;
		}

		if (maxLevel < level) {
			System.out.print(" " + node.getVal());
			maxLevel = level;
		}

		leftView_RecursionUtil(node.getLeft(), level+1);
		leftView_RecursionUtil(node.getRight(), level+1);
	}

	/*private static void topViewOfTree(Node root) {
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
	}*/

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

	private static void leftView(Node root) {
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		int currentCount = 0;
		int nextCount = 1;
		while (!q.isEmpty()) {
			Node node = q.poll();
			if (currentCount == 0) {
				System.out.print(node.getVal() + " ");
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

	public static List<Integer> rightSideView(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null) return result;
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		q.add(null);
		while (!q.isEmpty()) {
			TreeNode ele = q.poll();

			if (ele == null) {
				continue;
			}

			if (ele.left != null) {
				q.add(ele.left);
			}
			if (ele.right != null) {
				q.add(ele.right);
			}

			if (q.peek() == null) {
				result.add(ele.val);
				q.add(null);
			}
		}
		return result;
	}

	private static void printTree(Node root) {
		if (root == null) {
			return;
		}
		printTree(root.getLeft());
		System.out.println(root.getVal() + " ");
		printTree(root.getRight());

	}




}

/*
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

}*/
