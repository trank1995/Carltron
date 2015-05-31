package carltron;

/**
 * Created by shangd on 5/27/15.
 */
public class Jump extends Bonus {
    /**The constructor for the jump class. Takes an integer to represent the amount of turbos available (newAmount) to the LightCycle and sets amount to be this number.
     **/
    public Jump(int amount, LightCycle owner) {
        super();
        this.amount = amount;
        this.owner = owner;
    }
    /**Consumes a potion of jump and gains the ability to cross a path and leave no path behind while the potion is in effect.**/
    @Override
    public void consume(){
        if (this.amount == 0) return;

        setAmount(this.amount-1);
        this.owner.setLeavesPath(false);
        //this.owner.setShield(true);
    }


}
