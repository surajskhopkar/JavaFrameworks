package com.pojo;

import java.util.Arrays;

public class EngineerRepairCompletePOJO {
	
	private int job_id;
	private Problem[] problems;
	public EngineerRepairCompletePOJO(int job_id, Problem[] problems) {
		super();
		this.job_id = job_id;
		this.problems = problems;
	}
	@Override
	public String toString() {
		return "EngineerRepairCompletePOJO [job_id=" + job_id + ", problems=" + Arrays.toString(problems) + "]";
	}
	
	

}
