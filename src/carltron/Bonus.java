package carltron;

/**
 * Created by shangd on 5/27/15.
 */
public abstract class Bonus {
    protected int amount;
    protected LightCycle owner;

    public Bonus() {
        this.amount = 0;
    }

    public int getAmount() {
        return this.amount;
    }

    public void setAmount(int nAmount) {
        this.amount = nAmount;
    }

    public abstract void consume();

}