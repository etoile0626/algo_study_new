package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ1057 {              //토너먼트
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int j = Integer.parseInt(st.nextToken());               //지민
        int h = Integer.parseInt(st.nextToken());               //한수
        int cnt = 0;

        while(j != h){
            j = j/2 + j%2;
            h = h/2 + h%2;
            cnt++;
        }

        System.out.println(cnt);
    }
}
