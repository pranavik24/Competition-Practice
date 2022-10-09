package competition_practice;

import java.util.*;

public class Duplicates {
	private static Node startNode;
	public static Map<Character, Integer> duplicateTree = new HashMap<>();
	public static int total = 0;

	private static class Node {
		private Character data;
		private Node leftChild, rightChild;

		public Node(Character data) {
			this.data = data;
			leftChild = null;
			rightChild = null;
		}

		public void setLeftChild(Node n) {
			leftChild = n;
		}

		public void setRightChild(Node n) {
			rightChild = n;
		}

		public Character getValue() {
			return data;
		}

		public boolean hasOneChild() {
			if (leftChild == null && rightChild != null) {
				return true;
			}
			if (leftChild != null && rightChild == null) {
				return true;
			}
			return false;
		}
	}

	public void add(Character value) {
		Node newNode = new Node(value);
		if (startNode == null) {
			startNode = newNode;
		} else {
			Node n = startNode;
			while (n != null) {
				if (newNode.data.compareTo(n.data) <= 0) {
					// current node is less than parent node
					if (n.leftChild == null) {
						// parent node has no left node
						n.setLeftChild(newNode);
						break;
					} else {
						// parent node has left node
						n = n.leftChild;
					}
				}
				if (newNode.data.compareTo(n.data) > 0) {
					// current node is greater than parent node
					if (n.rightChild == null) {
						// parent node has no right node
						n.setRightChild(newNode);
						break;
					} else {
						// parent node has right node
						n = n.rightChild;
					}
				}
			}
		}
	}

	public static void getCount() {
		traverse(startNode);
	}

	public static void traverse(Node n) {
		if (n != null) {
			traverse(n.leftChild);

			total += getNumDuplicates(n);

			traverse(n.rightChild);

		}

	}

	public static int getNumDuplicates(Node n) {
		if (n.hasOneChild()) {
			// System.out.println(n.getValue() + " has one child");
			// System.out.println(n.getValue() + " has " + duplicateTree.get(n.getValue())+
			// " duplicates");
			return duplicateTree.get(n.getValue());
		}
		// System.out.println(n.getValue() + " DOES NOT have one child");
		return 0;
	}

	public void printElements() {
		// if printing inorder traversal
		System.out.print("Printing with Inorder Traversal: ");
		printInOrder(startNode);
		System.out.println();

	}

	public void printInOrder(Node n) {
		if (n != null) {
			printInOrder(n.leftChild);

			System.out.print(n.data + " ");

			printInOrder(n.rightChild);
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Duplicates tree = new Duplicates();
		Set<Character> currTreeVals = new HashSet<>();
		Character currLetter;

		String input = sc.nextLine();
		sc.close();
		input = input.toUpperCase();

		// adding elements to the duplicate tree
		// duplicate tree contains values and the number of times they appear
		int newIncrement;
		for (int i = 0; i < input.length(); i++) {
			currLetter = input.charAt(i);
			if (currLetter < 65 || currLetter > 90) {
				continue;
			} else {
				if (!currTreeVals.contains(currLetter)) {
					tree.add(currLetter);
					currTreeVals.add(currLetter);
					duplicateTree.put(currLetter, 1);
				} else {
					newIncrement = duplicateTree.get(currLetter) + 1;
					duplicateTree.replace(currLetter, newIncrement);
				}
			}
		}

		// System.out.println("Map" + duplicateTree);

//traversing through search tree and determining the number of children	

		// tree.printElements();

		getCount();

		System.out.println(total);

	}

}
