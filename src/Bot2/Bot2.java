package Bot2;

import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class Bot2 extends UiAutomatorTestCase{
	public void testDemo() throws UiObjectNotFoundException {
		getUiDevice().pressHome();
	}
}
