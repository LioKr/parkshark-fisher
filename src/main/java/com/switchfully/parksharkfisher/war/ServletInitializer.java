package com.switchfully.parksharkfisher.war;

import com.switchfully.parksharkfisher.war.ParksharkFisherApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ParksharkFisherApplication.class);
    }

}
