package revision.day37workshop.repository;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PostRepository {
    

    // Insert data into MongoDB
    @Autowired
    private MongoTemplate template;

    public void insertPost(String postId, String title, String content) {

        Document d = new Document();
        d.put("_id", postId);
        d.put("title", title);
        d.put("content", content);

        // insert document into collection called posts
        template.insert(d, "posts");
    }
}
