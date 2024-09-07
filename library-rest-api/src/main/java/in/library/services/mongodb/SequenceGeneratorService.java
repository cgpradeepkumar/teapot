package in.library.services.mongodb;

import in.library.services.mongodb.documents.Sequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service("sequenceGeneratorService")
public class SequenceGeneratorService {
    // https://www.baeldung.com/spring-boot-mongodb-auto-generated-field
    // https://www.mkyong.com/mongodb/spring-data-mongodb-auto-sequence-id-example/
    // https://www.tutorialspoint.com/mongodb/mongodb_query_document.htm

    private MongoOperations mongoOperations;

    @Autowired
    public SequenceGeneratorService(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    public long generateSequence(String sequenceName) {
        Sequence sequence = mongoOperations.findAndModify(Query.query(Criteria.where("_id").is(sequenceName)), new Update().inc("seq", 1), FindAndModifyOptions.options().returnNew(true).upsert(true), Sequence.class);
        return !Objects.isNull(sequence) ? sequence.getSeq() : 1;
    }
}
