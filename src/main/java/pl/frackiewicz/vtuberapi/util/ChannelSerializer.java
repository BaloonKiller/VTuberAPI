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
        jsonGenerator.writeStringField("youtubeId", channel.getYoutubeId());
        jsonGenerator.writeStringField("channelName", channel.getChannelName());
        jsonGenerator.writeStringField("channelUrl", channel.getChannelUrl());
        jsonGenerator.writeEndObject();

    }
}
