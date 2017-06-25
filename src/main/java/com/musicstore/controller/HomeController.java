package com.musicstore.controller;

import com.musicstore.dao.ProductDao;
import com.musicstore.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
public class HomeController {
   @Autowired
   private ProductDao productDao;

    //return to a jsp page
    @RequestMapping("/")
    public String home() {
        return "home";
    }

    @RequestMapping("/productList")
    public String getProductList(Model model) {
        List<Product> products = productDao.getAllProducts();
        //bind the products to the model and give the attribute name as products.
        // the model will attach to the view automatically
        model.addAttribute("products", products);
        //return the view
        return "productList";
    }

    @RequestMapping("/productList/viewProduct/{productId}")
    public String viewProduct(@PathVariable(value = "productId") int productId, Model model) throws IOException{
        Product product = productDao.getProductById(productId);
        model.addAttribute(product);
        return "viewProduct";
    }
}
