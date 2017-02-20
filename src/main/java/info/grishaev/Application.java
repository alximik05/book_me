package info.grishaev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.repository.init.Jackson2RepositoryPopulatorFactoryBean;

import javax.faces.webapp.FacesServlet;
import javax.servlet.DispatcherType;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.util.EnumSet;

/**
 * Created by stas on 16/02/17.
 */
@EnableAutoConfiguration
@ComponentScan("info.grishaev")
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        //TODO
        // populate DB
        // докрутить jsf

    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Application.class);
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        servletContext.setInitParameter("primefaces.CLIENT_SIDE_VALIDATION", "true");
        servletContext.setInitParameter("primefaces.THEME", "bootstrap");
    }


    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        FacesServlet servlet = new FacesServlet();
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(servlet, "*.jsf");
        return servletRegistrationBean;
    }

//    @Bean
//    public FilterRegistrationBean rewriteFilter() {
//        FilterRegistrationBean rwFilter = new FilterRegistrationBean();
//        rwFilter.setDispatcherTypes(EnumSet.of(DispatcherType.FORWARD, DispatcherType.REQUEST,
//                DispatcherType.ASYNC, DispatcherType.ERROR));
//        rwFilter.addUrlPatterns("/*");
//        return rwFilter;
//    }

//    @Bean
//    public Jackson2RepositoryPopulatorFactoryBean repositoryPopulator() {
//        Resource sourceData;
//        Jackson2RepositoryPopulatorFactoryBean factory;
//        try {
//            sourceData = new PathResource(init);
//            if(!sourceData.exists())
//                sourceData = new ClassPathResource(init);
//            factory = new Jackson2RepositoryPopulatorFactoryBean();
//            factory.setResources(new Resource[] { sourceData });
//        } catch (Exception e) {
//            return null;
//        }
//
//        return factory;
//    }
}
