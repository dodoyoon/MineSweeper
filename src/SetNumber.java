public class SetNumber extends Map {
	private static char[][] displayMap = Display.getDisplayTable();
	
	public static char[][] displaySet(int x, int y) {
		setDisplayMap(x, y);
		return displayMap;
	}
	
	private static void setDisplayMap(int dish, int disw) {
		int h = dish - 1;
		int w = disw - 1;
		
		//for debug
		//System.out.println(">in set Display Map > h : "+h+"\tw : "+w+"\twidth : "+width +"\theight"+height);
		
		if(h < 0 || w < 0 || h >= height || w >= width) return;
		
		int count = 0;
		if(h > 0 && w > 0 && table[h-1][w-1]=='X') count++;
		if(w > 0 && table[h][w-1]=='X' ) count++;
		if(h < height-1 && w > 0 && table[h+1][w-1]=='X') count++;
		if(h > 0 && table[h-1][w]=='X' ) count++;
		if(h < height-1 && table[h+1][w]=='X') count++;
		if(h > 0 && w < width-1 && table[h-1][w+1]=='X') count++;
		if(w < width-1 && table[h][w+1]=='X') count++;
		if(h < height-1 && w < width-1 && table[h+1][w+1]=='X') count++;
		
		if(count > 0)
			displayMap[dish][disw] = (char)(count + 48);
		//if count == 0
		else {
			displayMap[dish][disw]=' ';
			if(h > 0) {
				if(w > 0) {
					//for debug
					//System.out.println(">> h:" + h+"\tw : "+w);
					displayMap[dish-1][disw-1] = countCheck(h-1,w-1);
					if(displayMap[dish-1][disw-1] != ' ') {
						Display.visit[dish-1][disw-1] = true;
					}
				}
				if(w < width - 1) {
					//for debug
					//System.out.println(">> h:" + h+"\tw : "+w +"/twidth : "+width +"\theight"+height);
					displayMap[dish-1][disw+1] = countCheck(h-1,w+1);
					if(displayMap[dish-1][disw+1] != ' ')
						Display.visit[dish-1][disw+1] = true;
				}
				//for debug
				//System.out.println(">> h:" + h+"\tw : "+w);
				displayMap[dish-1][disw] = countCheck(h-1,w);
				if(displayMap[dish-1][disw] != ' ')
					Display.visit[dish-1][disw] = true;
			}
			if(h < height -1) {
				if(w > 0) {
					//for debug
					//System.out.println(">> h:" + h+"\tw : "+w);
					displayMap[dish+1][disw-1] = countCheck(h+1,w-1);
					if(displayMap[dish+1][disw-1] != ' ')
						Display.visit[dish+1][disw-1] = true;
				}
				if(w < width - 1) {
					//for debug
					//System.out.println(">> h:" + h+"\tw : "+w);
					displayMap[dish+1][disw+1] = countCheck(h+1,w+1);
					if(displayMap[dish+1][disw+1] != ' ')
						Display.visit[dish+1][disw+1] = true;
				}
				//for debug
				//System.out.println(">> h:" + h+"\tw : "+w);
				displayMap[dish+1][disw] = countCheck(h+1,w);
				if(displayMap[dish+1][disw] != ' ')
					Display.visit[dish+1][disw] = true;
			}
			if(w < width-1) {
				//for debug
				//System.out.println(">> h:" + h+"\tw : "+w);
				displayMap[dish][disw+1] = countCheck(h,w+1);
				if(displayMap[dish][disw+1] != ' ')
					Display.visit[dish][disw+1] = true;
			}
			if(w > 0) {
				//for debug
				//System.out.println(">> h:" + h+"\tw : "+w);
				displayMap[dish][disw-1] = countCheck(h,w-1);
				if(displayMap[dish][disw-1] != ' ')
					Display.visit[dish][disw-1] = true;
			}
			
		}

	}
	private static char countCheck(int dish, int disw) {
		int H=dish;
		int W=disw;
		int count1=0;
		
		//for debug
		//System.out.println("in count check H : "+H+"\tW : "+W);
		
		if(H > 0 && W > 0 && table[H-1][W-1]=='X') count1++;
		if(W > 0 && table[H][W-1]=='X' ) count1++;
		if(H < height-1 && W > 0 && table[H+1][W-1]=='X') count1++;
		if(H > 0 && table[H-1][W]=='X' ) count1++;
		if(H < height-1 && table[H+1][W]=='X') count1++;
		if(H > 0 && W < width-1 && table[H-1][W+1]=='X') count1++;
		if(W < width-1 && table[H][W+1]=='X') count1++;
		if(H < height-1 && W < width-1 && table[H+1][W+1]=='X') count1++;
		
		//for debug
		//System.out.println("count: "+(char)(count1+48));
		if(count1 == 0) 			
			return ' ';
		
		return (char)(count1 + 48);
		
	}
	public static boolean isMine(int x, int y) {
		if(table[x][y] == 'X')
			return true;
		return false;
	}
}

