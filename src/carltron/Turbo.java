package carltron;

/**
 * Created by shangd on 5/27/15.
 */
public class Turbo extends Bonus {
    public final static int BOOST_VELOCITY = 5;

    public Turbo(int amount, LightCycle owner) {
        super();
        this.amount = amount;
        this.owner = owner;
    }

    @Override
    public void consume() {
        if (this.amount == 0) return;

        setAmount(this.amount-1);
        if (this.owner.getVelocityX() < 0) {
            this.owner.setVelocityX(this.owner.getVelocityX() - BOOST_VELOCITY);
        } else if (this.owner.getVelocityX() > 0) {
            this.owner.setVelocityX(this.owner.getVelocityX() + BOOST_VELOCITY);
        } else if (this.owner.getVelocityY() < 0) {
            this.owner.setVelocityY(this.owner.getVelocityY() - BOOST_VELOCITY);
        } else if (this.owner.getVelocityY() > 0) {
            this.owner.setVelocityY(this.owner.getVelocityY() + BOOST_VELOCITY);
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
