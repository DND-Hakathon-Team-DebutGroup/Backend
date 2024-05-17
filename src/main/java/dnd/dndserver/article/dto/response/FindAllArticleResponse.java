package dnd.dndserver.article.dto.response;

import dnd.dndserver.article.domain.Article;

import java.util.List;

public record FindAllArticleResponse(
        List<Article> articles
) {

    public static FindAllArticleResponse from(List<Article> articles) {
        return new FindAllArticleResponse(articles);
    }
}
