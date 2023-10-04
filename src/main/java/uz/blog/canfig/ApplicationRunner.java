package uz.blog.canfig;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ApplicationRunner implements CommandLineRunner {

    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;

    @Override
    public void run(String... args){
        System.out.printf("%s => ### Flyway migration ###%n", this.getClass());

        Flyway flyway = Flyway.configure()
                .dataSource(url, username, password)
                .baselineOnMigrate(true)
                .sqlMigrationPrefix("C")
                .baselineVersion("0")
                .outOfOrder(true)
                .load();
        flyway.migrate();
    }
}