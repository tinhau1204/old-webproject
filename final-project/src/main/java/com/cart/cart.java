package com.cart;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    @Column(name = "cid")
    private int cid;
    
    @OneToOne
    private User user;

    @OneToMany(mappedBy = "cart",fetch = FetchType.EAGER)
    private List<Item> items = new ArrayList<Item>();

    public Cart()
    {

    }

    public Cart(int id, User user, List<Item> items)
    {
        this.cid = id;
        this.user = user;
        this.items = items;
    }
    public void setId(int id)
    {
        this.cid = id;
    }
    public int getId()
    {
        return this.cid;
    }

    public void setUser(User user)
    {
        this.user = user;
    }
    public User getUser()
    {
        return this.user;
    }

    public void setItems(List<Item> items)
    {
        this.items = items;
    }
    public List<Item> getItems()
    {
        return this.items;
    }
}
