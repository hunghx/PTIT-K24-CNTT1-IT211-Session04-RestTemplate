package ra.restful.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLUpdate;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data // getter và setter
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id; // tự động tạo ra 1 chuỗi 36 kí tự trên hàm thời gian

    private String name;
    private String description;
    private LocalDateTime startAt;
    private LocalDateTime endAt;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private String manager;
    private String member;
    @Enumerated(EnumType.STRING)
    private TaskStatus status;
    @ManyToOne
    @JoinColumn(name="student_id",foreignKey = @ForeignKey(name = "abc"))
    private Student student;
    private Boolean isDeleted;


    @PrePersist
    public void prePersist(){
//        trước khi thêm thì thực hiện logic này
        createdAt = LocalDateTime.now();
        isDeleted = false;
        status = TaskStatus.PENDING;
    }
}
