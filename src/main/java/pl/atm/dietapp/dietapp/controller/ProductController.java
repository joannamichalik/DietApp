package pl.atm.dietapp.dietapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.atm.dietapp.dietapp.dto.ProductDto;
import pl.atm.dietapp.dietapp.service.ProductService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @RequestMapping
    public String list(Model model){
        List<ProductDto> products = productService.findAll();
        model.addAttribute("products", products);
        model.addAttribute("product", new ProductDto());

        return "products";
    }

    @PostMapping(value = "products")
    public String create(@Valid @ModelAttribute("product") ProductDto product) {
        productService.create(product);
        return "products";
    }
//    usuwa produkty z bazy danych
//    @GetMapping
//    public String products(Model model, ProductDto productDto) {
//
//        List<ProductDto> products = productService.findAll();
//        if(productDto.getId()!=null) {
//            Optional<Product> chosenProductOpt = productService.findByID(productDto.getId());
//            Product chosenProduct = chosenProductOpt.get();
//            model.addAttribute("chosenProduct", chosenProduct);
//        }
//        model.addAttribute("products", products);
//        model.addAttribute("product", new ProductDto());
//        return "products";
//    }


}

