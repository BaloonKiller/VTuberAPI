package pl.frackiewicz.vtuberapi.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import pl.frackiewicz.vtuberapi.entity.VTuber;

import java.io.IOException;
import java.util.Set;

public class VTuberSetSerializer extends JsonSerializer<Set<VTuber>> {
    @Override
    public void serialize(Set<VTuber> vTubers, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStartArray("vtubers");
        for(VTuber vTuber : vTubers) {
            jsonGenerator.writeStartObject();
            jsonGenerator.writeObjectField("id", vTuber.getId());
            jsonGenerator.writeObjectField("lastName", vTuber.getLastName());
            jsonGenerator.writeObjectField("firstName", vTuber.getFirstName());
            jsonGenerator.writeEndObject();
        }
        jsonGenerator.writeEndArray();
        jsonGenerator.writeEndObject();
    }
}
