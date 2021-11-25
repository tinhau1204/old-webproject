package com.item;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.sql.Timestamp;

import com.cart.Cart;
import com.tree.Tree;
@Entity
@Table(name = "item")
public class Item implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iid")
    private int iid;
    private int quality;
    private int price;
    private String state;
    private Timestamp dayPaid;

    @OneToOne
    private Tree tree;

    @ManyToOne
    private Cart cart;

    public Item()
    {
        
    }

    public Item(int id, int quality, Tree tree, int price
    ,String state, Timestamp dayPaid)
    {
        this.iid = id;
        this.quality = quality;
        this.tree = tree;
        this.price = price;
        this.state = state;
        this.dayPaid = dayPaid;
    }
    public void setId(int id)
    {
        this.iid = id;
    }
    public int getId()
    {
        return this.iid;
    }

    public void setQuality(int quality)
    {
        this.quality = quality;
    }
    public int getQuality()
    {
        return this.quality;
    }

    public void setTree(Tree tree)
    {
        this.tree = tree;
    }
    public Tree getTree()
    {
        return this.tree;
    }

    public void setPrice(int price)
    {
        this.price = price;
    }
    public int getPrice()
    {
        return this.price;
    }

    public void setState(String state)
    {
        this.state = state;
    }
    public String getState()
    {
        return this.state; 
    }

    public void setDayPaid(Timestamp daypaid)
    {
        this.dayPaid = daypaid;
    }
    public Timestamp getDayPaid()
    {
        return this.dayPaid;
    }

    public void setCart(Cart cart)
    {
        this.cart = cart;
    }
    public Cart getCart()
    {
        return this.cart;
    }
}
