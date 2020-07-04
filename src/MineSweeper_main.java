public class MineSweeper_main {
	public static void main(String[] args) {
		SelectMenu game = new SelectMenu();
		
		game.newGame();
		Display.firstSet();
		Timer_mine.stopwatch(1);
		while(!game.isEnded) {
			Display.display();
			game.selectMenu();
		}
		Timer_mine.stopwatch(0);
		if(game.success) {
			//new
			System.out.println("=====You Win=====\nYour Record --> "+Timer_mine.timeBuffer);
			game.record();
			System.out.println("====Recorded!====");
		}
		else {
		System.out.println("=====Game Over=====\ngaming time "+Timer_mine.timeBuffer);
		}
	}
}