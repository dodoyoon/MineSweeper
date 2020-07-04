import java.util.Random;
public class Map {
	public static char[][] table;
	public static int width, height, mines;
	
	static Random random = new Random();
	
	public void SpreadMines(int mainHeight, int mainWidth, int mainMines) {
		height = mainHeight;
		width = mainWidth;
		mines = mainMines;
		table = new char [height][width];
		for(int i = 0; i < height; i++)
			for(int j = 0; j < width; j++) {
				if(i * width + j + 1 <= mines)
					table[i][j] = 'X';
				else
					table[i][j] = 'O';
			}
		shuffleTable(width, height);
		//for debugging
		/*for(int i=0;i<height;i++) {
			for(int j=0;j<width;j++) {
				System.out.print(table[i][j]);
			}
			System.out.println();
		}*/
		
	}
	
	private void shuffleTable(int width, int height) {
		for(int i = 0; i < height; i++)
			for(int j = 0; j < width; j++) 
				swap(i, j, random.nextInt(height), random.nextInt(width));
	}
	
	private void swap(int a, int b, int c, int d) {
		char ch = table[a][b];
		table[a][b] = table[c][d];
		table[c][d] = ch;
	}
	
	public int getHeight() {return height;}
	public int getWidth() {return width;}
	public int getMines() {return mines;}
	public char[][] getTable() {return table;}
}
