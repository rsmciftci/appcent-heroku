package appcentheroku.appcenttodo.service;

import appcentheroku.appcenttodo.converter.TaskMapper;
import appcentheroku.appcenttodo.dao.TaskDao;
import appcentheroku.appcenttodo.dto.TaskDto;
import appcentheroku.appcenttodo.dto.TaskSavingDto;
import appcentheroku.appcenttodo.dto.TaskUpdatingDto;
import appcentheroku.appcenttodo.entity.Task;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskDao taskDao;



    public TaskSavingDto save(TaskSavingDto taskSavingDto){

        Task task = TaskMapper.INSTANCE.convertTaskSavingDtoToTask(taskSavingDto);
        task.setCreationDateTime(LocalDateTime.now());
        task.setDone(false);
        task = taskDao.save(task);

        TaskSavingDto savedTaskSavingDto = TaskMapper.INSTANCE.convertTaskToTaskSavingDto(task);

        return savedTaskSavingDto;
    }

    public void delete(Long id) {
        Optional<Task> optionalTask = taskDao.findById(id);
        if (optionalTask.isPresent()){
            taskDao.deleteById(id);
        }
    }


    public TaskUpdatingDto update(TaskUpdatingDto taskUpdatingDto) {


        Task task = TaskMapper.INSTANCE.convertTaskUpdatingDtoToTask(taskUpdatingDto);
        task.setUpdatedDateTime(LocalDateTime.now());

        task = taskDao.save(task);

        TaskUpdatingDto updatedTask = TaskMapper.INSTANCE.convertTaskToTaskUpdatingDto(task);
        return  updatedTask;

    }

    public List<TaskDto> findAllByUserId(Long userId){
        List<Task> taskList = taskDao.findTasksByUsersId(userId);
        List<TaskDto> taskDtoList = TaskMapper.INSTANCE.convertTaskListToTaskDtoList(taskList);
        return  taskDtoList;
    }


    public TaskDto findById(Long taskId) {
        Optional<Task> optionalTask = taskDao.findById(taskId);
        Task task = null;
        if(optionalTask.isPresent()){
            task = optionalTask.get();
        }
        TaskDto taskDto = TaskMapper.INSTANCE.convertTaskToTaskDto(task);
        return taskDto;
    }


}
