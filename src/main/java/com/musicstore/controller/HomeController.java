package com.musicstore.controller;

import com.musicstore.dao.ProductDao;
import com.musicstore.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
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

   private Path path;
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
    public String viewProduct(@PathVariable int productId, Model model) throws IOException{
        Product product = productDao.getProductById(productId);
        model.addAttribute(product);
        return "viewProduct";
    }

    @RequestMapping("/admin")
    public String adminPage() {
        return "admin";
    }

    @RequestMapping("/admin/productInventory")
    public String productInventory(Model model) {
        List<Product> products = productDao.getAllProducts();
        model.addAttribute("products", products);
        return "productInventory";
    }

    @RequestMapping("/admin/productInventory/addProduct")
    public String addProduct(Model model) {
        Product product = new Product();
        product.setCategory("Instrument");
        product.setCondition("New");
        product.setStatus("Active");

        model.addAttribute("product", product);
        return "addProduct";
    }
    //default requestMethod is get
    //return to a path
    @RequestMapping(value = "/admin/productInventory/addProduct", method = RequestMethod.POST)
    public String addProductPost(@ModelAttribute("product") Product product, HttpServletRequest httpServletRequest) {
        productDao.addProduct(product);
        //add product image
        MultipartFile productImage = product.getProductImage();
        String rootDirectory = httpServletRequest.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\" + product.getProductId() + ".png");
        if (productImage != null && !productImage.isEmpty()) {
            try {
                productImage.transferTo(new File(path.toString()));
            } catch (IOException ioe) {
                ioe.printStackTrace();
                throw new RuntimeException("Product image was not saved", ioe);
            }
        }

        return "redirect:/admin/productInventory";
    }

   @RequestMapping("/admin/productInventory/deleteProduct/{productId}")
    public String deleteProduct(@PathVariable int productId, Model model, HttpServletRequest httpServletRequest) {
        //delete image
       String rootDirectory = httpServletRequest.getSession().getServletContext().getRealPath("/");
       path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\" + productId + ".png");
       if (Files.exists(path)) {
           try {
               Files.delete(path);
           } catch (IOException ioe) {
               ioe.printStackTrace();
           }
       }

        productDao.deleteProduct(productId);
        return "redirect:/admin/productInventory";
    }
}
