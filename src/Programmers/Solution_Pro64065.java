package Programmers;

/*
    특정 튜플을 표현하는 집합이 담긴 문자열 s가 매개변수로 주어질 때, s가 표현하는 튜플을 배열에 담아 return 하도록 solution 함수를 완성하기.
    *s는 항상 중복되는 원소가 없는 튜플을 올바르게 표현 중
    *s는 숫자와 '{', '}', ',' 로만 이루어져 있음.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution_Pro64065 {                    //튜플
    //다시 풀기
    class Solution {
        public int[] solution(String s) {
            List<Integer> list = new ArrayList<>();

            //맨 앞 뒤 {{, }}를 제거하면 튜플},{튜플},{...과 같은 형태
            s = s.substring(2, s.length()-2);     //맨 앞 {, 맨 뒤 }} 제거
            String[] arr = s.split("\\},\\{");      //},{을 기준으로 분리해서 각 튜플로 분리

            //길이가 작은 튜플 순으로 정렬
            Arrays.sort(arr, new Comparator<String>(){
                public int compare(String o1, String o2){
                    return Integer.compare(o1.length(), o2.length());
                }
            });

            for(int i = 0; i < arr.length; i++){
                String[] str = arr[i].split(",");

                for(int j = 0; j < str.length; j++){
                    int n = Integer.parseInt(str[j]);

                    if(!list.contains(n)){
                        list.add(n);
                    }
                }
            }

            int[] answer = list.stream().mapToInt(Integer::intValue).toArray();

            return answer;
        }
    }
}
