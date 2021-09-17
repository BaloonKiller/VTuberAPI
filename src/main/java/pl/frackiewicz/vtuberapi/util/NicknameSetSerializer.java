package pl.frackiewicz.vtuberapi.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import pl.frackiewicz.vtuberapi.entity.Nickname;

import java.io.IOException;
import java.util.Set;

public class NicknameSetSerializer extends StdSerializer<Set<Nickname>> {
    public NicknameSetSerializer() {
        this(null);
    }

    public NicknameSetSerializer(Class<Set<Nickname>> t) {
        super(t);
    }

    @Override
    public void serialize(Set<Nickname> nicknames, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        for(Nickname nickname : nicknames) {
            jsonGenerator.writeStartObject();
            jsonGenerator.writeStringField("nickname", nickname.getNickname());
            jsonGenerator.writeEndObject();
        }
        jsonGenerator.writeEndObject();
    }
}
