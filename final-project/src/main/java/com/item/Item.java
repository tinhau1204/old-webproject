package com.item;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
    @Column(name = "id")
    private int id;
    private int quality;
    private int amount;
    private String state;
    private Timestamp dayPaid;

    @OneToOne
    private Tree tree;

    @ManyToOne
    private Cart cart;

    public Item()
    {
        
    }

    public Item(int id, int quality, Tree tree, int amount
    ,String state, Timestamp dayPaid)
    {
        this.id = id;
        this.quality = quality;
        this.tree = tree;
        this.amount = amount;
        this.state = state;
        this.dayPaid = dayPaid;
    }
    public void setId(int id)
    {
        this.id = id;
    }
    public int getId()
    {
        return this.id;
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

    public void setPrice(int amount)
    {
        this.amount = amount;
    }
    public int getPrice()
    {
        return this.amount;
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
