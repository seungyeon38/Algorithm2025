package ch17_최소신장트리;

import java.io.*;
import java.util.*;

public class boj1197_최소스패닝트리_크루스칼_512ms {
    static int[] parents;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken()); // 정점의 개수 1~10,000
        int E = Integer.parseInt(st.nextToken()); // 간선의 개수 1~100,000

        List<Edge> edge_list = new ArrayList<>();

        // 간선에 대한 정보 -> 크루스칼
        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()); // 정점
            int B = Integer.parseInt(st.nextToken()); // 정점
            int C = Integer.parseInt(st.nextToken()); // 가중치 -1,000,000~1,000,000
            
            Edge e = new Edge(A, B, C);
            edge_list.add(e);
        }

        Collections.sort(edge_list);

        parents = new int[V+1];
        for(int i=1; i<=V; i++){
            parents[i] = i;
        }

        // V-1 개의 간선이 선택되어야 함.
        int cnt_v = 0;
        int result = 0; // 최소 스패닝 트리의 가중치

        for(int i=0; i<E; i++){
            Edge cur_edge = edge_list.get(i);

            if(union(cur_edge.s, cur_edge.e)){
                cnt_v++;
                result += cur_edge.value;
            }

            if(cnt_v == V-1) break;
        }

        // br.close();
        System.out.println(result);
    }

    public static boolean union(int n1, int n2){
        int n1_root = findRoot(n1);
        int n2_root = findRoot(n2);

        if(n1_root == n2_root) return false;

        parents[n1_root] = n2_root;
        return true;
    }

    public static int findRoot(int n){
        if(n == parents[n]) return n;

        return parents[n] = findRoot(parents[n]);
    }

    static class Edge implements Comparable<Edge> {
        int s;
        int e;
        int value;

        Edge(int s, int e, int value){
            this.s = s;
            this.e = e;
            this.value = value;
        }

        @Override
        public int compareTo(Edge e){
            return this.value - e.value; // 오름차순 정렬
        }

        // @Override
        // public String toString(){
        //     return s + ", " + e + " : " + value;
        // }
    }
}