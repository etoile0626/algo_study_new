package SWEA;

/*
    높은 곳의 상자를 낮은 곳에 옮기는 방식으로 최고점과 최저점의 간격을 줄이는 작업을 평탄화라고 한다.
    평탄화를 모두 수행하고 나면, 가장 높은 곳과 가장 낮은 곳의 차이가 최대 1 이내가 된다.
    평탄화 작업을 위해서 상자를 옮기는 작업 횟수에 제한이 걸려있을 때,
    제한된 횟수만큼 옮기는 작업을 한 후 최고점과 최저점의 차이를 반환하는 프로그램을 작성하시오.
    *가로 길이는 항상 100
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_swea1208 {            //[S/W 문제해결 기본] 1일차 - Flatten
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for(int T = 1; T <= 10; T++){
            int h = 0;                                                //높이 차
            int dump = Integer.parseInt(br.readLine());                //덤프 횟수
            int[] arr = new int[100];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < 100; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int max_idx = 0;
            int min_idx = 0;
            //덤프 시작
            for(int i = 0; i < dump; i++){
                int max = 0;
                int min = 101;                          //높이는 1이상 100이하
                max_idx = 0;
                min_idx = 0;

                for(int j = 0; j < 100; j++){
                    if(arr[j] > max){
                        max = arr[j];
                        max_idx = j;
                    }

                    if(arr[j] < min){
                        min = arr[j];
                        min_idx = j;
                    }
                }

                arr[max_idx]--;
                arr[min_idx]++;                     //덤프 수행
            }

            //최대 최소 값 찾기
            int max = 0;
            int min = 101;                          //높이는 1이상 100이하
            for(int j = 0; j < 100; j++){
                if(arr[j] > max){
                    max = arr[j];
                    max_idx = j;
                }

                if(arr[j] < min){
                    min = arr[j];
                    min_idx = j;
                }
            }

            h = arr[max_idx] - arr[min_idx];

            sb.append("#").append(T).append(" ").append(h).append("\n");
        }

        System.out.println(sb.toString());
    }
}
