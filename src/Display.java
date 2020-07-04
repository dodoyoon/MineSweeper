public class Display extends Map{
	public static char[][] displayTable = new char[height + 1][width + 1];
	public static boolean[][] visit = new boolean[height + 1][width + 1]; //방문확인
	private static int match;
	public static char[][] getDisplayTable() {return displayTable;}
	
	public static void firstSet() {
		for(int i = 0; i < height + 1; i++)
			for(int j = 0; j < width + 1; j++) {
				if(i * j == 0) {
					visit[i][j] = true;
					if(i == 0 && j == 0) displayTable[i][j] = '\\';
					else if(i+j <= 26) displayTable[i][j] = (char)(i + j + 96);
					else displayTable[i][j] = (char)(i + j + 38);
				}
				else {
					visit[i][j] = false;
					displayTable[i][j] = '*';
				}
			}
	}
	
	public static void display() {
		System.out.println();
		for(int i = 0; i < height + 1; i++)
			for(int j = 0; j < width + 1; j++) {
				System.out.print(displayTable[i][j] + " ");
				if(j == width) System.out.println();
			}
		System.out.println();
	}
	
	public static void displayMinesMap() {
		for(int i = 1; i < height + 1; i++)
			for(int j = 1; j < width + 1; j++)
				displayTable[i][j] = Map.table[i-1][j-1];
		display();
	}
	
	public static void markFlag(int x, int y) {
		if(displayTable[x][y] == 'F') displayTable[x][y] = '*';
		else if(displayTable[x][y] == '*') displayTable[x][y] = 'F';
	}
	
	public static int matchMines() {
		match = 0;
		for(int i = 1; i < height + 1; i++)
			for(int j = 1; j < width + 1; j++)
				if(displayTable[i][j] == 'F' && Map.table[i-1][j-1] == 'X') match++;
		return match;
	}
	
	public static void set(int x, int y) {
		displayTable = SetNumber.displaySet(x, y);
		visit[x][y] = true;
	}
}