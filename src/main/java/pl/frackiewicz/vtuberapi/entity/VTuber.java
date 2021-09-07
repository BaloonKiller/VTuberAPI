package pl.frackiewicz.vtuberapi.entity;

import java.time.LocalDate;
import java.util.UUID;

public class VTuber {
    private UUID uid;
    private String firstName;
    private String lastName;
    private Integer age;
    private LocalDate birthday;
    private Integer height;
    private String zodiacSign;
    private String description;
    private String[] nicknames;
    private Organisation organisation;
    private Branch branch;
    private Generation generation;
    private Channel channel;
    private String twitter;
    private LocalDate debutDate;
    private String[] socialMediaHashtags;
    private boolean active;
}
