package com.finaltask.corejavafinaltask.domain;

public class Author {
	private String fName;
	private String lName;
	private String address;
	private String institution;
	private String email;
	private String name;
	private int articleId;
	
	public Author() {
	}
	
	public Author(String fName, String lName, String address, String institution, String email,String name, int articleId) {
		this.fName = fName;
		this.lName = lName;
		this.address = address;
		this.institution = institution;
		this.email = email;
		this.fName = name;
		this.articleId = articleId;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String fname, String lname) {
		this.name = fname.concat(lname);
	}

	public int getArticleId() {
		return articleId;
	}

	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "\nAuthor [\n\tName=" + name+ "\n\t Address=" + address + ", \n\tInstitution=" + institution + ", \n\tEmail=" + email + 
				"]";
	}


	
	
	
	
	
}