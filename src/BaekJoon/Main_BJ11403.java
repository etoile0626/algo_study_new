package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    가중치 없는 방향 그래프가 주어질 때, 모든 정점에 대해 i에서 j로 가는 길이가 양수인 경로가 있는지 구하기
    *인접행렬로 그래프가 주어짐, i행 j열 숫자가 1이면 가는 길이 있는 경우, 0이면 길이 없음
    '모든 정점에 대해' -> 플로이드-워셜
 */

public class Main_BJ11403 {                     //경로 찾기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int k = 0; k < n; k++){                             //k번 노드를 경유한다고 가정할 때
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(arr[i][k] == 1 && arr[k][j] == 1){       //k를 경유해서 가는 i->j경로가 존재한다면
                        arr[i][j] = 1;
                    }
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
