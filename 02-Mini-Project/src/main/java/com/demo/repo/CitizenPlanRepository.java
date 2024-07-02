package com.demo.repo;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entity.CitizenPlan;

public interface CitizenPlanRepository  extends JpaRepository<CitizenPlan, Serializable>{

	List<String> getPlanNames();

	List<String> getPlanStatuses();

}
