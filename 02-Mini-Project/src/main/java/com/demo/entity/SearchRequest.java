package com.demo.entity;

//import java.time.LocalDate;

public class SearchRequest {
	
	private String planName;
	private String planStatus;
//	private LocalDate startDate;
//	private LocalDate endDate;

	public SearchRequest() {
		
	}

	public SearchRequest(String planName, String planStatus) {
		super();
		this.planName = planName;
		this.planStatus = planStatus;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public String getPlanStatus() {
		return planStatus;
	}

	public void setPlanStatus(String planStatus) {
		this.planStatus = planStatus;
	}

	@Override
	public String toString() {
		return "SearchRequest [planName=" + planName + ", planStatus=" + planStatus + "]";
	}

	

}
