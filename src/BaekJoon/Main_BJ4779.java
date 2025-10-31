package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    칸토어 집합 = 0과 1사이 실수로 이루어진 집합, 구간 [0, 1]에서 시작해서 각 구간을 3등분하여 가운데 구간을 반복적으로 제외하는 방식으로 설정
    1. -가 3^n개 있는 문자열에서 시작
    2. 문자열을 3등분 한 후, 가운데 문자열을 공백으로 바꾸기.
    3. 각 선(=문자열)을 3등분 후, 가운데 문자열을 공백으로 바꾸기. 모든 선의 길이가 1일때 까지 계속
    *n = 3 이면, 길이가 27인 문자열
 */

public class Main_BJ4779 {                                  //칸토어 집합

    static int n, len;
    static char[] str;

    static void space(int start, int size){
        if(size == 1){
            return;
        }

        int third = size / 3;
        for(int i = start + third; i < start + third * 2; i++){
            str[i] = ' ';
        }

        space(start, third);
        space(start + third * 2, third);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s;
        while((s = br.readLine()) != null) {            //주의! 파일 끝에서 멈추게하기 위함
            n = Integer.parseInt(s);
            len = (int) Math.pow(3, n);

            str = new char[len];
            for (int i = 0; i < len; i++) {
                str[i] = '-';
            }

            space(0, len);

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < len; i++) {
                sb.append(str[i]);
            }
            System.out.println(sb.toString());
        }
    }
}
