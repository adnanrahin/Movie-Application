package com.spring.boot.movie.app.services.implementaions;

import com.spring.boot.movie.app.model.Actor;
import com.spring.boot.movie.app.repositories.ActorRepository;
import com.spring.boot.movie.app.services.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class ActorServiceImpl implements ActorService {

    private static final Logger logger = Logger.getLogger(ActorServiceImpl.class.getName());

    private final ActorRepository actorRepository;

    @Autowired
    public ActorServiceImpl(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @Override
    public List<Actor> findAll() {
        try {
            List<Actor> actors = (List<Actor>) actorRepository.findAll();
            logger.info("Retrieved all actors successfully.");
            return actors;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error occurred while finding all actors: " + e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public Actor findById(Long id) {
        try {
            Actor actor = actorRepository.findById(id).orElse(null);
            if (actor != null) {
                logger.info("Retrieved actor by id " + id + " successfully.");
            } else {
                logger.warning("No actor found for id " + id);
            }
            return actor;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error occurred while finding actor by id: " + id + ". " + e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public Actor save(Actor object) {
        try {
            Actor savedActor = actorRepository.save(object);
            logger.info("Saved actor successfully: " + savedActor);
            return savedActor;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error occurred while saving actor: " + object.toString() + ". " + e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public void delete(Actor object) {
        try {
            actorRepository.delete(object);
            logger.info("Deleted actor successfully: " + object);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error occurred while deleting actor: " + object.toString() + ". " + e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public void deleteById(Long id) {
        try {
            actorRepository.deleteById(id);
            logger.info("Deleted actor by id successfully: " + id);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error occurred while deleting actor by id: " + id + ". " + e.getMessage(), e);
            throw e;
        }
    }
}
