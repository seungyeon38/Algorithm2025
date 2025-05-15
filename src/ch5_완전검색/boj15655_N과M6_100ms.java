package ch5_완전검색;

import java.util.*;
import java.io.*;

public class boj15655_N과M6_100ms {
    static int N, M;
    static int[] numbers;
    static int[] selected_arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numbers = new int[N];
        selected_arr = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);

        calc(0, 0);
        System.out.println(sb.toString());

        // br.close();
    }

    public static void calc(int cnt, int sp) {
        if (cnt == M) {
            for (int i = 0; i < M; i++) {
                sb.append(selected_arr[i]).append(" ");
            }
            sb.append("\n");

            return;
        }

        for (int i = sp; i < N; i++) {
            selected_arr[cnt] = numbers[i];
            calc(cnt + 1, i + 1);
        }
    }
}
