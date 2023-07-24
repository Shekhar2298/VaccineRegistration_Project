package com.example.vaccine.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.vaccine.Model.User;

@Repository
public interface Vaccinerepo extends JpaRepository<User, Integer>{
    
}
