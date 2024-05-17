package dnd.dndserver.user.dto;

import dnd.dndserver.article.dto.response.FindArticleResponse;
import java.util.List;

public record UserMyPageResponse(
        String user,
        String profileImage,
        List<FindArticleResponse> articles
) {

    public static UserMyPageResponse from(String user, String profileImage, List<FindArticleResponse> articles) {
        return new UserMyPageResponse(user, profileImage, articles);
    }
}

