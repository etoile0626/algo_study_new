package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
    화학 물질 용기 n2개가 n x n으로 배열되어 있었다.
    빈 용기에 해당하는 원소는 ‘0’으로 저장하고, 화학 물질이 들어 있는 용기에 해당하는 용기는 화학 물질의 종류에 따라 ‘1’에서 ‘9’사이의 정수를 저장

    화학 물질이 담긴 용기들로부터 3가지 사항을 발견하였다.
    1. 화학 물질이 담긴 용기들이 사각형을 이루고 있다. 또한, 사각형 내부에는 빈 용기가 없다.
    2. 사각형들은 각각 차원(가로의 용기 수 x 세로의 용기 수)이 다르다.
    3. 2개의 화학 물질이 담긴 용기들로 이루어진 사각형들 사이에는 빈 용기들이 있다. (사각형 간 거리가 존재)

    행렬에서 추출된 부분 행렬들을 개수와 그 뒤를 이어 행렬들의 행과 열의 크기를 출력하기.
    *크기는 행과 열을 곱한 값으로, 크기가 작은 순서대로 출력한다.
    *크기가 같을 경우 행이 작은 순으로 출력한다.
 */

public class Solution_swea1258 {                //[S/W 문제해결 응용] 7일차 - 행렬찾기
    static int n;
    static int[][] arr;
    static boolean[][] visit;
    static List<int[]> sub;

    private static void bfs(int x, int y){
        int r = 0;
        int c = 0;

        while(y + c < n && arr[x][y+c] != 0){
            c++;
        }

        while(x + r < n && arr[x+r][y] != 0){
            r++;
        }

        for(int i = x; i < x+r; i++){
            for(int j = y; j < y+c; j++){
                visit[i][j] = true;
            }
        }

        sub.add(new int[] {r, c});
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            n = Integer.parseInt(br.readLine());
            arr = new int[n][n];
            sub = new ArrayList<>();
            visit = new boolean[n][n];

            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());

                for(int j = 0; j < n; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            //부분행렬 sub 찾기
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(arr[i][j] != 0 && !visit[i][j]){
                        bfs(i, j);
                    }
                }
            }

            //sub값을 1. 행렬의 크기 2. 행의 오름차순으로 정렬
            sub.sort((a, b) -> {
                int resultA = a[0] * a[1];
                int resultB = b[0] * b[1];

                int result = Integer.compare(resultA, resultB);     //두 행렬의 크기 비교
                if(result == 0){                                    //크기값이 같으면
                    return Integer.compare(a[0], b[0]);             //더 작은애가 앞으로 오게
                } else{
                    return result;                                  //다르면 바로 크기 비교 값 기준 정렬
                }
            }
            );

            sb.append("#").append(t).append(" ").append(sub.size());
            for(int i = 0; i < sub.size(); i++){
                int[] tmp = sub.get(i);

                sb.append(" ").append(tmp[0]).append(" ").append(tmp[1]);
            }

            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
