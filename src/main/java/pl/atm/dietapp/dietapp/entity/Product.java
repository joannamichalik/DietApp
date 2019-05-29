package pl.atm.dietapp.dietapp.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double amount;
    private Double kcal;
    private Double carbs;
    private Double fat;
    private Double protein;

}
