package com.itranswarp.exchange.ui.web;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.actuate.autoconfigure.wavefront.WavefrontProperties.Application;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import io.restassured.response.ValidatableResponse;

@SpringBootTest(classes = Application.class)
public class MvcControllerTest {
	private final static String BASE_URI = "http://localhost";
	
	@LocalServerPort
	private String port;
	
	MvcController mvcController;
	ValidatableResponse validatableResponse;
	
	@BeforeEach
	public void setUp() {
		RestAssured.baseURI = BASE_URI;
		RestAssured.port = Integer.parseInt(port);
		mvcController = new MvcController();

	}

@Test
public void testSignIn() {
	//mvcController.signIn("MyEmail@gmail.com", "Password1", null, null);
	validatableResponse = given()
				.param("email", "MyEmail@gmail.com")
				.param("password", "Password1")
			.when()
				.post("/signin")
			.then()
				.statusCode(200);
}

}
