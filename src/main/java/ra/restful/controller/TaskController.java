package ra.restful.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ra.restful.dto.request.TaskAdd;
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
    public ResponseEntity<?> findById(@PathVariable("id") String id) throws NotFoundException{
//        try{
            return ResponseEntity.ok(taskService.findById(id)); // 200
//        }catch (NotFoundException ex){
//            return ResponseEntity.notFound().build(); // 404
//        }
    }

    @PostMapping
    public ResponseEntity<?> addTask(@Valid @RequestBody TaskAdd request){
//        if(rs.hasErrors()){
//            // trả về lỗi 400
//        }
        // trả về thành công
        return ResponseEntity.ok("Thành công");
    }
}
