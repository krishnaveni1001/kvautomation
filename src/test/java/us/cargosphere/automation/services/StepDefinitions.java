package us.cargosphere.automation.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import us.cargosphere.automation.managers.*;

import testDataTypes.Environment;
import testDataTypes.CompanyDetails;
import us.cargosphere.automation.BaseStepDefinitions;
import us.cargosphere.automation.CucumberRunner;
import us.cargosphere.automation.TestContext;
import us.cargosphere.automation.util.Flags;

public class StepDefinitions extends BaseStepDefinitions {

	RequestSpecification request;

	Response response = null;

	String responseAsStr = null;

	String accessToken = null;

	public String getAccessToken() {
		return accessToken;
	}

	public StepDefinitions(TestContext context) {
		super(context);
	}

	String json;

	@Given("^I want to execute service (.+)$")
	public void givenIwantToexecuteService(String service) {
		System.out.println("We are going to execute service:" + service);
		RestAssured.baseURI = CucumberRunner.cmd.getOptionValue(Flags.Long.PROTOCOL) + "://"
				+ CucumberRunner.cmd.getOptionValue(Flags.Long.BASE_URL) + service;
		// RestAssured.authentication = RestAssured.digest("dev", "cargosphere");
		request = RestAssured.given().relaxedHTTPSValidation();
	}

	@When("^I validate status code$")
	public void whenIvalidateStatusCode() throws IOException {
		// Capture the resulting status code after submitting the request
		responseAsStr = response.getBody().asString();
		testContext.getScenarioContext().setContext(us.cargosphere.automation.Context.ADD_USER_RESPONSE_JSON,
				responseAsStr);
		response.getBody().prettyPrint();

	}

	@Then("^I validate on bad request$")
	public void badRequest() throws IOException {
		int statusCode = response.getStatusCode();
		Assert.assertEquals(400, statusCode);
	}

	@Then("^it is success$")
	public void itIsSuccess() throws IOException {
		int statusCode = response.getStatusCode();
		Assert.assertEquals(200, statusCode);
	}

	@Then("^it is not success$")
	public void itIsNotSuccess() throws IOException {
		int statusCode = response.getStatusCode();
		Assert.assertEquals(401, statusCode);
	}

	@Given("^I assert on the environments with \"([^\"]*)\" details to endpoint \"([^\"]*)\"$")
	public void i_assert_on_the_environments_with_details_to_endpoint(String arg1, String arg2) throws Throwable {

		Environment customer = FileReaderManager.getInstance().getJsonReader().getCustomerByName(arg1);

		String json_d = FileReaderManager.getInstance().getJsonReader().getJson(customer);
		request.header("Content-Type", "application/json");
		request.body(json_d);
		response = request.post(arg2);
	}

	@When("^I assert on the environments with \"([^\"]*)\" details and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" to endpoint \"([^\"]*)\"$")
	public void i_assert_on_the_environments_with_details_and_and_to_endpoint(String environment, String deploymentType,
			String companyName, String emailAddress, String loginId, String userName, String masterEmailAddress,
			String masterLoginId, String masterUserName, String message, String result, int resultCode, int statusCode,
			String api) throws Throwable {

		Environment customer = FileReaderManager.getInstance().getJsonReader().getCustomerDetails(environment,
				deploymentType, companyName, emailAddress, loginId, userName, masterEmailAddress, masterLoginId,
				masterUserName);

		String json_d = FileReaderManager.getInstance().getJsonReader().getJson(customer);
		request.header("Content-Type", "application/json");
		request.body(json_d);
		response = request.post(api);
		System.out.println(response);

		responseAsStr = response.getBody().asString();
		testContext.getScenarioContext().setContext(us.cargosphere.automation.Context.ADD_USER_RESPONSE_JSON,
				responseAsStr);
		response.getBody().prettyPrint();

		String message_res = response.jsonPath().get("message");
		System.out.println(message_res);
		Assert.assertEquals(message_res, message);

		String res = response.jsonPath().get("result");
		System.out.println(res);
		Assert.assertEquals(res, result);

		int res_code = response.jsonPath().get("resultCode");
		System.out.println(res_code);
		Assert.assertEquals(res_code, resultCode);

		int status_Code = response.getStatusCode();
		System.out.println(status_Code);
		Assert.assertEquals(status_Code, statusCode);
	}

