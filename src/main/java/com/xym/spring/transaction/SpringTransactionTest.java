package com.xym.spring.transaction;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

/**
 * @Author: xym760
 * @Date: 2019/6/12 15:33
 * @Description:
 */
public class SpringTransactionTest {
    private ApplicationContext applicationContext;
    private BookShopDao bookShopDao;
    private BookShopService bookShopService;
    private Cashier cashier;

    {
        applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        bookShopDao = applicationContext.getBean(BookShopDao.class);
        bookShopService = applicationContext.getBean(BookShopService.class);
        cashier=applicationContext.getBean(Cashier.class);
    }

    @Test
    public void testBookShopDaoUpdateUserAccount() {
        bookShopDao.updateUserAccount("AA", 100);
    }

    @Test
    public void testBookShopDaoUpdateBookStock() {
        bookShopDao.updateBookStock("1001");
    }

    @Test
    public void testBookShopDaoFindPriceByIsbn() {
        System.out.println(bookShopDao.findBookPriceByIsbn("1002"));
    }

    @Test
    public void testBookShopService() {
        bookShopService.purchase("AA", "1001");
    }

    @Test
    public void testTransactionPropagation(){
        cashier.checkout("AA", Arrays.asList("1001","1002"));
    }
}
