package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    10 개의 평점을 총점이 높은 순서대로 부여하는데,
    각각의 평점은 같은 비율로 부여할 수 있다.
    예를 들어, N 명의 학생이 있을 경우 N/10 명의 학생들에게 동일한 평점을 부여할 수 있다.
    입력으로 각각의 학생들의 중간, 기말, 과제 점수가 주어지고,
    학점을 알고싶은 K 번째 학생의 번호가 주어졌을 때,
    K 번째 학생의 학점을 출력하기.
 */

public class Solution_swea1983 {                            //조교의 성적 매기기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            double[] arr = new double[n+1];                     //그냥 맵 쓰고 정렬 때리는게 편할려나????


            for(int i = 1; i <= n; i++){
                st = new StringTokenizer(br.readLine());
                int mid = Integer.parseInt(st.nextToken());
                int exam = Integer.parseInt(st.nextToken());
                int homework = Integer.parseInt(st.nextToken());

                arr[i] = mid * 0.35 + exam * 0.45 + homework * 0.20;
            }

            for(int i = 1; i <= n; i++){

            }

            sb.append("#").append(t).append(" ").append().append("\n");
        }

        System.out.println(sb.toString());
    }
}
