package pl.frackiewicz.vtuberapi.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import pl.frackiewicz.vtuberapi.entity.Branch;

import java.io.IOException;
import java.util.Set;

public class BranchSetSerializer extends JsonSerializer<Set<Branch>> {
    @Override
    public void serialize(Set<Branch> branches, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStartArray("branches");
        for(Branch branch : branches) {
            jsonGenerator.writeStartObject();
            jsonGenerator.writeStringField("id", branch.getId().toString());
            jsonGenerator.writeStringField("name", branch.getName());
            jsonGenerator.writeEndObject();
        }
        jsonGenerator.writeEndArray();
        jsonGenerator.writeEndObject();
    }
}
