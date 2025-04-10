import java.io.*;

public class boj3052_나머지_1_104ms { 
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        boolean[] remainder = new boolean[42];
        for(int i=0; i<10; i++){
            int n = Integer.parseInt(br.readLine());

            remainder[n%42] = true;
        }

        int result = 0;
        for(int i=0; i<42; i++){
            if(remainder[i]) result++;
        }

        System.out.println(result);
        // br.close();
    }
}
