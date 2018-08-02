package com.service;

import com.pojo.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ProductService implements ProductServiceHeader {


    @Override
    public Product edit() {
        return null;
    }

    @Override
    public ArrayList<Product> jquery() {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Product update(int id) {
        return null;
    }

    @Override
    public Product insert(Map<String, Object> map) {
//        HashMap<String,Object> hashMap= (HashMap<String, Object>) map;
        Product product=new Product();
        for (Map.Entry<String, Object> entity : map.entrySet()) {
            if (entity.getKey().equals("id"))
                product.setId(Integer.parseInt(((String[]) entity.getValue())[0]));
            else if (entity.getKey().equals("name"))
                product.setName( ((String[]) entity.getValue())[0]);
            else if (entity.getKey().equals("num"))
                product.setNum(Integer.parseInt(((String[]) entity.getValue())[0]));
            else
                System.out.println("未知参数");
            System.out.println("请求参数：" + entity.getKey()+" 值："+((String[])entity.getValue())[0]);
        }

        product.toString();
        return product;
    }
}
