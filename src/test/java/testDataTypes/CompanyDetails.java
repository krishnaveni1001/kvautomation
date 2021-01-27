package testDataTypes;

public class CompanyDetails {
	public String companyName;
	public String emailAddress;
	public String loginId;
	public String masterEmailAddress;
	public String masterLoginId;
	public String masterUserName;
	public String userName;

	public CompanyDetails() {
	}

	@Override
	public String toString() {
		return "CompanyDetails [companyName=" + companyName + ", emailAddress=" + emailAddress + ", loginId=" + loginId
				+ ", masterEmailAddress=" + masterEmailAddress + ", masterLoginId=" + masterLoginId
				+ ", masterUserName=" + masterUserName + ", userName=" + userName + "]";
	}

}