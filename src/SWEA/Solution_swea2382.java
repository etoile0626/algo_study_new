package SWEA;

/*
    N * N 개의 동일한 크기의 정사각형 셀들에 k개의 군집 존재.

    ① 최초 각 미생물 군집의 위치와 군집 내 미생물의 수, 이동 방향이 주어진다. 약품이 칠해진 부분에는 미생물이 배치되어 있지 않다. 이동방향은 상, 하, 좌, 우 네 방향 중 하나이다.
        *(상: 1, 하: 2, 좌: 3, 우: 4)
    ② 각 군집들은 1시간마다 이동방향에 있는 다음 셀로 이동한다.
    ③ 미생물 군집이 이동 후 약품이 칠해진 셀에 도착하면 군집 내 미생물의 절반이 죽고, 이동방향이 반대로 바뀐다.
       미생물 수가 홀수인 경우 반으로 나누어 떨어지지 않으므로, 다음과 같이 정의한다.
       살아남은 미생물 수 = 원래 미생물 수를 2로 나눈 후 소수점 이하를 버림 한 값
       따라서 군집에 미생물이 한 마리 있는 경우 살아남은 미생물 수가 0이 되기 때문에, 군집이 사라지게 된다,
    ④ 이동 후 두 개 이상의 군집이 한 셀에 모이는 경우 군집들이 합쳐지게 된다.
       합쳐 진 군집의 미생물 수는 군집들의 미생물 수의 합이며, 이동 방향은 군집들 중 미생물 수가 가장 많은 군집의 이동방향이 된다.
       합쳐지는 군집의 미생물 수가 같은 경우는 주어지지 않으므로 고려하지 않아도 된다.

    M 시간 동안 이 미생물 군집들을 격리하였다. M시간 후 남아 있는 미생물 수의 총합을 구하기.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution_swea2382 {                                //[모의 SW 역량테스트] 미생물 격리
    //다시 풀기
    static int[] dx = {0, -1, 1, 0};           //우상하좌 순
    static int[] dy = {1, 0, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for(int T = 1; T <= t; T++){
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            List<int[]> list = new ArrayList<>();
            for(int i = 0; i < k; i++){
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int num = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken());

                list.add(new int[] {x, y, num, dir%4});
            }

            for(int i = 0; i < m; i++){
                List<int[]> moved = new ArrayList<>();          //list기반으로 이동한 값을 저장하는 리스트

                //1회 이동
                for(int[] tmp : list) {
                    int ni = tmp[0] + dx[tmp[3]];
                    int nj = tmp[1] + dy[tmp[3]];

                    if (ni == 0 || ni == n - 1 || nj == 0 || nj == n - 1) {           //가장자리에 닿았다면 미생물 반 깎고 방향 변경
                        tmp[2] = tmp[2] / 2;
                        tmp[3] = 3 - tmp[3];            //1->2, 2->1, 3->0, 0->3
                    }

                    //미생물 없으면 소멸
                    if (tmp[2] == 0) {
                        continue;
                    }

                    moved.add(new int[]{ni, nj, tmp[2], tmp[3]});
                }

                //1회 이동이 끝나고 같은 위치에 있나 점검
                Map<String, int[]> map = new HashMap<>();           //중복 제거용 map
                for (int[] tmp : moved) {
                    String key = tmp[0] + "," + tmp[1];
                    if (!map.containsKey(key)) {
                        map.put(key, new int[]{tmp[0], tmp[1], tmp[2], tmp[3], tmp[2]});        //마지막 tmp[2]는 군체의 방향을 결정했던 기준값
                    } else {
                        int[] arr = map.get(key);

                        if (tmp[2] > arr[4]) {   // 누적합이 아닌 기준값과 비교
                            arr[3] = tmp[3];
                            arr[4] = tmp[2];
                        }
                        arr[2] += tmp[2];
                    }
                }

                list = new ArrayList<>(map.values());       //1사이클 끝나면 list map값으로 갱신
            }

            int sum = 0;
            for(int[] arr : list){
                sum += arr[2];
            }

            sb.append("#").append(T).append(" ").append(sum).append("\n");
        }

        System.out.println(sb.toString());
    }
}
