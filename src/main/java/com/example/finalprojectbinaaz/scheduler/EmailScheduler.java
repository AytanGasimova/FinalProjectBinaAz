package com.example.finalprojectbinaaz.scheduler;

import com.example.finalprojectbinaaz.dao.entity.ProductEntity;
import com.example.finalprojectbinaaz.dao.repository.ProductRepository;
import com.example.finalprojectbinaaz.service.ProductService;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;
import java.util.List;

@Configuration
@EnableScheduling
@RequiredArgsConstructor
public class EmailScheduler {
    private final ProductRepository productRepository;
    private final ProductService productService;

    @Scheduled(cron = "0 0 0 * 12 ?")
    public void schedulerAdExpireDate() throws MessagingException {
        List<ProductEntity> products = productRepository.findAll();
        LocalDateTime expireDate = LocalDateTime.now().minusMonths(1);

        for (ProductEntity product : products) {
            LocalDateTime creationDate = product.getCreationDate();
            if (creationDate.isBefore(expireDate)) {
//                System.out.println("Dear, " + product.getSellerEntity().getName()
//                        + "! Your ad date has expired.");
                productService.sendEmail(product.getSellerEntity().getEmail(),
                        "Informational email",
                        "Your ad date has expired. It will be deleted after 6 hours."
                );
                System.out.println("email was sent.");
            }
        }
    }
}
