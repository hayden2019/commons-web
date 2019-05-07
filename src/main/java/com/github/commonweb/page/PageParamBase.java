package com.github.commonweb.page;

import org.hibernate.validator.constraints.NotBlank;

public class PageParamBase extends PageBase{

    @NotBlank
    String orderKey;
    @NotBlank
    String orderBy;


    public String getOrderKey() {

        return orderKey;
    }

    public void setOrderKey(String orderKey) {
        this.orderKey = orderKey;
    }

    public String getOrderBy() {
//        if(this.orderBy.equals("1") ||this.orderBy.equals("asc") ){
//            orderBy="asc";
//        }else{
//            orderBy="desc";
//        }

        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }
}