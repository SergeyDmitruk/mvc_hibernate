package by.dmitruk.app.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.DispatcherServlet;


import javax.servlet.*;

public class ConfigDispatcherServlet implements WebApplicationInitializer {
@Override
public void onStartup(ServletContext servletContext) throws ServletException {
    AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
    context.register(WebConfig.class);
    context.setServletContext(servletContext);
    registerHiddenFieldFilter(servletContext);

    ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet(context));
    dispatcher.setLoadOnStartup(1);
    dispatcher.addMapping("/");

    CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
    characterEncodingFilter.setEncoding("UTF-8");
    characterEncodingFilter.setForceEncoding(true);

    FilterRegistration.Dynamic filterRegistration = servletContext
            .addFilter("characterEncodingFilter", characterEncodingFilter);
    filterRegistration.addMappingForUrlPatterns(null, false, "/*");
}

private void registerHiddenFieldFilter(ServletContext aContext) {
    aContext.addFilter("hiddenHttpMethodFilter",
            new HiddenHttpMethodFilter()).addMappingForUrlPatterns(null, true, "/*");
}
}
