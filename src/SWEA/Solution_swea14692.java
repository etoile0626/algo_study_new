package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    Alice와 Bob은 길이 N미터의 통나무를 자르는 게임을 한다.
    게임은 Alice가 먼저 시작하며 그 이후 둘이 번갈아가면서 턴을 가진다.
    각 턴을 맡은 사람은, 통나무를 두 조각으로 나누는데, 이 때 잘린 통나무가 모두 자연수(1 이상의 정수) 미터 길이를 가지도록 잘라야 한다.
    더 이상 자를 수 없게 되는 사람이 진다. 누가 이기는가?
 */

public class Solution_swea14692 {                   //통나무 자르기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            int n = Integer.parseInt(br.readLine());

            sb.append("#").append(t).append(" ");

            if(n % 2 == 0){
                sb.append("Alice");
            }else{
                sb.append("Bob");
            }

            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
