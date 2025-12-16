package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    1번부터 n번까지의 학생들이 두 학생끼리 키를 비교한 결과의 일부가 주어져 있다.
    단, n명의 학생들의 키는 모두 다르다고 가정한다.
    이 경우 자신의 키가 몇번째인지 알 수 있는 학생들이 모두 몇명인지 계산하기
 */

public class Main_BJ2458 {                      //키 순서
    //다시 풀기, 플로이드 워셜
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] student = new int[n][n];
        int max = n * (n * (n - 1) / 2);                //n * m, 배열 안에 들어올 수 있는 최댓값 대충 잡기

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                student[i][j] = max;
            }
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            student[n1 - 1][n2 - 1] = 1;
        }

        for(int k = 0; k < n; k++) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(student[i][j] > student[i][k] + student[k][j]) {
                        student[i][j] = student[i][k] + student[k][j];
                    }
                }
            }
        }

        int result = 0;
        for(int i = 0; i < n; i++) {
            int cnt = 0;
            for(int j = 0; j < n; j++) {
                if(student[i][j] < max || student[j][i] < max) {
                    cnt++;
                }
            }
            if(cnt == n - 1) {
                result++;
            }
        }

        System.out.println(result);
    }
}
