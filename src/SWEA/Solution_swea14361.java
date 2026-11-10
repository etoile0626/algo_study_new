package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
     N의 10진법 표기(단, 0으로 시작하지 않도록 표기해야 함)에서 나타나는 숫자들을 재배열하여 N보다 큰 N의 배수(즉 2N, 3N, …, k•N, …) 를 만들 수 있는지 판단하기.
 */

public class Solution_swea14361 {                   //숫자가 같은 배수
    //다시풀기
    static String str;
    static boolean flag;
    static StringBuilder tmp;
    static boolean[] used;

    private static void dfs(){
        if(flag){
            return;
        }

        if(tmp.length() == str.length()){
            int n = Integer.parseInt(str);
            int num = Integer.parseInt(tmp.toString());

            if(num > n && num % n == 0){
                flag = true;
            }

            return;
        }

        for(int i = 0; i < str.length(); i++){
            if(tmp.length() == 0 && str.charAt(i) == '0'){
                continue;
            }

            used[i] = true;
            tmp.append(str.charAt(i));

            dfs();

            tmp.deleteCharAt(tmp.length()-1);
            used[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            str = br.readLine();
            flag = false;
            tmp = new StringBuilder();
            used = new boolean[str.length()];

            dfs();

            sb.append("#").append(t).append(" ");
            if(flag){
                sb.append("possible");
            } else{
                sb.append("impossible");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
