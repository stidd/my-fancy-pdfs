package com.steventidd.myfancypdfinvoices.context;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.steventidd.myfancypdfinvoices.ApplicationLauncher;
import org.springframework.context.annotation.*;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackageClasses = ApplicationLauncher.class)
@PropertySource("classpath:/application.properties")
@PropertySource(value = "classpath:/application-${spring.profiles.active}.properties", ignoreResourceNotFound = true)
@EnableWebMvc
public class ApplicationConfiguration {


//        @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
//        public UserService userService() {
//            return new UserService();
//        }
//
//
//        public InvoiceService invoiceService(UserService userService) {
//            return new InvoiceService();
//        }

        @Bean
        public MethodValidationPostProcessor methodValidationPostProcessor() {
            return new MethodValidationPostProcessor();
        }

        @Bean
        public ObjectMapper objectMapper() {
            return new ObjectMapper();
        }

}
