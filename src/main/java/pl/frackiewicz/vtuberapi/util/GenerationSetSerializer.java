package pl.frackiewicz.vtuberapi.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import pl.frackiewicz.vtuberapi.entity.Generation;

import java.io.IOException;
import java.util.Set;

public class GenerationSetSerializer extends JsonSerializer<Set<Generation>> {
    @Override
    public void serialize(Set<Generation> generations, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStartArray("generations");
        for(Generation generation : generations) {
            jsonGenerator.writeStartObject();
            jsonGenerator.writeStringField("id", generation.getId().toString());
            jsonGenerator.writeStringField("name", generation.getName());
            jsonGenerator.writeEndObject();
        }
        jsonGenerator.writeEndArray();
        jsonGenerator.writeEndObject();
    }
}
