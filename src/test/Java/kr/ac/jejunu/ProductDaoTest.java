package kr.ac.jejunu;

import org.junit.Before;
import org.junit.Test;
import java.sql.SQLException;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertEquals;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ProductDaoTest {

    private ProductDao productDao;
    private DaoFactory daoFactory;

    @Before
    public void setup() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(DaoFactory.class);
        productDao = applicationContext.getBean("productDao", ProductDao.class);
    }


    @Test
    public void get() throws SQLException, ClassNotFoundException {
        //ProductDao productDao = new ProductDao();
        Long id = 1L;
        String title = "제주감귤";
        Integer price = 15000;


        Product product = productDao.get(id);
        assertEquals(id, product.getId());
        assertEquals(title, product.getTitle());
        assertEquals(price, product.getPrice());


        //ProductDao productDao1 = new ProductDao();
        //Product product = productDao.get(id);
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
        //ProductDao productDao = new ProductDao();
        Long id = productDao.add(product);
        Product resultUser = productDao.get(id);
        assertThat(id, is(resultUser.getId()));
        assertThat(id, is(resultUser.getId()));
        assertThat(price, is(resultUser.getPrice()));
    }
}