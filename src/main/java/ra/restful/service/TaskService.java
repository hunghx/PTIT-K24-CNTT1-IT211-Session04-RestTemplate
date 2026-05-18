package ra.restful.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ra.restful.dto.response.TaskDetailResponse;
import ra.restful.dto.response.TaskResponse;
import ra.restful.exception.NotFoundException;
import ra.restful.repository.TaskRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;
    public List<TaskResponse> findAll(){
        return taskRepository.findAllTasks();
    }
    public TaskDetailResponse findById(String id) throws NotFoundException{
        return taskRepository.findByIdDetail(id)
                .orElseThrow(() -> new NotFoundException("ID ko tồn tại"));
    }
}
