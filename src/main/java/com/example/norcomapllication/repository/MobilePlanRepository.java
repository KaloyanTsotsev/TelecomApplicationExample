package com.example.norcomapllication.repository;

import com.example.norcomapllication.model.entity.MobilePlanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MobilePlanRepository extends JpaRepository<MobilePlanEntity,Long> {
    List<MobilePlanEntity> getAllByMobilePlanType(String mobilePlanType);
    List<MobilePlanEntity> getAllBy();
}
