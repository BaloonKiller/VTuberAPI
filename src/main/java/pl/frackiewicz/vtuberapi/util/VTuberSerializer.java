package pl.frackiewicz.vtuberapi.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import pl.frackiewicz.vtuberapi.entity.VTuber;

import java.io.IOException;

public class VTuberSerializer extends StdSerializer<VTuber> {
    public VTuberSerializer() {
        this(null);
    }

    public VTuberSerializer(Class<VTuber> t) {
        super(t);
    }

    @Override
    public void serialize(VTuber vTuber, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeObjectField("id", vTuber.getId());
        jsonGenerator.writeObjectField("lastName", vTuber.getLastName());
        jsonGenerator.writeObjectField("firstName", vTuber.getFirstName());
        jsonGenerator.writeEndObject();
    }
}
