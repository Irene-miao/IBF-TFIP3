package revision.day37.repository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import revision.day37.model.Photo;
import revision.day37.model.Queries;


@Repository
public class PhotoRepository {
    
    @Autowired
    private JdbcTemplate template;


    public Optional<Photo> findPhotoById(Integer photoId) {
        
        Optional<Photo> opt = template.query(Queries.SQL_GET_PHOTO_BY_ID, rs -> {
            if (!rs.next()) {
                return Optional.empty();
            }
            Photo p = new Photo(photoId, rs.getString("title"), rs.getString("media_type"),
            rs.getBytes("content"));
            return Optional.of(p);
        },
        photoId
        );
        return opt;
    }


    public boolean save(String title, String contentType, byte[] content) {
        return template.update(Queries.SQL_SAVE_PHOTO, title, contentType, content) > 0;
    }

}
