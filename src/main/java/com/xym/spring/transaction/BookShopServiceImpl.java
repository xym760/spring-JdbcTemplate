package com.xym.spring.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
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
     * 使用isolation指定事务的隔离级别，最常用的取值为READ_COMMITTED
     * 通过noRollbackFor属性设置对哪些异常不回滚，通常情况下取默认值就行
     *  @Transactional(propagation = Propagation.REQUIRES_NEW,isolation= Isolation.READ_COMMITTED,noRollbackFor = {UserAccountException.class})
     *  通过readOnly属性指定事务是否为只读，可以帮助数据库引擎优化事务。比如不加锁提升性能等，如果事务为只读，应设置为true
     *  通过timeout属性指定事务最多能占用的时间，单位为秒，如timeout=3，表示事务最多能占用3秒的时间，超过3秒则强制回滚，不管是否有异常都回滚
     * @param username
     * @param isbn
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW,isolation= Isolation.READ_COMMITTED,readOnly = false,timeout = 3)
    @Override
    public void purchase(String username, String isbn) {
        try {
            Thread.sleep(2900);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //获取书的单价
        int price = bookShopDao.findBookPriceByIsbn(isbn);
        //更新书的库存
        bookShopDao.updateBookStock(isbn);
        //更新用户余额
        bookShopDao.updateUserAccount(username, price);
    }
}
