package dnd.dndserver.util;

import dnd.dndserver.file.FileStore;
import dnd.dndserver.util.dto.SaveImageResponse;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@Transactional
@RequiredArgsConstructor
public class UtilService {
    private final FileStore fileStore;

    public SaveImageResponse saveImage(MultipartFile multipartFile) throws IOException {
        return new SaveImageResponse(fileStore.storeFile(multipartFile).getStoreFileName());
    }
}
