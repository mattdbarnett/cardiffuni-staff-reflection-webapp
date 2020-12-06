//package group03.project.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.authentication.AuthenticationFailureHandler;
//import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    private UserDetailsService userDetailsService;
//
//    private static final String ADMIN = "ADMIN";
//    private static final String USER = "USER";
//
////    private AuthenticationFailureHandler failureHandler;
////    private LogoutSuccessHandler logoutHandler;
//
//
//    @Override
//    protected  void configure(HttpSecurity http) throws Exception {
//
//        http.authorizeRequests()
//                .mvcMatchers("/admin/**").hasRole("ADMIN")
//                .mvcMatchers("/user/**").hasAnyRole("USER", "ADMIN")
//                .mvcMatchers("/dashboard").authenticated()
//                .mvcMatchers("/css/**").permitAll()
//                .mvcMatchers("/fonts/**").permitAll()
//                .mvcMatchers("/js/**").permitAll()
//                .mvcMatchers("/register").permitAll()
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .permitAll()
////                .loginProcessingUrl("/process-login")
//                .defaultSuccessUrl("/dashboard");
////                .failureUrl("/login.html?error=true")
////                .failureHandler(failureHandler )
////                .and()
////                .logout()
////                .logoutUrl("/perform_logout")
////                .deleteCookies("JSESSIONID")
////                .logoutSuccessHandler(logoutHandler);
////                .anyRequest().denyAll())
////                .formLogin(AbstractAuthenticationFilterConfigurer::permitAll)
////
////                .headers().contentSecurityPolicy
////                (csp -> csp.policyDirectives("default-src *; object-src *;"));
//
//    }
//    @Override
//    protected void configure(AuthenticationManagerBuilder authorizer) throws Exception {
////        authorizer.userDetailsService(userDetailsService);
//        authorizer.inMemoryAuthentication()
//                .withUser("inMem")
//                .password("pass")
//                .roles("USER");
//    }
//
////    @Override
////    protected void configure(HttpSecurity http) throws Exception {
////        http.authorizeRequests()
////                .mvcMatchers("/admin/**").hasRole(ADMIN)
////                .mvcMatchers("/user/**").hasAnyRole(ADMIN, USER)
////                .mvcMatchers("/css/**").permitAll()
////                .mvcMatchers("/fonts/**").permitAll()
////                .mvcMatchers("/js/**").permitAll()
////                .mvcMatchers("/register").permitAll()
////                .and().formLogin();
////    }
//
//    @Bean
//    public PasswordEncoder getPasswordEncoder() {
//        return NoOpPasswordEncoder.getInstance();
//    }
//
////    @Bean
////    public UserDetailsService userDetailsService() {
////        InMemoryUserDetailsManager admin = new InMemoryUserDetailsManager();
////        admin.createUser(User
////                .withDefaultPasswordEncoder()
////                .username("user")
////                .password("password")
////                .roles("USER")
////                .build());
////        admin.createUser(User.withDefaultPasswordEncoder()
////        .username("admin")
////        .password("password")
////        .roles("ADMIN")
////        .build());
////
////        return admin;
////    }
////
////    @Bean
////    public PasswordEncoder encoder() {
////        return new BCryptPasswordEncoder();
////    }
//
////    @Override
////    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
////        auth.inMemoryAuthentication()
////                .withUser("user1").password(encoder().encode("user1pass")).roles("USER")
////                .and()
////                .withUser("admin").password(encoder().encode("adminPass")).roles("ADMIN");
////
////
////    }
//}
