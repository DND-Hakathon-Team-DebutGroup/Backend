package dnd.dndserver.article.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FindArticleResponse {

    private Long id;

    private String city;

    private String district;

    private String town;

    private int temperature;

    private int precipitation;

    private int sunshine;

    private String content;

    private int heart;

    private String user;

    private String fileName;

    private String nowTemp;
}
