package com.audit.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.audit.exception.ProjectManagerNotFoundException;
import com.audit.model.ProjectManagerDetails;
import com.audit.repository.ProjectManagerRepo;
import com.audit.service.ProjectManagerDetailsService;

@ExtendWith(MockitoExtension.class)
public class ProjectManagerServiceTest {

	@Mock
	private ProjectManagerRepo projectManagerRepo;

	@InjectMocks
	private ProjectManagerDetailsService projectManagerDetailsService; // the real one to assert

	@Test
	public void getProjectManagerByUserNameTest() throws ProjectManagerNotFoundException {
		String username1 = "user1";
		ProjectManagerDetails projectManagerDetails = null;
		// test ProjectManager object -- for correct
		projectManagerDetails = new ProjectManagerDetails();
		projectManagerDetails.setId(1);
		projectManagerDetails.setName("user1"); // same username
		projectManagerDetails.setPassword("abcd1234");
		projectManagerDetails.setProjectName("Project1");
		when(projectManagerRepo.getProjectManagerByUserName(username1)).thenReturn(projectManagerDetails);
		assertEquals(projectManagerDetails, projectManagerDetailsService.getProjectManagerByUserName(username1));

		// test ProjectManager object -- for wrong
		final String username2 = "invalidUser1";
		projectManagerDetails = null;
		when(projectManagerRepo.getProjectManagerByUserName(username2))
				.thenThrow(ProjectManagerNotFoundException.class);
		assertThrows(ProjectManagerNotFoundException.class,
				() -> projectManagerDetailsService.getProjectManagerByUserName(username2));

	}
}
