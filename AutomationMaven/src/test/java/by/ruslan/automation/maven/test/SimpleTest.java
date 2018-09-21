package by.ruslan.automation.maven.test;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import by.ruslan.automation.maven.entity.Data;
import by.ruslan.automation.maven.project.cbg.CBGpage;
import by.ruslan.automation.maven.utilities.Manager;


//@Listeners(by.ruslan.automation.maven.utilities.TestsListener.class)

public class SimpleTest extends PrepareWebTest {

	private CBGpage cbgPage;

	@BeforeMethod
	public void setUp() throws InterruptedException {
		cbgPage = new CBGpage(driver);
		cbgPage.openHomeURL();
		// Reporter.log("Home url is opened"); //better to use Log4j

		cbgPage.sleep(100);

	}

	@AfterMethod(groups = { "cbg", "stock" })
	public void clean() {
		cbgPage.cleanPage();
		// Reporter.log("Cookies cleaned");
	}

	@Test(priority = 0, dataProvider = "dataId", dataProviderClass = Data.class, groups = { "cbg" }) // retryAnalyzer =
																										// TryAgain.class)
	public void test1(String searchId) throws Exception {

		String expectedPage = "CBGs list";

		cbgPage.search(searchId);

		Manager.takeSnapShot(searchId.concat(".png"));

		cbgPage.sleep(500);

		//System.out.println("Response with " + cbgPage.getRows() + " rows");

		checkPageTitle(expectedPage);

		// cbgPage.clickOn(2);
	}

	@Parameters({ "number-of-times" })
	@Test(priority = 1, groups = { "cbg", "stock" })
	public void testStock(int numberOfTimes) throws InterruptedException {

		String expectedPage = "CBG Stock";

		while (numberOfTimes-- > 0) {

			cbgPage.goToStock();

			cbgPage.sleep(100);

			checkPageTitle(expectedPage);

			//System.out.println("run --> " + numberOfTimes);

			cbgPage.goBack();

		}
	}

	@Test(priority = 2, groups = { "cbg", "stock" })
	public void testLensStock() throws InterruptedException {

		String expectedPage = "Lenses Stock";

		cbgPage.goToLensStock();

		cbgPage.sleep(1000);

		checkPageTitle(expectedPage);

	}

	private void checkPageTitle(String expectedPage) {
		assertTrue(cbgPage.getTitle().contains(expectedPage), "expectedPage doesn't contain " + expectedPage);
	}

}
