package com.example.unifor.service;

import com.example.unifor.entity.Place;
import com.example.unifor.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaceService {

    @Autowired
    private static PlaceRepository placeRepository;

    public List<Place> findAllPlaces(){return placeRepository.findAll();
    }

    public Optional<Place> findPlaceById(Long id){
        return placeRepository.findById(id);
    }

    public Place savePlace(Place place){
        return placeRepository.save(place);
    }

    public Place updatePlace(Long id, Place updatePlace) {
        return placeRepository.findById(id)
                .map(place -> {
                    place.setName(updatePlace.getName());
                    return placeRepository.save(place);
                }).orElseThrow(() -> new RuntimeException("Place not found!"));
    }
    public void deletePlace(Long id){
        placeRepository.deleteById(id);
    }
}