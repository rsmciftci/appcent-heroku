package appcentheroku.appcenttodo.dao;

import appcentheroku.appcenttodo.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TaskDao extends JpaRepository<Task,Long> {

    List<Task> findTasksByUsersId(Long id);

}
