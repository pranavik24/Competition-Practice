package competition_practice;

import java.util.*;

public class TreePractice {
	private Node startNode;

	private static class Node {
		private String data;
		private Node leftChild, rightChild;

		public Node(String data) {
			this.data = data;
			this.leftChild = null;
			this.rightChild = null;

		}
		/*
		 * public Node(String data, Node next) { this.data = data; this.leftChild =
		 * next; }
		 */

		public void setLeftChild(Node n) {
			this.leftChild = n;
		}

		public void setRightChild(Node n) {
			this.rightChild = n;
		}

		public int getNumChildren() {
			if (leftChild == null && rightChild == null) {
				return 0;
			}
			if (leftChild != null && rightChild == null) {
				return 1;
			}
			if (leftChild == null && rightChild != null) {
				return 1;
			}
			if (leftChild != null && rightChild != null) {
				return 2;
			}
			return -1;

		}

		public String toString() {
			String string = "Data: " + data;
			if (leftChild != null) {
				string += "\tLeft Child: " + leftChild.data;
			}
			if (rightChild != null) {
				string += "\tRight Child: " + rightChild.data;
			}
			return string;
		}

	}

	public void add(String value) {
		Node newNode = new Node(value);
		if (startNode == null) {
			startNode = newNode;
		} else {
			Node n = startNode;
			while (n != null) {
				if (newNode.data.compareTo(n.data) <= 0) {
					if (n.leftChild == null) {
						n.setLeftChild(newNode);
						break;
					} else {
						n = n.leftChild;
					}
				}
				if (newNode.data.compareTo(n.data) > 0) {
					if (n.rightChild == null) {
						n.setRightChild(newNode);
						break;
					} else {
						n = n.rightChild;
					}
				}
			}
		}
	}

	public void printElements() {
		// if printing inorder traversal
		System.out.print("Printing with Inorder Traversal: ");
		printInOrder(startNode);

		System.out.print("\nPrinting with PostOrder Traversal: ");
		printPostOrder(startNode);

		System.out.print("\nPrinting with PreOrder Traversal: ");
		printPreOrder(startNode);

	}

	public void printInOrder(Node n) {
		if (n != null) {
			printInOrder(n.leftChild);

			System.out.print(n.data + " ");

			printInOrder(n.rightChild);
		}

	}

	public void printPostOrder(Node n) {
		if (n != null) {
			printPostOrder(n.leftChild);

			printPostOrder(n.rightChild);

			System.out.print(n.data + " ");

		}
	}

	public void printPreOrder(Node n) {
		if (n != null) {

			System.out.print(n.data + " ");

			printPreOrder(n.leftChild);

			printPreOrder(n.rightChild);

		}
	}

	public Node getFather(String string) {
		Node n = startNode;
		Node father = null;
		boolean found = false;
		while (n != null && !found) {
			if (string.compareTo(n.data) < 0) {
				father = n;
				n = n.leftChild;
			} else if (string.compareTo(n.data) > 0) {
				father = n;
				n = n.rightChild;
			} else {
				found = true;
				break;
			}

		}
		return father;
	}

	public void delete(String string) {
		Node father = getFather(string);
		Node n = null;
		if (father.leftChild.data == string) {
			n = father.leftChild;

		} else if (father.rightChild.data == string) {
			n = father.rightChild;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TreePractice tree = new TreePractice();

		String value = "";
		int numChar = sc.nextInt();
		for (int i = 0; i < numChar; i++) {
			value = sc.next();
			tree.add(value);
		}

		sc.close();
		tree.printElements();

	}

}
