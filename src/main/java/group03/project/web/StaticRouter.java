package group03.project.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class StaticRouter implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        /*
        if /streamer is in urlpath after 8080, direct to streamer webpage.
         */
//        registry.addViewController("streamer").setViewName("forward:/streamer.html");
        /*
        If invalid entry in url, redirect user to 404 error (no page found).
         */
        registry.addViewController("404").setViewName("forward:/404.html");
        /*
        if /test is in urlpath after 8080, direct to test webpage.
         */
//        registry.addViewController("test").setViewName("forward:/test.html");

        registry.addViewController("registration").setViewName("forward:/registration.html");

//        registry.addViewController("/streamer-add").setViewName("forward:/streamer-add.html");
    }
}
