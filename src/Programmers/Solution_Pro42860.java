package Programmers;

/*
    조이스틱으로 알파벳 이름을 완성하기.
    *초기값은 A로 채워져있음(완성할 이름의 글자수 만큼)
    *▲ - 다음 알파벳
    *▼ - 이전 알파벳 (A에서 아래쪽으로 이동하면 Z로)
    *◀ - 커서를 왼쪽으로 이동 (첫 번째 위치에서 왼쪽으로 이동하면 마지막 문자에 커서)
    *▶ - 커서를 오른쪽으로 이동 (마지막 위치에서 오른쪽으로 이동하면 첫 번째 문자에 커서)
    만들고자 하는 이름 name이 매개변수로 주어질 때, 이름에 대해 조이스틱 조작 횟수의 최솟값 구하기.
 */

public class Solution_Pro42860 {                //조이스틱
    class Solution {
        public int solution(String name) {
            int answer = 0;
            int n = name.length();
            int move = n-1;               //좌우 이동 횟수, 일단 좌->우로 다 이동한 경우가 최댓값이므로 최댓값으로 초기화

            for(int i = 0; i < n; i++){
                //상하 이동 계산
                int cnt = name.charAt(i) - 'A';                 //0 <= cnt < 26(A~Z까지)

                //0~12 -> 위로 움직이는게 가까움
                if(cnt < 13){
                    answer += cnt;
                }
                //13~25 -> 아래로(역순으로) 움직이는게 가까움
                else{
                    answer += (25 - cnt + 1);
                }

                //커서 이동 계산 -> 무조건 이동하면서 알파벳 변경을 하는게 아니라 시작 지점을 바꾸고 해도 되잖아?
                int ni = i + 1;

                while(ni < n && name.charAt(ni) == 'A'){
                    ni++;
                }

                //(1. i만큼 오른쪽으로 갔다 역행 / 2.왼쪽으로 먼저 역행 후 오른쪽으로 쭉 이동하기) 중 최솟값 가져오기.
                move = Math.min(move, Math.min(2*i + (n - ni), 2*(n - ni) + i));
            }

            answer += move;

            return answer;
        }
    }
}
