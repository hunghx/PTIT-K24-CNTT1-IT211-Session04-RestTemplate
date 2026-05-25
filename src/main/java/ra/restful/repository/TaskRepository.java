package ra.restful.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ra.restful.dto.response.TaskDetailResponse;
import ra.restful.dto.response.TaskResponse;
import ra.restful.entity.Task;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, String> {
    // đối với các câu lệnh select thì nên sử dụng @Query
    // DTO projection
    @Query("select new  ra.restful.dto.response.TaskDetailResponse(T)" +
            " from Task T WHERE  T.id = :id AND T.isDeleted = false")
    Optional<TaskDetailResponse> findByIdDetail(@Param("id") String id);
    @Query("select new  ra.restful.dto.response.TaskResponse(T)" +
            " from Task T WHERE T.isDeleted = false")
    List<TaskResponse> findAllTasks();

    // phương thức truy vấn
//    @Query("from Task where isDeleted = false ")
//    List<Task> findAll();
   // lấy danh sách công việc theo 1 sinh viên
    @Query() // sau này làm dự án tất cả select đều dùng @query
    List<Task> findByStudent_Id(Long id);
}
