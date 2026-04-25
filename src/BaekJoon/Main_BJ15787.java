package BaekJoon;

/*
    n개의 기차가 어둠을 헤치고 은하수를 건너려고 함.
    기차는 20개의 일렬로 된 좌석이 있고, 한 개의 좌석에는 한 개의 사.
    어떤 기차에 대해 m개의 명령이 주어짐.
    1 i x : i번째 기차에 x번째 좌석에 사람을 태워라. 이미 사람이 타있다면 , 아무런 행동을 하지 않는다.
    2 i x : i번째 기차에 x번째 좌석에 앉은 사람은 하차한다. 만약 아무도 그자리에 앉아있지 않았다면, 아무런 행동을 하지 않는다.
    3 i : i번째 기차 승객들이 모두 한칸씩 뒤로간다. k번째 앉은 사람은 k+1번째로 이동하여 앉는다.
        만약 20번째 자리에 사람이 앉아있었다면 그 사람은 이 명령 후에 하차한다.
    4 i : i번째 기차 승객들이 모두 한칸씩 앞으로간다. k번째 앉은 사람은 k-1 번째 자리로 이동하여 앉는다.
        만약 1번째 자리에 사람이 앉아있었다면 그 사람은 이 명령 후에 하차한다.
    M번의 명령 후에 1번째 기차부터 순서대로 한 기차씩 은하수를 건너는데 조건이 있다.
    기차는 순서대로 지나가며 기차가 지나갈 때 승객이 앉은 상태를 목록에 기록하며 이미 목록에 존재하는 기록이라면 해당 기차는 은하수를 건널 수 없다.
    ex)1번 기차와 3번 기차의 좌석 정보(어디에 승객이 있는지)가 같으면, 3번은 못 건넘.

    이때, 은하수를 건널 수 있는 기차의 수를 구하기.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_BJ15787 {                              //기차가 어둠을 헤치 은하수를
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());                           //기차 수
        int m = Integer.parseInt(st.nextToken());                           //명령 수

        boolean[][] train = new boolean[n+1][21];                                   //n개의 기차, 20개의 좌석

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());

            int order = Integer.parseInt(st.nextToken());                   //명령 번호
            int num = Integer.parseInt(st.nextToken());                     //간섭할 기차 번호
            int pos = 0;

            if(order < 3){
                pos = Integer.parseInt(st.nextToken());                 //간섭할 좌석 위치
            }

            switch(order){
                case 1:
                    train[num][pos] = true;
                    break;
                case 2:
                    train[num][pos] = false;
                    break;
                case 3:
                    for(int j = 20; j > 1; j--){
                        train[num][j] = train[num][j-1];
                    }

                    train[num][1] = false;
                    break;
                case 4:
                    for(int j = 1; j < 20; j++){
                        train[num][j] = train[num][j+1];
                    }

                    train[num][20] = false;
                    break;
            }
        }

        //은하수 통과
        Set<String> set = new HashSet<>();

        for(int i = 1; i <= n; i++){
            StringBuilder sb = new StringBuilder();

            for(int j = 1; j <= 20; j++){
                if(train[i][j]) {
                    sb.append("1");
                } else{
                    sb.append("0");
                }
            }

            set.add(sb.toString());
        }

        System.out.println(set.size());
    }
}
