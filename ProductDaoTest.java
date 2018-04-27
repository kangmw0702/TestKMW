package kr.ac.jejunu;

import org.junit.Test;

import java.sql.SQLException;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertEquals;

public class ProductDaoTest {
    @Test
    public void get() throws SQLException, ClassNotFoundException {
        ProductDao productDao = new ProductDao();
        Long id = 1L;
        String title = "제주감귤";
        Integer price = 15000;

/*
        Product product = productDao.get(id);
        assertEquals(id, product.getId());
        assertEquals(title, product.getTitle());
        assertEquals(price, product.getPrice());
*/

        ProductDao productDao1 = new ProductDao();
        Product product = productDao.get(id);
        assertThat(id, is(product.getId()));
        assertThat(title, is(product.getTitle()));
        assertThat(price, is(product.getPrice()));
            }


    @Test
    public void add() throws SQLException, ClassNotFoundException {
        String title = "사과";
        Integer price = 2000;

        Product product = new Product();
        product.setTitle(title);
        product.setPrice(price);
        ProductDao userDao = new ProductDao();
        Long id = userDao.add(product);
        Product resultUser = userDao.get(id);
        assertThat(id, is(resultUser.getId()));
        assertThat(id, is(resultUser.getId()));
        assertThat(price, is(resultUser.getPrice()));
    }
}