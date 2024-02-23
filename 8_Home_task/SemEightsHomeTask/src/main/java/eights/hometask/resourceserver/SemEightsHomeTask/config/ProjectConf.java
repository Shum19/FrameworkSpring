package eights.hometask.resourceserver.SemEightsHomeTask.config;

import eights.hometask.resourceserver.SemEightsHomeTask.aspects.TrackUserActionAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConf {
    /**
     *
     * @return возвращает экземпляр TrackActionAspect
     */
    @Bean
    public TrackUserActionAspect trackUserActionAspect(){
        return new TrackUserActionAspect();
    }
}
