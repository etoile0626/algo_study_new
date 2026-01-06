package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    r * c 크기의 직사각형 격자판에 봄버맨이 있다. 칸은 비어있거나 폭탄이 들어있다. ( . = 빈칸 / O = 폭탄)
    폭탄이 있는 칸은 3초가 지난 후에 폭발하고, 폭탄이 폭발한 이후에는 폭탄이 있던 칸이 파괴되어 빈 칸이 되며, 인접한 네 칸도 함께 파괴된다
    폭탄이 폭발할때 인접한 4칸에 폭탄이 있어도 폭발 없이 파괴된다(연쇄 폭발x)
    봄버맨은 폭발에 상관없이 이동 가능
    1. 봄버맨이 일부칸에 폭탄을 설치
    2. 1초 동안 가만히
    3. 1초 동안 폭탄이 설치되지 않은 모든 칸에 폭탄 설치
    4. 1초 후 3초전 폭탄이 폭발
    5. 3과 4 반복
    n 초 후 격자판 상태 구하기
 */

public class Main_BJ16918 {                 //봄버맨

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] arr = new int[r][c];
        for(int i = 0; i < r; i++){
            String str = br.readLine();

            for(int j = 0; j < c; j++) {
                if(str.charAt(j) == 'O') {
                    arr[i][j] = 3;
                }
            }
        }

        int time = 1;

        while (time <= n){
            if((time % 2) == 0){        //짝수초일때 폭탄을 놓음
                for(int i = 0; i < r; i++){
                    for(int j = 0; j < c; j++){
                        if(arr[i][j] == 0){
                            arr[i][j] = time + 3;
                        }
                    }
                }
            }
            else{
                for(int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++) {
                        if(arr[i][j] == time){
                            for(int d = 0; d < 4; d++){
                                int ni = i + dx[d];
                                int nj = j + dy[d];

                                if(0 <= ni&&ni < r && 0 <= nj&&nj < c && arr[ni][nj] != time){
                                    arr[ni][nj] = 0;
                                }
                                arr[i][j] = 0;
                            }
                        }
                    }
                }
            }

            time++;
        }

        char[][] sol = new char[r][c];
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(arr[i][j] == 0){
                    sol[i][j] = '.';
                } else{
                    sol[i][j] = 'O';
                }
            }
        }


        for(int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                sb.append(sol[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
