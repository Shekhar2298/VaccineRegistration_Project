package com.example.vaccine.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vaccine.Model.User;
import com.example.vaccine.Repository.Vaccinerepo;

@Service
public class Vaccineservice {
    @Autowired
    Vaccinerepo repo;

    public void AddAll(User u) {
        repo.save(u);
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }

    public List<User> Adding() {
        return repo.findAll();
    }

    public User updateid(Integer id) {
        Optional<User> tab = repo.findById(id);
        if (tab.isPresent()) {
            return tab.get();
        } else {
            return null;
        }
    }
}
