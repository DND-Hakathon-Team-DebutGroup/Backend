package dnd.dndserver.user;

import dnd.dndserver.user.application.repository.UserRepository;
import dnd.dndserver.user.dto.UserLoginRequest;
import io.swagger.v3.oas.annotations.Hidden;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;

    @GetMapping("/login")
    public Result login(@RequestPart(value = "imageFile", required = false) MultipartFile imageFile,
                        @RequestPart("userLoginRequest") UserLoginRequest userLoginRequest) {
        return new Result("로그인이 필요합니다.₩₩₩");
    }
}
