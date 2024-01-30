package com.runner;
import com.pojo.AssignEngineerRequestPOJO;
import com.pojo.CreateJobRequestPOJO;
import com.pojo.Customer;
import com.pojo.CustomerAddress;
import com.pojo.CustomerProduct;
import com.pojo.EngineerRepairCompletePOJO;
import com.pojo.JobSearchPOJO;
import com.pojo.LoginRequestPOJO;
import com.pojo.Problem;
import com.pojo.QCAcceptAPIRequestPOJO;
import com.util.TestUtility;

public class Runner {

	public static void main(String[] args) {
		
		LoginRequestPOJO loginRequestPOJO = new LoginRequestPOJO("iamfd","password");
		System.out.println(TestUtility.convertToJson(loginRequestPOJO));
		Customer customer = new Customer("Suraj", "Khopkar", "4545454545", "", "surajkhopkar88@gmail.com", "surajkhopkar88@gmail.com");
		
		CustomerAddress customer_address = new CustomerAddress("807", "Heaven", "Aamrai", "smart point", "100 feet road", "421306", "India", "Maharashtra");
		CustomerProduct customer_product = new CustomerProduct("2023-12-02T18:30:00.000Z", "12345678912345", "12345678912345", "12345678912345", "2023-12-02T18:30:00.000Z", 3, 3);
		Problem[] myproblem = new Problem[1];
		myproblem[0] = new Problem(1, "battery issue");
		CreateJobRequestPOJO createJobRequestPOJO = new CreateJobRequestPOJO(0, 2, 1, 2, customer, customer_address, customer_product,myproblem);
		System.out.println(TestUtility.convertToJson(createJobRequestPOJO));
		
		JobSearchPOJO job_search = new JobSearchPOJO("JOB_28616");
		System.out.println(TestUtility.convertToJson(job_search));
		
		AssignEngineerRequestPOJO assignEngineerRequestPOJO = new AssignEngineerRequestPOJO(TestUtility.jobId, 2);
		System.out.println(TestUtility.convertToJson(assignEngineerRequestPOJO));
		
		myproblem[0] = new Problem(2, "fixed");
		EngineerRepairCompletePOJO engineerRepairCompletePOJO = new EngineerRepairCompletePOJO(2, myproblem);
		System.out.println(TestUtility.convertToJson(engineerRepairCompletePOJO));
		
		QCAcceptAPIRequestPOJO qcAcceptAPIRequestPOJO = new QCAcceptAPIRequestPOJO("JOB_28616");
		System.out.println(TestUtility.convertToJson(qcAcceptAPIRequestPOJO));
		}

}
