package com.example.unifor.service;

import com.example.unifor.entity.Sport;
import com.example.unifor.repository.SportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SportService {
    @Autowired
    private SportRepository sportRepository;

    public List<Sport> findAllSports(){return sportRepository.findAll();
    }
}
