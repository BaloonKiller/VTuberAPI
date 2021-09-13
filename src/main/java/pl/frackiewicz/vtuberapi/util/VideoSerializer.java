package pl.frackiewicz.vtuberapi.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import pl.frackiewicz.vtuberapi.entity.Video;

import java.io.IOException;

public class VideoSerializer extends JsonSerializer<Video> {
    @Override
    public void serialize(Video video, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("id", video.getId().toString());
        jsonGenerator.writeStartArray("author");
        jsonGenerator.writeStringField("firstname", video.getAuthor().getFirstName());
        jsonGenerator.writeStringField("lastname", video.getAuthor().getLastName());
        jsonGenerator.writeEndArray();
        jsonGenerator.writeStringField("videourl", video.getVideoUrl());
        jsonGenerator.writeEndObject();
    }
}
