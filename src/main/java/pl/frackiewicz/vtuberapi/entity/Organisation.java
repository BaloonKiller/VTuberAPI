package pl.frackiewicz.vtuberapi.entity;

import java.time.LocalDate;
import java.util.UUID;

public class Organisation {
    private UUID uid;
    private String name;
    private LocalDate createdDate;
    private Branch[] branches;
    private Generation[] generations;
    private VTuber[] vTubers;
}
