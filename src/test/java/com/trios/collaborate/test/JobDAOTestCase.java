package com.trios.collaborate.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.trios.collaborate.dao.JobDAO;

import com.trios.collaborate.model.Job;

public class JobDAOTestCase {


	static JobDAO jobDAO;
             
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext annotationConfigAppContext=new AnnotationConfigApplicationContext();
		annotationConfigAppContext.scan("com.trios.collaborate");
		annotationConfigAppContext.refresh();
		jobDAO=(JobDAO)annotationConfigAppContext.getBean("jobDAO");
	}
	
	
	@Test
	public void createJobTest() {
		Job job=new Job();
		job.setJobId(14);
		
	}
	@Ignore
	@Test
	public void approveJobTest() {
		Job job=new Job();
		job.setJobId(14);
		
	}
	
	@Ignore
	@Test
	public void getJobsTest()
	{
         List<Job> listJob=jobDAO.getJobs();
         assertTrue("No Approved Blogs",listJob.size()>0);
	}
	
	@Ignore
	@Test
	public void deleteJobTest()
	{
		assertTrue("Problem in deleting",jobDAO.deleteJob(14));
	}
	
	@Ignore
	@Test
	public void getJobTest(){
		assertNotNull("Problem in getting job",jobDAO.getJob(14));
	}
}
