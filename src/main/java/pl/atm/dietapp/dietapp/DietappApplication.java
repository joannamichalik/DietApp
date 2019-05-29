package pl.atm.dietapp.dietapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.atm.dietapp.dietapp.entity.Product;
import pl.atm.dietapp.dietapp.repository.ProductRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DietappApplication {

    private static final Logger log = LoggerFactory.getLogger(DietappApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(DietappApplication.class, args);
    }


//    @Bean
//    public CommandLineRunner demo(ProductRepository productRepository) {
//
//        Path file = Paths.get("src\\main\\resources\\nutrients.txt");
//        Charset charset = Charset.forName("UTF-8");
//        List<Product> allProducts = new ArrayList<>();
//
//        try (BufferedReader reader = Files.newBufferedReader(file, charset)) {
//
//            String line;
//            List<String> allLines = new ArrayList<>();
//            while ((line = reader.readLine()) != null) {
//                allLines.add(line);
//
//            }
//
//            for (String s : allLines) {
//                String productData = s.replaceAll("\\s", " ");
//                String name = productData.replaceAll("\\d+(\\,\\d+)?", "").trim();
//                int numbersStart = name.length();
//                String data = productData.substring(numbersStart).replaceAll(",",".").trim();
//                String[] split = data.split(" ");
//
//                int splitLength = split.length-1;
//                Double kcal = Double.parseDouble(split[splitLength-3]);
//                Double carbs = Double.parseDouble(split[splitLength-2]);
//                Double protein = Double.parseDouble(split[splitLength-1]);
//                Double fat = Double.parseDouble(split[splitLength]);
//                Product product = new Product();
//                product.setName(name);
//                product.setAmount(100.0);
//                product.setKcal(kcal);
//                product.setCarbs(carbs);
//                product.setProtein(protein);
//                product.setFat(fat);
//                allProducts.add(product);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return (args) -> {
//            for (Product p : allProducts) {
//                productRepository.save(p);
//            }
//        };
//    }


}
