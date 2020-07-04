import java.util.*;

public class SelectMenu extends Map {
	Scanner kb = new Scanner(System.in);
	private int h, w, m;
	public boolean isEnded = false;
	public boolean success = false;
	
	public void newGame() {
		String level = null;
		
		while(true) {
			System.out.print("Start a new game!\nSelect the level easy / normal / hard : ");
			level = kb.next();
			if(level.equalsIgnoreCase("easy")) {
				h = 9;
				w = 9;
				m = 10;
				break;
			}
			else if(level.equalsIgnoreCase("normal")) {
				h = 16;
				w = 16;
				m = 40;
				break;
			}
			else if(level.equalsIgnoreCase("hard")) {
				h = 16;
				w =30;
				m = 99;
				break;
			}
		}
		Map newGame = new Map();
		newGame.SpreadMines(h, w, m);
	}
	
	public void selectMenu() {
		String menu = null;
		
		while(true) {
			System.out.println("Which menu do you want?");
			System.out.println("s : select a space");
			System.out.println("f : (de)mark a flag");
			System.out.println("e : exit");
			System.out.print("Select : ");
			menu = kb.next();
			if(menu.equalsIgnoreCase("s")) {
				selectSpace();
				break;
			}
			else if(menu.equalsIgnoreCase("f")) {
				flag();
				break;
			}
			else if(menu.equalsIgnoreCase("e"))
				System.exit(0);
			else
				System.out.println("Try again!\n");
		}
	}
	
	private void selectSpace() {
		while(true) {
			System.out.println("\nInput the space number you want");
			System.out.print("Height: ");
			String hh = kb.next();
			h = convertToNum(hh);
			System.out.print("Width: ");
			String ww = kb.next();
			w = convertToNum(ww);
			System.out.println("h : "+h+"\tw : "+w);
			if((h > 0 && w > 0) && (h <= height && w <= width) && !Display.visit[h][w] && hh.length() == 1 && ww.length() == 1)
				break;
			else
				System.out.println("Try again!\n");
		}
		if(SetNumber.isMine(h - 1, w - 1)) {
			System.out.println("You checked a mine!");
			Display.displayMinesMap();
			isEnded = true;
			kb.close();
		}
		else {
			Display.set(h, w);
		}
	}
	
	private int convertToNum(String s) {
		int num = 0;
		char input = s.charAt(0);
		if('a' <= input && input <= 'z')
			num = input - 96;
		else if('A' <= input && input <= 'Z')
			num = input - 64;
		return num;
	}
	
	private void flag() {
		while(true) {
			System.out.println("\nInput the space number you want");
			System.out.print("Height: ");
			String hh = kb.next();
			h = convertToNum(hh);
			System.out.print("Width: ");
			String ww = kb.next();
			w = convertToNum(ww);
			
			if((h > 0 && w > 0) && (h <= height && w <= width) && !Display.visit[h][w] && hh.length() == 1 && ww.length() == 1)
				break;
			else
				System.out.println("Try again!");
		}
		Display.markFlag(h, w);
		if(mines == Display.matchMines()) {
			isEnded = true;
			success = true;
			System.out.println("You've sweeped all of the mines!");
		}
	}
	
	public void record() {
		
		Ranking record = new Ranking();
		String name;
		do {
			System.out.print("Input your name(less than or same as 7 letters): ");
			name = kb.next();
			if(name.length() > 7) System.out.println("Try again!\n");
		} while(name.length() > 7);
		record.Ranking(mines, name, Timer_mine.timeBuffer);
		kb.close();
	}
}
