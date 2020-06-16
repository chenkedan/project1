package com.leetcode.demo.project.linkedList;

public class MyLinkedList {
    Node head = null;

    public void add(int data){
        Node newNode = new Node(data);
        if (head == null){
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next!=null){
            temp = temp.next;
        }
        temp.next = newNode;
    }

}
