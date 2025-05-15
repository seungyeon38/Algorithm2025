package ch9_힙;

import java.io.*;
import java.util.*;

public class boj1655_가운데를말해요_pq_436ms {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        int N = Integer.parseInt(br.readLine()); // 정수의 개수 1~100000
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> max_heap = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> min_heap = new PriorityQueue<>();

        for(int n=0; n<N; n++){
            int num = Integer.parseInt(br.readLine()); // -10000~10000
            
            if(max_heap.size() == min_heap.size()){
                max_heap.offer(num);
            } else{
                min_heap.offer(num);
            }

            if(!min_heap.isEmpty() && !max_heap.isEmpty() && min_heap.peek() < max_heap.peek()){
                int min_root = min_heap.poll();
                int max_root = max_heap.poll();
                min_heap.offer(max_root);
                max_heap.offer(min_root);
            }

            sb.append(max_heap.peek()).append("\n");
        }

        System.out.println(sb.toString());
    }
}
