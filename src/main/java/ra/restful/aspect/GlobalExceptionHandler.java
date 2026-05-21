package ra.restful.aspect;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ra.restful.exception.NotFoundException;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice // = RestController + Advice
public class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> handleNotFoundException(NotFoundException ex){
        System.out.println(ex.getMessage());
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handlerMethodArgumentNotValid(MethodArgumentNotValidException e){
        System.out.println(e.getMessage()); // ko đc phép sử dụng
        Map<String , String> err = new HashMap<>();
        e.getFieldErrors().forEach(f ->{
            err.put(f.getField(), f.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(err); // 400
    }

    // MethodArgumentInvalidException : validation  400
    // body :
    /*
            {
                "name": "không để trống",
                "email": "không đúng định dạng"
            }
     */
    // NotFoundException : custom  404
            /*
            body :
            {
                message : "mã sinh viên không tồn tại"
            }
             */
    // DataConflictException : trung dữ liệu custom 409
        /*
        body : {
            message : "email trúng lặp"
        }
         */
    // RuntimeException : 500 ko xử lí đc
        /*
        body : {
            "message": " Lỗi Server ..."
        }
         */

}
