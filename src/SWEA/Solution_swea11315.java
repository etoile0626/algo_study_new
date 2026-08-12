package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    N X N 크기의 판이 있다.
    판의 각 칸에는 돌이 있거나 없을 수 있다.
    돌이 가로, 세로, 대각선 중 하나의 방향으로 다섯 개 이상 연속한 부분이 있는지 없는지 판정하기.
    *각 문자는 ‘o’또는 ‘.’으로, ‘o’는 돌이 있는 칸을 의미하고, ‘.’는 돌이 없는 칸을 의미.
 */

public class Solution_swea11315 {               //오목 판정
    static int n;
    static char[][] arr;

    private static boolean isFive(int x, int y){
        boolean flag = false;
        //가로
        for(int i = 0; i < 5; i++){
            if(y+i < n && arr[x][y+i] == 'o'){
                flag = true;
                continue;
            } else {
                flag = false;
                break;
            }
        }
        if(flag){
            return true;
        }

        //세로
        for(int i = 0; i < 5; i++){
            if(x+i < n && arr[x+i][y] == 'o'){
                flag = true;
                continue;
            } else {
                flag = false;
                break;
            }
        }
        if(flag){
            return true;
        }

        //오른쪽 아래 대각선
        for(int i = 0; i < 5; i++){
            if(x+i < n && y+i < n && arr[x+i][y+i] == 'o'){
                flag = true;
                continue;
            } else {
                flag = false;
                break;
            }
        }
        if(flag){
            return true;
        }

        //왼쪽 아래 대각선
        for(int i = 0; i < 5; i++){
            if(x+i < n && y-i >= 0 && arr[x+i][y-i] == 'o'){
                flag = true;
                continue;
            } else {
                flag = false;
                break;
            }
        }
        if(flag){
            return true;
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            n = Integer.parseInt(br.readLine());
            arr = new char[n][n];
            boolean flag = false;
            String answer;

            for(int i = 0; i < n; i++){
                String str = br.readLine();

                for(int j = 0; j < n; j++){
                    arr[i][j] = str.charAt(j);
                }
            }

            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(arr[i][j] == 'o') {
                        flag = isFive(i, j);
                    }

                    if(flag){
                        break;
                    }
                }

                if(flag){
                    break;
                }
            }

            if(flag){
                answer = "YES";
            } else{
                answer = "NO";
            }

            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }

        System.out.println(sb.toString());
    }
}
