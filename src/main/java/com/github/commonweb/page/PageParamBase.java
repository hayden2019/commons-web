package com.github.commonweb.page;

import org.apache.commons.lang.StringUtils;
import org.hibernate.validator.constraints.NotBlank;

public class PageParamBase extends PageBase{

    @NotBlank
    String orderKey;
    @NotBlank
    String order;
    public String getOrderKey() {
        return orderKey;
    }
    public void setOrderKey(String orderKey) {
        this.orderKey = orderKey;
    }
    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getPhrase(){
        if(notEmpty(orderKey) && notEmpty(order)){
            return orderKey + " " + order;
        }else{
            return null;
        }
    }

    private boolean notEmpty(String s){
        return s != null && s.length() > 0;
    }
}