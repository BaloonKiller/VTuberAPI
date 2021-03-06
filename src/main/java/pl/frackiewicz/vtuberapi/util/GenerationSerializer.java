package pl.frackiewicz.vtuberapi.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.springframework.boot.jackson.JsonComponent;
import pl.frackiewicz.vtuberapi.entity.Generation;

import java.io.IOException;

public class GenerationSerializer extends StdSerializer<Generation> {
    public GenerationSerializer() {
        this(null);
    }

    public GenerationSerializer(Class<Generation> t) {
        super(t);
    }

    @Override
    public void serialize(Generation generation, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("id", generation.getId().toString());
        jsonGenerator.writeStringField("name", generation.getName());
        jsonGenerator.writeEndObject();
    }
}
