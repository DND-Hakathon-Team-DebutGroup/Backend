package dnd.dndserver.article.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SaveArticleResponse {
    String user;
    String content;
}
