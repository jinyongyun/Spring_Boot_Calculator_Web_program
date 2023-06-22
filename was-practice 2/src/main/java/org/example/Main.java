package org.example;

import java.io.IOException;

//GET  /calculate 라는 요청 들어오게 되면 계산 수행 후 결과 리턴 , /calculate?operand1=11&operator=*&operand2=55
public class Main {
    public static void main(String[] args) throws IOException {


         new CustomWebApplicationServer(8081).start();


    }
}