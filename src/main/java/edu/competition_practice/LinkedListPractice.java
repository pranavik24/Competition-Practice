package competition_practice;

import java.util.*;

public class LinkedListPractice {

	private Node startNode;

	private static class Node {
		private int data;
		private Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;

		}

		public Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}

		public void setNext(Node n) {
			this.next = n;
		}

		public String toString() {
			String string = "Data: " + data;
			if (next != null) {
				string += "  Next node: " + next.data;
			}
			return string;
		}
	}

	public void add(int value) {
		Node newNode = new Node(value);
		if (startNode == null) {
			startNode = newNode;
		} else {
			Node n = startNode;
			while (n != null) {
				if (n == startNode && newNode.data < n.data) {
					Node temp = startNode;
					startNode = newNode;
					startNode.setNext(temp);
					break;

				}
				if (newNode.data >= n.data && n.next != null && newNode.data <= n.next.data) {
					newNode.setNext(n.next);
					n.setNext(newNode);
					break;
				}

				if (n.next == null) {
					n.setNext(newNode);
					break;
				}

				n = n.next;

			}

		}

	}

	public void printElements() {
		Node n = startNode;
		while (n != null) {
			System.out.print(n.data + " ");
			n = n.next;
		}

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		LinkedListPractice list = new LinkedListPractice();

		int numOfNumbers = sc.nextInt();

		for (int i = 0; i < numOfNumbers; i++) {
			int temp = sc.nextInt();
			list.add(temp);

		}

		list.printElements();

		sc.close();
	}

}
