package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BJ1094 {                      //막대기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(br.readLine());

        int length = 64;                    //막대기 길이 합
        int cur = 64;                       //가장 짧은 막대기 길이
        int answer = 1;                     //막대기 개수

        //x가 64일 때
        if(x == 64)
            System.out.println(1);
        else{		//X != 64
            //막대기 자르고 붙이는 과정 진행!
            while(true){
                cur /= 2;	//막대기 절반으로 자르기
                length -= cur;	//절반으로 자른 1개 막대기 버렸다고 가정!

                if(length < x){	//막대기의 합 < X
                    answer++;	//막대기 버리지 않기
                    length += cur;
                } else if(length == x)	//막대기의 합 == X
                    break;
            }
            System.out.println(answer);	//막대기의 개수 BufferedWriter 저장
        }
    }
}
