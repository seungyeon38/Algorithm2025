import java.io.*;

public class boj8958_OX퀴즈_1_104ms{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());

        for(int tc=0; tc<TC; tc++){
            char[] result = br.readLine().toCharArray();
            int score = 0;
            int length = result.length;
            int sequence = 0;

            for(int i=0; i<length; i++){
                if(result[i] == 'O'){
                    sequence++;
                    score += sequence;
                } else if(result[i] == 'X'){
                    sequence = 0;
                }
            }

            sb.append(score).append("\n");
        }

        System.out.println(sb.toString());
        // br.close();
    }
}