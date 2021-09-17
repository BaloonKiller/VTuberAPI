package pl.frackiewicz.vtuberapi.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import pl.frackiewicz.vtuberapi.entity.Event;

import java.io.IOException;

public class EventSerializer extends StdSerializer<Event> {
    public EventSerializer() {
        this(null);
    }

    public EventSerializer(Class<Event> t) {
        super(t);
    }

    @Override
    public void serialize(Event event, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("id", event.getId().toString());
        jsonGenerator.writeStringField("eventdatetime", event.getEventDateTime().toString());
        jsonGenerator.writeStringField("type", event.getType());
        jsonGenerator.writeEndObject();
    }
}
