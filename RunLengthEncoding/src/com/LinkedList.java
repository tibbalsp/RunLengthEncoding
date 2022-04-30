package com;

// Single Linked List Class
class LinkedList {
    private int count = -1;
    Node head = null;
    Node tail = null;

    // Class for Node Pointers
    static final class Node{
        String data;
        Node next;
        private Node(char data){
            this.data = String.valueOf(data);
            this.next = null;
        }
    }
    // Retrieve the list size
    int getSize(){
        return count;
    }

    // Create and add node
    void addNode(char data){
        Node temp = new Node(data);
        if(head == null){
            head = temp;
        }else{
            tail.next = temp;
        }
        tail = temp;
        count++;
    }

    // Get the proper string format for Output Document
    public String toStrings(){
        String answer = "";
        Node curr = head;
        for (int i = 0; i < count; i++) {
            answer = answer.concat((curr.data) + "->");
            curr = curr.next;
        }
        answer = answer.concat((curr.data));
        return answer;
    }

     public LinkedList toLinkedList(String input){
        LinkedList list = new LinkedList();

        for (int i = 0; i < input.length(); i++) {
            list.addNode(input.charAt(i));
        }
        return list;
    }
}


