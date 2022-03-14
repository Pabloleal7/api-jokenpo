package com.example.apijokenpo.repository;

import com.example.apijokenpo.entity.InputEntity;
import com.example.apijokenpo.entity.MatchEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository extends JpaRepository<MatchEntity,Long> {
}
