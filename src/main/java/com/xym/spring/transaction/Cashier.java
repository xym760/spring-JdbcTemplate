package com.xym.spring.transaction;

import java.util.List;

/**
 * @Author: xym760
 * @Date: 2019/6/12 17:16
 * @Description:
 */
public interface Cashier {
    public void checkout(String username, List<String> isbns);
}
