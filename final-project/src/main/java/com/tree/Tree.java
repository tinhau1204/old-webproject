package com.tree;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tree")
public class Tree implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tid")
    private int tId;
    
    private String treeName;
    private String kind;
    private String brand;
    private String img;
    private String description;
    private Integer price;
    private Integer amount;

    public Tree()
    {

    }

    public Tree(int id, String name, String kind , String brand
    , String img, String description, int price, int amount)
    {
        this.tId = id;
        this.treeName = name;
        this.kind = kind;
        this.brand = brand;
        this.img = img;
        this.description = description;
        this.price = price;
        this.amount = amount;

    }

    public void setTreeid( int treeId)
    {
        this.tId = treeId;
    }
    public int getTreeid()
    {
        return this.tId;
    }

    public void setTreeName(String name)
    {
        this.treeName = name;
    }
    public String getTreeName()
    {
        return this.treeName;
    }

    public void setTreeKind(String kind)
    {
        this.kind = kind;
    }
    public String getTreeKind()
    {
        return this.kind;
    }

    public void setTreeBrand(String brand)
    {
        this.brand = brand;
    }
    public String getTreeBrand()
    {
        return this.brand;
    }

    public void setTreeImg(String img)
    {
        this.img = img;
    }
    public String getTreeImg()
    {
        return this.img;
    }

    public  void setTreeDescription(String description) {
        this.description = description;
    }
    public String getTreeDescription()
    {
        return this.description;
    }

    public void setAmount(int amount)
    {
        this.amount = amount;
    }
    public int getAmount()
    {
        return this.amount;
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
