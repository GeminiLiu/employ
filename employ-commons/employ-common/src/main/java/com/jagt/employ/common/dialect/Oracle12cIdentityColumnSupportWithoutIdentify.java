package com.jagt.employ.common.dialect;

import org.hibernate.dialect.identity.Oracle12cIdentityColumnSupport;

public class Oracle12cIdentityColumnSupportWithoutIdentify extends Oracle12cIdentityColumnSupport {

    @Override
    public String getIdentityColumnString(int type) {
        return "";
    }
}
