public class GravityPuzzleEasy {
	public static void main(String[] args) {
		GravityPuzzleEasy gpe = new GravityPuzzleEasy();
		String[] puzzle = 	
        {"..#.#", "#.#..", "...##"}
;
		System.out.println(gpe.solve(puzzle));
	}
	
	public String[] solve(String[] board) {
        //count the appearence of '#' for each column, record it into an array, then reconstruct the puzzle based on it.
		int[] numList = new int[board[0].length()];
		for(int i=0; i<=board[0].length()-1;i++) {
			int counter = 0;
			for(int r=0; r<=board.length-1; r++) {
				if (board[r].charAt(i)=='#') {
					counter +=1;
				}
			}
            numList[i] = counter;

        }
        		
		String[] resultString = new String[board.length];
		String newString;
		for(int r=board.length-1; r>=0;r--) {
			newString = "";
			for(int i=0; i<=numList.length-1;i++) {
				if (numList[i]!=0) {
                    newString += '#';
                    numList[i] -=1;
				}
				else {
					newString += '.';
				}
			}
			resultString[r] = newString;
		}
		
		return resultString;

	}
}