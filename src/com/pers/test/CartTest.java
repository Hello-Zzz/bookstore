package com.pers.test;

import com.pers.pojo.Cart;
import com.pers.pojo.CartItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class CartTest {

    @Test
    public void addItem() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(01, "乱世求生", 1, new BigDecimal(99), new BigDecimal(99)));
        cart.addItem(new CartItem(01, "乱世求生", 1, new BigDecimal(99), new BigDecimal(99)));
        cart.addItem(new CartItem(2, "水浒传", 1, new BigDecimal(56), new BigDecimal(56)));

        System.out.println(cart);
    }

    @Test
    public void deleteItem() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(01, "乱世求生", 1, new BigDecimal(99), new BigDecimal(99)));
        cart.addItem(new CartItem(01, "乱世求生", 1, new BigDecimal(99), new BigDecimal(99)));
        cart.addItem(new CartItem(2, "水浒传", 1, new BigDecimal(56), new BigDecimal(56)));

        cart.deleteItem(1);
        System.out.println(cart);

    }

    @Test
    public void clear() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(01, "乱世求生", 1, new BigDecimal(99), new BigDecimal(99)));
        cart.addItem(new CartItem(01, "乱世求生", 1, new BigDecimal(99), new BigDecimal(99)));
        cart.addItem(new CartItem(2, "水浒传", 1, new BigDecimal(56), new BigDecimal(56)));

        cart.deleteItem(1);

        cart.clear();
        System.out.println(cart);
    }

    @Test
    public void updateCount() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(01, "乱世求生", 1, new BigDecimal(99), new BigDecimal(99)));
        cart.addItem(new CartItem(01, "乱世求生", 1, new BigDecimal(99), new BigDecimal(99)));
        cart.addItem(new CartItem(2, "水浒传", 1, new BigDecimal(56), new BigDecimal(56)));

        cart.deleteItem(1);

        cart.clear();
        cart.addItem(new CartItem(2, "水浒传", 1, new BigDecimal(56), new BigDecimal(56)));
        cart.updateCount(2, 10);
        System.out.println(cart);
    }
}