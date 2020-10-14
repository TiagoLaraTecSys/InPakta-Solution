package com.laratecsys.inpaktaService.Service.Validations.Utils;

import java.util.Random;

public class ValidatorCode {
	
	private static Random rand = new Random();
	
	public static String generateCode() {
		char[] vet = new char[10];
		
		for (int i = 0; i < vet.length; i++) {
			
			vet[i] =(char) rand.nextInt(10);
		}
		
		return new String(vet);
	}
	
	private static char randomChar() {
		 
		//int opt = rand.nextInt(3);
		int opt = 0;
		char s = 0;
		
		s = (char) (rand.nextInt(10) + 48);
			
		
		return s;
	
	}
}
