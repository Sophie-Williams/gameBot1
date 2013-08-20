package com.my.AppHandler;

import android.util.Log;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;

public class AppHandler {

	public static boolean beginApp (String packageName, String desc) {
		UiScrollable appViews = new UiScrollable(new UiSelector()
        .scrollable(true));
		appViews.setAsHorizontalList();
		UiObject gameApp;
		Log.i("BOT: ", "in appHandler");

		try {
			Log.i("BOT: ", "in appHandler3");
			gameApp = appViews.getChildByText(new UiSelector()
	        .className(android.widget.TextView.class.getName()), 
	        "Fort Conquer");
			Log.i("BOT: ", gameApp.getContentDescription()+ "Launched");
			gameApp.clickAndWaitForNewWindow();
		} catch(UiObjectNotFoundException e) {
			Log.i("BOT: ", "Press recent Apps failed due to remote exception");
			return false;
		}
		return true;
	}
	
}
