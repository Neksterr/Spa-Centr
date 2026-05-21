package com.project.SpaCentr.repository;

import com.project.SpaCentr.model.entity.StickyNoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface StickyNoteRepository extends JpaRepository<StickyNoteEntity,Long> {

    Optional<StickyNoteEntity> findByNoteDate(LocalDate noteDate);


    Optional<StickyNoteEntity> findByDateWithUpdater(LocalDate date);

    void deleteByNoteDate(LocalDate noteDate);
}
