package pl.frackiewicz.vtuberapi.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.springframework.boot.jackson.JsonComponent;
import pl.frackiewicz.vtuberapi.entity.Channel;

import java.io.IOException;

public class ChannelSerializer extends StdSerializer<Channel> {
    public ChannelSerializer() {
        this(null);
    }

    public ChannelSerializer(Class<Channel> t) {
        super(t);
    }

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
