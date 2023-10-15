package com.minhaempresa.meuecommerce.appvenda.application.utils;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.springframework.stereotype.Component;

@Component
public class CopyUtils extends BeanUtilsBean {

    @Override
    public void copyProperty(Object dest, String name, Object value) {
        if (value == null) {
            return;
        }
        try {
            super.copyProperty(dest, name, value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
