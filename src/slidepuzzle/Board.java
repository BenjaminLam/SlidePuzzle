package slidepuzzle;

public class Board {
	private int n;
	private int[][] board;
	private Position emptyField;
	
	public Board(int n){ //constructor
		if (n<3 || n>100) {
			throw new IllegalArgumentException("Board size is out of bounds. It has to be between 3 and 100");
		}
		this.n=n;
		this.board= new int[this.n][this.n];
		emptyField=new Position (n-1,n-1);
		createBoard();
	}
	
	public void printBoard(){
		//for formatting
		String digits = "" +(this.n*this.n-1);
		String s="%" + (digits.length()+1) + "d";
		
		//prints board
		for(int i=0; i<this.n; i++){
			for(int j=0; j<this.n; j++){
				System.out.format(s, board[i][j]);
			}
			System.out.println();
		}
	}

	public boolean move(int k){
		int x=emptyField.getX();
		int y=emptyField.getY();
		if(checkMove (x,y+1,k)){
			return true;
		}
		if(checkMove (x,y-1,k)){
			return true;
		}
		if(checkMove (x+1,y,k)){
			return true;
		}
		if(checkMove (x-1,y,k)){
			return true;
		}
			
		return false;
	}
	
	public boolean boardSolved () {
		//checks if last position is 0
		if (board[this.n-1][this.n-1]!=0) {
			return false;
		}
		
		//checks if every 
		for (int i=0; i<this.n;i++) {
			for (int j=0; j<this.n;j++) {
				if (!(board[i][j]==(i*n+j+1))){
					if (!(i==this.n-1 && j ==this.n-1)) { //if the position containing a wrong number (according to algoritm) is not last number, return false 
						return false;
					}
				}
			}
		}
		return true;
	}
	
	private boolean checkMove (int nx, int ny, int k) {
		try {
			if(board[nx][ny]==k){
				board[emptyField.getX()][emptyField.getY()]=k;
				board[nx][ny]=0;
				emptyField.setPosition(nx, ny);
				return true;
			}
		}catch (ArrayIndexOutOfBoundsException e) {};
		return false;
	}
	
	private void createBoard(){
		//Fills the board with integers from 1 to n-1
				for(int i=0; i<this.n; i++){
					for(int j=0; j<this.n; j++){
						board[i][j]=i*this.n+j+1;
					}
				}
				//Fills the pre-configured fields with the given integers
				board[0][0]=2;
				board[0][1]=3;				
				board[0][2]=1;
				board[this.n-1][this.n-1]=0;			
	}
}
