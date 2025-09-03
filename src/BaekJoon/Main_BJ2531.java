package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    회전 초밥이 컨베이어 벨트 위에서 시계 방향으로 돌고 있음
    벨트 위에는 같은 종류의 초밥이 2개 이상 존재할 수 없음
    회전 초밥 집에서 2가지 행사를 진행
    1. 벨트의 임의의 한 위치에서부터 k개의 접시를 연속해서 먹을 경우 할인된 정액 가격으로 제공
    2. 각 고객에게 초밥의 종류가 쓰인 쿠폰을 발행, 1번 행사에 참여한 경우 이 쿠폰에 적혀진 초밥을 추가로 무료 제공. 벨트 위에 해당 초밥이 없으면 새로 만들어 제공.
    위 행사에 참여하여 최대한 다양한 종류의 초밥을 먹으려고 함.
    *회전 초밥 벨트에 놓인 접시의 수 n, 초밥의 가짓수 d, 연속해서 먹는 접시의 수 k, 쿠폰 번호 c
    *2 ≤ n ≤ 30,000, 2 ≤ d ≤ 3,000, 2 ≤ k ≤ 3,000 (k ≤ N), 1 ≤ c ≤ d
 */

public class Main_BJ2531 {                                          //회전 초밥
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());                   //초밥의 총 갯수
        int d = Integer.parseInt(st.nextToken());                   //초밥의 가짓수
        int k = Integer.parseInt(st.nextToken());                   //연속으로 먹는 접시의 수
        int c = Integer.parseInt(st.nextToken());                   //쿠폰 번호

        //회전 초밥
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] sushi = new int[d + 1];
        int cnt = 0;
        //0번부터 k개 초밥 먹는 경우부터 산정
        for(int i = 0; i < k; i++){
            if(sushi[arr[i]] == 0){
                cnt++;                      //처음 먹는 초밥이면 먹은 초밥 증가
            }

            sushi[arr[i]]++;                //해당 초밥 먹은거니까 수 증가
        }

        int max = cnt;                            //먹은 초밥 종류 최댓값 초기화

        for(int i = 1; i < n; i++){
            //이전 탐색의 쿠폰 사용 여부 검사
            if(max <= cnt) {
                if (sushi[c] == 0) {                         //쿠폰 사용 가능하면 사용하기
                    max = cnt + 1;
                } else{
                    max = cnt;
                }
            }
            
            //다음 end 포인트로 이동
            int end = (i + k - 1) % n;
            if(sushi[arr[end]] == 0){
                cnt++;
            }
            sushi[arr[end]]++;

            //이전 start 포인트 값 제외
            sushi[arr[i-1]]--;
            if(sushi[arr[i-1]] == 0){
                cnt--;
            }
        }

        System.out.println(max);
    }
}
