package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    8 x 8 크기의 체스판 위의 몇 개의 칸에 룩(rook)이 놓여 있다. 각 칸에는 최대 1개의 룩을 놓을 수 있으므로, 체스판 위에는 0개 이상 64개 이하의 룩이 놓여 있는 것이다.
    이때, 현재 체스판의 배치가 다음 조건을 모두 만족하는지를 판별하는 프로그램을 작성하라.
    - 정확히 8개의 룩이 있어야 한다.
    - 모든 룩은 서로 공격할 수 없어야 한다. 즉, 서로 다른 두 룩은 같은 열에 있거나 같은 행에 있으면 안 된다.

 */

public class Solution_swea15612 {                   //체스판 위의 룩 배치
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            String[] arr = new String[8];
            boolean flag = true;

            for(int i = 0; i < 8; i++){
                arr[i] = br.readLine();
            }

            //같은 행 점검
            for(int i = 0; i < 8; i++){
                int cnt = 0;

                for(int j = 0; j < 8; j++){
                    char c = arr[i].charAt(j);

                    if(c == 'O'){
                        cnt++;
                    }
                }

                if(cnt != 1){
                    flag = false;
                }
            }

            //같은 열 점검
            if(flag) {
                for (int i = 0; i < 8; i++) {
                    int cnt = 0;

                    for (int j = 0; j < 8; j++) {
                        char c = arr[j].charAt(i);

                        if (c == 'O') {
                            cnt++;
                        }
                    }

                    if (cnt != 1) {
                        flag = false;
                    }
                }
            }

            sb.append("#").append(t).append(" ");
            if(flag){
                sb.append("yes");
            } else{
                sb.append("no");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
