package Stepdefinition;

import java.io.IOException;

import Utilities.TestUtil;
import Utilities.payloadcoverter;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class definition {
	
	public String Loginpayload;
	RequestSpecification reqspec;
	String BaseURI = "https://ecommerceservice.herokuapp.com";
	Response response;
	
	@Given("Login API along with payload")
	public void login_api_along_with_payload() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
	    
		Loginpayload = payloadcoverter.generatepayloadString("login.json");
		System.out.println(Loginpayload);
		
	}
	@When("Execute login with resource {string} and provide me accesstoken")
	public void execute_login_with_resource_and_provide_me_accesstoken(String resourcepath) {
	    // Write code here that turns the phrase above into concrete actions
		reqspec = RestAssured.given().body(Loginpayload);
		reqspec.contentType(ContentType.JSON);
		response = reqspec.post(BaseURI + resourcepath);
		
		
	}
	@Then("executed successfully with status code {int}")
	public void executed_successfully_with_status_code(int statuscode) {
	    // Write code here that turns the phrase above into concrete actions
	    Assert.assertEquals(response.statusCode(), statuscode);
	}
	
	@Then("verify Login message")
	public void verify_login_message() {
	    // Write code here that turns the phrase above into concrete actions
	    String resasstring = TestUtil.getresasstring(response);
	    JsonPath resasjson = TestUtil.jsonparser(resasstring);
	    String accessToken = resasjson.getString("accessToken");
	    //String message = resasjson.get("message");
	    
	    System.out.println("Access token is "+ accessToken);
	    //System.out.println("Message is "+ message);
	    

	    
	    
	}

}
