package com.project.SpaCentr.repository;

import com.project.SpaCentr.model.entity.SpaServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpaServiceRepository extends JpaRepository<SpaServiceEntity,Long> {
}
