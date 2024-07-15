package br.com.ufersa.paulovictor181.cardapio.controller;

import org.springframework.web.bind.annotation.RestController;

import br.com.ufersa.paulovictor181.cardapio.food.Food;
import br.com.ufersa.paulovictor181.cardapio.food.FoodRepository;
import br.com.ufersa.paulovictor181.cardapio.food.FoodRequestDTO;
import br.com.ufersa.paulovictor181.cardapio.food.FoodResponseDTO;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("food")
public class FoodController {
    
    @Autowired
    private FoodRepository repository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void saveFood(@RequestBody FoodRequestDTO data){
        Food foodData = new Food(data);
        repository.save(foodData);
        return;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<FoodResponseDTO> getAll(){

        List<FoodResponseDTO> foodList = repository.findAll().stream().map(FoodResponseDTO::new).toList();
        return foodList;
    }
    
}
