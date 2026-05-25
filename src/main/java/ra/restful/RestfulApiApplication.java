package ra.restful;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import ra.restful.entity.Task;
import ra.restful.entity.TaskStatus;
import ra.restful.repository.TaskRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
@EnableAspectJAutoProxy
public class RestfulApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestfulApiApplication.class, args);
    }
    @Bean
    public CommandLineRunner runner(TaskRepository repository){ // chạy duy nhất 1 lần khi start ứng dụng
        return args -> {
//            repository.save(new Task(null, "Đi học môn Java", "Học web service", LocalDateTime.of(2026,5,19,0,0,0),LocalDateTime.of(2026,6,19,0,0,0),null, null, "Hung hx","Sơn TX", TaskStatus.IN_PROCESS, false));
            List<Task> list = repository.findByStudentId(10L);

        };
    }
}