	@When("^I read the json data file \"(.*?)\"$")
	public void i_read_the_json_data_file(String arg1) throws Throwable {
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(arg1);
		InputStreamReader in = new InputStreamReader(inputStream);
		BufferedReader bufferedReader = new BufferedReader(in);
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = bufferedReader.readLine()) != null) {
			sb.append(line);
		}
		json = sb.toString();
		System.out.println(json);
	}

	public void i_read_the_json_data(String arg1) throws Throwable {
		json = arg1;
		System.out.println(json);
	}

	@Then("^I send the json post request to endpoint \"(.*?)\"$")
	public void i_send_the_json_data_file(String endpoint) throws Throwable {
		// Add a header stating the Request body is a JSON
		request.header("Content-Type", "application/json");

		// Add the Json to the body of the request
		request.body(json);
		response = request.post(endpoint);
	}

	@Then("^I do json get request to endpoint \"(.*?)\"$")
	public void i_do_get_request_data_file(String endpoint) throws Throwable {
		// Add a header stating the Request body is a JSON
		request.header("Content-Type", "application/json");

		// Add the Json to the body of the request
		request.body(json);
		response = request.get(endpoint);
	}

	@When("^I verify the result message param \"(.*?)\"$")
	public void i_verify_resultCode(String resultParam) throws Throwable {
		String successCode = response.jsonPath().get(resultParam);
		Assert.assertNotNull(successCode);

	}

	@Then("^I verify the result message param \"([^\"]*)\" value$")
	public void i_verify_the_result_message_param_value(String resultCode) throws Throwable {
		int successCode = response.jsonPath().get(resultCode);
		Assert.assertNotNull(successCode);
	}

	@And("^get the access token$")
	public void get_the_access_token() throws Throwable {
		accessToken = response.jsonPath().get("accessToken");
		testContext.getScenarioContext().setContext(us.cargosphere.automation.Context.AUTH_ACCESS_TOKEN, accessToken);
	}

	@When("I hit the service with token (.+)$")
	public void i_hit_the_service_with_token(String service) throws Throwable {
		System.out.println("We are going to hit service:" + service + " with token:" + accessToken);
		RestAssured.baseURI = CucumberRunner.cmd.getOptionValue(Flags.Long.PROTOCOL) + "://"
				+ CucumberRunner.cmd.getOptionValue(Flags.Long.BASE_URL) + service;
		// RestAssured.authentication = RestAssured.digest("dev", "cargosphere");
		request = RestAssured.given().auth().oauth2(accessToken).relaxedHTTPSValidation();
	}

	@When("I hit the service with \"(.*?)\" token (.+)$")
	public void i_hit_the_service_with_given_token(String token, String service) throws Throwable {
		System.out.println("We are going to hit service:" + service + " with token:" + token);
		RestAssured.baseURI = CucumberRunner.cmd.getOptionValue(Flags.Long.PROTOCOL) + "://"
				+ CucumberRunner.cmd.getOptionValue(Flags.Long.BASE_URL) + service;
		// RestAssured.authentication = RestAssured.digest("dev", "cargosphere");
		request = RestAssured.given().auth().oauth2(token).relaxedHTTPSValidation();
	}

	@After("@deleteUserCreated")
	public void afterScenario() throws ParseException {
		// String responseJSON = response.getBody().asString();
		responseAsStr = (String) testContext.getScenarioContext()
				.getContext(us.cargosphere.automation.Context.ADD_USER_RESPONSE_JSON);
		accessToken = (String) testContext.getScenarioContext()
				.getContext(us.cargosphere.automation.Context.AUTH_ACCESS_TOKEN);
		if (responseAsStr != null) {
			JSONParser parser = new JSONParser();
			JSONObject json = (JSONObject) parser.parse(responseAsStr);
			long resultCode = (Long) json.get("resultCode");
			if (resultCode == 1000) {
				RestAssured.baseURI = CucumberRunner.cmd.getOptionValue(Flags.Long.PROTOCOL) + "://"
						+ CucumberRunner.cmd.getOptionValue(Flags.Long.BASE_URL) + "/api/admin/";
				// RestAssured.authentication = RestAssured.digest("dev", "cargosphere");
				request = RestAssured.given().auth().oauth2(accessToken).relaxedHTTPSValidation();
				// Add a header stating the Request body is a JSON
				request.header("Content-Type", "application/json");
				JSONObject deleteJson = new JSONObject();
				JSONArray jsonArr = new JSONArray();
				jsonArr.add(json.get("data"));
				deleteJson.put("companyId", "1");
				deleteJson.put("userIds", jsonArr);
				// Add the Json to the body of the request
				request.body(deleteJson);
				response = request.post("users/delete");
				response.getBody().prettyPrint();
			}
		}
	}
}
