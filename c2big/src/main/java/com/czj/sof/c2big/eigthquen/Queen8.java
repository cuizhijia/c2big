package com.czj.sof.c2big.eigthquen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Queen8 {

	static final int MAX_NUM = 8;
	
	
	static final int MAX_NUM_QUEN = 8;
	
	
	static final int[][] chessBoard = new int[MAX_NUM][MAX_NUM];
	
	
	private static final Queen8 Q8 = new Queen8();
	
	protected void checkPrin() {
		
		System.out.println("father");
		
	}
	
	static boolean check(int x,int y) {
		
		for(int i=0; i<y; i++) {
			
			if(chessBoard[x][i] == 1) {
				return false;
			}
			
			if(x-1-i>=0 && chessBoard[x-1-i][y-1-i]==1) {
				return false;
			}
			
			if(x+1+i<MAX_NUM && chessBoard[x+1+i][y-1-i]==1) {
				return false;
			}
		}
		return true;
	}
	
	
	
	static boolean settleQueen(int y) {
		if(y == MAX_NUM_QUEN) {
			return true;
		}
		
		for(int i=0; i<MAX_NUM; i++) {
			for(int x=0; x<MAX_NUM; x++) {
				chessBoard[x][y] = 0;
			}
			
			if(check(i, y)) {
				chessBoard[i][y] = 1;
				
				if(settleQueen(y+1)) {
					return true;
				}
			}
			
		}
		return false;
	}
	
	static void printChessBoard() {
		for(int j=0; j<MAX_NUM; j++) {
			for(int i=0; i<MAX_NUM; i++) {
				System.out.print(chessBoard[i][j]+" ");
			}
			System.out.println(" ");
		}
	}
	
	
	
	
	
	public static  Queen8 instan(Queen8 q8) {
		
		return q8==null?Q8:q8;
	}
	
	public static  Queen8 instan() {
		
		return instan(null);
	}
	
	
	
	
	
	
	
	public static void main(String[] args) {
//		Queen8.settleQueen(0);
//		Queen8.printChessBoard();
		
		assert Boolean.TRUE;	
		
//		Queen8 instan = Queen8.instan(new Q8impl());
//		
//		instan.checkPrin();
		
//		System.out.println(instan);
		System.out.println((1<<30) +"&&&&&&&&&"+(1>>>4));
		
		
		System.out.println((2^31>>4) +"  "+(2^31>>>4));
		
		
		// 00000001
		
		// 00001000
		
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("1", "hello");
		map.forEach((K,V)->{
			
			
			System.out.println(K+" "+V);
		});	
		
		
		
		List<String> list = new ArrayList<>();
		
		list.forEach(item -> System.out.println(item));
		
		list.forEach(item -> {
			
			System.out.println(item);
			
		});
		
		list.stream().filter(item -> {
			if(item.equals("")) {
				return true;
			}
			return false;
		});
	}
	
	
}
