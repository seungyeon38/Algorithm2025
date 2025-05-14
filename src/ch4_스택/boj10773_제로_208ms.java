package ch4_스택;

import java.io.*;
import java.util.*;

public class boj10773_제로_208ms {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        int K = Integer.parseInt(br.readLine()); // 1~100000
        Stack<Integer> stack = new Stack<>();

        for (int k = 0; k < K; k++) {
            int n = Integer.parseInt(br.readLine());

            if (n == 0) {
                stack.pop();
            } else {
                stack.push(n);
            }
        }

        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        System.out.println(result);
    }
}
