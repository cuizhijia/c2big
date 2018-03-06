package com.czj.sof.c2big.eigthquen;

public final class Queen8 {

	static final int MAX_NUM = 8;
	
	
	static final int MAX_NUM_QUEN = 8;
	
	
	static final int[][] chessBoard = new int[MAX_NUM][MAX_NUM];
	
	
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
	
	public static void main(String[] args) {
		Queen8.settleQueen(0);
		Queen8.printChessBoard();
		
	}
	
	
}
