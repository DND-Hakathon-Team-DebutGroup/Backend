package dnd.dndserver.article.presentation;

import dnd.dndserver.article.application.ArticleService;
import dnd.dndserver.article.dto.request.FindArticleRequest;
import dnd.dndserver.article.dto.response.FindAllArticleResponse;
import dnd.dndserver.global.handler.ResponseHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
