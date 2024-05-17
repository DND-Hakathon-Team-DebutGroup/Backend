package dnd.dndserver.user.dto;

import dnd.dndserver.file.ImageFile;
import io.swagger.v3.oas.annotations.Hidden;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@AllArgsConstructor
public class UserJoinDto {

    String nickName;

    String uuid;

    ImageFile imageFile;
}
