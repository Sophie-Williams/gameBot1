package com.Fort;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class PreGame extends UiAutomatorTestCase {
	private static int LOCAL_X = 0;
	private static int LOCAL_Y = 0;
	private static PreGame m_instance;
	private static UiDevice m_uiDevice;
	PreGame(){
		m_uiDevice = getUiDevice();
	}
	
	public static PreGame getInstance(){
		if(m_instance== null) {
			m_instance = new PreGame();
		}
		return m_instance;
	}
	
	public boolean initiateLocalGame() {
		getUiDevice().click(200, 360);
		sleep(5000);
		return true;
	}
}
