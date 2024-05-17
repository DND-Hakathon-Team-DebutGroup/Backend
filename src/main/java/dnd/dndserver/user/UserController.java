package dnd.dndserver.user;

import dnd.dndserver.user.application.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;

//    @GetMapping("/login")
//    public Result login(@RequestPart(value = "imageFile", required = false) MultipartFile imageFile,
//                        @RequestPart("userLoginRequest") UserLoginRequest userLoginRequest) {
//        return new Result("로그인이 필요합니다.₩₩₩");
//    }
}
