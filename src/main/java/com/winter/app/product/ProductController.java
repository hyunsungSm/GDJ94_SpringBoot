package com.winter.app.product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import com.winter.app.util.Pager;

public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("commentList")
	public void commentList(ProductCommentDTO productCommentDTO, Pager pager) throws Exception{
		Map<String, Object> map = new HashMap<>();
		map.put("product", productCommentDTO);
		map.put("pager", pager);
		
		pager.pageing(20L);
		
		List<ProductCommentDTO> list = productService.commentList(map);
	} 
	
	public void commentAdd(ProductCommentDTO productCommentDTO) throws Exception{
	}
	
}
