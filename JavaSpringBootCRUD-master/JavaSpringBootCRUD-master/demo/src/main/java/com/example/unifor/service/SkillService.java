package com.example.unifor.service;

import com.example.unifor.entity.Skill;
import com.example.unifor.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillService {
    @Autowired
    private SkillRepository skillRepository;

    public List<Skill> findAllSkills(){
        return skillRepository.findAll();
    }

    public Skill saveSkill(Skill skill){
        return skillRepository.save(skill);
    }

}
