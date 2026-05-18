package ra.restful.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ra.restful.exception.NotFoundException;
import ra.restful.service.TaskService;

@RestController
@RequestMapping("/hunghx.com/v1/tasks")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;
    // thiết kế các endpoint(uri + method)

    // Lấy danh sách
    @GetMapping
    public ResponseEntity<?> getAllTasks(){
        return ResponseEntity.ok(taskService.findAll()); // 200 thành công
    }
    // Lấy chi tiết theo id
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") String id){
        try{
            return ResponseEntity.ok(taskService.findById(id)); // 200
        }catch (NotFoundException ex){
            return ResponseEntity.notFound().build(); // 404
        }
    }
}
