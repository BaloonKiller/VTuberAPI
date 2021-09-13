package pl.frackiewicz.vtuberapi.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import pl.frackiewicz.vtuberapi.entity.SocialMediaHashtag;

import java.io.IOException;

public class SocialMediaHashtagSerializer extends JsonSerializer<SocialMediaHashtag> {
    @Override
    public void serialize(SocialMediaHashtag socialMediaHashtag, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("hashtag", socialMediaHashtag.getHashtag());
        jsonGenerator.writeStringField("type", socialMediaHashtag.getType());
        jsonGenerator.writeEndObject();
    }
}
