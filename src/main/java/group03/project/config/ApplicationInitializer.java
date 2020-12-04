//package group03.project.config;
//
//import org.springframework.security.access.SecurityConfig;
//import org.springframework.web.WebApplicationInitializer;
//import org.springframework.web.context.ContextLoaderListener;
//import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
//import org.springframework.web.filter.DelegatingFilterProxy;
//
//import javax.servlet.ServletContext;
//import javax.servlet.ServletException;
//
//public class ApplicationInitializer implements WebApplicationInitializer {
//    @Override
//    public void onStartup(ServletContext servletContext) throws ServletException {
//
//        AnnotationConfigWebApplicationContext root = new AnnotationConfigWebApplicationContext();
//        root.register(SecurityConfig.class);
//
//        servletContext.addListener(new ContextLoaderListener(root));
//
//        servletContext.addFilter("SecurityFilter",
//                new DelegatingFilterProxy("springSecurityFilterChain"))
//                .addMappingForUrlPatterns(null, false, "/*");
//
//    }
//}
