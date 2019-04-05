package xyz.playtheia.controller.requestBodies;

public class PurchaseBody {

    private Long id;
    private Integer gold;
    private String sidekick;
    private String side;

    public PurchaseBody(Long id, Integer gold, String sidekick, String side) {
        this.id = id;
        this.gold = gold;
        this.sidekick = sidekick;
        this.side = side;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getGold() {
        return gold;
    }

    public void setGold(Integer gold) {
        this.gold = gold;
    }

    public String getSidekick() {
        return sidekick;
    }

    public void setSidekick(String sidekick) {
        this.sidekick = sidekick;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }
}