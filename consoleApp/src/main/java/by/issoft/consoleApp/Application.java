package by.issoft.consoleApp;

import by.issoft.domain.Category;
import by.issoft.store.RandomStorePopulator;
import by.issoft.store.Store;
import by.issoft.store.handlers.CommandHandler;
import by.issoft.store.handlers.quit.QuitProgramException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;
import java.util.Scanner;

@Slf4j
@RequiredArgsConstructor
@EntityScan("by.issoft")
@EnableJpaRepositories("by.issoft")
@SpringBootApplication(scanBasePackages = "by.issoft")
public class Application {
    private final RandomStorePopulator populator;
    private final CommandHandler commandHandler;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            List<Category> categories = populator.generateCategories();
            Store store = Store.builder()
                    .categories(categories)
                    .build();

            try (Scanner scanner = new Scanner(System.in)) {
                while (true) {
                    log.info("Try to put your command here:");
                    if (scanner.hasNext()) {
                        String command = scanner.nextLine();
                        log.info("Your command: {} \n", command);

                        String result = commandHandler.handleCommand(command, store);
                        log.info(result);
                    }
                }
            } catch (QuitProgramException e) {
                log.info(e.getMessage());
            }
            ((ConfigurableApplicationContext) ctx).close();
            System.exit(0);
        };
    }
}
