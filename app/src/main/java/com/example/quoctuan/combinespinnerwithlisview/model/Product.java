package com.example.quoctuan.combinespinnerwithlisview.model;


public class Product extends Goods{
    private Catalog list;

    public Product() {
    }

    public Product(Catalog list) {
        this.list = list;
    }

    public Product(String id, String name, Catalog list) {
        super(id, name);
        this.list = list;
    }

    public Catalog getList() {
        return list;
    }

    public void setList(Catalog list) {
        this.list = list;
    }
}
