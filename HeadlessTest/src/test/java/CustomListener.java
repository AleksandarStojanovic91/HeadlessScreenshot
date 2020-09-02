import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomListener extends Base implements ITestListener {
    public void onTestFailure(ITestResult result) {
        takeScreenshot(result.getMethod().getMethodName());
    }
}