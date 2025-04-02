package com.example.csd230_test2_practical_Brock_McClelland;

import com.example.csd230_test2_practical_Brock_McClelland.Entities.Product;
import com.example.csd230_test2_practical_Brock_McClelland.Repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class Csd230Test2PracticalBrockMcClellandApplication {

	public static void main(String[] args) {
		SpringApplication.run(Csd230Test2PracticalBrockMcClellandApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ProductRepository productRepository) {
		return args -> {

			productRepository.deleteAll();

			List<Product> products = List.of(
					new Product("Product 1", "This is Product 1", 5.00, LocalDateTime.of(2025, 1, 1, 0, 1), 10),
					new Product("Product 2", "This is Product 2", 10.00, LocalDateTime.of(2025, 1, 2, 0, 1), 10),
					new Product("Product 3", "This is Product 3", 15.00, LocalDateTime.of(2025, 1, 3, 0, 1), 10),
					new Product("Product 4", "This is Product 4", 20.00, LocalDateTime.of(2025, 1, 4, 0, 1), 10),
					new Product("Product 5", "This is Product 5", 25.00, LocalDateTime.of(2025, 1, 5, 0, 1), 10),
					new Product("Product 6", "This is Product 6", 30.00, LocalDateTime.of(2025, 1, 6, 0, 1), 10)
			);

			productRepository.saveAll(products);
			System.out.println("Inserted 6 products into the database.");


			System.out.println("All Products:");
			productRepository.findAll().forEach(System.out::println);

			System.out.println("\nProducts from Jan 2, 2025 to Jan 4, 2025:");
			productRepository.findProductsBetween(
					LocalDateTime.of(2025, 1, 2, 0, 0, 1),
					LocalDateTime.of(2025, 1, 4, 0, 0, 1)
			).forEach(System.out::println);
		};
	}
}