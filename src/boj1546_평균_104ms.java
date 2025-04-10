import java.io.*;
import java.util.StringTokenizer;

public class boj1546_평균_104ms {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        int N = Integer.parseInt(br.readLine()); // 시험 본 과목 개수 (<=1000)
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] result = new int[N];
        int M = 0;

        for(int i=0; i<N; i++){
            result[i] = Integer.parseInt(st.nextToken());
            M = Math.max(result[i], M);
        }

        float new_result_sum = 0;
        for(int i=0; i<N; i++){
            new_result_sum += (float)result[i]/M*100;
        }

        System.out.println(new_result_sum/N);
        // br.close();
    }
}
