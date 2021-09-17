package pl.frackiewicz.vtuberapi.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import pl.frackiewicz.vtuberapi.entity.Nickname;

import java.io.IOException;
import java.util.Set;

public class NicknameSetSerializer extends JsonSerializer<Set<Nickname>> {
    @Override
    public void serialize(Set<Nickname> nicknames, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStartArray("nicknames");
        for(Nickname nickname : nicknames) {
            jsonGenerator.writeStartObject();
            jsonGenerator.writeStringField("nickname", nickname.getNickname());
            jsonGenerator.writeEndObject();
        }
        jsonGenerator.writeEndArray();
        jsonGenerator.writeEndObject();
    }
}
