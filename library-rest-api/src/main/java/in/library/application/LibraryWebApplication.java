package in.library.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by pradeepkumar on 10/2/18.
 */

@SpringBootApplication(scanBasePackages = "in.library")
public class LibraryWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryWebApplication.class, args);
    }
    
    @Bean
    public WebMvcConfigurer corsConfigurer() {
    	return new WebMvcConfigurerAdapter() {
    		@Override
    		public void addCorsMappings(CorsRegistry registry) {
    			registry.addMapping("/**").allowedOrigins("*");
    		}
    	};
    }
}
