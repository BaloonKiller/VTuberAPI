package pl.frackiewicz.vtuberapi.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import pl.frackiewicz.vtuberapi.entity.Event;

import java.io.IOException;

public class EventSerializer extends JsonSerializer<Event> {
    @Override
    public void serialize(Event event, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("id", event.getId().toString());
        jsonGenerator.writeStringField("eventdatetime", event.getEventDateTime().toString());
        jsonGenerator.writeStringField("type", event.getType());
        jsonGenerator.writeEndObject();
    }
}
