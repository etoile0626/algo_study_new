package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*
    학생회장 후보 = 전체 학생의 추천에 의해 정해진 만큼 선정
    추천 받은 학생을 게시하고 추천 횟수를 표시하는 규칙은 아래와 같음.
    1. 추천 시작 전에는 모두 비어있음
    2. 학생을 추천하면, 추천 받은 학생은 사진이 게시되어야 함.
    3. 게시된 학생 수가 전부 차면 가장 적은 추천 수를 받은 학생과 교체. 여러 명일 경우 가장 오래된 사진 교체
    4. 이미 게시된 학생이 추천 받으면 추천 횟수만 갱신
    5. 게시된 학생이 내려가면 추천수는 0으로 초기화
    일때, 최종 후보가 누구인지 결정하기.

    *학생은 1~100번 사이, 1 <= n <= 20, 총 추천 횟수는 1000번 이하
 */

public class Main_BJ1713 {                      //후보 추천하기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());                //게시된 학생 상한치
        int k = Integer.parseInt(br.readLine());                //총 추천횟수

        Map<Integer, Integer> map = new HashMap<>();                //추천 학생
        Map<Integer, Integer> timeMap = new HashMap<>();            //학생의 등록 시간
        int time = 0;                                               //등록시간 (맵에 새 값이 갱신될때마다 증가)
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < k; i++){
            int num = Integer.parseInt(st.nextToken());

            if(map.containsKey(num)) {                              //이미 추천 후보에 오른 학생이면
                map.put(num, map.get(num) + 1);
            } else{                                                 //새로 추천 후보에 오른 학생이면
                if (map.size() == n) {                              //추천 후보생이 가득 차 있으면
                    int value = Integer.MAX_VALUE;                  //추천 수 중 최솟값
                    int old = Integer.MAX_VALUE;                    //시간들 중 최솟값
                    int min = 0;                                    //최소일때의 학생
                    
                    for(int m : map.keySet()){
                        //추천 수가 최소인지 먼저 확인 -> 그 후 최소이면서 old 값이 가장 작은 경우 탐색
                        if(value > map.get(m) || (value == map.get(m) && timeMap.get(m) < old)) {                       
                            value = map.get(m);
                            old = timeMap.get(m);
                            min = m;
                        }
                    }
                    map.remove(min);
                    timeMap.remove(min);
                }
                map.put(num, 1);
                timeMap.put(num, time++);
            }
        }

        //맵에 있는 값들 오름차순으로 정리하기
        int[] arr = new int[map.size()];                    //n이 아닌 map의 크기임에 주의하기
        int j = 0;
        for(int num : map.keySet()){
            arr[j++] = num;
        }
        Arrays.sort(arr);

        for(int i = 0; i < map.size(); i++){
            System.out.print(arr[i] + " ");
        }
    }
}
