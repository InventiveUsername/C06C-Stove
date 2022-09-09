

public class Burner {
	public enum Temperature { BLAZING, HOT, WARM, COLD }
	private Temperature myTemperature;
	
	
	public Temperature getMyTemperature() {
		return myTemperature;
	}


	public final static int TIME_DURATION = 2;
	private Setting mySetting;
	private int timer;
	
	public Burner() {
		super();
		myTemperature = Temperature.COLD;
		mySetting = Setting.OFF;
	}
	
	public void plusButton() {
		
		switch (mySetting) {
		case OFF:
			mySetting = Setting.LOW;
		case LOW:
			mySetting = Setting.MEDIUM;
		case MEDIUM:
			mySetting = Setting.HIGH;
		case HIGH:
			mySetting = Setting.HIGH;
		
		}
		timer = TIME_DURATION;
	}
	
	public void minusButton() {
		switch (mySetting) {
		case OFF:
			mySetting = Setting.OFF;
		case LOW:
			mySetting = Setting.OFF;
		case MEDIUM:
			mySetting = Setting.LOW;
		case HIGH:
			mySetting = Setting.MEDIUM;
		}
		timer = TIME_DURATION;
		
	}
	
	public void temperatureUp() {
		switch (myTemperature) {
		case COLD:
			myTemperature = Temperature.WARM;
		case WARM:
			myTemperature = Temperature.HOT;
		case HOT:
			myTemperature = Temperature.BLAZING;
		case BLAZING:
			myTemperature = Temperature.BLAZING;
		}
		timer = TIME_DURATION;	
	}
	
	
	public void temperatureDown() {
		switch (myTemperature) {
		case COLD:
			myTemperature = Temperature.COLD;
		case WARM:
			myTemperature = Temperature.COLD;
		case HOT:
			myTemperature = Temperature.WARM;
		case BLAZING:
			myTemperature = Temperature.HOT;
		}
		timer = TIME_DURATION;	
	}
	
	public boolean checkMatch() {
		if(mySetting == Setting.OFF && myTemperature == Temperature.COLD) {
			return true;
		}
		if(mySetting == Setting.LOW && myTemperature == Temperature.WARM) {
			return true;
		}
		if(mySetting == Setting.MEDIUM && myTemperature == Temperature.HOT) {
			return true;
		}
		if(mySetting == Setting.HIGH && myTemperature == Temperature.BLAZING) {
			return true;
		} else {
			return false;
		}
		
	}
	
	public void updateTemperature() {
		if (timer == 1) {
			timer++;
			return;
		}
		
		else if (timer == 2 && this.checkMatch()) {
			this.timer = 0;
			return;
		} 
		else {
			myTemperature = Temperature.HOT; // TODO: This branch would increase or decrease temperature;
			timer = 1;
		}
	}
	
	public void display() {
		System.out.println(mySetting);
	}
}
