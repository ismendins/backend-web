package com.example.unifor.service;

import com.example.unifor.entity.Place;
import com.example.unifor.entity.Skill;
import com.example.unifor.entity.Sport;
import com.example.unifor.entity.User;
import com.example.unifor.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaceService {

    @Autowired
    private PlaceRepository placeRepository;

    public List<Place> findAllPlaces(){return placeRepository.findAll();
    }

    public static Optional<Place> findPlaceById(Long id){
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

    public Place addSporttoPlace(Long placeId, Long sportId){
        Place place = placeRepository.findById(placeId).orElseThrow(() -> new RuntimeException("Place not found"));
        Sport sport = sportRepository.findById(sportId).orElseThrow(() -> new RuntimeException("Sport not found"));
        place.getSports().add(sport);
        return placeRepository.save(place);

    }

}
