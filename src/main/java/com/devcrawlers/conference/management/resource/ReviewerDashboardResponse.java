package com.devcrawlers.conference.management.resource;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ReviewerDashboardResponse {

	private String totalApprovedResearches;
	
	private String totalRejectedResearches;
	
	private String totalApprovedWorkshops;
	
	private String totalRejectedWorkshops;

	public String getTotalApprovedResearches() {
		return totalApprovedResearches;
	}

	public void setTotalApprovedResearches(String totalApprovedResearches) {
		this.totalApprovedResearches = totalApprovedResearches;
	}

	public String getTotalRejectedResearches() {
		return totalRejectedResearches;
	}

	public void setTotalRejectedResearches(String totalRejectedResearches) {
		this.totalRejectedResearches = totalRejectedResearches;
	}

	public String getTotalApprovedWorkshops() {
		return totalApprovedWorkshops;
	}

	public void setTotalApprovedWorkshops(String totalApprovedWorkshops) {
		this.totalApprovedWorkshops = totalApprovedWorkshops;
	}

	public String getTotalRejectedWorkshops() {
		return totalRejectedWorkshops;
	}

	public void setTotalRejectedWorkshops(String totalRejectedWorkshops) {
		this.totalRejectedWorkshops = totalRejectedWorkshops;
	}
	
}
