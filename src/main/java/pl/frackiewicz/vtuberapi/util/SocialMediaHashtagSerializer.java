package pl.frackiewicz.vtuberapi.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.springframework.boot.jackson.JsonComponent;
import pl.frackiewicz.vtuberapi.entity.SocialMediaHashtag;

import java.io.IOException;

public class SocialMediaHashtagSerializer extends StdSerializer<SocialMediaHashtag> {
    public SocialMediaHashtagSerializer() {
        this(null);
    }

    public SocialMediaHashtagSerializer(Class<SocialMediaHashtag> t) {
        super(t);
    }

    @Override
    public void serialize(SocialMediaHashtag socialMediaHashtag, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("hashtag", socialMediaHashtag.getHashtag());
        jsonGenerator.writeStringField("type", socialMediaHashtag.getType());
        jsonGenerator.writeEndObject();
    }
}
