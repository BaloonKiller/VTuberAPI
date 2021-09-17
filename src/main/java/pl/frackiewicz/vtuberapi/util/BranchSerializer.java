package pl.frackiewicz.vtuberapi.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.springframework.boot.jackson.JsonComponent;
import pl.frackiewicz.vtuberapi.entity.Branch;

import java.io.IOException;

public class BranchSerializer extends StdSerializer<Branch> {

    public BranchSerializer() {
        this(null);
    }

    public BranchSerializer(Class<Branch> t) {
        super(t);
    }

    @Override
    public void serialize(Branch branch, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("id", branch.getId().toString());
        jsonGenerator.writeStringField("name", branch.getName());
        jsonGenerator.writeEndObject();
    }
}
