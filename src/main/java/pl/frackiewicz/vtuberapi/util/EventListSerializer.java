package pl.frackiewicz.vtuberapi.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import pl.frackiewicz.vtuberapi.entity.Event;

import java.io.IOException;
import java.util.Set;

public class EventListSerializer extends JsonSerializer<Set<Event>> {
    @Override
    public void serialize(Set<Event> events, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStartArray("events");
        for(Event event : events) {
            jsonGenerator.writeStartObject();
            jsonGenerator.writeStringField("id", event.getId().toString());
            jsonGenerator.writeStringField("eventdatetime", event.getEventDateTime().toString());
            jsonGenerator.writeStringField("type", event.getType());
            jsonGenerator.writeEndObject();
        }
        jsonGenerator.writeEndArray();
        jsonGenerator.writeEndObject();
    }
}
