package com.trios.collaborate.dao;

import java.util.List;


import com.trios.collaborate.model.Job;

public interface JobDAO {
	public void createJob(Job job);
	public Job getJob(int jobId);
	public List<Job> getJobs();
	
	public boolean deleteJob(int jobId);
	
}
