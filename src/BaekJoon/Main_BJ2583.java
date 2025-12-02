package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/*
    m*n크기의 모눈 종이가 있을 때, 이 위에 눈금에 맞추어 k개의 직사각형을 그린다.
    k개의 직사각형으로 인해 영역이 나누어질때, 몇개의 영역으로 나누어지고 그 크기는 얼마인지 구하기
    *모눈종이의 왼쪽 아래 = (0, 0) / 오른쪽 위 = (m, n)
    *k개의 직사각형 좌표들은 왼쪽 아래 꼭짓점의 x, y좌표와 오른쪽 위 꼭짓점의 x, y좌표로 제공
 */

public class Main_BJ2583 {                              //영역 구하기

    static int m, n, size;
    static int[][] arr;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static void dfs(int y, int x){
        arr[y][x] = 1;

        for(int d = 0; d < 4; d++){
            int ny = y + dy[d];
            int nx = x + dx[d];

            if(0 <= nx&&nx < n && 0 <= ny&&ny < m && arr[ny][nx] == 0){
                size++;
                dfs(ny, nx);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        ArrayList<Integer> list = new ArrayList<>();
        
        arr = new int[m][n];
        for(int i =0; i < k; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            //k개의 직사각형 칠하기
            for(int y = y1; y < y2; y++){
                for(int x = x1; x < x2; x++){
                    arr[y][x] = 1;
                }
            }
        }

        for(int i = 0; i < m; i++){
            for(int j =0; j <n; j++){
                if(arr[i][j] == 0){
                    size = 1;               //size 초기화
                    dfs(i, j);
                    list.add(size);
                }
            }
        }

        Collections.sort(list);

        System.out.println(list.size());
        for(int num : list){
            System.out.print(num + " ");
        }
    }
}
