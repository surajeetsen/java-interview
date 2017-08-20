package datastructures;

/**
 * A simple implementation of a Single Linked List that stores integer values.
 * 
 * @author Surajeet Sen
 */
public class SingleLinkedList {

	class Node {
		int val;
		Node next;

		Node(int val) {
			this.val = val;
		}
	}

	Node head;
	int size = 0;

	// Add an element to the end of the list.
	public void add(int val) {
		addLast(val);
	}

	// Add element at a particular index
	public void add(int index, int val) {
		if (index < 0 || index > this.size) {
			throw new IllegalArgumentException("Not a valid index");
		}

		if (index == 0) {
			addFirst(val);
		} else if (index == size) {
			addLast(val);
		} else {
			Node node = new Node(val);
			Node temp = head;

			while (--index > 0) {
				temp = temp.next;
			}
			Node next = temp.next;
			temp.next = node;
			node.next = next;
			++size;
		}
	}

	// Add a node to the head of the list.
	public void addFirst(int val) {
		Node node = new Node(val);
		++size;

		// If the list is empty
		if (head == null) {
			head = node;
		} else {
			Node temp = head;
			head = node;
			node.next = temp;
		}
	}

	// Add an element to the end of the list.
	public void addLast(int val) {
		Node node = new Node(val);
		++size;

		// If the list is empty
		if (head == null) {
			head = node;
		} else {
			Node temp = head;

			// Navigate to the last node in the list
			while (temp.next != null) {
				temp = temp.next;
			}

			// Point the next pointer of the last
			// node to the new node.
			temp.next = node;
		}
	}

	// Removes the first element of the list.
	public void removeFirst() {
		if (size == 0) {
			return;
		}
		head = head.next;
		--size;
	}

	// Removes the last element of the list
	public void removeLast() {
		if (size <= 1) {
			head = null;
			size = 0;
			return;
		}

		Node prev = head;
		Node next = prev.next;

		while (next.next != null) {
			prev = next;
			next = next.next;
		}
		--size;
		prev.next = null;
	}

	// Removes the first occurrence of an element
	public void removeElement(int val) {
		if (size == 0) {
			return;
		}

		if (head.val == val) {
			head = head.next;
			--size;
			return;
		}

		Node prev = head;
		Node next = prev.next;

		while (next != null) {
			if (next.val == val) {
				prev.next = next.next;
				--size;
				return;
			}

			prev = next;
			next = next.next;
		}
	}

	// Remove the element at a particular index.
	public void removeAtIndex(int index) {
		if (index < 0 || index >= size) {
			throw new IllegalArgumentException("Not a valid index");
		}

		if (index == 0) {
			removeFirst();
		} else if (index + 1 == size) {
			removeLast();
		} else {
			Node temp = head;

			while (--index > 0) {
				temp = temp.next;
			}

			temp.next = temp.next.next;
			--size;
		}
	}

	// Returns the size of the list.
	public int size() {
		return this.size;
	}

	// To get a readable output
	// when trying to print the list.
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		Node temp = head;
		while (temp != null) {
			sb.append(temp.val);
			if (temp.next != null) {
				sb.append(" -> ");
			}
			temp = temp.next;
		}
		sb.append("]");
		return sb.toString();
	}

}