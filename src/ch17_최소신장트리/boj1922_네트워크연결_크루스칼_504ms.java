package ch17_최소신장트리;

import java.io.*; 
import java.util.*;

public class boj1922_네트워크연결_크루스칼_504ms {
    static int[] parents;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        int N = Integer.parseInt(br.readLine()); // 컴퓨터의 수 1~1000
        int M = Integer.parseInt(br.readLine()); // 연결할 수 있는 선의 수 1~100,000

        List<Edge> edge_list = new ArrayList<>();

        for(int i=0; i<M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken()); // 1~10,000

            if(a != b) edge_list.add(new Edge(a, b, c));
        }

        Collections.sort(edge_list);

        parents = new int[N+1];
        for(int i=1; i<=N; i++){
            parents[i] = i;
        }

        int cnt = 0; // 연결한 간선 수
        int result = 0; // 최소비용
        
        for(int i=0; i<M; i++){
            Edge cur_edge = edge_list.get(i);
            if(union(cur_edge.s, cur_edge.e)){
                cnt++;
                result += cur_edge.value;
            }

            if(cnt == N-1) break;
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

    static class Edge implements Comparable<Edge>{
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
            return this.value - e.value;
        }
    }
}
