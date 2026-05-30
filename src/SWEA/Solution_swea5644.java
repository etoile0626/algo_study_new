package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
    BC의 충전 범위가 C일 때, BC와 거리가 C 이하이면 BC에 접속할 수 있다.
    이때, 두 지점 A(XA, YA), B(XB, YB) 사이의 거리는 다음과 같이 구할 수 있다.
    D = |XA – XB| + |YA – YB|
    두 충전 범위에 모두 속하는 경우, 이 위치에서는 두 BC 중 하나를 선택하여 접속
    사용자 A와 B의 이동 궤적이 주어졌다고 가정하자. T는 초(Second)를 의미한다. 예를 들어 5초에 사용자 A는 (5, 2) 지점에, 사용자 B는 (6, 9) 지점에 위치한다.
    매초마다 특정 BC의 충전 범위에 안에 들어오면 해당 BC에 접속이 가능하다. 따라서 T=5에 사용자 A는 BC 3에, 사용자 B는 BC 2에 접속할 수 있다.
    이때, 접속한 BC의 성능(P)만큼 배터리를 충전 할 수 있다.
    만약 한 BC에 두 명의 사용자가 접속한 경우, 접속한 사용자의 수만큼 충전 양을 균등하게 분배한다.
    BC의 정보와 사용자의 이동 궤적이 주어졌을 때, 모든 사용자가 충전한 양의 합의 최댓값을 구하기.
 */

public class Solution_swea5644 {                    //[모의 SW 역량테스트] 무선 충전
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    }
}
