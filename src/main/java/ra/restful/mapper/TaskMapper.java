package ra.restful.mapper;


import ra.restful.dto.response.TaskDetailResponse;
import ra.restful.entity.Task;

public class TaskMapper {
    public static TaskDetailResponse mapToResponseDetails(Task entity){
        return new TaskDetailResponse(
                entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.getStartAt(),
                entity.getEndAt(),
                entity.getCreatedAt(),
                entity.getUpdatedAt(),
                entity.getManager(),
                entity.getMember(),
                entity.getStatus()
        );
    }
}
