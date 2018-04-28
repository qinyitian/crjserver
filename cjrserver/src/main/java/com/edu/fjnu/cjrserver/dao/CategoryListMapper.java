package com.edu.fjnu.cjrserver.dao;

import com.edu.fjnu.cjrserver.model.CategoryList;

import java.util.List;

/**
 * CategoryListMapper 管理所有的下拉列表选项mapper
 *
 * @version 	    2018-03-23
 * @author 	        吴祖根
 */
public interface CategoryListMapper {

    /**
     * 增加下拉列表选项
     *
     * @param categoryList      类别项
     */
    void addCategory(CategoryList categoryList);

    /**
     * 删除某个列表选项
     *
     * @param no        流水号
     */
    void delCategory(int no);

    /**
     * 更新某个列表选项
     *
     * @param categoryList          类别项
     */
    void updateCategory(CategoryList categoryList);

    /**
     * 查询类别列表
     *
     * @param tag           标记
     * @return              返回所有列表options
     */
    List<CategoryList> findAllCategoryList(int tag);

}
