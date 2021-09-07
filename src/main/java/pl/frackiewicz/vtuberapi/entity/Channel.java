package pl.frackiewicz.vtuberapi.entity;

import java.math.BigInteger;
import java.util.UUID;

public class Channel {
    private UUID uid;
    private VTuber vTuber;
    private String channelUrl;
    private BigInteger subscriptions;
    private BigInteger videoCount;
    private BigInteger viewsSum;
    private BigInteger likesSum;
    private BigInteger dislikesSum;
}
