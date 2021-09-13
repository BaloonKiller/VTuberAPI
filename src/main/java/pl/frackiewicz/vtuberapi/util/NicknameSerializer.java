package pl.frackiewicz.vtuberapi.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import pl.frackiewicz.vtuberapi.entity.Nickname;

import java.io.IOException;

public class NicknameSerializer extends JsonSerializer<Nickname> {
    @Override
    public void serialize(Nickname nickname, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("nickname", nickname.getNickname());
        jsonGenerator.writeEndObject();
    }
}
