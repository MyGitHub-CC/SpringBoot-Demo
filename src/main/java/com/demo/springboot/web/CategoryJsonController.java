package com.demo.springboot.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.springboot.mapper.CategoryMapper;
import com.demo.springboot.pojo.Category;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
/**
 * 控制器里提供3个方法，分别用来处理json 提交，json获取单个对象，json获取多个对象
 * @author lenovo
 *
 */
@RestController
public class CategoryJsonController {
	@Autowired
	private CategoryMapper categoryMapper;

	@GetMapping("/categoryJson")
	public List<Category> listCategory(@RequestParam(value = "start", defaultValue = "0") int start,
			@RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
		// 2. 根据start,size进行分页，并且设置id 倒排序
		PageHelper.startPage(start, size, "id desc");
		// 3. 因为PageHelper的作用，这里就会返回当前分页的集合了
		List<Category> cs = categoryMapper.findAll();
		// 4. 根据返回的集合，创建PageInfo对象
		PageInfo<Category> page = new PageInfo<>(cs);
		return page.getList();
	}

	@GetMapping("/categoryJson/{id}")
	public Category getCategory(@PathVariable("id") int id) throws Exception {
		Category c = categoryMapper.get(id);
		System.out.println(c);
		return c;
	}

	@PutMapping("/categoryJson")
	public void addCategory(@RequestBody Category category) throws Exception {
		System.out.println("springboot接受到浏览器以JSON格式提交的数据：" + category);
	}
}
