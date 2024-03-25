package hu.bme.mit.train.interfaces;

import java.time.LocalDate;
import java.util.Set;

import com.google.common.collect.Table.Cell;

public interface TrainSensor {

	int getSpeedLimit();

	void overrideSpeedLimit(int speedLimit);

	LocalDate getTime();

	Set<Cell<LocalDate, Integer, Integer>> getTableData();
	
	void relativeSetSpeedLimitCheck(int speedlimit);

	void absoluteSetSpeedLimitCheck(int speedlimit);

}
