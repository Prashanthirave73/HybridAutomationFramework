//
//package com.framework.tests;
//
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import com.framework.api.endpoints.UserAPI;
//import com.framework.api.models.CreateUserRequestWithoutLombok;
//import com.framework.base.BaseTest;
//import com.framework.database.OrderRepository;
//import com.framework.database.UserRepository;
//import com.framework.models.CreateUserRequest;
//import com.framework.models.OrderDBModel;
//import com.framework.models.UserDBModel;
//import com.framework.ui.pages.CartPage;
//import com.framework.ui.pages.CheckoutPage;
//import com.framework.ui.pages.HomePage;
//import com.framework.ui.pages.LoginPage;
//import com.framework.ui.pages.ProductPage;
//
//import io.restassured.response.Response;
//
//public class E2EUserOrderFlowTest extends BaseTest {
//
//	@Test public void verifyCompleteUserJourney() {
//  
//  // Step 1 Create User API //
//  String email = "user" + System.currentTimeMillis() + "@test.com";
//  
//  CreateUserRequestWithoutLombok user = new CreateUserRequestWithoutLombok();
//  
//  user.setName("Prashant"); user.setEmail("test@gmail.com");
//  user.setPassword("Test@1133");
//  
//  Response createResponse = userAPI.createUser(user);
//  
//  createResponse.then().statusCode(200);
//  
//  // ---------------------------------- // Step 2 Verify User DB //
//  UserRepository userRepo = new UserRepository();
//  
//  UserDBModel dbUser = userRepo.getUserByEmail(email);
//  
//  Assert.assertEquals(dbUser.getEmail(), email);
//  
//  // ---------------------------------- // Step 3 Login UI //
//  driver.get("https://yourapp.com/login");
//  LoginPage loginPage = new LoginPage(driver);
//  loginPage.login(email, "Test@123");
//  HomePage homePage = new HomePage(driver);
//  
//  Assert.assertTrue(homePage.isUserLoggedIn());
//  
//  // ---------------------------------- // Step 4 Search Product //
//  ProductPage productPage = new ProductPage(driver);
//  
//  productPage.searchProduct("Blue Top");
//  
//  Assert.assertTrue(productPage.isProductDisplayed("Blue Top"));
//  
//  // ---------------------------------- // Step 5 Checkout //
//  
//  productPage.addToCart("Blue Top");
//  
//  CartPage cartPage = new CartPage(driver);
//  
//  cartPage.proceedToCheckout();
//  
//  CheckoutPage checkoutPage = new CheckoutPage(driver);
//  
//  String orderId = checkoutPage.placeOrder();
//  
//  Assert.assertNotNull(orderId);
//  
//  // ---------------------------------- // Step 6 Verify Order DB //
//  
//  OrderRepository orderRepo = new OrderRepository();
//  
//  OrderDBModel dbOrder = orderRepo.getOrderById(orderId);
//  
//  Assert.assertEquals(dbOrder.getOrderId(), orderId);
//  
//  Assert.assertEquals(dbOrder.getUserEmail(), email);
//  
//  // ---------------------------------- // Step 7 Delete User API //
//  Response deleteResponse = userAPI.deleteUser(email, "Test@123");
//  
//  deleteResponse.then().statusCode(200);
//  
//  // ---------------------------------- // Step 8 Verify User Deleted DB //
//  
//  UserDBModel deletedUser = userRepo.getUserByEmail(email);
//  
//  Assert.assertNull(deletedUser.getEmail());
//  
//  System.out.println("E2E Flow Completed Successfully"); }
//}
