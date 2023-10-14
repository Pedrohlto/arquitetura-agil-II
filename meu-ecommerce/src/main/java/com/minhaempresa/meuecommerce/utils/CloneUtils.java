package com.minhaempresa.meuecommerce.utils;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.springframework.stereotype.Component;

@Component
public class CloneUtils extends BeanUtilsBean {

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
