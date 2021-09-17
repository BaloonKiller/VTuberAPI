package pl.frackiewicz.vtuberapi.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.springframework.boot.jackson.JsonComponent;
import pl.frackiewicz.vtuberapi.entity.SocialMediaHashtag;

import java.io.IOException;
import java.util.Set;

public class SocialMediaHashtagSetSerializer extends StdSerializer<Set<SocialMediaHashtag>> {
    public SocialMediaHashtagSetSerializer() {
        this(null);
    }

    public SocialMediaHashtagSetSerializer(Class<Set<SocialMediaHashtag>> t) {
        super(t);
    }

    @Override
    public void serialize(Set<SocialMediaHashtag> socialMediaHashtags, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        for(SocialMediaHashtag socialMediaHashtag : socialMediaHashtags) {
            jsonGenerator.writeStartObject();
            jsonGenerator.writeStringField("hashtag", socialMediaHashtag.getHashtag());
            jsonGenerator.writeStringField("type", socialMediaHashtag.getType());
            jsonGenerator.writeEndObject();
        }
        jsonGenerator.writeEndObject();
    }
}
