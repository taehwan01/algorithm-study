import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //입력 값을 받는 BufferedReader
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //결과를 출력하는 BufferedWriter
        long num = Integer.parseInt(br.readLine());		//입력값 저장
        String result = findFractional(num);			//함수 결과값 받기
        bw.write(result + "\n");				//결과 bw에 저장
        bw.flush();						//결과 출력
        bw.close();
        br.close();
    }
    public static String findFractional(long num) {		//분수 찾기 함수
    	long plus = 2,start = 1,temp;				//범위 더하는 값, 비교 값, 임시 값
    	int stack = 1,molecules,denominator;			//시작 분수, 분자, 분모
    	boolean check;						//시작하는 방향 체크
    	String result="";					//결과값 반환 변수
    	if(num==1)
    		return "1/1";					//1/1일때 그대로 반환
    	else {
    		for(;;) {					//무한 반복함수
    			temp = start;
    			start+=plus;
    			stack++;
    			if(num<=start) {//입력 값 범위 안에 있을 때 무슨 분수를 가지는지 도출
    				check = odd_even_number(stack);
    				temp = num - temp;
    				if(check) {
    					molecules = 1;
    					denominator = stack;
    					for(int i=1;i<temp;i++) {
    						molecules++;
    						denominator--;
        				}
    				}else {
    					molecules = stack;
    					denominator = 1;
    					for(int i=1;i<temp;i++) {
    						molecules--;
    						denominator++;
        				}
    				}
    				break;
    			}
    			plus++;
        	}
    	}
    	result = String.valueOf(molecules) + "/" + String.valueOf(denominator);		//결과 String형
    	return result;						//결과 반환
    }
    public static boolean odd_even_number(int num) {		//홀수, 짝수로 방향 정하는 함수
    	if(num%2==0)
    		return true;
    	else
    		return false;
    }
}