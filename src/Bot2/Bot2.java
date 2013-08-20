package Bot2;

import android.os.RemoteException;
import android.util.Log;

import com.Fort.FortManager;
import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.my.AppHandler.AppHandler;

public class Bot2 extends UiAutomatorTestCase{
	private static UiDevice m_uiDevice ;
	private static int DISPLAY_WIDTH;
	private static int DISPLAY_HEIGHT;
	public void testDemo() throws UiObjectNotFoundException {
		
		initSetup();
		//debug();
		AppHandler.beginApp("com.droidhen.fortconquer", "Fort");
		//debug();
	    FortManager.begin();
		exit();
	}
	
	private void exit() {
		try{
			m_uiDevice.unfreezeRotation();	
			Log.i("BOT: ", " unfreeze rotation succeeded");

		}catch (RemoteException e){
			Log.i("BOT: ", " unfreeze rotation failed");
		}
		m_uiDevice.pressBack();
		m_uiDevice.pressBack();
		m_uiDevice.pressBack();
		m_uiDevice.pressBack();
	}

	private void initSetup() {
		m_uiDevice = getUiDevice();
		//m_uiDevice.pressHome();
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
		getDevice().swipe(275, 540, 300 ,350, 100);
		getDevice().swipe(300, 300, 420, 760, 100);
		getDevice().swipe(300, 300, 420, 770,  100);
		getDevice().swipe(300, 300, 420, 780, 100);
	}
	
	public static UiDevice getDevice() {
		return m_uiDevice;
	}

}
