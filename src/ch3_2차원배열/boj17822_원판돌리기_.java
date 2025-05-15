package ch3_2차원배열;

import java.io.*;
import java.util.StringTokenizer;

public class boj17822_원판돌리기_ {
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

        int[][] adj = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}}; // 인접한 방향

        print(round);    

        for(int tc=0; tc<T; tc++){
            st = new StringTokenizer(br.readLine());
            System.out.println(tc + "번째--------------------------------------");

            // 원판 회전시키기
            int x = Integer.parseInt(st.nextToken()); // 번호가 x의 배수인 원판을
            int d = Integer.parseInt(st.nextToken()); // d 방향으로 (0: 시계, 1: 반시계)
            int k = Integer.parseInt(st.nextToken()); // k칸 회전시킨다

            for(int i=1; x*i<=N; i++){ // x의 배수
                int rotate_n = x*i; // 회전시킬 원판 번호

                if(d == 0){ // 시계 방향으로 k번 회전
                    for(int r=0; r<k; r++){
                        int temp = round[rotate_n][M-1];
                        for(int j=M-1; j>0; j--){
                            round[rotate_n][j] = round[rotate_n][j-1];
                        }
                        round[rotate_n][0] = temp;
                    }
                    print(round);    
                } else { // 반시계 방향으로 k번 회전
                    for(int r=0; r<k; r++){
                        int temp = round[rotate_n][0];
                        for(int j=0; j<M-1; j++){
                            round[rotate_n][j] = round[rotate_n][j+1];
                        }
                        round[rotate_n][M-1] = temp;
                    }
                    print(round);    
                }
            }

            // 인접한 수 찾기
            boolean has_same_n = false;
            for(int n=1; n<=N; n++){
                for(int m=0; m<M; m++){
                    System.out.println("("+ n + "," + m +"): " + round[n][m]);
                    if(round[n][m] == 0) continue; // 숫자가 없는 경우 건너뛰기

                    int cur_n = round[n][m];
                    for(int dir=0; dir<4; dir++){ // 인접한 수 중 같은 것 찾기
                        int adj_n = n+adj[dir][0];
                        int adj_m = m+adj[dir][1];
                        if(adj_n<1 || adj_n>N) continue;
                        if(adj_m<0 || adj_m>=M) adj_m = (adj_m+M)%M;

                        if(round[adj_n][adj_m] == 0) continue;
                        if(cur_n == round[adj_n][adj_m]) {
                            round[n][m] = 0; // 인접하면서 같은 수가 있는 경우 자기도 바껴야 함
                            round[adj_n][adj_m] = 0;
                            has_same_n = true;
                        }
                    }

                    print(round);
                }
            }

            // 숫자가 같은 경우가 있으면 끝
            if(has_same_n) continue;

            // 숫자가 같은 경우가 없으면
            System.out.println("숫자 같은 경우X");
            int sum = 0;
            int cnt = 0;

            for(int n=1; n<=N; n++){
                for(int m=0; m<M; m++){
                    if(round[n][m] == 0) continue;
                    sum += round[n][m];
                    cnt++;
                }    
            }
            
            double avg = (double)sum/(double)cnt;
            for(int n=1; n<=N; n++){
                for(int m=0; m<M; m++){
                    if(round[n][m] == 0) continue;
                    if(round[n][m] > avg) round[n][m]--;
                    else if(round[n][m] < avg) round[n][m]++;
                }
            }

            print(round);
        }

        int result = 0;
        for(int n=1; n<=N; n++){
            for(int m=0; m<M; m++){
                result += round[n][m];
            }
        }

        System.out.println(result);
        br.close();
    }

    public static void print(int[][] round) {
        int r = round.length;
        int c = round[0].length;

        for(int i=1; i<r; i++){
            for(int j=0; j<c; j++){
                System.out.printf("%3d", round[i][j]);
            }
            System.out.println();
        }

        System.out.println();
    }
}
