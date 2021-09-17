package pl.frackiewicz.vtuberapi.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.springframework.boot.jackson.JsonComponent;
import pl.frackiewicz.vtuberapi.entity.Organisation;

import java.io.IOException;
import java.util.Set;

public class OrganizationSetSerializer extends StdSerializer<Set<Organisation>> {
    public OrganizationSetSerializer() {
        this(null);
    }

    public OrganizationSetSerializer(Class<Set<Organisation>> t) {
        super(t);
    }

    @Override
    public void serialize(Set<Organisation> organisations, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        for (Organisation organisation : organisations) {
            jsonGenerator.writeStartObject();
            jsonGenerator.writeStringField("id", organisation.getId().toString());
            jsonGenerator.writeStringField("name", organisation.getName());
            jsonGenerator.writeEndObject();
        }
        jsonGenerator.writeEndObject();
    }
}
