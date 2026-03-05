package com.project.SpaCentr.repository;

import com.project.SpaCentr.model.entity.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.lang.ScopedValue;
import java.time.LocalDateTime;
import java.util.Collection;

@Repository
public interface BookingRepository extends JpaRepository<BookingEntity,Long> {
    boolean existsOverLappingSchedule(Long id, LocalDateTime start, LocalDateTime end);

    <T> ScopedValue<T> findBookingById(long bookingId);

    Collection<Object> findAllByStartTimeAndEndTimePeriod(LocalDateTime from, LocalDateTime to);
}
