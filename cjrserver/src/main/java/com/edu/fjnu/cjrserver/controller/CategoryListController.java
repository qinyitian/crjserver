package com.edu.fjnu.cjrserver.controller;

import com.edu.fjnu.cjrserver.model.CategoryList;
import com.edu.fjnu.cjrserver.model.ResultData;
import com.edu.fjnu.cjrserver.service.CategoryListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * CategoryListController 管理所有的下拉列表选项Controller设计实现
 *
 * @version 	2018-03-23
 * @author 	吴祖根
 */
@RestController
@RequestMapping("/CategoryListService")
public class CategoryListController {

    /* 管理所有的下拉列表选项Service */
    @Autowired
    CategoryListService categoryListService;

    /**
     * 按照tag查询类别列表，0标记适用人群，1标记赛事类型，2标记器材类别,2标记企业经营范围
     *
     * @param tag       标记
     * @return          List<CategoryList>列表选项组
     */
    @RequestMapping(value = "/showAllOptionsByTag")
    public List<CategoryList> showAllOptionsByTag(@RequestParam(value = "Tag") Integer tag) {
        return categoryListService.findAllCategoryList(tag);
    }

    /**
     *  添加新的类别选项
     *
     * @param tag           标记
     * @param content       类别描述
     * @return resultData        存储操作结果信息，不论成功失败都会有值，比如成功返回“投票更新成功！”，失败返回“添加失败”
     */
    @RequestMapping(value = "/addCategory")
    public ResultData<Object> addNewCategory(@RequestParam(value = "Tag") Integer tag,
                                             @RequestParam(value = "Content") String content) {

        ResultData<Object> resultData = new ResultData<Object>();
        if (tag != null && content != null) {
            CategoryList categoryList = new CategoryList();
            categoryList.setTag(tag);
            categoryList.setContent(content);
            categoryListService.addCategory(categoryList);
            resultData.setRightResult("类别选项添加成功！");
            System.out.println("类别选项添加成功！" + categoryList.getContent());
            return resultData;
        } else {
            resultData.setErrorResult(0,false,"填写信息缺少，添加失败");
            return resultData;
        }
    }

    /**
     * 删除指定的类别选项
     *
     * @param no        要删除的选项的流水号
     * @return          删除操作结果信息，不论成功失败都会有值，比如成功返回“删除成功！”，失败返回“删除失败”
     */
    @RequestMapping(value = "/delCategory")
    public ResultData<Object> delCategory(@RequestParam(value = "No") Integer no){

        ResultData<Object> resultData = new ResultData<Object>();
        if (no != null) {
            categoryListService.delCategory(no);
            resultData.setRightResult("类别选项删除成功！");
            System.out.println("类别选项删除成功！");
            return resultData;
        } else {
            resultData.setErrorResult(0,false,"填写信息缺少，删除失败");
            return resultData;
        }
    }


    @RequestMapping(value = "/modifyCategory")
    public ResultData<Object> modifyCategory(@RequestParam(value = "No") Integer no,
                                             @RequestParam(value = "Content") String content) {

        ResultData<Object> resultData = new ResultData<Object>();
        if (no != null && content != null) {
            CategoryList categoryList = new CategoryList();
            categoryList.setNo(no);
            categoryList.setContent(content);
            categoryListService.updateCategory(categoryList);
            resultData.setRightResult("类别选项更新成功！");
            System.out.println("类别选项[" + categoryList.getContent() + "]更新成功！");
            return resultData;
        } else {
            resultData.setErrorResult(0,false,"填写信息缺少，更新失败");
            return resultData;
        }
    }

}
