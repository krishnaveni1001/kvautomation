package testDataTypes;

public class Environment {

	public String clientName;
	public String clientShortName;
	public String environmentType;
	public String deploymentType;
	public CompanyDetails companyDetail;

	@Override
	public String toString() {
		return "Environment [clientName=" + clientName + ", clientShortName=" + clientShortName + ", environmentType="
				+ environmentType + ", deploymentType=" + deploymentType + ", companydetails=" + companyDetail + "]";
	}

}
