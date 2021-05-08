package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.Screenshooter;

public class TestAllureListeners implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        Screenshooter.makeScreenshotOnFailure();
    }

}
