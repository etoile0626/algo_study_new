package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    n*n 행렬 크기의 종이가 존재.
    종이의 각 칸에는 -1, 0, 1 중 하나가 저장.
    1. 종이가 모두 같은 수로 되어있다면, 종이를 그대로 사용.
    2. 위의 경우가 아닌 경우 종이를 같은 크기의 종이 9개로 자르고, 잘린 종이에 대해 1의 과정을 반복
    위의 조건을 만족할 때, -1, 0, 1로 이루어진 종이의 개수를 구하기
    *순서대로 한 줄에 하나씩 출력하기
 */

public class Main_BJ1780 {                  //종이의 개수

    static int cnt_a, cnt_b, cnt_c, n;
    static int[][] arr;

    static boolean check(int row, int col, int size){                  //arr[row][col]부터  size만큼 범위의 값 비교
        for(int i = row; i < row + size; i++){
            for(int j = col; j < col + size; j++){
                if(arr[i][j] != arr[row][col]){
                    return false;
                }
            }
        }

        return true;
    }

    static void divide(int row, int col, int size){
        if(check(row, col, size)){
            if(arr[row][col] == -1){
                cnt_a++;
            } else if(arr[row][col] == 0){
                cnt_b++;
            } else {
                cnt_c++;
            }

            return;
        }

        divide(row, col, size/3);
        divide(row, col + size/3, size/3);
        divide(row, col + (size/3) * 2, size/3);


        divide(row + size/3, col, size/3);
        divide(row + size/3, col + size/3, size/3);
        divide(row + size/3, col + (size/3) * 2, size/3);

        divide(row + (size/3) * 2, col, size/3);
        divide(row + (size/3) * 2, col + size/3, size/3);
        divide(row + (size/3) * 2, col + (size/3) * 2, size/3);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cnt_a = 0;                      //-1
        cnt_b = 0;                      //0
        cnt_c = 0;                      //1

        divide(0, 0, n);

        System.out.println(cnt_a);
        System.out.println(cnt_b);
        System.out.println(cnt_c);
    }
}
