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
public class JobDAOImpl implements JobDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	public JobDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	@Transactional
	public boolean createJob(Job job) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(job);
			return true;
		} catch (Exception e) {
			System.out.println("Exception Arised:" + e);
		}
		return false;
	}

	public Job getJob(int jobId) {
		Session session = sessionFactory.openSession();
		Job job = (Job) session.get(Job.class, jobId);
		session.close();
		return job;
	}

	public List<Job> getJobs() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("From Job where status='A'");
		List<Job> listJob = query.list();
		session.close();
		return listJob;
	}
	@Transactional
	public boolean approveJob(Job job) {
		try {
			job.setStatus("A");
			sessionFactory.getCurrentSession().saveOrUpdate(job);
			return true;
		} catch (Exception e) {
			System.out.println("Exception Arised:" + e);
		}
		return false;
	}

	public boolean editJob(int jobId) {
		// TODO Auto-generated method stub
		return false;
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
