package com.n9mtq4.botclient.example;

import com.n9mtq4.botclient.ControllableBot;
import com.n9mtq4.botclient.Game;

/**
 * Created by will on 11/28/15 at 1:27 AM.
 * 
 * An example bot ai that just moves to the center
 * of the map
 * 
 * @author Will "n9Mtq4" Bresnahan
 */
public class MoveForward {
	
	public static void main(String[] args) {
		
		Game game = new Game(); // start the game
		
		while (true) {
			
			ControllableBot bot = game.waitForTurn(); // wait for your turn and get the bot
			
//			team 1 is on the left, and 2 on the right
//			make sure to invert the x if you are team 2
			bot.move(game.getTeam() == 1 ? 1 : -1, 0); // move forward
			
			game.endTurn(bot); // end your turn
			
		}
		
	}
	
}
