package com.example.apijokenpo.repository;

import com.example.apijokenpo.entity.InputEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository extends JpaRepository<MatchEntity,Long> {
}
