package pl.atm.dietapp.dietapp.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.atm.dietapp.dietapp.service.ProductService;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/caloriescalc")
public class CaloriesCalcRestController {

    private ProductService productService;

    public CaloriesCalcRestController(ProductService productService) {
        this.productService = productService;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productService.delete(id);
    }
}
