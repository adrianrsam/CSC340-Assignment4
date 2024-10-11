package com.adrian.animalsapi.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/animals")
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    @GetMapping
    public List<Animal> getAllAnimals() {
        return animalService.getAllAnimals();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Animal> getAnimalById(@PathVariable int id) {
        Optional<Animal> animal = animalService.getAnimalById(id);
        return animal.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Animal> addAnimal(@RequestBody Animal animal) {
        Animal createdAnimal = animalService.addAnimal(animal);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAnimal);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Animal> updateAnimal(@PathVariable int id, @RequestBody Animal updatedAnimal) {
        Animal animal = animalService.updateAnimal(id, updatedAnimal);
        return ResponseEntity.ok(animal);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnimal(@PathVariable int id) {
        animalService.deleteAnimal(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/species/{species}")
    public List<Animal> getAnimalsBySpecies(@PathVariable String species) {
        return animalService.getAnimalsBySpecies(species);
    }

    @GetMapping("/search")
    public List<Animal> searchAnimals(@RequestParam String name) {
        return animalService.searchAnimalsByName(name);
    }
}
