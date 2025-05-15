package ch9_힙;

import java.io.*;
import java.util.*;

public class boj1655_가운데를말해요 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        int N = Integer.parseInt(br.readLine()); // 정수의 개수 1~100000
        StringBuilder sb = new StringBuilder();

        List<Integer> num_list = new ArrayList<>();

        for(int n=0; n<N; n++){
            int num = Integer.parseInt(br.readLine()); // -10000~10000
            num_list.add(num);
            Collections.sort(num_list, new Comparator<Integer>(){
                @Override
                public int compare(Integer n1, Integer n2){
                    return n1-n2;
                }
            });

            sb.append(num_list.get(n/2)).append("\n");
        }

        System.out.println(sb.toString());
    }
}
