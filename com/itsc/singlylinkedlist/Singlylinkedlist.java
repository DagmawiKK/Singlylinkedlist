package com.itsc.singlylinkedlist;
public class Singlylinkedlist {
    Node head;
    public Singlylinkedlist() {
        head = null;
    }
    public void insertAtPos(int data, int position) {
        Node newNode = new Node(data);
        if(position == 1) {
            newNode.next = head;
            head = newNode;
            return;
        }
        Node current = head;
        for (int i = 0; i < position - 2; i++) {
            if (current == null) {
                System.out.println("Position out of range");
                return;
            }
            current = current.next;
        }
        if (current == null) {
            System.out.println("Position out of range");
            return;
        }
        newNode.next = current.next;
        current.next = newNode;
    }

    public void deleteAtPosition(int position) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node temp = head;
        if (position == 1) {
            head = temp.next;
            temp = null;
            return;
        }
        for (int i = 0; temp != null && i < position - 2; i++) {
            temp = temp.next;
        }
        if (temp == null || temp.next == null) {
            System.out.println("Position out of range");
            return;
        }
        Node nextNode = temp.next.next;
        temp.next = null;
        temp.next = nextNode;
    }

    public void deleteAfterNode(Node prevNode) {
        if (prevNode == null || prevNode.next == null) {
            System.out.println("Given node is null or last node");
            return;
        }
        prevNode.next = prevNode.next.next;
    }

    public int searchNode(int value) {
        Node current = head;
        int position = 1;
        while (current != null) {
            if (current.value == value) {
                return position;
            }
            current = current.next;
            position++;
        }
        return -1;
    }


        public static void main(String[] args) {

            Singlylinkedlist mySinglylinkedlist = new Singlylinkedlist();
            mySinglylinkedlist.insertAtPos(1, 1);
            mySinglylinkedlist.insertAtPos(2, 2);
            mySinglylinkedlist.insertAtPos(3, 3);
            mySinglylinkedlist.insertAtPos(4, 4);
            mySinglylinkedlist.insertAtPos(5, 5);

            System.out.println();
            System.out.println("------Linked List-------");

            System.out.println("Original Linked List:");
            Node current = mySinglylinkedlist.head;
            while (current != null) {
                System.out.print(current.value + " -> ");
                current = current.next;
            }
            System.out.println("null");

            mySinglylinkedlist.deleteAtPosition(3);

            System.out.println("Linked List after deleting node at position 3:");
            current = mySinglylinkedlist.head;
            while (current != null) {
                System.out.print(current.value + " -> ");
                current = current.next;
            }
            System.out.println("null");

            System.out.println("Deleting node after node with value 2:");
            Node prevNode = mySinglylinkedlist.head;
            while (prevNode != null && prevNode.value != 2) {
                prevNode = prevNode.next;
            }
            if (prevNode != null) {
                mySinglylinkedlist.deleteAfterNode(prevNode);
            }

            System.out.println("Linked List after deleting node after node with value 2:");
            current = mySinglylinkedlist.head;
            while (current != null) {
                System.out.print(current.value + " -> ");
                current = current.next;
            }
            System.out.println("null");

            int searchValue = 2;
            int position = mySinglylinkedlist.searchNode(searchValue);
            if (position != -1) {
                System.out.println("Node with value " + searchValue + " found at position " + position);
            } else {
                System.out.println("Node with value " + searchValue + " not found in the linked list");
            }

            stack stack = new stack();
            stack.push(1);
            stack.push(2);
            stack.push(3);

            System.out.println();
            System.out.println("------Stack-------");
            System.out.println("Peek: " + stack.peek());
            System.out.println("Pop: " + stack.pop());
            System.out.println("Peek: " + stack.peek());

        }
}
