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
		// String URL = "https://dev-us.pandora.net/en/necklaces/"; //262
		// String URL = "https://dev-us.pandora.net/en/charms/"; //1057
		// String URL = "https://dev-us.pandora.net/en/bracelets/"; //121
		// String URL = "https://dev-us.pandora.net/en/rings/"; //248
		// String URL = "https://dev-us.pandora.net/en/earrings/"; //168
		// String URL = "https://dev-us.pandora.net/en/collections/"; // 933
		// String URL = "https://dev-us.pandora.net/en/whats-new/"; //97
		String URL = "https://dev-us.pandora.net/en/sale/"; // 151
		page.openHomePage(URL);

		int i = 0;
		while (i < 5) {
			System.out.println("scroll " + i);
			page.loadMoreImages();
			i++;
		}

		page.showNoImages();
	}

}
