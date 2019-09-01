package com.mybatis3.domain;

import java.io.Serializable;



public class Student implements Serializable
{
	private static final long serialVersionUID = 1L;
	private Integer studId;
	private String name;
	private String email;
	//自定义类型，注意如何处理
	private PhoneNumber phone;
	private com.mybatis3.domain.Address address;
	
	@Override
	public String toString() {
		return "Student [studId=" + studId + ", name=" + name + ", email=" + email
				+ ", phone=" + (phone==null?null:phone.getAsString()) + ", address=" + address + "]";
	}
	public Student()
	{
	}
	public Student(Integer id)
	{
		this.studId = id;
	}
	public Integer getStudId()
	{
		return studId;
	}
	public void setStudId(Integer id)
	{
		this.studId = id;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public com.mybatis3.domain.Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public PhoneNumber getPhone() {
		return phone;
	}
	public void setPhone(PhoneNumber phone) {
		this.phone = phone;
	}
	
}
