package by.ruslan.automation.maven.test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import by.ruslan.automation.maven.project.pandora.PandoraPage;

public class TestImages extends PrepareWebTest {

	private PandoraPage page;

	@BeforeTest
	public void init() {
		page = new PandoraPage(driver);
	}

	@Test
	public void test() throws Exception {
		// String URL = "https://dev-us.pandora.net/en/gifts/gifts-for-daughters/";
		// String URL = "https://dev-us.pandora.net/en/necklaces/view-all";
		// String URL = "https://dev-us.pandora.net/en/charms";
		// String URL = "https://dev-us.pandora.net/en/whats-new-1/";
		String URL = "https://dev-us.pandora.net/en/collections"; // 860
		page.openHomePage(URL);

		int i = 0;
		while (i < 1) {
			page.loadMoreImages();
			i++;
		}

		page.showNoImages();
	}

}
