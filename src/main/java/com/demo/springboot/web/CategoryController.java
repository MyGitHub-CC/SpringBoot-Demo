package com.demo.springboot.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.springboot.mapper.CategoryMapper;
import com.demo.springboot.pojo.Category;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class CategoryController {

	@Autowired
	private CategoryMapper categoryMapper;
	
	/**
	 * 分页查询
	 */
//	@RequestMapping("/listCategory")
	@GetMapping("/category")
	public String listCategory(Model m, @RequestParam(value = "start", defaultValue = "0") int start,//1. 在参数里接受当前是第几页 start ，以及每页显示多少条数据 size。 默认值分别是0和5。
			@RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
		//2. 根据start,size进行分页，并且设置id 倒排序
		PageHelper.startPage(start, size, "id desc");
		//3. 因为PageHelper的作用，这里就会返回当前分页的集合了
		List<Category> cs = categoryMapper.findAll();
		//4. 根据返回的集合，创建PageInfo对象
		PageInfo<Category> page = new PageInfo<>(cs);
		//5. 把PageInfo对象扔进model，以供后续显示
		m.addAttribute("page", page);
		return "listCategory";//6. 跳转到listCategory.jsp
	}

	/**
	 * 添加
	 */
//	@RequestMapping("/addCategory")
	@PutMapping("/category")
	public String addCategory(Category c) throws Exception {
		categoryMapper.save(c);
		return "redirect:/category";
	}
	
	/**
	 * 删除
	 */
//	@RequestMapping("/deleteCategory")
	@DeleteMapping("/category/{id}")
	public String deleteCategory(Category c) throws Exception {
		categoryMapper.delete(c.getId());
		return "redirect:/category";
	}
	
	/**
	 * 修改
	 */
//	@RequestMapping("/updateCategory")
	@PostMapping("/category/{id}")
	public String updateCategory(Category c) throws Exception {
		categoryMapper.update(c);
		return "redirect:/category";
	}

	/**
	 * 跳转修改页面 
	 */
//	@RequestMapping("/editCategory")
	@GetMapping("/category/{id}")
	public String editCategory(@PathVariable("id") int id, Model m) throws Exception {
		Category c = categoryMapper.get(id);
		m.addAttribute("c", c);
		return "editCategory";
	}



}
