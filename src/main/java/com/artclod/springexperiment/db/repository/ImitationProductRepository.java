package com.artclod.springexperiment.db.repository;

import com.artclod.springexperiment.db.entity.ImitationProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ImitationProductRepository extends JpaRepository<ImitationProduct, UUID>  {

//	public List<ImitationProduct> findByScenarioSnapshotIdOrderByStartTimeAscEndTimeAsc(UUID scenarioSnapshotId);

}
