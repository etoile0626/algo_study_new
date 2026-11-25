package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    몬스터를 공격할 때는 기본적으로 D만큼의 데미지를 입힌다. 여기에, 용사가 익힌 공격의 레벨 L에 따라 추가적인 데미지가 있는데,
    지금까지 몬스터를 때린 횟수가 n번이라고 하면, 다음 공격이 몬스터에게 입히는 데미지는 D(1+nㆍL%)가 된다. %는 1/100을 의미한다.
    지금까지 용사가 몬스터를 때린 횟수가 0번이라고 할 때, 앞으로 총 N번의 공격을 하면 몬스터에게 가한 총 데미지가 몇이 되는지 구하기.
 */

public class Solution_swea11387 {                       //몬스터 사냥
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());
            long d = Integer.parseInt(st.nextToken());
            long l = Integer.parseInt(st.nextToken());
            long n = Integer.parseInt(st.nextToken());
            double dmg = 0;

            for(int i = 0; i < n; i++){
                double num = (d * (1 + ((double) (i * l) / 100)));
                dmg += num;
            }

            sb.append("#").append(t).append(" ").append((long)dmg).append("\n");
        }

        System.out.println(sb.toString());
    }
}
