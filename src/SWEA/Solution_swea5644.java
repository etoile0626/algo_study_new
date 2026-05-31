package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
    BC의 충전 범위가 C일 때, BC와 거리가 C 이하이면 BC에 접속할 수 있다.
    이때, 두 지점 A(XA, YA), B(XB, YB) 사이의 거리는 다음과 같이 구할 수 있다.
    D = |XA – XB| + |YA – YB|
    두 충전 범위에 모두 속하는 경우, 이 위치에서는 두 BC 중 하나를 선택하여 접속
    사용자 A와 B의 이동 궤적이 주어졌다고 가정하자. T는 초(Second)를 의미한다. 예를 들어 5초에 사용자 A는 (5, 2) 지점에, 사용자 B는 (6, 9) 지점에 위치한다.
    매초마다 특정 BC의 충전 범위에 안에 들어오면 해당 BC에 접속이 가능하다. 따라서 T=5에 사용자 A는 BC 3에, 사용자 B는 BC 2에 접속할 수 있다.
    이때, 접속한 BC의 성능(P)만큼 배터리를 충전 할 수 있다.
    *만약 한 BC에 두 명의 사용자가 접속한 경우, 접속한 사용자의 수만큼 충전 양을 균등하게 분배한다.
    BC의 정보와 사용자의 이동 궤적이 주어졌을 때, 모든 사용자가 충전한 양의 합의 최댓값을 구하기.
    *사용자A는 지도의 (1, 1) 지점에서, 사용자B는 지도의 (10, 10) 지점에서 출발.
 */

//좌표 클래스
class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // 좌표 움직이동
    public void move(int dir) {
        switch (dir) {
            case 1:
                y--;
                break;	// 상
            case 2:
                x++;
                break; // 우
            case 3:
                y++;
                break; // 하
            case 4:
                x--;
                break; // 좌
        }
    }
}

//BC(Battery Charger) 클래스
class BC {
    Point point; // 좌표
    int c, p;   // 충전 범위, 처리량

    public BC(Point point, int c, int p) {
        this.point = point;
        this.c = c;
        this.p = p;
    }
}

public class Solution_swea5644 {                    //[모의 SW 역량테스트] 무선 충전
    static int m, a, answer;
    static int[] arrA, arrB;
    static BC[] arrAP;

    private static void charge(Point userA, Point userB) {
        // A와 B 위치의 접속 가능한 BC 리스트
        List<Integer> listA = new ArrayList<>();
        List<Integer> listB = new ArrayList<>();

        // BC 개수만큼 반복
        for (int i = 0; i < a; i++) {
            // A와 각 BC와의 거리가 접속 가능하다면 ( 충전범위 C >= 거리 D )
            if (arrAP[i].c >= (Math.abs(arrAP[i].point.x - userA.x)) + Math.abs(arrAP[i].point.y - userA.y)) {
                listA.add(i);
            }

            // B와 각 BC와의 거리가 접속 가능하다면 ( 충전범위 C >= 거리 D )
            if (arrAP[i].c >= (Math.abs(arrAP[i].point.x - userB.x)) + Math.abs(arrAP[i].point.y - userB.y)) {
                listB.add(i);
            }
        }

        int max = 0, temp = 0;

        // A와 B가 접속 가능한 모두 1개 이상이라면
        if (listA.size() > 0 && listB.size() > 0) {
            // 완전 탐색으로 가능한 조합을 모두 비교하여 최대 처리량P 구하기
            for (int i : listA) {
                for (int j : listB) {
                    temp = 0;

                    if (i == j) { // 같은 BC인 경우 처치량 나눠가지므로 한개만 더하기
                        temp = arrAP[i].p;
                    } else {	// 같은 BC가 아닌 경우 각각 처리량 더하기
                        temp += arrAP[i].p;
                        temp += arrAP[j].p;
                    }

                    max = Math.max(max, temp);
                }
            }
        }
        else if (listA.size() > 0) {              // A가 접속 가능한 BC가 1개 이상이라면
            // 접속 가능한 BC중 최대 처리량P 구하기
            for (int i : listA) {
                if (max < arrAP[i].p)
                    max = arrAP[i].p;
            }
        }
        else if (listB.size() > 0) {              // B가 접속 가능한 BC가 1개 이상이라면
            // 접속 가능한 BC중 최대 처리량P 구하기
            for (int i : listB) {
                if (max < arrAP[i].p)
                    max = arrAP[i].p;
            }
        }

        answer += max;	                    //결과 누적
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for(int T = 1; T <= t; T++){
            st = new StringTokenizer(br.readLine());

            m = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());
            arrA = new int[m];
            arrB = new int[m];
            arrAP = new BC[a];
            answer = 0;

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < m; i++){
                arrA[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < m; i++){
                arrB[i] = Integer.parseInt(st.nextToken());
            }


            for(int i = 0; i < a; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken());
                arrAP[i] = new BC(new Point(x, y), c, p);
            }

            //유저 초기화
            Point userA = new Point(1, 1);
            Point userB = new Point(10, 10);

            // 처음 좌표에서 충전 가능한지 판단
            charge(userA, userB);

            for (int i = 0; i < m; i++) {
                // A와 B 움직인후 충전 가능한지 판단
                userA.move(arrA[i]);
                userB.move(arrB[i]);
                charge(userA, userB);
            }

            sb.append("#").append(T).append(" ").append(answer).append("\n");
        }

        System.out.println(sb.toString());
    }
}
