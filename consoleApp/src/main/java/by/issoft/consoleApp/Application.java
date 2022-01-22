package by.issoft.consoleApp;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Slf4j
@RequiredArgsConstructor
@EntityScan("by.issoft")
@EnableJpaRepositories("by.issoft")
@ComponentScan(basePackages = {"by.issoft"})
@SpringBootApplication(scanBasePackages = "by.issoft")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
