package com.WebDevPro.cv.controllers;

import com.WebDevPro.cv.models.Bird;
import com.WebDevPro.cv.repositories.BirdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

    @RestController
    @RequestMapping("api/birds")
    public class BirdController {
        @Autowired
        private BirdRepository birdRepository;

        @PostMapping
        public Bird create(@RequestBody Bird newBird) {
            this.birdRepository.save(newBird);
            return newBird;
        }
        @GetMapping
        public Collection<Bird> list() {
            return this.birdRepository.findAll();
        }
        @GetMapping("{id}")
        public Bird findById(@PathVariable long id) {
            Bird result = this.birdRepository.findById(id);
            return result;
        }

        @PutMapping("{id}")
        public Bird updateById(@PathVariable long id, @RequestBody Bird update) {
            return this.birdRepository.update(id, update);
        }

        @DeleteMapping("{id}")
        public void deleteById(@PathVariable long id) {
            this.birdRepository.deleteById(id);
        }
    }
