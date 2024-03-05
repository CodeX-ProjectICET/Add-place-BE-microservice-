package org.example.repository;


import org.example.entity.ImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ImageRepository extends CrudRepository<ImageEntity,Long> {
    Optional<ImageEntity> findTopByOrderByIdDesc();
}
