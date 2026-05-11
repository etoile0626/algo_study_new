package SWEA;

/*
    9*9 스도쿠가 주어질 때, 스도쿠 조건에 맞게 겹치는 숫자가 없는지 검사하기.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_swea1974 {                        //스도쿠 검증
    //다시 풀기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for(int T = 1; T <= t; T++){
            int answer = 1;
            int[][] sudoku = new int[10][10];

            for(int i = 0; i < 9; i++) {
                st = new StringTokenizer(br.readLine());

                for(int j = 0; j < 9; j++) {
                    sudoku[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            //가로 체크
            for(int i = 0; i < 9; i++) {
                int[] arr = new int[10];

                for(int j = 0; j < 9; j++)
                    arr[sudoku[i][j]]++;

                for(int k = 1; k <= 9; k++) {
                    if(arr[k] == 0) {
                        answer = 0;
                        break;
                    }
                }
            }

            //세로 체크
            for(int i = 0; i < 9; i++) {
                int[] arr = new int[10];

                for(int j = 0; j < 9; j++)
                    arr[sudoku[j][i]]++;

                for(int k = 1; k <= 9; k++) {
                    if(arr[k] == 0) {
                        answer = 0;
                        break;
                    }
                }
            }

            //3*3체크
            for(int i = 0; i <= 6; i += 3) {
                for(int j = 0; j <= 6; j += 3) {
                    int[] arr = new int[10];

                    int a = i + 3;
                    int b = j + 3;

                    for(int x = i; x < a; x++) {
                        for(int y = j; y < b; y++) {
                            arr[sudoku[x][y]]++;
                        }
                    }

                    for(int z = 1; z <= 9; z++) {
                        if(arr[z] == 0) {
                            answer = 0;
                            break;
                        }
                    }
                }
            }

            sb.append("#").append(T).append(" ").append(answer).append("\n");
        }

        System.out.println(sb.toString());
    }
}
