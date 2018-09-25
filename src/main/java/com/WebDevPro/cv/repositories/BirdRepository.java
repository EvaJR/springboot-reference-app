package com.WebDevPro.cv.repositories;

import com.WebDevPro.cv.models.Bird;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class BirdRepository {

    // in real life we would have a real DB here .... like Oracle, MySQL or Postgres
    private static long lastId = 0;
    private Map<Long, Bird> birds = new HashMap<>();  // this you might see as a mock db

    @PostConstruct
    public void addSomeBirdsToGetStarted() {
        for(int i = 0; i < 5; i++) {
            Bird bird = new Bird();
            bird.setName("Gerrit "+ i);
            this.save(bird);
        }
    }

    // CREATE
    public void save(Bird newBird) {
        newBird.setId(++lastId);
        this.birds.put(newBird.getId(), newBird);
    }

    //READ
    public Collection<Bird> findAll() {
        return this.birds.values();
    }

    //READ one bird
    public Bird findById(long id) {
        Bird found = this.birds.get(id);
        return found;
    }

    //UPDATE
    public Bird update(long id, Bird update) {
        Bird victim = this.findById(id);
        victim.setName(update.getName());
        victim.setFlying(update.isFlying());
        victim.setNumberOfEggs(update.getNumberOfEggs());
        return victim;
    }

    //DELETE
    public void deleteById(long id) {
        this.birds.remove(id);
    }

}
