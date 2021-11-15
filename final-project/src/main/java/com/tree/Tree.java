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
    private int tId;
    
    private String treeName;
    private String kind;
    private String brand;
    private String img;
    private String description;

    public Tree()
    {

    }

    public Tree(int id, String name, String kind , String brand
    , String img, String description)
    {
        this.tId = id;
        this.treeName = name;
        this.kind = kind;
        this.brand = brand;
        this.img = img;
        this.description = description;
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
    public String getTreeKind(String kind)
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
}
