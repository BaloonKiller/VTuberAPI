package pl.frackiewicz.vtuberapi.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import pl.frackiewicz.vtuberapi.entity.VTuber;

import java.io.IOException;

public class VTuberSerializer extends JsonSerializer<VTuber> {
    @Override
    public void serialize(VTuber vTuber, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("id", vTuber.getId().toString());
        jsonGenerator.writeStringField("firstname", vTuber.getFirstName());
        jsonGenerator.writeStringField("lastname", vTuber.getLastName());
        jsonGenerator.writeEndObject();
    }
}
