package com.edu.fjnu.cjrserver.test;

import com.edu.fjnu.cjrserver.model.CategoryList;
import com.edu.fjnu.cjrserver.service.CategoryListService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/spring-*.xml")
public class CategoryListServiceTest {

    private CategoryList categoryList;

    @Resource
    CategoryListService categoryListService;

    @Before
    public void initCategory(){
        categoryList = new CategoryList();
        categoryList.setTag(0);
        categoryList.setContent("视觉障碍");
    }

    @Test
    public void testAddCategory() {
        categoryList.setContent("嗅觉障碍");
        categoryListService.addCategory(categoryList);
    }

    @Test
    public void testDelCategory() {
        categoryListService.delCategory(2);
        testFindAllCategoryList();
    }

    @Test
    public  void testUpdateCategory() {
        categoryList.setContent("111");
        categoryList.setNo(1);
        categoryListService.updateCategory(categoryList);
        testFindAllCategoryList();
    }

    @Test
    public void testFindAllCategoryList() {
        List<CategoryList> categoryLists = new ArrayList<CategoryList>();
        categoryLists = categoryListService.findAllCategoryList(0);
        for (CategoryList category : categoryLists) {
            System.out.println(category);
        }
    }

}
