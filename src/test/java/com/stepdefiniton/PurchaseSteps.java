package com.stepdefiniton;

import org.junit.Assert;

import com.factory.DriverFactory;
import com.pages.CheckOut;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.ProductPage;
import com.pages.SearchPage;
import com.pages.ShoppingCart;
import com.util.Constants;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PurchaseSteps {

	HomePage homePage = new HomePage(DriverFactory.getDriver());
	SearchPage searchPage = new SearchPage(DriverFactory.getDriver());
	ProductPage productPage = new ProductPage(DriverFactory.getDriver());
	ShoppingCart shoppingCart = new ShoppingCart(DriverFactory.getDriver());
	LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	CheckOut checkOut = new CheckOut(DriverFactory.getDriver());

	@Given("User search the product {string}")
	public void user_search_the_product(String product) {

		homePage.doSearch(product);

	}

	@When("User select the product")
	public void user_select_the_product() {

		searchPage.doSelectProduct();

	}

	@When("Navigate to add to cart")
	public void click_add_to_cart() {

		productPage.doAddToCart();

	}

	@Then("Validate the product")
	public void validate_the_product() {

		String verify = shoppingCart.doVerify();
		Assert.assertEquals(Constants.productName, verify);

	}

	@When("User proceed to checkout")
	public void click_proceed_to_checkout() {

		shoppingCart.doCheckOut();

	}

	@When("User logon {string},{string}")
	public void user_logon(String username, String password) {
		loginPage.doLogin(username, password);

	}

	@When("slect Address")
	public void slect_address() {

		checkOut.doAddress();

	}

	@When("select Payment Options")
	public void select_payment_options() {

		checkOut.doPayment();

	}

	@Then("Make sure that Product is Cancel")
	public void make_sure_that_product_is_cancel() {

		shoppingCart.doCancel();
		String doVerify = shoppingCart.emptyCart();
		System.out.println(doVerify);
		Assert.assertEquals(Constants.empty, doVerify);

	}

}
