package com.Fort;

import Bot2.Bot2;
import android.util.Log;

public class BattleManager extends Thread{
	public BattleManager (String str) {
		super (str);
	}
	int ROAD_X = 300, SLOT_Y= 430;
	int[] ROAD_Y={350,285,220,160,90};
	int[] SLOT_X={275,350,425,500,575};
	int current_slot=0;
	int current_road=0;
	public void run () {
		while(FortManager.isInBattle()== 1 ) {
			Log.i("BOT: ", "In battle");
			try {
			 sleep(8000);
			 makeMove();
			} catch (InterruptedException e) {
				Log.i("BOT: ","Battle sleep interrupted");
			}
		}
		Log.i("BOT: ", "Battle done ");
	}
	private void makeMove() {
		Bot2.getDevice().swipe(SLOT_X[current_slot], SLOT_Y, ROAD_X, ROAD_Y[current_road], 5);
		String messge = "In MakeMove: Current slot: "+ String.valueOf(current_slot)+" current road: "+String.valueOf(current_road)+" "+String.valueOf(SLOT_X[current_slot]) +" "+String.valueOf(SLOT_Y)+" " +String.valueOf(ROAD_X)+" "+String.valueOf(ROAD_Y[current_road]);  
		Log.i("BOT: ", messge);
		current_road = (current_road+1)%5;
		current_slot = (current_slot+1)%5;
	}
}
