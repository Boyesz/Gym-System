package hu.iit.unimiskolc.repasi6.beadando.web.config;

import hu.iit.unimiskolc.beadando.repasi6.gym.GymController;
import hu.iit.unimiskolc.beadando.repasi6.gym.GymDAOSQLITE;
import hu.iit.unimiskolc.beadando.repasi6.gym.core.service.GymService;
import hu.iit.unimiskolc.beadando.repasi6.gym.dao.GymDAO;
import hu.iit.unimiskolc.beadando.repasi6.gym.service.GymServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;


@Configuration
public class WebConfig {

    @Bean(value = "giantkiller")
    public GymController gymController(){
        return new GymController(gymService());
    }
    @Bean(value = "generic")
    GymService gymService(){
        return new GymServiceImpl(gymDAO());
    }
    @Bean(value = "gao")
    GymDAO gymDAO(){
        return new GymDAOSQLITE();
    }

}
