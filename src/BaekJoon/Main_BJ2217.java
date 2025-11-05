package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main_BJ2217 {                          //로프
    //다시 풀기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());  //수 입력받기
        }

        Arrays.sort(arr, Collections.reverseOrder());  //내림차순으로 정렬하기

        int total = 0;
        for (int i = 0; i < n; i++) {
            total = Math.max(total, arr[i] * (i+1));
        }

        System.out.print(total);
    }
}
