package pl.frackiewicz.vtuberapi.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.springframework.boot.jackson.JsonComponent;
import pl.frackiewicz.vtuberapi.entity.Branch;

import java.io.IOException;
import java.util.Set;

public class BranchSetSerializer extends StdSerializer<Set<Branch>> {

    public BranchSetSerializer() {
        this(null);
    }

    public BranchSetSerializer(Class<Set<Branch>> t) {
        super(t);
    }

    @Override
    public void serialize(Set<Branch> branches, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        for(Branch branch : branches) {
            jsonGenerator.writeStartObject();
            jsonGenerator.writeStringField("id", branch.getId().toString());
            jsonGenerator.writeStringField("name", branch.getName());
            jsonGenerator.writeEndObject();
        }
        jsonGenerator.writeEndObject();
    }
}
