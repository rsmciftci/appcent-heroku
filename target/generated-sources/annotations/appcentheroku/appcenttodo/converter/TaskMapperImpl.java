package appcentheroku.appcenttodo.converter;

import appcentheroku.appcenttodo.dto.TaskDto;
import appcentheroku.appcenttodo.dto.TaskSavingDto;
import appcentheroku.appcenttodo.dto.TaskUpdatingDto;
import appcentheroku.appcenttodo.entity.Task;
import appcentheroku.appcenttodo.entity.Users;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-02-21T09:04:58+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.13 (Ubuntu)"
)
public class TaskMapperImpl implements TaskMapper {

    @Override
    public TaskSavingDto convertTaskToTaskSavingDto(Task task) {
        if ( task == null ) {
            return null;
        }

        TaskSavingDto taskSavingDto = new TaskSavingDto();

        taskSavingDto.setUserId( taskUsersId( task ) );
        taskSavingDto.setTask( task.getTask() );
        taskSavingDto.setDeadlineDate( task.getDeadlineDate() );
        taskSavingDto.setDeadlineTime( task.getDeadlineTime() );

        return taskSavingDto;
    }

    @Override
    public Task convertTaskSavingDtoToTask(TaskSavingDto taskSavingDto) {
        if ( taskSavingDto == null ) {
            return null;
        }

        Task task = new Task();

        task.setUsers( taskSavingDtoToUsers( taskSavingDto ) );
        task.setTask( taskSavingDto.getTask() );
        task.setDeadlineDate( taskSavingDto.getDeadlineDate() );
        task.setDeadlineTime( taskSavingDto.getDeadlineTime() );

        return task;
    }

    @Override
    public Task convertTaskUpdatingDtoToTask(TaskUpdatingDto taskUpdatingDto) {
        if ( taskUpdatingDto == null ) {
            return null;
        }

        Task task = new Task();

        task.setUsers( taskUpdatingDtoToUsers( taskUpdatingDto ) );
        task.setId( taskUpdatingDto.getId() );
        task.setTask( taskUpdatingDto.getTask() );
        task.setCreationDateTime( taskUpdatingDto.getCreationDateTime() );
        task.setDeadlineDate( taskUpdatingDto.getDeadlineDate() );
        task.setDeadlineTime( taskUpdatingDto.getDeadlineTime() );
        task.setDone( taskUpdatingDto.isDone() );

        return task;
    }

    @Override
    public TaskUpdatingDto convertTaskToTaskUpdatingDto(Task task) {
        if ( task == null ) {
            return null;
        }

        TaskUpdatingDto taskUpdatingDto = new TaskUpdatingDto();

        taskUpdatingDto.setUserId( taskUsersId( task ) );
        taskUpdatingDto.setId( task.getId() );
        taskUpdatingDto.setTask( task.getTask() );
        taskUpdatingDto.setDone( task.isDone() );
        taskUpdatingDto.setCreationDateTime( task.getCreationDateTime() );
        taskUpdatingDto.setDeadlineDate( task.getDeadlineDate() );
        taskUpdatingDto.setDeadlineTime( task.getDeadlineTime() );

        return taskUpdatingDto;
    }

    @Override
    public TaskDto convertTaskToTaskDto(Task task) {
        if ( task == null ) {
            return null;
        }

        TaskDto taskDto = new TaskDto();

        taskDto.setUserId( taskUsersId( task ) );
        taskDto.setId( task.getId() );
        taskDto.setTask( task.getTask() );
        taskDto.setUpdatedDateTime( task.getUpdatedDateTime() );
        taskDto.setCreationDateTime( task.getCreationDateTime() );
        taskDto.setDeadlineDate( task.getDeadlineDate() );
        taskDto.setDeadlineTime( task.getDeadlineTime() );
        taskDto.setDone( task.isDone() );

        return taskDto;
    }

    @Override
    public List<TaskDto> convertTaskListToTaskDtoList(List<Task> taskList) {
        if ( taskList == null ) {
            return null;
        }

        List<TaskDto> list = new ArrayList<TaskDto>( taskList.size() );
        for ( Task task : taskList ) {
            list.add( convertTaskToTaskDto( task ) );
        }

        return list;
    }

    private Long taskUsersId(Task task) {
        if ( task == null ) {
            return null;
        }
        Users users = task.getUsers();
        if ( users == null ) {
            return null;
        }
        Long id = users.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected Users taskSavingDtoToUsers(TaskSavingDto taskSavingDto) {
        if ( taskSavingDto == null ) {
            return null;
        }

        Users users = new Users();

        users.setId( taskSavingDto.getUserId() );

        return users;
    }

    protected Users taskUpdatingDtoToUsers(TaskUpdatingDto taskUpdatingDto) {
        if ( taskUpdatingDto == null ) {
            return null;
        }

        Users users = new Users();

        users.setId( taskUpdatingDto.getUserId() );

        return users;
    }
}
