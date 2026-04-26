package BaekJoon;

/*
    N개의 정수로 이루어진 배열 A가 주어진다.
    이때, 배열에 들어있는 '정수의 순서를 적절히 바꿔서' 다음 식의 최댓값을 구하는 프로그램을 작성하시오.
    |A[0] - A[1]| + |A[1] - A[2]| + ... + |A[N-2] - A[N-1]|
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ10819 {                                          //차이를 최대로
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }


    }
}
