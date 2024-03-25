package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;

import java.time.LocalDate;
import java.util.Set;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import com.google.common.collect.Table.Cell;

public class TrainSensorImpl implements TrainSensor {

	private TrainController controller;
	private TrainUser user;
	private int speedLimit = 5;
	private LocalDate time = LocalDate.now();
	private Table<LocalDate, Integer, Integer> sensorData;

	public TrainSensorImpl(TrainController controller, TrainUser user) {
		this.controller = controller;
		this.user = user;
		sensorData = HashBasedTable.create();
		sensorData.put(time,user.getJoystickPosition(),controller.getReferenceSpeed());
	}

	@Override
	public int getSpeedLimit() {
		return speedLimit;
	}
	@Override
	public LocalDate getTime() {
		return time;
	}
	@Override
	public Set<Cell<LocalDate, Integer, Integer>> getTableData(){
		return sensorData.cellSet();
	}

	@Override
	public void overrideSpeedLimit(int speedLimit) {
		this.speedLimit = speedLimit;
		controller.setSpeedLimit(speedLimit);
		relativeSetSpeedLimitCheck(speedLimit);
	}
	@Override
	public void relativeSetSpeedLimitCheck(int speedlimit){
		if( controller.getReferenceSpeed()/speedlimit < 0.5){
			user.setAlarmState(true);
		}
	}
}
