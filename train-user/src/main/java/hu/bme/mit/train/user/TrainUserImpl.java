package hu.bme.mit.train.user;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainUser;

public class TrainUserImpl implements TrainUser {

	private TrainController controller;
	private int joystickPosition;
	private boolean alarmflag = false;

	public TrainUserImpl(TrainController controller) {
		this.controller = controller;
	}

	@Override
	public boolean getAlarmFlag() {
		return alarmflag;
	}

	@Override
	public int getJoystickPosition() {
		return joystickPosition;
	}

	@Override
	public void overrideJoystickPosition(int joystickPosition) {
		this.joystickPosition = joystickPosition;
		if(alarmflag){
			controller.enforceSafetyBrake();
		}
		else{
			controller.setJoystickPosition(joystickPosition);
		}
	}
	@Override
	public void setAlarmflag(boolean flag){
		alarmflag = flag;
	}

}
