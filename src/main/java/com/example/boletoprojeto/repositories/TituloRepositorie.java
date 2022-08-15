package com.example.boletoprojeto.repositories;

import com.example.boletoprojeto.model.TituloModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TituloRepositorie extends JpaRepository<TituloModel, UUID> {

}
