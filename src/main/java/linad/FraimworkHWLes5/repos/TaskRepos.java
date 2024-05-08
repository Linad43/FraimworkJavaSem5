package linad.FraimworkHWLes5.repos;

import linad.FraimworkHWLes5.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepos extends JpaRepository<Task, Long> {
}
