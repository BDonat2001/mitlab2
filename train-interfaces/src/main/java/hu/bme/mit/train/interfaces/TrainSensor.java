package hu.bme.mit.train.interfaces;

import java.time.LocalDate;
import java.util.Set;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import com.google.common.collect.Table.Cell;

public interface TrainSensor {

	int getSpeedLimit();

	void overrideSpeedLimit(int speedLimit);

	LocalDate getTime();

	Set<Cell<LocalDate, Integer, Integer>> getTableData();

}
