package com.example.apijokenpo.repository;

import com.example.apijokenpo.entity.PlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<PlayerEntity,Long> {

}
