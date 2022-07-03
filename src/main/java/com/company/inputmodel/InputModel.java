package com.company.inputmodel;

import java.util.List;
import java.util.stream.Collectors;

import com.company.inputmodel.product.ProductModel;
import com.fasterxml.jackson.annotation.JsonProperty;

public class InputModel {

	@JsonProperty(value="products")
	public List<ProductModel> productList;

	public List<ProductModel> getProductList() {
		return productList;
	}
	
	@Override
	public String toString() {
		if(productList!=null){			
			String productUIDs = String.join(",", productList.stream().map(e -> e.getUid()).collect(Collectors.toList()));
			return "Product is ["+productUIDs+"]";
		}
		return this.toString();
	}
}
