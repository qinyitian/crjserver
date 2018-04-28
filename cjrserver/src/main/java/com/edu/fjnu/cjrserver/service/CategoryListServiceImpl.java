package com.edu.fjnu.cjrserver.service;

import com.edu.fjnu.cjrserver.dao.CategoryListMapper;
import com.edu.fjnu.cjrserver.model.CategoryList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * CategoryListServiceImpl 管理所有的下拉列表选项Service设计实现
 *
 * @version 	2018-02-22
 * @author 	吴祖根
 */
@Service("CategoryListService")
public class CategoryListServiceImpl implements CategoryListService {

    /* 管理所有的下拉列表选项的Mapper */
    @Autowired
    CategoryListMapper categoryListMapper;

    public void addCategory(CategoryList categoryList) {
        categoryListMapper.addCategory(categoryList);
    }

    public void delCategory(int no) {
        categoryListMapper.delCategory(no);
    }

    public void updateCategory(CategoryList categoryList) {
        categoryListMapper.updateCategory(categoryList);
    }

    public List<CategoryList> findAllCategoryList(int tag) {
        return categoryListMapper.findAllCategoryList(tag);
    }
}
