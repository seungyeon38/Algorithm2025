package ch4_스택;

import java.io.*;
import java.util.*;

public class boj4949_균형잡힌세상_188ms {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        String str;
        StringBuilder sb = new StringBuilder();

        while (!(".".equals(str = br.readLine()))) {
            char[] clist = str.toCharArray();
            int length = clist.length; // 1~100
            Stack<Character> stack = new Stack<>();
            String result = "yes";

            for (int i = 0; i < length; i++) {
                if (clist[i] == '(' || clist[i] == '[') {
                    stack.push(clist[i]);
                } else if (clist[i] == ')') {
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                    } else {
                        result = "no";
                        break;
                    }
                } else if (clist[i] == ']') {
                    if (!stack.isEmpty() && stack.peek() == '[') {
                        stack.pop();
                    } else {
                        result = "no";
                        break;
                    }
                }
            }

            if (!stack.isEmpty())
                result = "no";

            sb.append(result).append("\n");
        }
        // br.close();

        System.out.println(sb.toString());
    }
}
