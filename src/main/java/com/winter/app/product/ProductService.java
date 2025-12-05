package com.winter.app.product;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

public class ProductService {

	@Autowired
	private ProductDAO productDAO;
	
	public List<ProductCommentDTO> commentList(Map<String, Object> map) throws Exception{
		return productDAO.commentList(map);
	} 
	
	public int commentAdd(ProductCommentDTO productCommentDTO) throws Exception{
		return productDAO.commentAdd(productCommentDTO);
	}
}
