package SWEA;

/*
    N X N 크기의 단어 퍼즐을 만들려고 한다. 입력으로 단어 퍼즐의 모양이 주어진다.
    주어진 퍼즐 모양에서 특정 길이 K를 갖는 단어가 들어갈 수 있는 자리의 수를 출력하기.
    *흰색 부분은 1, 검은색 부분은 0
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_swea1979 {                    //어디에 단어가 들어갈 수 있을까
    static int n, k, cnt;
    static int[][] arr;

    //가로퍼즐 칸 세기
    static void row(int i, int j){
        int num = 0;

        for(int c = j; c < n; c++){
            if(arr[i][c] == 1){
                num++;
            } else{
                break;
            }
        }

        if(num == k){
            cnt++;
        }
    }

    //세로퍼즐 칸 세기
    static void cal(int i, int j){
        int num = 0;

        for(int r = i; r < n; r++){
            if(arr[r][j] == 1){
                num++;
            } else{
                break;
            }
        }

        if(num == k){
            cnt++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for(int T = 1; T <= t; T++){
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            arr = new int[n][n];
            cnt = 0;

            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());

                for(int j = 0; j < n; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            //가로 순회
            for(int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(arr[i][j] == 1){
                        if(j != 0 && arr[i][j-1] == 1){
                            continue;
                        }

                        row(i, j);
                    }
                }
            }

            //세로 순회
            for(int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(arr[i][j] == 1){
                        if(i != 0 && arr[i-1][j] == 1){
                            continue;
                        }

                        cal(i, j);
                    }
                }
            }

            sb.append("#").append(T).append(" ").append(cnt).append("\n");
        }

        System.out.println(sb.toString());
    }
}
