package ra.restful.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component // thành phần chung chung
public class AspectComponent {
    // Bài toán, ghi log trước khi thực hiện bất cứ chức năng nào của TaskService
    // Join Point / Join Cut trước / TaskService
    // Aspect : đoạn code ghi log
    @Before(value = "execution(* ra.restful.service.TaskService.*(..))")
    public void loggingBeforeMethodExecute(JoinPoint joinPoint){
        // ghi log lại
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Đây la phương thức xử lí trước khi bất cứ phương thức nào của TaskService được gọi");
    }

}
