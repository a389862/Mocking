import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;

public class LearnMocking {
	
	@BeforeMethod
	public void setUpStub() {
		//Creating stub
		stubFor(get(urlEqualTo("/api/issues"))
				.willReturn(aResponse()
						//.withHeader("Content-Type", "application/json")
						.withStatus(200)
						//.withBody("{\"desc\":\"good\"}")
						.withBody("good")
						));

	}
	
	@Test
	public void runGetMethod() {
		RestAssured.baseURI ="http://localhost:9999/api/table/issues";
		Response response = RestAssured.get();
		response.prettyPrint();
		
		
		

	}

}
