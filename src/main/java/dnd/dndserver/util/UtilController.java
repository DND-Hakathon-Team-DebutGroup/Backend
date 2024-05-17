package dnd.dndserver.util;

import dnd.dndserver.article.dto.request.SaveArticleRequest;
import dnd.dndserver.article.dto.response.SaveArticleResponse;
import dnd.dndserver.file.FileStore;
import dnd.dndserver.global.handler.ResponseHandler;
import dnd.dndserver.util.dto.SaveImageResponse;
import io.swagger.v3.oas.annotations.Hidden;
import java.io.IOException;
import java.net.MalformedURLException;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
public class UtilController {

    private final FileStore fileStore;
    private final UtilService utilService;

    @ResponseBody
    @GetMapping("/images/{filename}")
    public Resource downloadImage(@PathVariable("filename") String filename) throws MalformedURLException {
        return new UrlResource("file:" + fileStore.getFullPath(filename));
    }

    @GetMapping("/users/nickname")
    public RandomNickNameResponse createRandomNickname() {
        return new RandomNickNameResponse(CreateRandomNickName.generateRandomNickName());
    }

    @PostMapping(value = "/images", consumes = {"multipart/form-data"})
    public ResponseEntity<ResponseHandler<SaveImageResponse>> save(@RequestPart("file") MultipartFile file)
            throws IOException {
        return ResponseEntity.ok()
                .body(ResponseHandler.<SaveImageResponse>builder()
                        .statusCode(HttpStatus.OK)
                        .data(utilService.saveImage(file))
                        .build()
                );
    }
}
