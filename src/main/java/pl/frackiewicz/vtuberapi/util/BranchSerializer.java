package pl.frackiewicz.vtuberapi.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import pl.frackiewicz.vtuberapi.entity.Branch;
import pl.frackiewicz.vtuberapi.entity.Generation;
import pl.frackiewicz.vtuberapi.entity.Organisation;
import pl.frackiewicz.vtuberapi.entity.VTuber;

import java.io.IOException;


public class BranchSerializer extends JsonSerializer<Branch> {
    @Override
    public void serialize(Branch branch, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("id", branch.getId().toString());
        jsonGenerator.writeStringField("name", branch.getName());
        jsonGenerator.writeStartArray("organisation");
        jsonGenerator.writeStringField("id", branch.getOrganisation().getId().toString());
        jsonGenerator.writeStringField("name", branch.getOrganisation().getName());
        jsonGenerator.writeEndArray();
        jsonGenerator.writeStartArray("generations");
        for(Generation generation : branch.getGenerations()) {
            jsonGenerator.writeStringField("id", generation.getId().toString());
            jsonGenerator.writeStringField("name", generation.getName());
        }
        jsonGenerator.writeEndArray();
        jsonGenerator.writeStartArray("vtubers");
        for(VTuber vTuber : branch.getVTubers()) {
            jsonGenerator.writeStringField("id", vTuber.getId().toString());
            jsonGenerator.writeStringField("firstname", vTuber.getFirstName());
            jsonGenerator.writeStringField("lastname", vTuber.getLastName());
        }
        jsonGenerator.writeEndArray();
        jsonGenerator.writeEndObject();
    }
}
