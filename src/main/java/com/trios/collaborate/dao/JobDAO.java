package com.trios.collaborate.dao;

import java.util.List;


import com.trios.collaborate.model.Job;

public interface JobDAO {
	public boolean createJob(Job job);
	public Job getJob(int jobId);
	public List<Job> getJobs();
	public boolean approveJob(Job job);
	public boolean editJob(int jobId);
	public boolean deleteJob(int jobId);
	
}
