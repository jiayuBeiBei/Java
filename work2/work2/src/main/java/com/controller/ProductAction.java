package com.controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.pojo.Product;
import com.service.ProductService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ProductAction extends ActionSupport {
    int productId=-1;
    int flag=0;
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    ProductService productService=new ProductService();
	private ActionContext actionContext=ActionContext.getContext();
	private Product product;
	private ArrayList<Product> productList;
//	=(ArrayList<Product>) getProductList();
//	(ArrayList<Product>)actionContext.getApplication().get("productlist");
	public ActionContext getActionContext() {
		return actionContext;
	}

	public void setActionContext(ActionContext actionContext) {
		this.actionContext = actionContext;
	}

	// 编辑商品
	public String edit() {

		System.out.println("编辑商品");
		// ...省略一些编辑商品的业务+ product.toString()
        getScopeProductList();
        if (flag==0)
        {
            for (Product p: productList)
            {
                if ((p.getId())==productId)
                {
                    productList.remove(p);
                    break;
                }
            }
            setScopeProductList();
            flag=1;
          return   this.listPageToEditPage();
        }else if (flag==1){
            flag=0;
            Map<String,Object> map=ActionContext.getContext().getParameters();
           Product product=productService.insert(map);
            this.getScopeProductList();
            productList.add(product);
//            productId=product.getId();
            System.out.println(productList.toString());
            this.setScopeProductList();
        }
		return "edit";
	}


	public String listPageToEditPage(){
	    return "editPage";
    }

	// 删除商品
	public String del() {
		System.out.println("删除商品" );
		// ...省略一些删除商品的业务 + product.toString()
        getScopeProductList();
        for (Product p: productList
             ) {

            if ((p.getId())==productId)
            {
                productList.remove(p);
                break;
            }
        }
        System.out.println(productList.toString());
        setScopeProductList();
		return "del";
	}

	public String insert() {
		System.out.println("添加商品" );
		// ...省略一些删除商品的业务+ product.toString()
		return "insert";
	}

	public String insertReturn(){
        Map<String,Object> map=ActionContext.getContext().getParameters();
//		Map<String,Object> map= actionContext.getContextMap().getgetParameters();
		Product product=productService.insert(map);
		this.getScopeProductList();
		productList.add(product);
		this.setScopeProductList();
		return "productList";
	}
	public String jquery()
	{
//		System.out.println("查询商品" + product.toString());
		// ...省略一些删除商品的业务
		actionContext.getApplication().get(productList);
        System.out.println("jquery");
		return "jquery";
	}
	
	public ArrayList<Product> getProductList() {
		return (ArrayList<Product>) actionContext.getApplication().get("productList");

	}

	public void setScopeProductList() {
//		this.product= product;
//		productList=new ArrayList<Product>();
		actionContext.getApplication().put("productList",productList);
	}
	public ArrayList<Product> getScopeProductList() {
//		this.product= product;
//		productList=new ArrayList<Product>();
        productList=(ArrayList<Product>) actionContext.getApplication().get("productList");
        if (productList==null){
            productList =new ArrayList<Product>();
            return productList;
        }
        else
            return productList;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}


}
