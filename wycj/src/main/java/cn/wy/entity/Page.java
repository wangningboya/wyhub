package cn.wy.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Page<T> {
    //查询出的数据
    private List<T> rows=new ArrayList<T>();

    //总条数
    private int total;

    //每页显示
    private int limit;

    //位移数
    private int offset;

    //查询条件
    private Map<String, Object> params;

    // 数组查询条件
    private Map<String, List<String>> paramLists;

    public Page(){
        super();
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    public Map<String, List<String>> getParamLists() {
        return paramLists;
    }

    public void setParamLists(Map<String, List<String>> paramLists) {
        this.paramLists = paramLists;
    }
}
