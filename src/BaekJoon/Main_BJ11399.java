package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
    atm 앞에 n명의 사람들이 줄 서있다.
    줄 서는 순서에 따라, 돈을 인출하는데 필요한 시간의 합이 달라지게 된다.
    줄 서는 사람 수 n과 각 사람이 돈을 인출하는데 걸리는 시간 Pi가 주어질 때, 각 사람이 돈을 인출하는데 필요한 시간의 합의 최솟값을 구하기
 */

public class Main_BJ11399 {                 //ATM
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int time = 0;

        for(int i = 0; i < n; i++){
            int sum = 0;

            for(int j = 0; j <= i; j++){
                sum += arr[j];
            }

            time += sum;
        }

        System.out.println(time);
    }
}
