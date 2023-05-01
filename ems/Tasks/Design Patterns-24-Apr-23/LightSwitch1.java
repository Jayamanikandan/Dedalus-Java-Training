package state;


public class LightSwitch1 {
	private State1 state;
    
    public LightSwitch1() {
        state = new RedState();
    }
    
    public void setState(RedState redState) {
        this.state = redState;
    }
    
    public void redSwitch() {
        state.switchOnRed(this);
    }
    
    public void yellowSwitch() {
        state.switchOnYellow(this);
    }
    
    public void greenSwitch() {
        state.switchOnGreen(this);
    }
}


