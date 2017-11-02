package com.trios.collaborate.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.trios.collaborate.model.Job;

@Repository("jobDAO")
@Transactional
public class JobDAOImpl implements JobDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	public JobDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}



	public void createJob(Job job) {
		Session session=sessionFactory.getCurrentSession();
		session.save(job);
		
	}

	public Job getJob(int jobId) {
		Session session=sessionFactory.getCurrentSession();
		Job job = (Job) session.get(Job.class, jobId);
		
		return job;
	}

	public List<Job> getJobs() {
		Session session=sessionFactory.getCurrentSession();
		Query query = session.createQuery("From Job");
		
		return query.list();
	}
	
	

	public boolean deleteJob(int jobId) {
		try {
			Session session = sessionFactory.openSession();
			Job job = (Job) session.get(Job.class, jobId);
			session.delete(job);
			session.flush();
			session.close();
			return true;
		} catch (Exception e) {
			System.out.println("Exception Arised:" + e);
		}
		return false;
	}

}
