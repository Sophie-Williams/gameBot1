package Bot2;

import android.os.RemoteException;
import android.util.Log;

import com.Fort.FortManager;
import com.Fort.PreGame;
import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.my.AppHandler.AppHandler;

public class Bot2 extends UiAutomatorTestCase{
	private static UiDevice m_uiDevice ;
	private static int DISPLAY_WIDTH;
	private static int DISPLAY_HEIGHT;
	private static int START_SCREEN = 1;
	private static int START_X = 400;
	private static int START_Y = 360;
	public void testDemo() throws UiObjectNotFoundException {
		
		initSetup();
		AppHandler.beginApp("com.droidhen.fortconquer", "Fort");
		FortManager.begin();
		debug();
		exit();
		//mainFlow();
	}
	private void exit() {
		try{
			m_uiDevice.unfreezeRotation();	
			Log.i("BOT: ", " unfreeze rotation succeeded");

		}catch (RemoteException e){
			Log.i("BOT: ", " unfreeze rotation failed");
		}
	}

	private void initSetup() {
		m_uiDevice = getUiDevice();
		m_uiDevice.pressHome();
		try{
			m_uiDevice.freezeRotation();	
			Log.i("BOT: ", " Freeze rotation succeeded");

		}catch (RemoteException e){
			Log.i("BOT: ", " Freeze rotation failed");
		}
	}
	private void debug() {
		DISPLAY_HEIGHT= m_uiDevice.getDisplayHeight();
		DISPLAY_WIDTH= m_uiDevice.getDisplayWidth();
		Log.i("BOT: ", String.valueOf(DISPLAY_HEIGHT) + " " + String.valueOf(DISPLAY_WIDTH) );
	}
	
	public static UiDevice getDevice() {
		return m_uiDevice;
	}
	private boolean openGame(){
		UiScrollable appViews = new UiScrollable(new UiSelector()
        .scrollable(true));
		appViews.setAsHorizontalList();
		UiObject gameApp;
		
		try {
		gameApp = appViews.getChildByText(new UiSelector()
        .className(android.widget.TextView.class.getName()), 
        "Fort Conquer");
		gameApp.clickAndWaitForNewWindow();
		
		} catch(UiObjectNotFoundException e) {
			Log.i("BOT: ", "Press recent Apps failed due to remote exception");
			return false;
		}
		int c = 10;
		while ( (c--)!=0 ) {
			sleep (5);
			if(m_uiDevice.waitForWindowUpdate(null, 20000)) {
				Log.i("BOT: ", "Wait for window update done " + String.valueOf(c) );
			} else {
				Log.i("BOT: ", "Wait for window update failed "  + String.valueOf(c));
			}
		}
		DISPLAY_HEIGHT= m_uiDevice.getDisplayHeight();
		DISPLAY_WIDTH= m_uiDevice.getDisplayWidth();
		Log.i("BOT: ", String.valueOf(DISPLAY_WIDTH) + " " + String.valueOf(DISPLAY_HEIGHT) );

		if(currentWindowType(START_SCREEN) == START_SCREEN) {
			m_uiDevice.click(400, 360);
			Log.i("BOT: ", "Clicked start" );

			sleep(2000);
			m_uiDevice.click(200, 360);
			Log.i("BOT: ", "Clicked local start" );
			sleep(2000);
			m_uiDevice.click (700, 360);
			Log.i("BOT: ", "Clicked begin battle" );
			sleep(1000);
			return true;
		}
		return false;
	}
	private int currentWindowType(int def){
		return def;
	}
	
	


}
