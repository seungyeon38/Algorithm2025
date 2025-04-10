import java.io.*;
import java.util.*;

public class boj10807_개수세기_104ms {
    public static void main(String[] args) throws Exception{
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        int N = Integer.parseInt(br.readLine()); // 정수의 개수 (1~100)
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] num = new int[201];
        for(int i=0; i<N; i++){
            num[Integer.parseInt(st.nextToken()) + 100]++;
        }

        int find_num = Integer.parseInt(br.readLine());
        System.out.println(num[find_num+100]);
        br.close();
    }
}
