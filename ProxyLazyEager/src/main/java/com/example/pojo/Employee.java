package com.example.pojo;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

@Entity
@Table (name = "Employee_Details")
public class Employee {
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int empId;
	
	@Column (name = "User_Name") 
	private String userName;
	
	@ElementCollection(fetch=FetchType.EAGER)
	@JoinTable(name="Employee_Address",
				joinColumns=@JoinColumn(name="Emp_Id")
			)
	private Collection<Address> listOfAddress = new ArrayList<Address>();

	public Collection<Address> getListOfAddress() {
		return listOfAddress;
	}

	public void setListOfAddress(Collection<Address> listOfAddress) {
		this.listOfAddress = listOfAddress;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	
}
