package com.artclod.springexperiment.db.repository;

import com.artclod.springexperiment.db.entity.ImitationProduct;
import com.artclod.springexperiment.db.entity.OriginalProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OriginalProductRepository extends JpaRepository<OriginalProduct, UUID>  {

//	public List<ImitationProduct> findByScenarioSnapshotIdOrderByStartTimeAscEndTimeAsc(UUID scenarioSnapshotId);

}
