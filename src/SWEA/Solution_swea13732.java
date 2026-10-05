package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    N×N 크기의 격자판이 있다. 각각의 격자는 비어 있거나(‘.’), 막혀 있다(‘#’).
    이때, 막혀 있는 칸들이 하나의 정사각형을 이루는지를 판단하기.
 */

public class Solution_swea13732 {                                   //정사각형 판정
    //다시 풀기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            int n = Integer.parseInt(br.readLine());
            String[] arr = new String[n];
            boolean flag = true;

            for(int i = 0; i < n; i++){
                arr[i] = br.readLine();
            }

            //정사각형 판별
            int block = 0;
            int x = -1;
            int y = -1;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i].charAt(j) == '#') {
                        if (block == 0) {               // 처음 만난 #
                            x = i;
                            y = j;
                        }

                        block++;
                    }
                }
            }

            int k = (int) Math.round(Math.sqrt(block));
            if (x == -1 || k * k != block || x + k > n || y + k > n) {
                flag = false;
            } else {
                for (int i = x; i < x + k; i++){
                    for (int j = y; j < y + k; j++) {
                        if (arr[i].charAt(j) != '#') {
                            flag = false;
                            break;
                        }
                    }

                    if(!flag){
                        break;
                    }
                }
            }

            sb.append("#").append(t).append(" ");
            if(flag){
                sb.append("yes");
            } else {
                sb.append("no");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}

