package linad.FraimworkHWLes5;

import linad.FraimworkHWLes5.model.Task;
import linad.FraimworkHWLes5.repos.TaskRepos;
import linad.FraimworkHWLes5.service.TaskService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class FraimworkHwLes5ApplicationTests {
	@InjectMocks
	private TaskService service;
	@Mock
	private TaskRepos repos;

	@Test
	public void testAddTask() {
		Task task = new Task();
		task.setId(1);
		task.setName("name");
		task.setText("text");

		service.addTask(task);

		verify(repos).save(task);
	}

}
