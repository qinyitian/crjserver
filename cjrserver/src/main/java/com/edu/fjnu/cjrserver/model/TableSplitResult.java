package com.edu.fjnu.cjrserver.model;

import java.io.Serializable;

/**
 * 分页信息包装类
 * Created by Administrator on 2017/12/29 0029.
 */
public class TableSplitResult<T> implements Serializable {
    /*当前页号*/
    private Integer pageNumber=1;
    /*每页记录条数*/
    private  Integer pageSize=10;
    /*总共有多少条记录*/
    private  Integer total;
    /*是否有下一页*/
    private Boolean nextPage;
    /*是否有上一页*/
    private Boolean prePage;
    /*记录开始位置*/
    private Integer startIndex;
    /*记录结束位置*/
    private Integer endIndex;
    /*总共多少页*/
    private Integer totalPageNum;
    /*该页的数据*/
    private  T rows;

    public TableSplitResult(Integer pageNumber, Integer pageSize, Integer total, T rows) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.total = total;
        this.rows = rows;
        this.nextPage = pageNumber<getTotalPageNum()?true:false;
        this.prePage = pageNumber>1?true:false;
        this.startIndex = pageSize*(pageNumber-1)+1;
        this.endIndex = (pageSize*pageNumber>this.total)? (int)(this.total.longValue()):(pageSize*pageNumber);
        this.totalPageNum = total%pageSize>0?(int)(total/pageSize+1):(int)(total/pageSize);
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public T getRows() {
        return rows;
    }

    public void setRows(T rows) {
        this.rows = rows;
    }

    public Boolean getNextPage() {
        return pageNumber<getTotalPageNum()?true:false;
    }

    public void setNextPage(Boolean nextPage) {
        this.nextPage = nextPage;
    }

    public Boolean getPrePage() {
        return pageNumber>1?true:false;
    }

    public void setPrePage(Boolean prePage) {
        this.prePage = prePage;
    }

    public Integer getStartIndex() {
        return pageSize*(pageNumber-1)+1;
    }

    public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
    }

    public Integer getEndIndex() {
        return (pageSize*pageNumber>this.total)? (int)(this.total.longValue()):(pageSize*pageNumber);
    }

    public void setEndIndex(Integer endIndex) {
        this.endIndex = endIndex;
    }

    public Integer getTotalPageNum() {
        return total%pageSize>0?(int)(total/pageSize+1):(int)(total/pageSize);
    }

    public void setTotalPageNum(Integer totalPageNum) {
        this.totalPageNum = totalPageNum;
    }

    @Override
    public String toString() {
        return "TableSplitResult{" +
                "pageNumber=" + pageNumber +
                ", pageSize=" + pageSize +
                ", total=" + total +
                ", nextPage=" + nextPage +
                ", prePage=" + prePage +
                ", startIndex=" + startIndex +
                ", endIndex=" + endIndex +
                ", totalPageNum=" + totalPageNum +
                ", rows=" + rows +
                '}';
    }
}
