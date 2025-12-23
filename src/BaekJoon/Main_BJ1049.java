package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ1049 {                      //기타줄
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int pack = Integer.MAX_VALUE;
        int piece = Integer.MAX_VALUE;
        int answer = 0;

        //기타줄 브랜드 정보 저장
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());

            //패키지 및 낱개 최소값 구하기
            pack = Math.min(pack, Integer.parseInt(st.nextToken()));
            piece = Math.min(piece, Integer.parseInt(st.nextToken()));
        }

        //낱개를 6개 살 때 패키지보다 싼지 확인
        if(piece * 6 <= pack)	//"낱개 최소값 × 6  ≤ 패키지 최소값" 확인
            answer = piece * n;	//기타줄 모두 낱개로 구매
        else{
            answer = (n / 6) * pack;	//패키지 구매할 수 있을 때까지 구매
            if((n % 6) * piece <= pack)	//남은 기타줄 패키지로 구매할지, 낱개로 구매할지 확인
                answer += (n % 6) * piece;	//남은 기타줄 낱개로 구매
            else
                answer += pack;	//남은 기타줄 패키지로 구매
        }

        System.out.println(answer);
    }
}
