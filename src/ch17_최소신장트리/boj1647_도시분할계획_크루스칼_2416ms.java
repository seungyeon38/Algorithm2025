package ch17_최소신장트리;

import java.io.*;
import java.util.*;

public class boj1647_도시분할계획_크루스칼_2416ms {
    static int[] parents;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 집의 개수 2~100,000
        int M = Integer.parseInt(st.nextToken()); // 길의 개수 1~1,000,000

        Edge[] edge_list = new Edge[M];
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()); // 집1
            int B = Integer.parseInt(st.nextToken()); // 집2
            int C = Integer.parseInt(st.nextToken()); // 유지비 1~1,000

            edge_list[i] = new Edge(A, B, C);
        }

        Arrays.sort(edge_list);

        parents = new int[N+1];
        for(int i=1; i<=N; i++){
            parents[i] = i;
        }

        int cnt = 0; // 선택한 간선의 수
        int result = 0; // 최소 간선 비용의 합
        int max_value = 0; // 최대 간선 비용

        for(Edge cur : edge_list){
            if(union(cur.s, cur.e)){
                cnt++;
                result += cur.weight;
                max_value = Math.max(max_value, cur.weight);
            }

            if(cnt == N-1) break;
        }

        // br.close();
        System.out.println(result - max_value);
    }
    
    static boolean union(int n1, int n2){
        int n1_root = findRoot(n1);
        int n2_root = findRoot(n2);

        if(n1_root == n2_root) return false;

        parents[n1_root] = n2_root;
        return true;
    }

    static int findRoot(int n){
        if(n == parents[n]) return n;

        return parents[n] = findRoot(parents[n]);
    }
    
    static class Edge implements Comparable<Edge>{
        int s;
        int e;
        int weight;

        Edge(int s, int e, int weight){
            this.s = s;
            this.e = e;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge e){
            return this.weight-e.weight;
        }
    }
}
