package ch2_2차원배열;

import java.io.*;
import java.util.StringTokenizer;

public class boj17822_원판돌리기 {
    public static void main(String[] args) throws Exception{
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 원판 개수 (2~50)
        int M = Integer.parseInt(st.nextToken()); // 원판 하나에 적힌 정수 개수 (2~50)
        int T = Integer.parseInt(st.nextToken()); // 회전 횟수

        int[][] round = new int[N+1][M];
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                round[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int[][] adj = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}}; // 인접한 방향

        for(int t=0; t<T; t++){
            int x = Integer.parseInt(st.nextToken()); // 번호가 x의 배수인 원판을
            int d = Integer.parseInt(st.nextToken()); // d 방향으로 (0: 시계, 1: 반시계)
            int k = Integer.parseInt(st.nextToken()); // k칸 회전시킨다
            for(int i=1; x*i<=N; i++){ // x의 배수
                // 원판 회전
                int n = x*i; // 회전시킬 원판 번호
                // 해당 원판을 회전
                if(d == 0){ // 시계 방향 회전
                    int temp = round[n][M-1];
                    for(int j=M-1; j>0; j--){
                        round[n][j] = round[n][j-1];
                    }
                    round[n][0] = temp;
                } else { // 반시계 방향 회전
                    int temp = round[n][0];
                    for(int j=0; j<M-1; j++){
                        round[n][j] = round[n][j+1];
                    }
                    round[n][M-1] = temp;
                }

                // 수
                boolean has_same_n = false;
                for(int m=0; m<M; m++){
                    if(round[n][m] == -1) continue; // 숫자가 있을 때

                    for(int dir=0; dir<4; dir++){
                        int adj_n = n+adj[dir][0];
                        int adj_m = m+adj[dir][1];
                        if(adj_n<1 || adj_n>N) continue;
                        if(adj_m<0 || adj_m>=M) adj_m = (adj_m+M)%M;

                        if(round[adj_n][adj_m] == -1) continue;
                        if(round[n][m] == round[adj_n][adj_m]) {
                            round[adj_n][adj_m] = -1;
                            has_same_n = true;
                        }
                    }
                }

                // 숫자가 같은 경우가 있으면 끝
                if(has_same_n) continue;

                // 숫자가 같은 경우가 없으면
                int sum = 0;
                int cnt = 0;

                for(int m=0; m<M; m++){
                    if(round[n][m] == -1) continue;
                    sum += round[i][m]; 
                    cnt++;
                }

                int avg = sum/cnt;
                for(int m=0; m<M; m++){
                    if(round[n][m] == -1) continue;
                    if(round[n][m] > avg) round[n][m]--;
                    else if(round[n][m] < avg) round[n][m]++;
                }
            }
        }

        int result = 0;
        for(int i=1; i<=N; i++){
            for(int j=0; j<M; j++){
                if(round[i][j] == -1) continue;
                result += round[i][j];
            }
        }

        System.out.println(result);
        br.close();
    }
}
