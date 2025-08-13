package BaekJoon;

import java.util.Scanner;

/*
    +, -, 괄호를 가지고 식을 만듦. 그 후 괄호를 지움.
    그 후 괄호를 적절히 쳐서 식의 값을 최소로 만들고자 함.
    *수는 최대 5자리, 0으로 시작 가능, 식의 길이는 50이하
 */

public class Main_BJ1541 {                              //잃어버린 괄호
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        int num = 0;
        int first = 0;
        String[] strs = str.split("-");
        for(int i = 0; i < strs.length; i++){
            if(strs[i].contains("+")){
                String[] tmp = strs[i].split("\\+");
                for(int j = 0; j < tmp.length; j++){
                    num += Integer.parseInt(tmp[j]);
                }
            } else {
                num += Integer.parseInt(strs[i]);
            }
            if(i == 0){
                first = num;
            }
        }

        num = (num - (first * 2)) * -1;

        System.out.println(num);
    }
}
