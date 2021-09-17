package pl.frackiewicz.vtuberapi.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import pl.frackiewicz.vtuberapi.entity.Organisation;

import java.io.IOException;
import java.util.Set;

public class OrganizationSetSerializer extends JsonSerializer<Set<Organisation>> {

    @Override
    public void serialize(Set<Organisation> organisations, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStartArray("organisations");
        for (Organisation organisation : organisations) {
            jsonGenerator.writeStartObject();
            jsonGenerator.writeStringField("id", organisation.getId().toString());
            jsonGenerator.writeStringField("name", organisation.getName());
            jsonGenerator.writeEndObject();
        }
        jsonGenerator.writeEndArray();
        jsonGenerator.writeEndObject();
    }
}
