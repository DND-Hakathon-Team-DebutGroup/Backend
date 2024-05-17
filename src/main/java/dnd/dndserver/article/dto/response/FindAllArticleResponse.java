package dnd.dndserver.article.dto.response;

import dnd.dndserver.article.domain.Article;

import java.util.List;

public record FindAllArticleResponse(
        List<FindArticleResponse> articles
) {

    public static FindAllArticleResponse from(List<FindArticleResponse> articles) {
        return new FindAllArticleResponse(articles);
    }
}
