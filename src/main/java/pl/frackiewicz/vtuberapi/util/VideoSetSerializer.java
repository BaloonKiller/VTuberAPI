package pl.frackiewicz.vtuberapi.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import pl.frackiewicz.vtuberapi.entity.Video;

import java.io.IOException;
import java.util.Set;

public class VideoSetSerializer extends JsonSerializer<Set<Video>> {
    @Override
    public void serialize(Set<Video> videos, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStartArray("videos");
        for(Video video : videos) {
            jsonGenerator.writeStartObject();
            jsonGenerator.writeStringField("id", video.getId().toString());
            jsonGenerator.writeStartArray("author");
            jsonGenerator.writeStringField("firstname", video.getAuthor().getFirstName());
            jsonGenerator.writeStringField("lastname", video.getAuthor().getLastName());
            jsonGenerator.writeEndArray();
            jsonGenerator.writeStringField("videourl", video.getVideoUrl());
            jsonGenerator.writeEndObject();
        }
        jsonGenerator.writeEndArray();
        jsonGenerator.writeEndObject();
    }
}
