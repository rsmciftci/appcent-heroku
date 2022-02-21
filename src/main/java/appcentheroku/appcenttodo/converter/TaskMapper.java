package appcentheroku.appcenttodo.converter;

import appcentheroku.appcenttodo.dto.TaskDto;
import appcentheroku.appcenttodo.dto.TaskSavingDto;
import appcentheroku.appcenttodo.dto.TaskUpdatingDto;
import appcentheroku.appcenttodo.entity.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TaskMapper {

    TaskMapper INSTANCE = Mappers.getMapper(TaskMapper.class);

    @Mapping(source = "users.id", target = "userId")
    TaskSavingDto convertTaskToTaskSavingDto(Task task);

    @Mapping(target = "users.id", source = "userId")
    Task convertTaskSavingDtoToTask(TaskSavingDto taskSavingDto);

    @Mapping(target = "users.id", source = "userId")
    Task convertTaskUpdatingDtoToTask(TaskUpdatingDto taskUpdatingDto);

    @Mapping(source = "users.id", target = "userId")
    TaskUpdatingDto convertTaskToTaskUpdatingDto(Task task);

    @Mapping(source = "users.id", target = "userId" )
    TaskDto convertTaskToTaskDto(Task task);

    @Mapping(source = "users.id", target = "userId" )
    List<TaskDto> convertTaskListToTaskDtoList(List<Task> taskList);
}
