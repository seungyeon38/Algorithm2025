package ch9_힙;

import java.util.*;
import java.io.*;

public class boj11279_최대힙_300ms {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        int N = Integer.parseInt(br.readLine()); // 연산의 개수 1~100000
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        StringBuilder sb = new StringBuilder();

        for(int n=0; n<N; n++){
            int x = Integer.parseInt(br.readLine()); // int범위

            if(x == 0){
                if(pq.isEmpty()) sb.append("0\n");
                else sb.append(pq.poll()).append("\n");
            } else {
                pq.add(x);
            }
        }
        
        System.out.println(sb.toString());
    }   
}
