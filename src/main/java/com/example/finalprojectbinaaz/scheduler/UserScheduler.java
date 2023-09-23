package com.example.finalprojectbinaaz.scheduler;

import com.example.finalprojectbinaaz.dao.entity.ProductEntity;
import com.example.finalprojectbinaaz.dao.repository.ProductRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;
import java.util.List;

@Configuration
@EnableScheduling
public class UserScheduler {
    public final ProductRepository productRepository;

    public UserScheduler(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Scheduled(cron = "0 0 21 * * ?")
    public void schedulerAdExpireDate() {
        List<ProductEntity> products = productRepository.findAll();
        LocalDateTime expireDate = LocalDateTime.now().minusMonths(1);

        for (ProductEntity product : products) {
            LocalDateTime creationDate = product.getCreationDate();
            if (creationDate.isBefore(expireDate)) {
                System.out.println("Dear, " + product.getSellerEntity().getName()
                        + "! Your ad date has expired.");
            }
        }
    }
}
