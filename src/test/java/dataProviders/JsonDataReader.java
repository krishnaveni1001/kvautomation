package dataProviders;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;

import com.google.gson.Gson;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import us.cargosphere.automation.managers.*;

import testDataTypes.Environment;
import testDataTypes.CompanyDetails;

public class JsonDataReader {

	String json_d;
	private final String customerFilePath = FileReaderManager.getInstance().getConfigReader().getTestDataResourcePath()
			+ "create-env-parameters.json";
	private List<Environment> envList;

	public JsonDataReader() {
		envList = getCustomerData();

	}

	private List<Environment> getCustomerData() {
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(customerFilePath));
			Environment[] customers = gson.fromJson(bufferReader, Environment[].class);

			return Arrays.asList(customers);
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Json file not found at path : " + customerFilePath);
		} finally {
			try {
				if (bufferReader != null)
					bufferReader.close();
			} catch (IOException ignore) {
			}
		}
	}

	public final Environment getCustomerByName(String customerName) {
		for (Environment customer : envList) {

			if (customer.environmentType.equals(customerName))
				return customer;
			// if(customer.environment.equalsIgnoreCase(customerName)) return customer;

		}
		return null;
	}

	// environment,deploymentType,companyName,emailAddress,loginId,userName,masterEmailAddress,
	// masterLoginId,masterUserName
	public final Environment getCustomerDetails(String environment, String deploymentType, String companyName,
			String emailAddress, String loginId, String userName, String masterEmailAddress, String masterLoginId,
			String masterUserName) {
		for (Environment customer : envList) {

			if ((customer.companyDetail.companyName.equals(companyName))
					&& (customer.environmentType.equals(environment))
					&& (customer.deploymentType.equals(deploymentType))
					&& (customer.companyDetail.emailAddress.equals(emailAddress))
					&& (customer.companyDetail.loginId.equals(loginId))
					&& (customer.companyDetail.userName.equals(userName))
					&& (customer.companyDetail.masterEmailAddress.equals(masterEmailAddress))
					&& (customer.companyDetail.masterLoginId.equals(masterLoginId))
					&& (customer.companyDetail.masterLoginId.equals(masterUserName)))
				return customer;

		}
		return null;

	}

	public String getJson(Environment customer) {
		Gson gson = new Gson();
		json_d = gson.toJson(customer);
		System.out.println(json_d);
		return json_d;

	}

}
