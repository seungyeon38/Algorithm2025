package ch1_1차원배열;

import java.util.*;
import java.io.*;

public class boj4344_평균은넘겠지_144ms {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringBuilder sb = new StringBuilder();

        int C = Integer.parseInt(br.readLine());
        for(int tc=0; tc<C; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 학생 수 (1~1000)
            
            int score_sum = 0; // 점수 합계
            int[] score = new int[N];

            for(int i=0; i<N; i++){
                score[i] = Integer.parseInt(st.nextToken());
                score_sum += score[i];
            }

            float score_avg = score_sum/N; // 평균 점수
            int upper_avg_cnt = 0; // 평균을 넘는 학생 수

            for(int i=0; i<N; i++){
                if(score_avg < score[i]){
                    upper_avg_cnt++;
                }
            }

            sb.append(String.format("%.3f", (float)upper_avg_cnt/N*100)).append("%\n");
        }

        System.out.println(sb.toString());
        // br.close();
    }
}
