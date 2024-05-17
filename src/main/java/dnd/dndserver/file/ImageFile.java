package dnd.dndserver.file;

import dnd.dndserver.global.entity.BaseTimeEntity;
import dnd.dndserver.user.User;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ImageFile extends BaseTimeEntity {

    @Id
    @GeneratedValue
    @Column(name = "file_id")
    private Long id;

    private String uploadFileName;
    private String storeFileName;

    @OneToOne(mappedBy = "imageFile", cascade = CascadeType.ALL)
    private User user;

    public ImageFile(String uploadFileName, String storeFileName) {
        this.uploadFileName = uploadFileName;
        this.storeFileName = storeFileName;
    }
}