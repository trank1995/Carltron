package carltron;

/**
 * Created by shangd on 5/27/15.
 */
public class Turbo extends Bonus {
    public final static int BOOST_VELOCITY = 1;

    public Turbo(int amount, LightCycle owner) {
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
        if (this.amount == 0) {
            return;
        }

        if (this.owner.getVelocityX() == -1) {
            this.owner.setVelocityX(this.owner.getVelocityX() - BOOST_VELOCITY);
            setAmount(this.amount - 1);
        } else if (this.owner.getVelocityX() == 1) {
            this.owner.setVelocityX(this.owner.getVelocityX() + BOOST_VELOCITY);
            setAmount(this.amount - 1);
        } else if (this.owner.getVelocityY() == -1) {
            this.owner.setVelocityY(this.owner.getVelocityY() - BOOST_VELOCITY);
            setAmount(this.amount - 1);
        } else if (this.owner.getVelocityY() == 1) {
            this.owner.setVelocityY(this.owner.getVelocityY() + BOOST_VELOCITY);
            setAmount(this.amount - 1);
        }
    }

    // These are only used for testing.
    public int getAmountTest() {
        return this.amount;
    }

    public LightCycle getOwnerTest() {
        return this.owner;
    }
}
