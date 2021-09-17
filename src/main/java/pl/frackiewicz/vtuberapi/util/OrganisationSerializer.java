package pl.frackiewicz.vtuberapi.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import pl.frackiewicz.vtuberapi.entity.Organisation;

import java.io.IOException;

public class OrganisationSerializer extends StdSerializer<Organisation> {
    public OrganisationSerializer() {
        this(null);
    }

    public OrganisationSerializer(Class<Organisation> t) {
        super(t);
    }

    @Override
        public void serialize(Organisation organisation, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
            jsonGenerator.writeStartObject();
            jsonGenerator.writeStringField("id", organisation.getId().toString());
            jsonGenerator.writeStringField("name", organisation.getName());
            jsonGenerator.writeEndObject();
        }
}
