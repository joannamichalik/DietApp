package pl.atm.dietapp.dietapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.atm.dietapp.dietapp.dto.ProductDto;
import pl.atm.dietapp.dietapp.entity.Product;
import pl.atm.dietapp.dietapp.repository.ProductRepository;
import pl.atm.dietapp.dietapp.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductRestController {

    @RequestMapping
    public String products() {
        return "products";
    }


    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/all")
    public @ResponseBody List<ProductDto> getAll() {
        return productService.findAll();
    }

    @GetMapping("/add")
    public @ResponseBody String addProduct(
            @RequestParam Long id,
            @RequestParam Double amount,
            @RequestParam String name,
            @RequestParam Double kcal,
            @RequestParam Double carbs,
            @RequestParam Double fat,
            @RequestParam Double protein) {
//        ProductDto dto = new ProductDto();
//        dto.setId(id);
//        dto.setName(name);
//        dto.setKcal(kcal);
//        dto.setCarbs(carbs);
//        dto.setFat(fat);
//        dto.setProtein(protein);
//        productService.create(dto);
        Product product = new Product();
        product.setId(id);
        product.setAmount(amount);
        product.setName(name);
        product.setKcal(kcal);
        product.setCarbs(carbs);
        product.setFat(fat);
        product.setProtein(protein);
        productRepository.save(product);

        return "saved";
    }


}
