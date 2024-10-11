package com.adrian.animalsapi.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }

    public Optional<Animal> getAnimalById(int id) {
        return animalRepository.findById(id);
    }

    public Animal addAnimal(Animal animal) {
        return animalRepository.save(animal);
    }

    public Animal updateAnimal(int id, Animal updatedAnimal) {
        updatedAnimal.setAnimalId(id);
        return animalRepository.save(updatedAnimal);
    }

    public void deleteAnimal(int id) {
        animalRepository.deleteById(id);
    }

    public List<Animal> getAnimalsBySpecies(String species) {
        return animalRepository.findBySpecies(species);
    }

    public List<Animal> searchAnimalsByName(String name) {
        return animalRepository.findByNameContaining(name);
    }
}
