package dnd.dndserver.article.presentation;

import dnd.dndserver.article.application.ArticleService;
import dnd.dndserver.article.dto.request.FindArticleRequest;
import dnd.dndserver.article.dto.request.SaveArticleRequest;
import dnd.dndserver.article.dto.response.FindAllArticleResponse;
import dnd.dndserver.article.dto.response.SaveArticleResponse;
import dnd.dndserver.global.handler.ResponseHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequiredArgsConstructor
@RestController
@RequestMapping("/article")
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping
    public ResponseEntity<ResponseHandler<FindAllArticleResponse>> find(
            @ModelAttribute FindArticleRequest request
    ) {
        return ResponseEntity.ok()
                .body(ResponseHandler.<FindAllArticleResponse>builder()
                        .statusCode(HttpStatus.OK)
                        .data(articleService.find(request))
                        .build()
                );
    }

    @PostMapping(consumes = {"multipart/form-data"})
    public ResponseEntity<ResponseHandler<SaveArticleResponse>> save(
            @RequestPart("request") SaveArticleRequest request,
            @RequestPart("file") MultipartFile file
    ) throws IOException {
        return ResponseEntity.ok()
                .body(ResponseHandler.<SaveArticleResponse>builder()
                        .statusCode(HttpStatus.OK)
                        .data(articleService.save(request, file))
                        .build()
                );
    }
}
