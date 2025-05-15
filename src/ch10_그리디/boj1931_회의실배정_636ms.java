package ch10_그리디;

import java.io.*;
import java.util.*;

public class boj1931_회의실배정_636ms {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        int N = Integer.parseInt(br.readLine()); // 회의 수 1~100000
        List<int[]> conf_list = new ArrayList<>();

        for(int n=0; n<N; n++){
            String[] conf_time = br.readLine().split(" ");
            int conf_st = Integer.parseInt(conf_time[0]);
            int conf_et = Integer.parseInt(conf_time[1]);
            
            conf_list.add(new int[]{conf_st, conf_et});
        }

        Collections.sort(conf_list, new Comparator<int[]>(){
            @Override
            public int compare(int[] conf1, int[] conf2){
                if(conf1[1] != conf2[1]){ // 회의 먼저 끝나는 시간 순으로 정렬
                    return conf1[1]-conf2[1];
                } else return conf1[0]-conf2[0]; // 회의 끝나는 시간이 같을 시에는 시작하는 시간이 빠른 순으로 정렬
            }
        });

        int cur_t = 0;
        int result = 0;
        for(int n=0; n<N; n++){
            if(cur_t > conf_list.get(n)[0]) continue;

            result++;
            cur_t = conf_list.get(n)[1];
        }

        System.out.println(result);

        // br.close();
    }
}
