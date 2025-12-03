package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
    암호가 서로 다른 l개의 알파벳 소문자로 구성, 최소 1개의 모음(a e i o u)과 2개의 자음 존재
    알파벳이 암호에서 증가하는 순서로 배열되었을 것으로 추측 (abc O, bca X)
    문자의 종류가 c가지 있고 c개의 문자가 모두 주어질 때, 가능한 암호들을 모두 구하기
    (3 <= l <= c <= 15), 중복되는 문자는 없음
 */

public class Main_BJ1759 {                          //암호 만들기

    static int l, c;
    static char[] arr, str;

    static void dfs(int cnt, int idx){
        if(cnt == l){
            if(isVaild(str)) {
                for(char c : str) {
                    System.out.print(c);
                }
                System.out.println();
            }

            return;
        }

        for(int i = idx; i < c; i++){
            str[cnt] = arr[i];
            dfs(cnt+1, i+1);
        }
    }

    static boolean isVaild(char[] str){
        int a = 0;                  //모음
        int b = 0;                  //자음

        for(int i = 0; i < l; i++){
            if(str[i] == 'a' || str[i] == 'e' || str[i] == 'i' || str[i] == 'o' || str[i] == 'u'){
                a++;
            } else{
                b++;
            }
        }

        if(a >= 1 && b >= 2){
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        l = Integer.parseInt(st.nextToken());                   //암호의 길이
        c = Integer.parseInt(st.nextToken());                   //사용한 문자 수
        arr = new char[c];                                      //입력값
        str = new char[l];                                      //출력배열

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < c; i++){
            arr[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(arr);

        dfs(0, 0);
    }
}
