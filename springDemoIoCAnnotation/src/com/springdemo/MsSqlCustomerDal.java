package com.springdemo;

import org.springframework.beans.factory.annotation.Value;

public class MsSqlCustomerDal implements ICustomerDal{
	
	@Value("${local.email}")
	String connectionString;

	public String getConnectionString() {
		return connectionString;
	}

	public void setConnectionString(String connectionString) {
		this.connectionString = connectionString;
	}
	
	@Override
	public void add() {
		System.out.println("System Connection : " + connectionString);

		System.out.println("Ms Sql Veri Tabanina Eklendi");
	}

}
