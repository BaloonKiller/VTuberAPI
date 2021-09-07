package pl.frackiewicz.vtuberapi.entity;

import java.util.UUID;

public class Event {
    private UUID uid;
    private VTuber[] members;
    private String type;
    private String description;
}
