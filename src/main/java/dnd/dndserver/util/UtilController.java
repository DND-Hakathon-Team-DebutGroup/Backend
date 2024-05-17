package dnd.dndserver.util;

import dnd.dndserver.file.FileStore;
import io.swagger.v3.oas.annotations.Hidden;
import java.net.MalformedURLException;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UtilController {

    private final FileStore fileStore;

    @ResponseBody
    @GetMapping("/images/{filename}")
    public Resource downloadImage(@PathVariable("filename") String filename) throws MalformedURLException {
        return new UrlResource("file:" + fileStore.getFullPath(filename));
    }

    @GetMapping("/users/nickname")
    public RandomNickNameResponse createRandomNickname() {
        return new RandomNickNameResponse(CreateRandomNickName.generateRandomNickName());
    }
}
