package state;



public class RedState implements State1 {

	@Override
	public void switchOnRed(LightSwitch1 lightSwitch) {
		System.out.println("Red Light is already on");
		
	}

	@Override
	public void switchOnYellow(LightSwitch1 lightSwitch) {
		System.out.println("Yellow light is switching on");
		lightSwitch.setState(new YellowState());
	}

	
	@Override
	public void switchOnGreen(LightSwitch1 lightSwitch) {
		System.out.println("Green light is switching on");
		lightSwitch.setState(new GreenState());
	}

}
