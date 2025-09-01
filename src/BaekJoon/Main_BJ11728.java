package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
    정렬되어 있는 두 배열 A, B가 주어질 때 두 배열을 합친 다음 정렬해서 출력하는 프로그램 작성하기

    * A의 크기 n, B의 크기 m / 1 <= n, m <= 10000000
    * 배열 안에 든 수는 절댓값이 10^9보다 작거나 같은 정수이다.
 */

public class Main_BJ11728 {                                 //배열 합치기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] a = new int[n];
        int[] b = new int[m];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++){
            b[i] = Integer.parseInt(st.nextToken());
        }

        int ptn_a = 0;
        int ptn_b = 0;
        while(ptn_a != n || ptn_b != m){                    //두 포인터 모두 n과 m에 도달할때까지 반복
            if(ptn_a == n){
                sb.append(b[ptn_b]).append(" ");
                ptn_b++;
            }
            else if(ptn_b == m){
                sb.append(a[ptn_a]).append(" ");
                ptn_a++;
            }
            else if(ptn_a != n || ptn_b != m) {
                if (a[ptn_a] <= b[ptn_b]) {
                    sb.append(a[ptn_a]).append(" ");
                    ptn_a++;
                } else if (a[ptn_a] > b[ptn_b]) {
                    sb.append(b[ptn_b]).append(" ");
                    ptn_b++;
                }
            }
        }

        System.out.println(sb);
    }
}
