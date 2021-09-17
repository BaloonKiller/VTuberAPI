package pl.frackiewicz.vtuberapi.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import pl.frackiewicz.vtuberapi.entity.VTuber;

import java.io.IOException;
import java.util.Set;

public class VTuberSetSerializer extends StdSerializer<Set<VTuber>> {
    public VTuberSetSerializer() {
        this(null);
    }

    public VTuberSetSerializer(Class<Set<VTuber>> t) {
        super(t);
    }

    @Override
    public void serialize(Set<VTuber> vTubers, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        for(VTuber vTuber : vTubers) {
            jsonGenerator.writeStartObject();
            jsonGenerator.writeObjectField("id", vTuber.getId());
            jsonGenerator.writeObjectField("lastName", vTuber.getLastName());
            jsonGenerator.writeObjectField("firstName", vTuber.getFirstName());
            jsonGenerator.writeEndObject();
        }
        jsonGenerator.writeEndObject();
    }
}
