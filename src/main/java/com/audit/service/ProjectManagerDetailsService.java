package com.audit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.audit.exception.ProjectManagerNotFoundException;
import com.audit.model.ProjectManagerDetails;
import com.audit.repository.ProjectManagerRepo;

@Service
public class ProjectManagerDetailsService implements UserDetailsService {

	@Autowired
	private ProjectManagerRepo projectManagerRepo;

	@Override
	public ProjectManagerDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		ProjectManagerDetails projectManagerDetails = null;
		projectManagerDetails = getProjectManagerByUserName(username);
		if (projectManagerDetails != null) {
			projectManagerDetails = new ProjectManagerDetails(getProjectManagerByUserName(username));
		}

		return projectManagerDetails;
	}

	public ProjectManagerDetails getProjectManagerByUserName(String username) throws ProjectManagerNotFoundException {
		ProjectManagerDetails projectManagerDetails = null;
		projectManagerDetails = projectManagerRepo.getProjectManagerByUserName(username);
		if (projectManagerDetails == null) {
			throw new ProjectManagerNotFoundException("Given Project-Manager-Details does not exist in our Database!!");
		}
		return projectManagerDetails;
	}

}
