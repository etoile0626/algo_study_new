package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_swea4406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            String str = br.readLine();
            StringBuilder tmp = new StringBuilder();
            for(int i = 0; i < str.length(); i++){
                char c = str.charAt(i);

                if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
                    continue;
                } else{
                    tmp.append(c);
                }
            }

            sb.append("#").append(t).append(" ").append(tmp).append("\n");
        }

        System.out.println(sb.toString());
    }
}
