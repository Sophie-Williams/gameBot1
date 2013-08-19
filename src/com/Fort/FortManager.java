package com.Fort;

import android.util.Log;
import Bot2.Bot2;

public class FortManager {
	private static int WINDOW_UPDATE_TIMEOUT = 20000;
	private static FortManager m_instance;
	private static int START_1_X = 400, START_1_Y = 360;
	private static int START_LOCAL_1_X = 200, START_LOCAL_1_Y = 360;
	private static int START_BATTLE_X = 750, START_BATTLE_Y = 420;
	
	public FortManager(){
		getToStartScreen2();
		boolean local = true;
		if(local) {
			startLocalFight();	
		}else {
			startArenaFight();
		}
		
	}
	public static void begin(){
		m_instance = new FortManager();
	}
	
	
	private boolean getToStartScreen2() {
		int c = 3;
		while((c--)!=0) {
			if(	Bot2.getDevice().waitForWindowUpdate(null, WINDOW_UPDATE_TIMEOUT)){
				Log.i("BOT: ", "Wait for window update done " + String.valueOf(c) );
			}else {
				Log.i("BOT: ", "Wait for window update failed " + String.valueOf(c) );
			}
		}
		Log.i("BOT: ", "At start screen 1" );
		//getting to start screen 2
		Bot2.getDevice().click(START_1_X, START_1_Y);
		if(	Bot2.getDevice().waitForWindowUpdate(null, WINDOW_UPDATE_TIMEOUT)){
			Log.i("BOT: ", "Start screen 2 done " );
		}else {
			Log.i("BOT: ", "Start screen 2 failed ");
		}		return true;
	}
	
	private boolean startLocalFight() {
		//For now assuming that I am already on the screen
		Bot2.getDevice().click(START_LOCAL_1_X, START_LOCAL_1_Y);
		Bot2.getDevice().waitForWindowUpdate(null, WINDOW_UPDATE_TIMEOUT);
		if(	Bot2.getDevice().waitForWindowUpdate(null, WINDOW_UPDATE_TIMEOUT)){
			Log.i("BOT: ", "Unit selection screen done " );
		}else {
			Log.i("BOT: ", "Unit selection screen failed " );
		}		startBattle();
		return true;
	}
	
	private boolean startBattle(){
		Bot2.getDevice().click(START_BATTLE_X, START_BATTLE_Y);
		if(	Bot2.getDevice().waitForWindowUpdate(null, WINDOW_UPDATE_TIMEOUT)){
			Log.i("BOT: ", "Fight screen done " );
		}else {
			Log.i("BOT: ", "Fight screen failed " );
		}
		Bot2.getDevice().dumpWindowHierarchy(null);
		return true;
	}
	private boolean startArenaFight() {
		return true;
	}
}
