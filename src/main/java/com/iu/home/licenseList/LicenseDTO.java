package com.iu.home.licenseList;

public class LicenseDTO {

	private Long licenseNum;
	private String licenseName;
	private BookDTO bookDTO;
	
	public Long getLicenseNum() {
		return licenseNum;
	}
	public void setLicenseNum(Long licenseNum) {
		this.licenseNum = licenseNum;
	}
	public String getLicenseName() {
		return licenseName;
	}
	public void setLicenseName(String licenseName) {
		this.licenseName = licenseName;
	}
	public BookDTO getBookDTO() {
		return bookDTO;
	}
	public void setBookDTO(BookDTO bookDTO) {
		this.bookDTO = bookDTO;
	}
	
	
}
