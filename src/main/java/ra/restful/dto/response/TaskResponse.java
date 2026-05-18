package ra.restful.dto.response;


import lombok.Data;
import ra.restful.entity.Task;
import ra.restful.entity.TaskStatus;

import java.time.LocalDateTime;
@Data
public class TaskResponse {
    private String id; // tự động tạo ra 1 chuỗi 36 kí tự trên hàm thời gian

    private String name;
    private String description;
    private LocalDateTime startAt;
    private LocalDateTime endAt;
//    private LocalDateTime createdAt;
//    private LocalDateTime updatedAt;

    private String manager;
    private String member;
    private TaskStatus status;

//    private Boolean isDeleted;
    public TaskResponse(Task entity){
        this.id = entity.getId();
        this.name = entity.getName();
        this.description = entity.getDescription();
        this.startAt = entity.getStartAt();
        this.endAt = entity.getEndAt();
        this.manager = entity.getManager();
        this.member = entity.getMember();
        this.status = entity.getStatus();
    }
}
