package 구현;

import java.io.*;
import java.util.*;

public class swea1263_사람네트워크2_플로이드워샬 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int t=1; t<=T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int N = Integer.parseInt(st.nextToken()); // 사람 수 ~1000

            int[][] dist = new int[N][N];
            for(int i=0; i<N; i++){
                Arrays.fill(dist[i], Integer.MAX_VALUE);
                dist[i][i] = 0;
            }
            
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(st.nextToken().equals("1")){
                        dist[i][j] = 1;
                        dist[j][i] = 1;
                    }
                }
            }

            for(int k=0; k<N; k++){
                for(int i=0; i<N; i++){
                    if(i == k) continue;
                    for(int j=0; j<N; j++){
                        if(j == i || j == k) continue;
                        if(dist[i][k] == Integer.MAX_VALUE || dist[k][j] == Integer.MAX_VALUE) continue;

                        if(dist[i][j] > dist[i][k]+dist[k][j]){
                            dist[i][j] = dist[i][k]+dist[k][j];
                        }
                    }
                }
            }

            int result = Integer.MAX_VALUE;
            for(int i=0; i<N; i++){
                int sum = 0;
                for(int j=0; j<N; j++){
                    sum += dist[i][j];
                }

                result = Math.min(sum, result);
            }

            sb.append("#").append(t).append(" ").append(result).append("\n");
        }

        System.out.println(sb.toString());
    }
}
