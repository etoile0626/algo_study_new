package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    철수가 빙고판에 쓴 수들과 사회자가 부르는 수의 순서가 주어질 때, 사회자가 몇 번째 숫자를 부른 후 빙고를 외치게 되는지 구하기
    *빙고를 외치다 = 빙고가 3개가 될 때
    *빙고판에 쓰이는 수 = 1~25가 한 번씩 사용
 */

public class Main_BJ2578 {              //빙고

    static int[][] arr;
    static int bingo, cross1, cross2;
    static boolean cross1Done, cross2Done;
    static boolean[] rowDone;
    static boolean[] colDone;

    private static void isIn(int num) {
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++) {
                if(arr[i][j] == num){
                    //불린 숫자 지우기
                    arr[i][j] = 0;
                    //빙고 여부 검사
                    isCal(i, j);      
                    isRow(i, j);
                    isCross(i, j);
                }
            }
        }
    }

    private static void isCross(int i, int j) {
        if(i == j){
            cross1++;
            if(cross1 == 5 && !cross1Done){         //대각선 전부 0 && 중복으로 체크된 것이 아니라면
                bingo++;
                cross1Done = true;
            }
        }

        if(i + j == 4){
            cross2++;
            if(cross2 == 5 && !cross2Done){         //대각선 전부 0 && 중복으로 체크된 것이 아니라면
                bingo++;
                cross2Done = true;
            }
        }
    }

    private static void isRow(int i, int j) {
        boolean flag = true;

        for(int k = 0; k < 5; k++){
            if(arr[i][k] != 0){
                flag = false;
                break;
            }
        }

        if(flag && !rowDone[i]){
            bingo++;
            rowDone[i] = true;                  //중복된 가로줄 방지용
        }
    }

    private static void isCal(int i, int j) {
        boolean flag = true;

        for(int k = 0; k < 5; k++){
            if(arr[k][j] != 0){
                flag = false;
                break;
            }
        }

        if(flag && !colDone[j]){
            bingo++;
            colDone[j] = true;                  //중복된 세로줄 방지용
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        arr = new int[5][5];
        rowDone = new boolean[5];
        colDone = new boolean[5];
        int cnt = 0;

        for(int i = 0; i < 5; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < 5; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++) {
                int num = Integer.parseInt(st.nextToken());
                isIn(num);
                cnt++;
                if(bingo >= 3){                     //빙고 갯수가 한 번에 늘어날 것을 대비
                    break;
                }
            }
            if(bingo >= 3){
                break;
            }
        }

        System.out.println(cnt);
    }
}
