package com.musicstore.controller.admin;

import com.musicstore.model.Product;
import com.musicstore.service.ProductService;
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

@Controller
@RequestMapping("/admin")
public class adminProduct {
    private Path path;

    @Autowired
    private ProductService productService;

    @RequestMapping("/product/addProduct")
    public String addProduct(Model model) {
        Product product = new Product();
        product.setCategory("instrument");
        product.setCondition("new");
        product.setStatus("active");
        model.addAttribute("product", product);
        return "addProduct";
    }

    @RequestMapping(value = "/product/addProduct", method = RequestMethod.POST)
    public String addProductPost(@Valid @ModelAttribute("product")Product product, BindingResult bindingResult, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            return "editProduct";
        }
        productService.addProduct(product);
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

    @RequestMapping("/product/editProduct/{id}")
    public String editProduct(@PathVariable("id") int id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "editProduct";
    }

    @RequestMapping(value = "/product/editProduct", method = RequestMethod.POST)
    public String editProductPost(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            return "addProduct";
        }
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
        productService.editProduct(product);
        return "redirect:/admin/productInventory";
    }

    @RequestMapping("/product/deleteProduct/{id}")
    public String deleteProduct(@PathVariable int id, Model model, HttpServletRequest httpServletRequest) {
        String rootDirectory = httpServletRequest.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\" + id + ".png");
        if (Files.exists(path)) {
            try {
                Files.delete(path);
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
        Product product = productService.getProductById(id);
        productService.deleteProduct(product);
        return "redirect:/admin/productInventory";
    }
}
