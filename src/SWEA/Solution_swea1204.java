package SWEA;

/*
    1000명의 수학 성적을 가지고 최빈값 구하기.
    *단, 최빈수가 여러 개 일 때에는 가장 큰 점수를 출력.
    *학생의 수는 1000명이며, 각 학생의 점수는 0점 이상 100점 이하의 값.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_swea1204 {                //[S/W 문제해결 기본] 1일차 - 최빈수 구하기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for(int n = 1; n <= t; n++){
            int T = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            int[] arr = new int[1000];                                  //학생 점수 담을 배열
            int[] score = new int[101];                                 //0~100점 점수 빈도 체크
            int mode = 0;                                               //최빈값
            int max = 0;

            for(int i = 0; i < 1000; i++){
                arr[i] = Integer.parseInt(st.nextToken());
                score[arr[i]]++;
            }

            for(int i = 0; i < 101; i++){
                if(max <= score[i]) {                                   //최빈값이 같을 경우 큰 점수를 고르기 위해 등호 포함
                    max = score[i];
                    mode = i;
                }
            }

            sb.append("#").append(T).append(" ").append(mode).append("\n");
        }

        System.out.println(sb.toString());
    }
}
