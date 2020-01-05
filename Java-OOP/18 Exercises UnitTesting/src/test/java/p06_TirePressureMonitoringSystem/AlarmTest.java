package p06_TirePressureMonitoringSystem;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class AlarmTest {

    @Test
    public void defaultAlarmShouldBeFalse(){
        Alarm alarm = new Alarm(new Sensor());
        Assert.assertFalse(alarm.getAlarmOn());
    }

    @Test
    public void shouldReturnTrueWhenPressureIsLessThanLowestThreshold(){
        Sensor fakeSensor = Mockito.mock(Sensor.class);
        Mockito.when(fakeSensor.popNextPressurePsiValue()).thenReturn(1.0);
        Alarm alarm = new Alarm(fakeSensor);
        alarm.check();
        Assert.assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void shouldReturnTrueWhenPressureIsMoreThanHighestThreshold(){
        Sensor fakeSensor = Mockito.mock(Sensor.class);
        Mockito.when(fakeSensor.popNextPressurePsiValue()).thenReturn(30.0);
        Alarm alarm = new Alarm(fakeSensor);
        alarm.check();
        Assert.assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void shouldReturnFalseWhenPressureIsBetweenThresholds(){
        Sensor fakeSensor = Mockito.mock(Sensor.class);
        Mockito.when(fakeSensor.popNextPressurePsiValue()).thenReturn(20.0);
        Alarm alarm = new Alarm(fakeSensor);
        alarm.check();
        Assert.assertFalse(alarm.getAlarmOn());
    }

}