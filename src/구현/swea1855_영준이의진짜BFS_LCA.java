package 구현;

import java.io.*;
import java.util.*;

public class swea1855_영준이의진짜BFS_LCA {
    static int[] level; // 깊이
    static int[][] parent; // 부모
    static int MAX_LEVEL; // 최대 깊이

    public static void main(String[] args) throws Exception{
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int t=1; t<=T; t++){
            int N = Integer.parseInt(br.readLine()); // 자연수 1~10^5

            // 최대 level 구하기 (2^k번째 조상을 구하기 때문에)
            MAX_LEVEL = 0;
            while((1 << MAX_LEVEL) <= N){
                MAX_LEVEL++;
            }

            level = new int[N+1]; // 깊이
            parent = new int[N+1][MAX_LEVEL]; // 부모
            ArrayList<Integer>[] adj_list = new ArrayList[N+1]; // 인접 리스트
            for(int i=0; i<=N; i++){
                adj_list[i] = new ArrayList<>();
            }

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=2; i<=N; i++){
                int p = Integer.parseInt(st.nextToken());
                parent[i][0] = p; // 바로 위 부모 저장
                adj_list[p].add(i); // 인접리스트에 저장
            }

            Queue<Integer> queue = new LinkedList<>(); // bfs를 위한 큐
            queue.add(1);
            int[] order = new int[N]; // bfs로 방문하는 순서를 저장해야 함
            int idx = 0;

            while(!queue.isEmpty()){ // bfs
                int cur = queue.poll();
                order[idx++] = cur;

                for(int i=1; i<MAX_LEVEL; i++){ // 부모 저장
                    parent[cur][i] = parent[parent[cur][i-1]][i-1];
                }

                for(int next : adj_list[cur]){ // bfs
                    level[next] = level[cur]+1; // level 저장
                    queue.add(next);
                }
            }

            long result = 0;
            for(int i=0; i<N-1; i++){
                int lca = LCA(order[i], order[i+1]);
                result += (level[order[i]]-level[lca])+(level[order[i+1]]-level[lca]); // 이동하는(도착하는) 정점에서 공통정점까지 거리의 합
            }

            sb.append("#").append(t).append(" ").append(result).append("\n");
        }

        System.out.println(sb.toString());
    }

    public static int LCA(int a, int b){
        // level[a] >= level[b] 가 되도록
        if(level[a] < level[b]){
            int temp = a;
            a = b;
            b = temp;
        }

        // 높이 맞춤
        // level[a] > level[b]에서 같아지도록
        for(int i=MAX_LEVEL; i>=0; i--){
            if((level[a]-level[b]) >= (1<<i)){
                a = parent[a][i];
            }
        }

        if(a == b) return a; // 만약에 같아지면 LCA라는 뜻

        for(int i=MAX_LEVEL-1; i>=0; i--){ // 같은 높이만큼
            if(parent[a][i] != parent[b][i]){
                a = parent[a][i];
                b = parent[b][i];
            }
        }

        return parent[a][0];
    }
}