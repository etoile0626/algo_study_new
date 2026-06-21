package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    메모리 bit중 하나를 골라 0인지 1인지 결정하면 해당 값이 메모리의 끝까지 덮어씌우게 됨.
    ex)메모리 값이 0100이고, 3번째 bit를 골라 1로 설정하면 0111.
    원래 상태가 주어질 때 초기화 상태 (모든 bit가 0) 에서 원래 상태로 돌아가는데 최소 몇 번이나 고쳐야 하는지 구하기.
 */

public class Solution_swea1289 {                    //원재의 메모리 복구하기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            String str = br.readLine();                                 //원래 상태(정답)
            int min = 0;
            char init = '0';

            for(char c : str.toCharArray()){
                if(c != init){                                          //현재 탐색중인 메모리자리가 정답과 다르면 수정
                    min++;
                    init = c;
                }
            }

            sb.append("#").append(t).append(" ").append(min).append("\n");
        }

        System.out.println(sb.toString());
    }
}
