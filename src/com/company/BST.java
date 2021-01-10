package com.company;

import java.util.ArrayList;

public class BST {
    Node head;

    class Node{
        String key;
        Node left;
        Node right;

        public Node(String key) {
            this.key = key;
            left = null;
            right = null;
        }
        public int compareTo(Node otherNode){
            return  this.key.compareTo(otherNode.key);
        }
    }

    /**
     * this function prints the tree, it is recursive and calls itself for each new line
     * until it is called with nodes that only hold empty values.
     * @param nodeList
     * @param space
     */
    public void print(ArrayList<Node> nodeList, int space) {
        boolean empty = true;
        for (Node node:nodeList){
            if (!node.key.equals("")){
                empty = false;
            }
        }
        if (empty){
            return;
        }
        ArrayList<Node> tempList = new ArrayList<Node>();
        for (Node node : nodeList) {
            int tempSpace = (space-node.key.length()) / 2;
            String padding = "";
            for (int i = 0; i < tempSpace; i++) {
                padding += " ";
            }

            System.out.print(padding+node.key+padding);
            if (node.key.equals("") || (node.left == null && node.right==null)){
                tempList.add(new Node(""));
                tempList.add(new Node(""));
            }
            else if (node.right!=null && node.left==null) {
                tempList.add(node.right);
                tempList.add(new Node(""));
            }
            else if (node.left!=null && node.right == null) {
                tempList.add(new Node(""));
                tempList.add(node.left);
            }

            else if (node.right!= null && node.left!=null){
                tempList.add(node.right);
                tempList.add(node.left);
            }
        }
        if (tempList.size()!=0){
            System.out.println("\n");
            this.print(tempList, space / 2);
        }
    }

    /**
     * simple function to add words to the tree from a string of words seperated with a space.
     * @param string
     */
    public void addFromString(String string){
        String[] stringList = string.split("\\s+");
        for (String word:stringList){
            this.newNode(word);
        }
    }
    public void newNode(String key){
        Node temp = new Node(key);
        boolean found = false;
        if (this.head == null){
            this.head = temp;
            found = true;
        }
        Node pointer = this.head;
        while(!found){
            if (temp.compareTo(pointer)<0){
                if (pointer.left == null){
                    pointer.left = temp;
                    return;
                }
                pointer = pointer.left;
            } else if (temp.compareTo(pointer) > 0) {
                if (pointer.right == null){
                    pointer.right = temp;
                    return;
                }
                pointer = pointer.right;
            }
            else{
                break;
            }
            if (pointer == null){
                pointer = temp;
            }
        }
    }
}
