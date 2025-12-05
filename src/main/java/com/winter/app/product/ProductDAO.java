package com.winter.app.product;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductDAO {

	public List<ProductCommentDTO> commentList(Map<String, Object> map) throws Exception; 
	
	public int commentAdd(ProductCommentDTO productCommentDTO) throws Exception;
}
