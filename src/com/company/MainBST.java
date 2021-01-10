package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class MainBST {

    public static void main(String[] args) {
	BST bst = new BST();
	Scanner scanner = new Scanner(System.in);
	bst.addFromString(scanner.nextLine());


	ArrayList<BST.Node> list = new ArrayList<BST.Node>();
	list.add(bst.head);
	bst.print(list,64);

    }
}
