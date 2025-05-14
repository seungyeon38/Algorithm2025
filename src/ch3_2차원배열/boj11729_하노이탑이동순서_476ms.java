package ch2_2차원배열;

import java.io.*;

public class boj11729_하노이탑이동순서_476ms {
    static StringBuilder sb = new StringBuilder();
    static int cnt = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine()); // 첫번째 장대에 쌓인 원판 개수(1~20)

        hanoi(K, 1, 2, 3);

        System.out.println(cnt);
        System.out.println(sb.toString());
    }

    public static void hanoi(int n, int start, int mid, int to){
        cnt++;
        if(n == 1) {
            sb.append(start).append(" ").append(to).append("\n");
            return;
        }

        hanoi(n-1, start, to, mid);
        sb.append(start).append(" ").append(to).append("\n");
        hanoi(n-1, mid, start, to);
    }
}
