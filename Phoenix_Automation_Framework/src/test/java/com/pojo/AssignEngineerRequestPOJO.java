package com.pojo;

public class AssignEngineerRequestPOJO {
	
	private int job_id;
	private int engineer_id;
	public AssignEngineerRequestPOJO(int job_id, int engineer_id) {
		super();
		this.job_id = job_id;
		this.engineer_id = engineer_id;
	}
	@Override
	public String toString() {
		return "AssignEngineerRequestPOJO [job_id=" + job_id + ", engineer_id=" + engineer_id + "]";
	}
	
	

}
