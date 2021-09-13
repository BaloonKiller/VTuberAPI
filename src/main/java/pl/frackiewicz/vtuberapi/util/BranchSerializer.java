package pl.frackiewicz.vtuberapi.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import pl.frackiewicz.vtuberapi.entity.Branch;
import pl.frackiewicz.vtuberapi.entity.Generation;
import pl.frackiewicz.vtuberapi.entity.VTuber;

import java.io.IOException;


public class BranchSerializer extends JsonSerializer<Branch> {
    @Override
    public void serialize(Branch branch, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("id", branch.getId().toString());
        jsonGenerator.writeStringField("name", branch.getName());
        jsonGenerator.writeEndObject();
    }
}
