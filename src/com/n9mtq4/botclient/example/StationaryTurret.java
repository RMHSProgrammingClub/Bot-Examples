package com.n9mtq4.botclient.example;

import com.n9mtq4.botclient.ControllableBot;
import com.n9mtq4.botclient.Game;
import com.n9mtq4.botclient.world.Bot;
import com.n9mtq4.botclient.world.WorldObject;

/**
 * Created by will on 11/28/15 at 1:16 AM.
 * 
 * An example bot ai that stays stationary and shoots at enemy bots
 * 
 * @author Will "n9Mtq4" Bresnahan
 */
public class StationaryTurret {
	
	public static void main(String[] args) {
		
		Game game = new Game(); // start the game
		
		while (true) {
			
			ControllableBot bot = game.waitForTurn(); // wait for your turn and get the bot
			
//			lets process the vision
			for (WorldObject object : bot.getVision()) {
				
				if (!object.isBot()) continue; // make what we see is a bot
				Bot target = (Bot) object;
				
				if (target.getTeam() == game.getTeam()) continue; // make sure we don't shoot our own bots
				
//				calculate how much we need to turn
				int turnAmount = getTurnAmount(bot.getX(), bot.getY(), bot.getAngle(), target.getX(), target.getY());
				bot.turn(turnAmount); // then turn but that amount
				bot.shoot(); // and shoot towards the target bot
				
			}
			
			game.endTurn(bot); // end your turn
			
		}
		
	}
	
	private static int getTurnAmount(int x, int y, int angle, int x1, int y1) {
		
		double newAngle = Math.atan2(y - y1, x - x1); // calculate desired angle
		return (int) (Math.toDegrees(newAngle) - angle); // return the difference
		
	}
	
}
