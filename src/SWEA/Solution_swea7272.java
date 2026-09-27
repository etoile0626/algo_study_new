package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_swea7272 {                        //안경이 없어!

    private static int zeroCount(char c){
        if(c == 'B'){
            return 2;
        } else if(c == 'A' || c == 'D' || c == 'O' || c == 'P' || c == 'Q' || c == 'R'){
            return 1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());
            String str1 = st.nextToken();
            String str2 = st.nextToken();
            boolean flag = true;
            int n = str1.length();

            if (str1.length() != str2.length()){
                flag = false;
            }
            else {
                for (int i = 0; i < n; i++) {
                    int zero1 = zeroCount(str1.charAt(i));
                    int zero2 = zeroCount(str2.charAt(i));

                    if (zero1 != zero2) {
                        flag = false;
                        break;
                    }
                }
            }

            sb.append("#").append(t).append(" ");
            if(!flag){
                sb.append("DIFF");
            } else {
                sb.append("SAME");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
