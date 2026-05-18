package ra.restful.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ra.restful.entity.Task;
import ra.restful.entity.TaskStatus;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskDetailResponse {
    private String id; // tự động tạo ra 1 chuỗi 36 kí tự trên hàm thời gian

    private String name;
    private String description;
    private LocalDateTime startAt;
    private LocalDateTime endAt;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private String manager;
    private String member;
    private TaskStatus status;
    public TaskDetailResponse(Task entity){
        this.id = entity.getId();
        this.name = entity.getName();
        this.description = entity.getDescription();
        this.startAt = entity.getStartAt();
        this.endAt = entity.getEndAt();
        this.createdAt = entity.getCreatedAt();
        this.updatedAt = entity.getUpdatedAt();
        this.manager = entity.getManager();
        this.member = entity.getMember();
        this.status = entity.getStatus();
    }
}
