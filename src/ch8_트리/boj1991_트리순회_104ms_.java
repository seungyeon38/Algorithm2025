package ch8_트리;

import java.io.*;

public class boj1991_트리순회_104ms_ {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        int N = Integer.parseInt(br.readLine()); // 이진 트리의 노드 개수 1~26
        Node root = new Node('A');

        for (int n = 0; n < N; n++) {
            String[] info = br.readLine().split(" ");
            char data = info[0].charAt(0);
            char left = info[1].charAt(0);
            char right = info[2].charAt(0);

            insertNode(root, data, left, right);
        }

        preorder(root);
        sb.append("\n");
        inorder(root);
        sb.append("\n");
        postorder(root);

        br.close();
        System.out.println(sb.toString());
    }

    static void insertNode(Node node, char data, char left, char right) {
        if (node == null) return;

        if (node.data == data) {
            if (left != '.') node.left = new Node(left);
            if (right != '.') node.right = new Node(right);
        } else {
            if(node.left != null) insertNode(node.left, data, left, right);
            if(node.right != null) insertNode(node.right, data, left, right);
        }
    }

    static void preorder(Node node){
        if(node == null) return;

        sb.append(node.data);
        preorder(node.left);
        preorder(node.right);
    }
    
    static void inorder(Node node){
        if(node == null) return;

        inorder(node.left);
        sb.append(node.data);
        inorder(node.right);
    }

    static void postorder(Node node){
        if(node == null) return;

        postorder(node.left);
        postorder(node.right);
        sb.append(node.data);
    }

    static class Node {
        char data;
        Node left;
        Node right;

        Node(char c) {
            this.data = c;
        }
    }
}
