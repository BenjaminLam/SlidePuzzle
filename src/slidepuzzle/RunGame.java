package slidepuzzle;

import java.util.Scanner;

public class RunGame {
	public static void main(String[] args) {
		Board board = new Board(3);
		board.printBoard();
		
		Scanner console = new Scanner(System.in);
		int numberOfMoves=0;
		
		while(!board.boardSolved()){
			int k = 0;
			while(k==0){
				System.out.println("Please enter the integer you want to move:");
				try{
					k = Integer.parseInt(console.nextLine());
				} catch (NumberFormatException e){
					System.out.println("Illegal input. Try again.");
				}
			}
			if(board.move(k)){
				board.printBoard();
				numberOfMoves++;
			}
			else{System.out.println("Wrong Integer. Try again.");}
		}
		console.close();
		System.out.println("Congratulations you have completet the puzzle!");
		System.out.println("You used " + numberOfMoves + " moves!");
	}
}
