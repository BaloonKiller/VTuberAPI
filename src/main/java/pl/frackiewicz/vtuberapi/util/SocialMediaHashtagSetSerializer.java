package pl.frackiewicz.vtuberapi.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import pl.frackiewicz.vtuberapi.entity.SocialMediaHashtag;

import java.io.IOException;
import java.util.Set;

public class SocialMediaHashtagSetSerializer extends JsonSerializer<Set<SocialMediaHashtag>> {
    @Override
    public void serialize(Set<SocialMediaHashtag> socialMediaHashtags, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStartArray("hashtags");
        for(SocialMediaHashtag socialMediaHashtag : socialMediaHashtags) {
            jsonGenerator.writeStartObject();
            jsonGenerator.writeStringField("hashtag", socialMediaHashtag.getHashtag());
            jsonGenerator.writeStringField("type", socialMediaHashtag.getType());
            jsonGenerator.writeEndObject();
        }
        jsonGenerator.writeEndArray();
        jsonGenerator.writeEndObject();
    }
}
