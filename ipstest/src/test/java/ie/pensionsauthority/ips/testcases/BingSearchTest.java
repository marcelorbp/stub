package ie.pensionsauthority.ips.testcases;


import org.testng.annotations.Test;

import ie.pensionsauthority.page.functions.BingHomepageFunctions;

public class BingSearchTest extends BingBaseTest{

	@Test(testName = "Search on bing1", description = "This test case performs a bing search", groups = {"P0" })
	public void search1() {
		BingHomepageFunctions bing = new BingHomepageFunctions(app.get());
		bing.populateSearchField("search1");
		bing.clickSearchButton();
	}
	
	@Test(testName = "Search on bing2", description = "This test case performs a bing search", groups = {"P0" })
	public void search2() {
 		BingHomepageFunctions bing = new BingHomepageFunctions(app.get());
		bing.populateSearchField("search2");
		bing.clickSearchButton();
	}
	
	@Test(testName = "Search on bing3", description = "This test case performs a bing search", groups = {"P0" })
	public void search3() {
 		BingHomepageFunctions bing = new BingHomepageFunctions(app.get());
		bing.populateSearchField("search3");
		bing.clickSearchButton();
	}
	
	@Test(testName = "Search on bing4", description = "This test case performs a bing search", groups = {"P0" })
	public void search4() {
 		BingHomepageFunctions bing = new BingHomepageFunctions(app.get());
		bing.populateSearchField("search4");
		bing.clickSearchButton();
	}
	
	@Test(testName = "Search on bing5", description = "This test case performs a bing search", groups = {"P0" })
	public void search5() {
 		BingHomepageFunctions bing = new BingHomepageFunctions(app.get());
		bing.populateSearchField("search5");
		bing.clickSearchButton();
	}
	
	@Test(testName = "Search on bing6", description = "This test case performs a bing search", groups = {"P0" })
	public void search6() {
 		BingHomepageFunctions bing = new BingHomepageFunctions(app.get());
		bing.populateSearchField("search6");
		bing.clickSearchButton();
	}
	
	@Test(testName = "Search on bing7", description = "This test case performs a bing search", groups = {"P0" })
	public void search7() {
 		BingHomepageFunctions bing = new BingHomepageFunctions(app.get());
		bing.populateSearchField("search7");
		bing.clickSearchButton();
	}
	
	@Test(testName = "Search on bing8", description = "This test case performs a bing search", groups = {"P0" })
	public void search8() {
 		BingHomepageFunctions bing = new BingHomepageFunctions(app.get());
		bing.populateSearchField("search8");
		bing.clickSearchButton();
	}
	
	@Test(testName = "Search on bing9", description = "This test case performs a bing search", groups = {"P0" })
	public void search9() {
 		BingHomepageFunctions bing = new BingHomepageFunctions(app.get());
		bing.populateSearchField("search9");
		bing.clickSearchButton();
	}
	
	@Test(testName = "Search on bing10", description = "This test case performs a bing search", groups = {"P0" })
	public void search10() {
 		BingHomepageFunctions bing = new BingHomepageFunctions(app.get());
		bing.populateSearchField("search10");
		bing.clickSearchButton();
	}
	
}
