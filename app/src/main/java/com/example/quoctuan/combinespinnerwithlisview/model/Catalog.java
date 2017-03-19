package com.example.quoctuan.combinespinnerwithlisview.model;


import java.util.ArrayList;

public class Catalog extends Goods{
    private ArrayList<Product> listProduct=null;
    public Catalog(String id,String name){
        super(id,name);
        this.listProduct=new ArrayList<Product>();
    }
    public Catalog(){
        super();
        this.listProduct=new ArrayList<Product>();
    }
//    kiểm tra xem sản phẩm có trong danh mục chưa
    public  boolean isDuplicate(Product p){
        for (Product p1:listProduct){
            if (p1.getId().trim().equalsIgnoreCase(p.getId().trim()));
            return true;
        }
        return false;
    }
//    Thêm 1 sản phẩm vào danh mục
    public boolean addProduct(Product p){
        boolean isDup=isDuplicate(p);
        if (!isDup)
        {
            p.setList(this);
            return listProduct.add(p);
        }
        return !isDup;
    }
    public ArrayList<Product>getListProduct(){
        return this.listProduct;
    }
    public int size(){
        return listProduct.size();
    }
    public Product get(int i){
        return listProduct.get(i);
    }
}
