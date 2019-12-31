package com.warning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.warning.model.WarningModel;

public interface WarningModelRepository extends JpaRepository<WarningModel, Integer>, JpaSpecificationExecutor<WarningModel> {

}
