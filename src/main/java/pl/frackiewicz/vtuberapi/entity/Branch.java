package pl.frackiewicz.vtuberapi.entity;

import java.util.UUID;

public class Branch {
    private UUID uid;
    private String name;
    private Organisation organisation;
    private Generation[] generations;
    private VTuber[] vTubers;
}
