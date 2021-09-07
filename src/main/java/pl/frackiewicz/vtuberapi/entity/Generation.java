package pl.frackiewicz.vtuberapi.entity;

import java.util.UUID;

public class Generation {
    private UUID uid;
    private String name;
    private Organisation organisation;
    private Branch branch;
    private VTuber[] vTubers;
}
