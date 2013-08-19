package com.Fort;

import android.util.Log;
import Bot2.Bot2;

public class FortManager {
	private static int WINDOW_UPDATE_TIMEOUT = 20000;
	private static FortManager m_instance;
	private static int START_1_X = 400, START_1_Y = 360;
	public FortManager(){
		getToStartScreen2();
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
		return true;
	}
}
