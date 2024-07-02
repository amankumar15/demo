package com.demo.service;

import java.util.List;

import com.demo.entity.CitizenPlan;
import com.demo.entity.SearchRequest;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface ReportService {
	
	
	public List<String> getPlanNames();
	public List<String> getPlanStatuses();
	public List<CitizenPlan> getCitizenPlans(SearchRequest request);
	public void exportExcel(HttpServletResponse response) throws Exception;
	public void exportPdf(HttpServletRequest response)throws Exception;
}
