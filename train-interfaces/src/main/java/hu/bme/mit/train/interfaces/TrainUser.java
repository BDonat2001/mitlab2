package hu.bme.mit.train.interfaces;

public interface TrainUser {

	int getJoystickPosition();

	boolean getAlarmFlag();

	void setAlarmflag(boolean flag);

	void overrideJoystickPosition(int joystickPosition);

}
