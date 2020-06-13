package fr.cesi.qcm.repositories;

import fr.cesi.qcm.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long>{

}
