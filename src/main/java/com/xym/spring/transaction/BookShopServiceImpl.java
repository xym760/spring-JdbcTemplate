package com.xym.spring.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: xym760
 * @Date: 2019/6/12 16:48
 * @Description:
 */
@Service("bookShopService")
public class BookShopServiceImpl implements BookShopService {
    @Autowired
    private BookShopDao bookShopDao;

    /**
     * 添加事务注解
     *使用propagation指定事务的传播行为，即当前的事务方法被另一个事务方法调用时
     * 如何使用事务，默认取值为REQUIRED，即使用调用方法的事务
     * REQUIRES_NEW:使用自己的事务，调用的事务方法的事务被挂起，即只在当前方法中回滚，不影响调用它的事务方法
     * @param username
     * @param isbn
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void purchase(String username, String isbn) {
        //获取书的单价
        int price = bookShopDao.findBookPriceByIsbn(isbn);
        //更新书的库存
        bookShopDao.updateBookStock(isbn);
        //更新用户余额
        bookShopDao.updateUserAccount(username, price);
    }
}
