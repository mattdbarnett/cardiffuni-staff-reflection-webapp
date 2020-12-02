package group03.project.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class StaticRouter implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        /*
        If invalid entry in url, redirect user to 404 error (no page found).
         */
        registry.addViewController("404").setViewName("forward:/404.html");

        registry.addViewController("").setViewName("forward:/index.html");
        /*
        if /test is in urlpath after 8080, direct to test webpage.
         */

//        registry.addViewController("registration").setViewName("forward:/registration.html");

    }
}
