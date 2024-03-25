package hu.bme.mit.train.sensor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainUser;

import static org.mockito.Mockito.*;

public class TrainSensorTest {

    TrainController mockTC;
	TrainSensorImpl sensor;
	TrainUser mockTU;

    @Before
    public void before() {
        mockTU = mock(TrainUser.class);
        mockTC = mock(TrainController.class);
        sensor = new TrainSensorImpl(mockTC, mockTU);
    }

    @Test
    public void absoluteSpeedLimitMinTest(){
        sensor.overrideSpeedLimit(150);
        verify(mockTU,times(0)).setAlarmState(true);
        
        sensor.overrideSpeedLimit(-1);
        verify(mockTU,times(1)).setAlarmState(true);
    }
    @Test
    public void absoluteSpeedLimitMaxTest(){
        sensor.overrideSpeedLimit(150);
        verify(mockTU,times(0)).setAlarmState(true);
        
        sensor.overrideSpeedLimit(555);
        verify(mockTU,times(1)).setAlarmState(true);
    }
    @Test
    public void relativeSpeedLimitLowerTest(){
        sensor.overrideSpeedLimit(150);
        verify(mockTU,times(0)).setAlarmState(true);
        
        sensor.overrideSpeedLimit(50);
        verify(mockTU,times(1)).setAlarmState(true);
    }
    @Test
    public void relativeSpeedLimitGreaterTest(){
        sensor.overrideSpeedLimit(150);
        verify(mockTU,times(0)).setAlarmState(true);
        
        sensor.overrideSpeedLimit(155);
        verify(mockTU,times(0)).setAlarmState(true);
    }

    
}
