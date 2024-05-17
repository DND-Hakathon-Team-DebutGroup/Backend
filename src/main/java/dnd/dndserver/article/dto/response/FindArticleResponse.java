package dnd.dndserver.article.dto.response;

import dnd.dndserver.file.ImageFile;
import dnd.dndserver.user.User;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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
}
