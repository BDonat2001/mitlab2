package hu.bme.mit.train.interfaces;

import java.time.LocalDate;

public interface TrainSensor {

	int getSpeedLimit();

	void overrideSpeedLimit(int speedLimit);

	LocalDate getTime();

}
