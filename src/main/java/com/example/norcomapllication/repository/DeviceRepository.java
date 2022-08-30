package com.example.norcomapllication.repository;

import com.example.norcomapllication.model.entity.DeviceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeviceRepository extends JpaRepository<DeviceEntity,Long> {
    @Query("SELECT d FROM DeviceEntity AS d WHERE d.name LIKE CONCAT('%',:keyword,'%') ")
    List<DeviceEntity> searchDevice(String keyword);

}
