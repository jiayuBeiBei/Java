package com.service;

import com.pojo.Product;

import java.util.ArrayList;
import java.util.Map;

public interface ProductServiceHeader {
    public Product edit();
    public ArrayList<Product> jquery();
    public void delete(int id);
    public Product update(int id);
    public Product insert(Map<String,Object> map);

}
