package xyz.playtheia.controller.requestBodies;

public class EndGameIncome {

   private Long id;
   private Integer experience;
   private Integer gold;

    public EndGameIncome(Long id, Integer experience, Integer gold) {
        this.id = id;
        this.experience = experience;
        this.gold = gold;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public Integer getGold() {
        return gold;
    }

    public void setGold(Integer gold) {
        this.gold = gold;
    }
}
