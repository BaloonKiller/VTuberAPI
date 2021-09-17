package pl.frackiewicz.vtuberapi.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.springframework.boot.jackson.JsonComponent;
import pl.frackiewicz.vtuberapi.entity.Video;

import java.io.IOException;
import java.util.Set;

public class VideoSetSerializer extends StdSerializer<Set<Video>> {
    public VideoSetSerializer() {
        this(null);
    }

    public VideoSetSerializer(Class<Set<Video>> t) {
        super(t);
    }

    @Override
    public void serialize(Set<Video> videos, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        for(Video video : videos) {
            jsonGenerator.writeStartObject();
            jsonGenerator.writeStringField("id", video.getId().toString());
            jsonGenerator.writeStartArray("author");
            jsonGenerator.writeStringField("id", video.getAuthor().getId().toString());
            jsonGenerator.writeStringField("firstname", video.getAuthor().getFirstName());
            jsonGenerator.writeStringField("lastname", video.getAuthor().getLastName());
            jsonGenerator.writeEndArray();
            jsonGenerator.writeStringField("videourl", video.getVideoUrl());
            jsonGenerator.writeEndObject();
        }
        jsonGenerator.writeEndObject();
    }
}
