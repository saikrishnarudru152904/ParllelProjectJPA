package com.cg.test;
import static org.junit.Assert.*;

import org.junit.Test;

import com.cg.beans.Account;
import com.cg.exception.AccountException;
import com.cg.service.AccountService;
import com.cg.service.AccountServiceImpl;

public class AccountTest { 

	private AccountService service= new AccountServiceImpl();
	
	@Test
	public void testCreateAccountForMobile() {
	Account ac = new Account();
	ac.setMobile_no("9999");
	ac.setCustomer_name("Ramesh");
	ac.setEmail_id("ramesh@gmail.com");
	ac.setBalance(200.0);
	try {
	service.createAccount(ac);
	} catch (AccountException e) {
	assertEquals("Mobile number should contain 10 digits", e.getMessage());
	}
	}
	 
	@Test
	public void testCreateAccountForName() {
	Account ac = new Account();
	ac.setMobile_no("9999999999");
	ac.setCustomer_name("ravi123");
	ac.setEmail_id("ravi@gmail.com");
	ac.setBalance(500.0);
	try {
	service.createAccount(ac);
	} catch (AccountException e) {
	assertEquals("Name should start with Capital letter and should contain only alphabets", e.getMessage());
	}
	}
	@Test
	public void testCreateAccountForName1() {
	Account ac1 = new Account();
	ac1.setMobile_no("9999999999");
	ac1.setCustomer_name("Ravi1");
	ac1.setEmail_id("ravi@gmail.com");
	ac1.setBalance(500.0);
	try {
	service.createAccount(ac1);
	} catch (AccountException e) {
	assertEquals("Name should start with Capital letter and should contain only alphabets", e.getMessage());
	}
	}
	 
	@Test
	public void testCreateAccountForNameIsEmpty() {
	Account ac = new Account();
	ac.setMobile_no("9999999999");
	ac.setCustomer_name("");
	ac.setEmail_id("deepak@gmail.com");
	ac.setBalance(200.0);
	try {
	service.createAccount(ac);
	} catch (AccountException e) {
	assertEquals("Name cannot be empty", e.getMessage());
	}
	}	 
	@Test
	public void testCreateAccountForEmailId() {
	Account ac = new Account();
	ac.setMobile_no("9999999999");
	ac.setCustomer_name("Ramesh");
	ac.setEmail_id("ramesh@@23gmail.com");
	ac.setBalance(200.0);
	try {
	service.createAccount(ac);
	} catch (AccountException e) {
	assertEquals("Enter a valid EmailID", e.getMessage());
	}
	}
	
	 
	@Test
	public void testShowBalanceForMobileNo() {
	try {
	service.showBalance("95059");
	} catch (AccountException e) {
	assertEquals("Mobile number should contain 10 digits",e.getMessage());
	}
	}
	
	@Test
	public void testDepositForMobileNo() {
	Account ac=new Account();
	ac.setMobile_no("95059345");
	try {
	service.deposit(ac.getMobile_no(), 230);
	} catch (AccountException e) {
	assertEquals("Mobile number should contain 10 digits",e.getMessage());
	}
	}
	
	
	
	
	 
	@Test
	public void testFundTransferForMobileNo() {
	Account ac=new Account();
	Account ac2=new Account();
	ac.setMobile_no("95059345");
	ac2.setMobile_no("1234");
	try {
	service.fundTransfer(ac.getMobile_no(),ac2.getMobile_no(), 230);
	} catch (AccountException e) {
	assertEquals("Mobile number should contain 10 digits",e.getMessage());
	}
	}

	
	
	@Test
	public void testPrinttransactionDetailsForMobile() {
		Account ac=new Account();
		ac.setMobile_no("950593");
		try {
		Account acc=service.printTransactionDetails(ac.getMobile_no());
		} catch (AccountException e) {
		assertEquals("Mobile number should contain 10 digits",e.getMessage());
		}
	}
	
	
	
	@Test
	public void testFundTransferForFirstMobile() {
	Account ac=new Account();
	Account ac2=new Account();
	ac.setMobile_no("950592");
	ac2.setMobile_no("9848468242");
	try {
		service.fundTransfer(ac.getMobile_no(),ac2.getMobile_no(),230);
	} catch (AccountException e) {
		assertEquals("Mobile number should contain 10 digits",e.getMessage());
	}
	}
	
	@Test
	public void testFundTransferForSecondMobile() {
	Account ac=new Account();
	Account ac2=new Account();
	ac.setMobile_no("9999999999");
	ac2.setMobile_no("9848");
	try {
		service.fundTransfer(ac.getMobile_no(),ac2.getMobile_no(),230);
	} catch (AccountException e) {
		assertEquals("Mobile number should contain 10 digits",e.getMessage());
	}
	}
}
