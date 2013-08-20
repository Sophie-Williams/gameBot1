package com.Fort;

import Bot2.Bot2;
import android.util.Log;

public class BattleManager extends Thread{
	public BattleManager (String str) {
		super (str);
	}
	int ROAD_X = 300, SLOT_Y= 430;
	int[] ROAD_Y={350,285,236,180,140};
	int[] SLOT_X={275,350,425,500,575};
	int current_slot=0;
	int current_road=0;
	public void run () {
		while(FortManager.isInBattle()== 1 ) {
			Log.i("BOT: ", "In battle");
			try {
			 sleep(10000);
			 makeMove();
			} catch (InterruptedException e) {
				Log.i("BOT: ","Battle sleep interrupted");
			}
		}
		Log.i("BOT: ", "Battle done ");
		postBattle();
	}
	private void makeMove() {
		Bot2.getDevice().swipe(SLOT_X[current_slot], SLOT_Y, ROAD_X, ROAD_Y[current_road], 100);
		String messge = String.valueOf(SLOT_X[current_slot]) +String.valueOf(SLOT_Y) +String.valueOf(ROAD_X) +String.valueOf(ROAD_Y[current_road]);  
		Log.i("BOT: ", messge);
		current_road++;
		current_slot++;
	}
	private void postBattle() {
		Log.i("BOT: ", "Post battle screen");
	}
	
}
