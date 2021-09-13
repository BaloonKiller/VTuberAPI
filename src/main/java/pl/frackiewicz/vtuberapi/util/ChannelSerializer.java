package pl.frackiewicz.vtuberapi.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import pl.frackiewicz.vtuberapi.entity.Channel;

import java.io.IOException;

public class ChannelSerializer extends JsonSerializer<Channel> {
    @Override
    public void serialize(Channel channel, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("id", channel.getId().toString());
        jsonGenerator.writeStartArray("vtuber");
        jsonGenerator.writeStringField("id", channel.getVTuber().getId().toString());
        jsonGenerator.writeStringField("firstname", channel.getVTuber().getFirstName());
        jsonGenerator.writeStringField("lastname", channel.getVTuber().getLastName());
        jsonGenerator.writeEndArray();
        jsonGenerator.writeStringField("channelurl", channel.getChannelUrl());
        jsonGenerator.writeEndObject();

    }
}
