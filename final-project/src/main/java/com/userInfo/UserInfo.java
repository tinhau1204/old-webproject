package com.userInfo;

import javax.persistence.Column;
import javax.persistence.Entity;



import javax.persistence.Table;


import java.io.Serializable;

import javax.persistence.Id;

@Entity
@Table(name = "persona")
public class UserInfo implements Serializable
{
  @Id
 
  @Column(name = "uid")
    int uid;
    
  
    private String fName;

    
    private String lName;
    private  String address;

    private String phone;

    public UserInfo()
    {
    }
 

    public UserInfo(int uid,String firstName, String lastName, String address, String phone)
    {
        this.uid = uid;
        this.fName = firstName;
        this.lName = lastName;
        this.address = address;
        this.phone = phone;
    }

    public void setId(int id) {
		this.uid = id;
	}

    public int getId() {
		return this.uid;
	}

    public void setFirstName(String firstName) {
		this.fName = firstName;
	}

    public String getFirstName() {
		return this.fName;
	}

    public void setLastName(String lastName) {
		this.lName = lastName;
	}

    public String getLastName() {
		return this.lName;
	}

    public void setaddress(String address) {
		this.address = address;
	}

    public String getaddress() {
		return this.address;
	}


  public void setPhone(String phone) {
		this.phone = phone;
	}

    public String getPhone() {
		return this.phone;
	}
}