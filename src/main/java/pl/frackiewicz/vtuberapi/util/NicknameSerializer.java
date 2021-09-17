package pl.frackiewicz.vtuberapi.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.springframework.boot.jackson.JsonComponent;
import pl.frackiewicz.vtuberapi.entity.Nickname;

import java.io.IOException;

public class NicknameSerializer extends StdSerializer<Nickname> {
    public NicknameSerializer() {
        this(null);
    }

    public NicknameSerializer(Class<Nickname> t) {
        super(t);
    }

    @Override
    public void serialize(Nickname nickname, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("nickname", nickname.getNickname());
        jsonGenerator.writeEndObject();
    }
}
