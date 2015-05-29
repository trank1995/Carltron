package carltron;

/**
 * Created by shangd on 5/27/15.
 */
public class Turbo extends Bonus {
    public final static int DURATION = 3;
    private int inEffect;

    public Turbo(int amount, LightCycle owner) {
        super();
        this.amount = amount;
        this.owner = owner;
        this.inEffect = 0;
    }

    public boolean isInEffect() {
        inEffect = (inEffect+1)%DURATION;
        return (inEffect != 0);
    }

    @Override
    public void consume() {
        if (!isInEffect()) {
            setAmount(this.amount-1);
        }
    }

    /*
    in GameManager:
        onPressEnter(player1.consume("Turbo"));
        for (int i=0;i<3;i++) {
            if (!player1.getBonuses[i].isInEffect())
                { player1.turnDefault(); }
        }
     */

}
