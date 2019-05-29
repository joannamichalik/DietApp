package pl.atm.dietapp.dietapp.dto;

import lombok.Data;

@Data
public class ProductDto {

    private Long id;
    private String name;
    private Double amount;
    private Double kcal;
    private Double carbs;
    private Double fat;
    private Double protein;
}
