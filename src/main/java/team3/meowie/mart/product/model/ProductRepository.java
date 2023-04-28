package team3.meowie.mart.product.model;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * ClassName:ProductRepository
 * Description:
 * Create:2023/4/28 上午 11:10
 */
public interface ProductRepository extends JpaRepository<Product, Integer> {
Product findFirstByOrderByAddedDesc();

}
