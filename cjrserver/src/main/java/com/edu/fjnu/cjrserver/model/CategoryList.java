package com.edu.fjnu.cjrserver.model;

/**
 * CategoryList 类别列表，描述所有的下拉列表选项
 *
 * @version 	    2018-03-23
 * @author 	        吴祖根
 */
public class CategoryList extends ValueObject {

    /* 流水号 */
    private int no;
    /* 标记，0标记适用人群，1标记赛事类型，2标记器材类别 */
    private int tag;
    /* 类别描述 */
    private String content;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "CategoryList{" +
                "no=" + no +
                ", tag=" + tag +
                ", content='" + content + '\'' +
                '}';
    }
}
