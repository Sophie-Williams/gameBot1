package com.Fort;

import android.util.Log;
import Bot2.Bot2;

public class FortManager {
	private static int WINDOW_UPDATE_TIMEOUT = 5000;
	private static FortManager m_instance;
	private static int START_1_X = 400, START_1_Y = 360;
	private static int START_LOCAL_1_X = 200, START_LOCAL_1_Y = 360;
	private static int START_BATTLE_X = 750, START_BATTLE_Y = 420;
	private static int RETRY_X = 582, RETRY_Y = 353;
	private static int inBattle = 0;
	
	public FortManager(){
		getToStartScreen2();
		boolean local = true;
		if(local) {
			startLocalFight();	
		}else {
			startArenaFight();
		}

		for(int i = 0 ; i < 10 ; i ++ ) {
			Log.i("BOT: ", "Round " + String.valueOf(i));
			startBattle();
			doBattle();
			postBattle();	
		}
		
	}
	
	private void postBattle() {
		Log.i("BOT: ", "On battle end screen");
		Bot2.getDevice().click(RETRY_X, RETRY_Y);
		if(	Bot2.getDevice().waitForWindowUpdate(null, WINDOW_UPDATE_TIMEOUT*2)){
			Log.i("BOT: ", "Retry 2 done " );
		}else {
			Log.i("BOT: ", "Retry 2 failed ");
		}
	}
	public static void begin(){
		Log.i("BOT: ", "FortManager begin()");
		m_instance = new FortManager();
	}
	
	public static FortManager getInstance() {
		return m_instance;
	}
	
	private void doBattle() {
		inBattle = 1;
		Log.i("BOT: ", "On battle screen");
		new BattleManager("BATTLE").start();
		Log.i("BOT: ", "On battle screen After Spawning Thread");

		if(	Bot2.getDevice().waitForWindowUpdate(null, WINDOW_UPDATE_TIMEOUT*18)){
			Log.i("BOT: ", "Battle done ");
		}else {
			Log.i("BOT: ", " Battle failed " );
		}
		inBattle = 0;
		try{
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			Log.i("BOT: ","Post Battle sleep interrupted");
		}
	}
	
	public static int isInBattle() {
		return inBattle;
	}
	
	private boolean getToStartScreen2() {
		int c = 3;
		Log.i("BOT: ", "FortManager beginning");
		while((c--)!=0) {
			if(	Bot2.getDevice().waitForWindowUpdate(null, WINDOW_UPDATE_TIMEOUT*4)){
				Log.i("BOT: ", "Wait for window update done " + String.valueOf(c) );
			}else {
				Log.i("BOT: ", "Wait for window update failed " + String.valueOf(c) );
			}
		}
		Log.i("BOT: ", "At start screen 1 [ one that has Rate, more and start ]" );
		//getting to start screen 2
		Bot2.getDevice().click(START_1_X, START_1_Y);
		if(	Bot2.getDevice().waitForWindowUpdate(null, WINDOW_UPDATE_TIMEOUT*2)){
			Log.i("BOT: ", "got to screen 2 done " );
		}else {
			Log.i("BOT: ", "got to screen 2 failed ");
		}
		/*try {
			UiObject screenData = new UiObject(new UiSelector().className("android.webkit.WebView"));
			Log.i("BOT: ", screenData.getPackageName());
		} catch (UiObjectNotFoundException e) {
			Log.i("BOT: ", "No webview found");
		}*/
		
		return true;
	}
	
	private boolean startLocalFight() {
		//For now assuming that I am already on the screen
    Log.i("BOT: ", "At Start Local Fight [ One where I can select the Local or Arena ]");
		Bot2.getDevice().click(START_LOCAL_1_X, START_LOCAL_1_Y);
		if(	Bot2.getDevice().waitForWindowUpdate(null, WINDOW_UPDATE_TIMEOUT)){
			Log.i("BOT: ", "Arrived at Unit selection screen done " );
		}else {
			Log.i("BOT: ", "Arrived at Unit selection screen failed " );
		}		
		return true;
	}
	
	private boolean startBattle(){
		Bot2.getDevice().click(START_BATTLE_X, START_BATTLE_Y);
		if(	Bot2.getDevice().waitForWindowUpdate(null, WINDOW_UPDATE_TIMEOUT)){
			Log.i("BOT: ", "On Fight screen done " );
		}else {
			Log.i("BOT: ", "On Fight screen failed " );
		}
		return true;
	}
	private boolean startArenaFight() {
		return true;
	}
}
