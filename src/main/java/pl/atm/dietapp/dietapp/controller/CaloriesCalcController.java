package pl.atm.dietapp.dietapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.atm.dietapp.dietapp.dto.ProductDto;
import pl.atm.dietapp.dietapp.dto.UserDto;
import pl.atm.dietapp.dietapp.entity.Product;
import pl.atm.dietapp.dietapp.service.ProductService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller

public class CaloriesCalcController {

    ProductService productService;

    public CaloriesCalcController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "/caloriescalc", method = RequestMethod.GET)
    public String showCalculator(@RequestParam(required = false) Long deleteId, Model model,
                                 HttpServletRequest request) {

        List<Product> mealPlan = (List<Product>) request.getSession().getAttribute("plan");
       // Double amount = (Double) request.getSession().getAttribute("amount");


        if (deleteId != null) {

            for(int i = 0; i < mealPlan.size(); i++){
                if(mealPlan.get(i).getId().equals(deleteId)){
                    mealPlan.remove(i);
                    break;
                }
            }
            return "redirect:caloriescalc";
        }

        if(mealPlan!=null) {
            double prot = 0;
            double carbs = 0;
            double fat = 0;
            double kcal = 0;
            double amount = 0;

            for (Product meal : mealPlan) {

                prot = prot+(meal.getProtein()/100)*meal.getAmount();
                carbs = carbs+(meal.getCarbs()/100)*meal.getAmount();
                fat = fat+(meal.getFat()/100)*meal.getAmount();
                kcal = kcal+(meal.getKcal()/100)*meal.getAmount();
                amount = amount+meal.getAmount();
            }

            model.addAttribute("totalProt", prot);
            model.addAttribute("totalCarbs", carbs);
            model.addAttribute("totalFat", fat);
            model.addAttribute("totalKcal", kcal);
            model.addAttribute("totalAmount", amount);
        }
        List<ProductDto> products = productService.findAll();
        model.addAttribute("product",  new ProductDto());
        model.addAttribute("products",  products);


        return "/caloriescalc";
    }

//    @RequestMapping(value = "/caloriescalc/amount", method = RequestMethod.GET)
//    public String addAmounnt(@Valid @ModelAttribute("product")ProductDto product,
//                             Model model, HttpServletRequest request){
//
//
//        Double amount = product.getAmount()/100;
//        System.err.println(amount);
//        request.getSession().setAttribute("amount", amount);
//
//        return "redirect:/caloriescalc";
//    }

    @RequestMapping(value = "/caloriescalc", method = RequestMethod.POST)
    public String addProduct(@Valid @ModelAttribute("product")ProductDto product,
                             BindingResult result, Model model, HttpServletRequest request) {
        if (result.hasErrors()) {
            return "error";
        }

        //request.getSession().setAttribute("amount", product.getAmount());

        List<Product> mealPlan = (List<Product>) request.getSession().getAttribute("plan");
        if(mealPlan == null){
            mealPlan = new ArrayList<>();
        }
        if(product.getId()!=null) {
            Optional<Product> chosenProductOpt = productService.findByID(product.getId());
            Product chosenProduct = chosenProductOpt.get();
            chosenProduct.setAmount(product.getAmount());
            mealPlan.add(chosenProduct);
            chosenProduct.setAmount(product.getAmount());
            request.getSession().setAttribute("plan", mealPlan);
            model.addAttribute("mealPlan", mealPlan);

        }

        return "redirect:caloriescalc";
    }
    




}
