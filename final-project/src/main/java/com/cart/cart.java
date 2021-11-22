package com.cart;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.item.Item;
import com.user.User;

@Entity
@Table(name = "cart")
public class Cart implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @OneToOne
    private User user;
    @OneToMany(mappedBy = "cart", fetch = FetchType.EAGER)
    private List<Item> items;
    private int amount;
    private String state;
    private Date date;

    public Cart()
    {
        
    }

    public Cart(int id, User user, List<Item>items, int amount
    ,String state, Date date) {
        this.id = id;
        this.user = user;
        this.items = items;
        this.amount = amount;
        this.state = state;
        this.date = date;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return this.id;
    }

    public void setUser(User user) {
        this.user = user;
    }
    public User getUser()
    {
        return this.user;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
    public List<Item> getItems()
    {
        return this.items;
    }

    public void setAmount(int amount)
    {
        this.amount = amount;
    }
    public int getAmount() {
        return this.amount;
    }

    public void setState(String state)
    {
        this.state = state;
    }
    public String getState() {
        return this.state;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }
    public Date getDate()
{
    return this.date;
}
}
