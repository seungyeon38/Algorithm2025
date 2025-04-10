import java.io.*;
import java.util.*;

public class boj10871_X보다작은수_144ms {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 정수 갯수
        int X = Integer.parseInt(st.nextToken()); // 기준 정수

        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<N; i++){
            int n = Integer.parseInt(st.nextToken());
            if(n < X){
                sb.append(n).append(" ");
            }
        }

        System.out.println(sb.toString());
        // br.close();
    }
}
