package vn.amabuy.models;

import org.apache.commons.lang3.RandomStringUtils;

public class Account {
	
	public static AccountBuilder named(String name) {
		return new AccountBuilder(name);
	}
	
	public static class AccountBuilder{
		
		private String name;
		private String email;
		private String phone;
		private String password;
		private String rePassword;
		
		public AccountBuilder(String name) {
			this.name = name;
		}

		public AccountBuilder withEmail(String email) {
			this.email = email;
			return this;
		}
		

		public AccountBuilder withRandomEmail(String email) {
			this.email = String.format("%s_%s", RandomStringUtils.randomAlphanumeric(10), email);
			return this;
		}

		public AccountBuilder withPhone(String phone) {
			this.phone = phone;
			return this;
		}
		public AccountBuilder withPassword(String password) {
			this.password = password;
			return this;
		}
		
		public AccountBuilder withConfirmPassword(String rePassword) {
			this.rePassword = rePassword;
			return this;
		}

		public Account build() {
			return new Account(name, email, phone, password, rePassword);
		}
	}

	private String fullName;
	private String email;
	private String phone;
	private String password;
	private String rePassword;

	public Account(String fullName, String email, String phone, String password, String rePassword) {
		this.fullName = fullName;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.rePassword = rePassword;
	}

	public String getRePassword() {
		return rePassword;
	}

	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}



}
