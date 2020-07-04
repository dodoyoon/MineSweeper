
public class setNumber {
	public void number(char[][] table, int height, int width) {
		for(int i=0; i<height; i++)
			for(int j=0; j<width; j++) {
				set(table, i, j, height, width);
			}
	}
	
	//x,y가 0이거나 max일 때 넣어야함 
	
	private void set(char[][] table, int x, int y, int max_x, int max_y) {
		int count=0;
		if(table[x][y]=='X') return;
		
		if(table[x-1][y-1]=='X'&&x!=0&&y!=0) count++;
		if(table[x][y-1]=='X'&&y!=0) count++;
		if(table[x+1][y-1]=='X'&&x!=max_x&&y!=0) count++;
		if(table[x-1][y]=='X'&&x!=0) count++;
		if(table[x+1][y]=='X'&&x!=max_x) count++;
		if(table[x-1][y+1]=='X'&&x!=0&&y!=max_y) count++;
		if(table[x][y+1]=='X'&&y!=max_y) count++;
		if(table[x+1][y+1]=='X'&&x!=max_x&&y!=max_y) count++;
		
		table[x][y]=(char)count;
		if(count==0)
			table[x][y]=' ';
	}
}

