package com.biz.inout;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StringInput03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String strLetter = "src/com/biz/inout/loveLetter.txt";
		String secLetter = "src/com/biz/inout/secLetter.txt";
		
		List<Integer> intList = new ArrayList();
		
		FileReader fr;
		
		try {
			fr = new FileReader(strLetter);
			
			while(true) { // while문을 이용한 무한반복
				
				//ASCII코드로 파일을 읽기
				int read = fr.read();
				if(read < 0) break; // EOF이면 끝
				intList.add(read);
				
				//System.out.print((char)read + ", ");
			}
			fr.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //try end
		
		// intList에 담긴 Letter를 암호화 해서
		// 파일에 기록하기
		
		// 1. intList에 담긴 Letter를 암호화
		int intLen = intList.size();
		for(int i = 0; i < intLen; i++) {
			
			int intChar = intList.get(i);
			intChar = intChar + 'A';
			
			intList.set(i, intChar);
			
		}
		// 2. 
		 for(int i : intList) {
			 System.out.print((char)i);
					
		}
		
		
		FileWriter fw;
		
		/*
		 * try
		 */
		// FileWriter를 이용해서 writer한 파일은
		// 가끔 메모장으로 열리지 않는 경우가 있는데
		// 파일이 char형으로 저장이 되면
		// 그런 현상이 생길 수 있다.
		
		
		try {
			fw = new FileWriter(secLetter);
			
			// 2. intList에 담긴 문자들을 1개씩 파일에 기록
			for(int i: intList) {
			
				char c = (char)i;
						fw.write(c);
						int listLen = intList.size();
				
			}
			
			fw.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
