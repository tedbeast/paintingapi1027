package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
    /**
     * Spring has different 'projects'
     * Spring core (dependency injection, beans, IOC container)
     * Spring boot (auto-configuration of beans like tomcat/datasource, component scanning)
     * Spring MVC (Spring Model-View-Controller)
     *      Model - Spring is able to easily work with our provided data models
     *      View - Spring is able to easily configure the presentation of data models / render HTML (servlets)
     *      Controller - Spring is able to manage how to handle an incoming request (differentiate http methods/uri/parse params)
     * Spring Data
     *      Will allow us to use JPARepositories, which allow us to interact with the database in a very
     *      abstract way that allow us to avoid writing queries much of the time.
     * Spring ORM
     *      ORM - Spring will automatically manage the relationship between a table and a POJO for us.
     *
     * @param args
     */
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Application.class);
    }
}
