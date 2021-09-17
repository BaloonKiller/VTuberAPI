package pl.frackiewicz.vtuberapi.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import pl.frackiewicz.vtuberapi.entity.Video;

import java.io.IOException;

public class VideoSerializer extends StdSerializer<Video> {
    public VideoSerializer() {
        this(null);
    }

    public VideoSerializer(Class<Video> t) {
        super(t);
    }

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
