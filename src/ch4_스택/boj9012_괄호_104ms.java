package ch4_스택;

import java.io.*;
import java.util.*;

public class boj9012_괄호_104ms {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        int T = Integer.parseInt(br.readLine()); // 테스트 데이터 수
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            char[] ps = br.readLine().toCharArray(); // 괄호 문자 리스트 (크기: 2~50)
            if (calc(ps))
                sb.append("YES\n");
            else
                sb.append("NO\n");
        }

        System.out.println(sb.toString());
    }

    public static boolean calc(char[] clist) {
        Stack<Character> stack = new Stack<>();
        int length = clist.length;

        for (int i = 0; i < length; i++) {
            char cur_c = clist[i];
            if (cur_c == '(') {
                stack.add(cur_c);
            } else {
                if (stack.isEmpty() || stack.peek() != '(')
                    return false;
                else
                    stack.pop();
            }
        }

        if (stack.isEmpty())
            return true;
        else
            return false;
    }
}