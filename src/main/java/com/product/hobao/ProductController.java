package com.product.hobao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.hobao.dao.CategoryDAO;
import com.hobao.dao.ProductDAO;
import com.product.entity.Category;

@Controller
public class ProductController {
	@Autowired
	ProductDAO pdao;
	@Autowired
	CategoryDAO cdao;

	@ModelAttribute("categories")
	public List<Category> getCategories() {
		return cdao.getAll();
	}
	@RequestMapping("products")
	public String showProducts(ModelMap model, @RequestParam(value = "cate", required = false) Integer categoryId) {
		if (categoryId == null) {
			model.addAttribute("products", pdao.getAll());
		} else {
			model.addAttribute("products", pdao.getByCategoryId(categoryId));
		}
		System.out.println(pdao.getAll().get(0).getName());
		return "product";
	}
}
