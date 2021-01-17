package com.spring.boot.movie.app.configurations;


import com.spring.boot.movie.app.model.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Configuration
public class RestDataConfig implements RepositoryRestConfigurer {

    private final EntityManager entityManager;

    @Autowired
    public RestDataConfig(@Qualifier("movieDSFactory") EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {

        HttpMethod[] theUnSupportedActions = {HttpMethod.DELETE, HttpMethod.POST, HttpMethod.PUT, HttpMethod.GET};

        config.getExposureConfiguration()
                .forDomainType(Film.class)
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnSupportedActions))
                .withCollectionExposure(((metdata, httpMethods) -> httpMethods.disable(theUnSupportedActions)));

        exposeIds(config);

    }

    public void exposeIds(RepositoryRestConfiguration config) {
        Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();
        List<Class> entityClasses = new ArrayList<>();

        for (EntityType tempEntityType : entities) {
            entityClasses.add(tempEntityType.getJavaType());
        }

        Class[] domainTypes = entityClasses.toArray(new Class[0]);

        config.exposeIdsFor(domainTypes);
    }

}
