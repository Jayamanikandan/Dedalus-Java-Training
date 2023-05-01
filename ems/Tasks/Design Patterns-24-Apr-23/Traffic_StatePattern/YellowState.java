package state;



	public class YellowState implements State1 {
		@Override
		public void switchOnRed(LightSwitch1 lightSwitch) {
			System.out.println("Red Light is switching on");
			lightSwitch.setState(new RedState());
			
		}

		@Override
		public void switchOnYellow(LightSwitch1 lightSwitch) {
			System.out.println("Yellow Switching is already on");
		}

		
		@Override
		public void switchOnGreen(LightSwitch1 lightSwitch) {
			System.out.println("Green Switch is switching on");
			lightSwitch.setState(new GreenState());
		}
	}

