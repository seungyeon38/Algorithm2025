package ch6_큐;

import java.io.*;
import java.util.*;

public class boj10845_큐_164ms {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        int N = Integer.parseInt(br.readLine()); // 1~10000
        StringBuilder sb = new StringBuilder();
        Deque<Integer> queue = new LinkedList<>();

        for (int n = 0; n < N; n++) {
            String[] order_str = br.readLine().split(" ");

            switch (order_str[0]) {
                case "push":
                    queue.add(Integer.parseInt(order_str[1]));
                    break;
                case "pop":
                    if (queue.isEmpty()) {
                        sb.append("-1\n");
                    } else {
                        int num = queue.pop();
                        sb.append(num).append("\n");
                    }
                    break;
                case "size":
                    sb.append(queue.size()).append("\n");
                    break;
                case "empty":
                    if (queue.isEmpty()) {
                        sb.append("1\n");
                    } else {
                        sb.append("0\n");
                    }
                    break;
                case "front":
                    if (queue.isEmpty()) {
                        sb.append("-1\n");
                    } else {
                        sb.append(queue.peek()).append("\n");
                    }
                    break;
                case "back":
                    if (queue.isEmpty()) {
                        sb.append("-1\n");
                    } else
                        sb.append(queue.peekLast()).append("\n");
            }
        }
        // br.close();
        System.out.println(sb.toString());
    }
}
