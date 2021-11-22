package com.item;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.tree.Tree;
@Entity
@Table(name = "item")
public class Item implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    private int quality;
    private int price;

    @OneToOne
    private Tree tree;

    

    public Item()
    {
        
    }

    public Item(int id, int quality, Tree tree, int price)
    {
        this.id = id;
        this.quality = quality;
        this.tree = tree;
        this.price = price;
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

    public void setPrice(int price)
    {
        this.price = price;
    }
    public int getPrice()
    {
        return this.price;
    }
}
