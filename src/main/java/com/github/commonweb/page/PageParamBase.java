package com.github.commonweb.page;

import org.hibernate.validator.constraints.NotBlank;

public class PageParamBase extends PageBase{

    @NotBlank
    String orderBy;
    @NotBlank
    String order;
    public String getOrderBy() {
        return orderBy;
    }
    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }
    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getPhrase(){
        if(notEmpty(orderBy) && notEmpty(order)){
            return orderBy + " " + order;
        }else{
            return null;
        }
    }

    private boolean notEmpty(String s){
        return s != null && s.length() > 0;
    }
}