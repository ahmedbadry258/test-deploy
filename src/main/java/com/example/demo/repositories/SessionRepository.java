package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Session;

public interface SessionRepository extends JpaRepository<Session,Long> {

}
