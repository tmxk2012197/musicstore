package com.musicstore.controller;

import com.musicstore.dao.CartDao;
import com.musicstore.dao.ProductDao;
import com.musicstore.model.Cart;
import com.musicstore.model.CartItem;
import com.musicstore.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/rest/cart")
public class CartController {
    @Autowired
    private CartDao cartDao;

    @Autowired
    private ProductDao productDao;

    //@Responsebody: When spring sees this, it will automatically cast this object to JSON
    //return a Cart with read cartId
    @RequestMapping(value = "/{cartId}", method = RequestMethod.GET)
    public @ResponseBody Cart read(@PathVariable(value = "cartId") String cartId) {
        return cartDao.readCartInfo(cartId);
    }

    @RequestMapping(value = "/{cartId}", method = RequestMethod.PUT)
    //not reply any content
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(@PathVariable(value = "cartId") String cartId, @RequestBody Cart cart) {
        cartDao.updateCart(cartId, cart);
    }

    @RequestMapping(value = "/{cartId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "cartId") String cartId) {
        cartDao.deleteCart(cartId);
    }

    @RequestMapping(value = "/add/{productId}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addItem(@PathVariable(value = "productId") int productId, HttpServletRequest httpServletRequest) {
        String sessionId = httpServletRequest.getSession(true).getId();
        Cart cart = cartDao.readCartInfo(sessionId);
        if (cart == null) {
            cart = cartDao.createCart(new Cart(sessionId));
        }
        Product product = productDao.getProductById(productId);
        if (product == null) {
            throw new IllegalArgumentException();
        }
        cart.addCartItem(new CartItem(product));
        cartDao.updateCart(sessionId, cart);
    }

    @RequestMapping(value = "/remove/{productId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void removeItem(@PathVariable(value = "productId") int productId, HttpServletRequest httpServletRequest) {
        String sessionId = httpServletRequest.getSession(true).getId();
        Cart cart = cartDao.readCartInfo(sessionId);
        if (cart == null) {
            cart = cartDao.createCart(new Cart(sessionId));
        }
        Product product = productDao.getProductById(productId);
        if (product == null) {
            throw new IllegalArgumentException();
        }
        cart.removeCartItem(new CartItem(product));
        cartDao.updateCart(sessionId, cart);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Illegal request, please verify your payload")
    public void handleClientErrors(Exception e){}

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal Server Error")
    public void handleServerErrors(Exception e){}
}
