package us.cargosphere.automation.dataload;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Base64;

import javax.xml.bind.DatatypeConverter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import us.cargosphere.automation.BaseStepDefinitions;
import us.cargosphere.automation.TestContext;

public class UsersStepupSteps extends BaseStepDefinitions{
	 public UsersStepupSteps(TestContext context) {
	        super(context);
	    }
	 
	 @Given("^that a Super user with login id \"([^\"]*)\" and email \"([^\"]*)\" created with ratesearch permission$")
	 public void addSuperUserWithRateSearchPermission(String loginId,String emailAddr) throws Throwable {
		 us.cargosphere.automation.services.StepDefinitions stepDefs = new us.cargosphere.automation.services.StepDefinitions(testContext);
		 stepDefs.givenIwantToexecuteService("/api/auth/");
		 stepDefs.i_read_the_json_data_file("json/auth-login.json");
		 stepDefs.i_send_the_json_data_file("login");
		 stepDefs.get_the_access_token();
		 stepDefs.i_hit_the_service_with_token("/api/admin/");
		//JSON parser object to parse read file
	        JSONParser jsonParser = new JSONParser();
	        JSONObject inputJson = null;
	        try (java.io.FileReader reader = new java.io.FileReader(getClass()
		  			.getClassLoader().getResource("json/add-user-rate-search.json").getFile()))
	        {
	            //Read JSON file
	            Object obj = jsonParser.parse(reader);
	            inputJson = (JSONObject) obj;
	            inputJson.replace("loginId", loginId);
	            ((JSONObject)inputJson.get("contactInfo")).replace("email", emailAddr);
	            inputJson.replace("userName",loginId);
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
	        if(inputJson!=null) {
	        	stepDefs.i_read_the_json_data(inputJson.toJSONString());
	        }
		 stepDefs.i_send_the_json_data_file("adduser");
		 stepDefs.whenIvalidateStatusCode();
	 }
	 
	 private static String decode(String encodedString) {
		    return new String(Base64.getUrlDecoder().decode(encodedString));
		}
	 
	 @Given("^that a Super user with login id \"([^\"]*)\" and email \"([^\"]*)\" created with report permission$")
	 public void addSuperUserWithAllReportPermission(String loginId,String emailAddr) throws Throwable {
		 us.cargosphere.automation.services.StepDefinitions stepDefs = new us.cargosphere.automation.services.StepDefinitions(testContext);
		 stepDefs.givenIwantToexecuteService("/api/auth/");
		 stepDefs.i_read_the_json_data_file("json/auth-login.json");
		 stepDefs.i_send_the_json_data_file("login");
		 stepDefs.get_the_access_token();
		 stepDefs.i_hit_the_service_with_token("/api/admin/");
		//JSON parser object to parse read file
	        JSONParser jsonParser = new JSONParser();
	        JSONObject inputJson = null;
	        try (java.io.FileReader reader = new java.io.FileReader(getClass()
		  			.getClassLoader().getResource("json/add-user-all-reports.json").getFile()))
	        {
	            //Read JSON file
	            Object obj = jsonParser.parse(reader);
	            inputJson = (JSONObject) obj;
	            inputJson.replace("loginId", loginId);
	            ((JSONObject)inputJson.get("contactInfo")).replace("email", emailAddr);
	            inputJson.replace("userName",loginId);
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
	        if(inputJson!=null) {
	        	stepDefs.i_read_the_json_data(inputJson.toJSONString());
	        }
		 stepDefs.i_send_the_json_data_file("/users/add");
		 stepDefs.whenIvalidateStatusCode();
	 }
}
