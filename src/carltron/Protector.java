package carltron;

/**
 * Created by shangd on 5/27/15.
 */
public class Protector extends Bonus {

    public Protector(int amount, LightCycle owner) {
        super();
        if (amount < 0) {
            this.amount = 0;
        } else {
            this.amount = amount;
        }
        this.owner = owner;
    }

    @Override
    public void consume() {
        if (this.amount == 0) return;

        setAmount(this.amount - 1);
        //this.owner.setShield(true);
    }

    // These are only used for testing.
    public int getAmountTest() {
        return this.amount;
    }

    public LightCycle getOwnerTest() {
        return this.owner;
    }
}
