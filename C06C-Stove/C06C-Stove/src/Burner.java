
/*
 * Burner class
 * 
 * @author Ben Reinicke
 * @author Mila Kania
 * 
 * Purpose/Description: Simulates a burner, with time/setting/temperature delays
 * 
 * Mila, put your certification of equal contribution here.
 * Grader, git was annoying so we couldn't both properly execute commits through the git terminal
 *
 */


public class Burner {
	public enum Temperature { BLAZING, HOT, WARM, COLD }
	private Temperature myTemperature;
	private boolean burningHot = false;
	
	
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
	
	
	
	public Setting getMySetting() {
		return mySetting;
	}


	public void plusButton() {
		
		switch (mySetting) {
		case OFF:
			mySetting = Setting.LOW;
			break;
		case LOW:
			mySetting = Setting.MEDIUM;
			break;
		case MEDIUM:
			mySetting = Setting.HIGH;
			break;
		case HIGH:
			break;
		
		}
		timer = TIME_DURATION;
	}
	
	public void minusButton() {
		switch (mySetting) {
		case OFF:
			break;
		case LOW:
			mySetting = Setting.OFF;
			break;
		case MEDIUM:
			mySetting = Setting.LOW;
			break;
		case HIGH:
			mySetting = Setting.MEDIUM;
			break;
		}
		timer = TIME_DURATION;
		
	}
	
	public void temperatureUp() {
		switch (myTemperature) {
		case COLD:
			myTemperature = Temperature.WARM;
			break;
		case WARM:
			myTemperature = Temperature.HOT;
			break;
		case HOT:
			myTemperature = Temperature.BLAZING;
			break;
		case BLAZING:
			break;
		}
		//timer = TIME_DURATION;	//??
	}
	
	
	public void temperatureDown() {
		switch (myTemperature) {
		case COLD:
			break;
		case WARM:
			myTemperature = Temperature.COLD;
			break;
		case HOT:
			myTemperature = Temperature.WARM;
			break;
		case BLAZING:
			myTemperature = Temperature.HOT;
			break;
		}
		//timer = TIME_DURATION;	//not sure
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
		if (timer != 1) {
			timer--;
			return;
		}
		
		else if (this.checkMatch()) {  //timer == 2 && this.checkMatch()
			//this.timer = 0;
			return;
		} 
		
		else {
			timer = TIME_DURATION; //added
			//switch temp depending on setting
			//More cases
			if(mySetting == Setting.OFF && (myTemperature == Temperature.WARM || myTemperature == Temperature.HOT || myTemperature == Temperature.BLAZING)) { //add ors
				temperatureDown();  //myTemperature.temperatureDown();
			}
			else if(mySetting == Setting.LOW && myTemperature == Temperature.COLD) {
				temperatureUp();
			}
			else if(mySetting == Setting.LOW && (myTemperature == Temperature.HOT || myTemperature == Temperature.BLAZING)) {
				temperatureDown();
			}
			else if(mySetting == Setting.MEDIUM && (myTemperature == Temperature.WARM || myTemperature == Temperature.COLD)) {
				temperatureUp();
			}
			else if(mySetting == Setting.MEDIUM && myTemperature == Temperature.BLAZING) {
				temperatureDown();
			}
			else if(mySetting == Setting.HIGH && (myTemperature == Temperature.HOT || myTemperature == Temperature.WARM || myTemperature == Temperature.COLD)) {
				temperatureUp();
			}
			
		
			timer--;
		}
	}
	
	public void display() {
		
		String displayTemp = "";
		
		if(myTemperature == Temperature.BLAZING) {
			displayTemp = ".....VERY HOT! DON'T TOUCH";
		}
		if (myTemperature == Temperature.HOT) {
			displayTemp = ".....CAREFUL";
		}
		if (myTemperature == Temperature.WARM) {
			displayTemp = ".....warm";
		}
		if (myTemperature == Temperature.COLD) {
			displayTemp = ".....cooool";
		}
		
		if(mySetting == Setting.OFF) {
			System.out.println("[" + mySetting + "]" + displayTemp); 
		}
		
		if(mySetting == Setting.LOW) {
			System.out.println("[" + mySetting + "]" + displayTemp); 
		}
		
		if(mySetting == Setting.MEDIUM) {
			System.out.println("[" + mySetting + "]" + displayTemp); 
		}
		
		if(mySetting == Setting.HIGH) {
			System.out.println("[" + mySetting + "]" + displayTemp);
			//return mySetting.toString() + displayTemp; 
		}
	}
}
