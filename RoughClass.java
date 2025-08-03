package com.web.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RoughClass {

	public static void main(String[] args) {
		try{
            int i =1/0;
            System.out.println(i);
        }catch(ArithmeticException e){
            e.printStackTrace();
        }catch(Exception e){
              System.out.println("handled");
        }
		
	}
}
