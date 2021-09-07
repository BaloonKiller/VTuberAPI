package pl.frackiewicz.vtuberapi.entity;

import java.math.BigInteger;
import java.util.UUID;

public class Video {
    private UUID uid;
    private VTuber author;
    private VTuber[] members;
    private BigInteger views;
    private BigInteger likes;
    private BigInteger dislikes;
    private String videoUrl;
}
