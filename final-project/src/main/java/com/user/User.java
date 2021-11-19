package com.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



import java.io.Serializable;

@Entity
@Table(name = "login")
public class User implements Serializable{
   

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid")

    private int uid;
    private String email;
    private String pass;
    private int admin;

    public User()
    {
    }

    public User(int uid, String email, String pass)
    {
        super();
        this.uid = uid;
        this.email = email;
        this.pass = pass;
    }

    public void setId(int id) {
		this.uid = id;
	}

    public int getId() {
		return this.uid;
	}

    public void setEmail(String email) {
		this.email =email;
	}

    public String getEmail() {
		return this.email;
	}
    public void setPass(String pass) {
		this.pass =pass;
	}

    public String getPass() {
		return this.pass;
	}

  public void setAdmin(int admin)
  {
    this.admin = admin;
  }
  public int getAdmin()
  {
    return this.admin;
  }
}
