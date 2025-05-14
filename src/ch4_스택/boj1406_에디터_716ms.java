package ch4_스택;

import java.io.*;
import java.util.*;

public class boj1406_에디터_716ms {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        Stack<Character> left_stack = new Stack<>();
        Stack<Character> right_stack = new Stack<>();
        char[] clist = br.readLine().toCharArray(); // 길이<100,000
        for (int i = 0, length = clist.length; i < length; i++) {
            left_stack.add(clist[i]);
        }
        int M = Integer.parseInt(br.readLine()); // 입력할 명령어 개수 1~500,000
        for (int m = 0; m < M; m++) {
            String[] order_str = br.readLine().split(" ");
            switch (order_str[0]) {
                case "L":
                    if (!left_stack.isEmpty()) {
                        right_stack.add(left_stack.pop());
                    }
                    break;
                case "D":
                    if (!right_stack.isEmpty()) {
                        left_stack.add(right_stack.pop());
                    }
                    break;
                case "B":
                    if (!left_stack.isEmpty()) {
                        left_stack.pop();
                    }
                    break;
                case "P":
                    left_stack.add(order_str[1].charAt(0));
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!left_stack.isEmpty()) {
            right_stack.add(left_stack.pop());
        }

        while (!right_stack.isEmpty()) {
            sb.append(right_stack.pop());
        }

        // br.close();
        System.out.println(sb.toString());
    }
}
