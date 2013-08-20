package com.Fort;

import android.util.Log;

public class BattleManager extends Thread{
	public BattleManager (String str) {
		super (str);
	}
	
	public void run () {
		while(FortManager.isInBattle()== 1 ) {
			Log.i("BOT: ", "In battle");
			try {
			 sleep(1000);
			} catch (InterruptedException e) {
				Log.i("BOT: ","Battle sleep interrupted");
			}
		}
		Log.i("BOT: ", "Battle done ");
		postBattle();
	}
	private void postBattle() {
		Log.i("BOT: ", "Post battle screen");
	}
	
}
