package ra.restful.dto.request;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import lombok.Data;
import ra.restful.entity.TaskStatus;

import java.time.LocalDateTime;
@Data
public class TaskAdd {
   @NotBlank(message = "Ko đc bỏ trống name")// ko đc null hoặc ko đc để trống
    private String name;
    private String description;
    @Past
    private LocalDateTime startAt;
    private LocalDateTime endAt;
    @NotBlank
    private String manager;
    @NotBlank
    private String member;

}
