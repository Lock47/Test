package com.logistics.model;

import java.util.Date;

public class ContractInfo {
	private int contract_id;
	private String contract_name;
	private int contract_money;
	private int customer_id;
	private String contract_customer;
	private String contract_carrier;
	private String contract_customertel;
	private String contract_carriertel;
	private String contract_signdate;
	private String contract_duedate;
	private String contract_content;

	public int getContract_id() {
		return contract_id;
	}

	public void setContract_id(int contractId) {
		contract_id = contractId;
	}

	public String getContract_name() {
		return contract_name;
	}

	public void setContract_name(String contractName) {
		contract_name = contractName;
	}

	public int getContract_money() {
		return contract_money;
	}

	public void setContract_money(int contractMoney) {
		contract_money = contractMoney;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customerId) {
		customer_id = customerId;
	}

	public String getContract_customer() {
		return contract_customer;
	}

	public void setContract_customer(String contractCustomer) {
		contract_customer = contractCustomer;
	}

	public String getContract_carrier() {
		return contract_carrier;
	}

	public void setContract_carrier(String contractCarrier) {
		contract_carrier = contractCarrier;
	}

	public String getContract_customertel() {
		return contract_customertel;
	}

	public void setContract_customertel(String contractCustomertel) {
		contract_customertel = contractCustomertel;
	}

	public String getContract_carriertel() {
		return contract_carriertel;
	}

	public void setContract_carriertel(String contractCarriertel) {
		contract_carriertel = contractCarriertel;
	}

	public String getContract_signdate() {
		return contract_signdate;
	}

	public void setContract_signdate(String contractSigndate) {
		contract_signdate = contractSigndate;
	}

	public String getContract_duedate() {
		return contract_duedate;
	}

	public void setContract_duedate(String contractDuedate) {
		contract_duedate = contractDuedate;
	}

	public String getContract_content() {
		return contract_content;
	}

	public void setContract_content(String contractContent) {
		contract_content = contractContent;
	}

}
