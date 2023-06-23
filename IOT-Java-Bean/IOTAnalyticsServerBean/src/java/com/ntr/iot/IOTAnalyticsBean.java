/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package com.ntr.iot;

import static com.ntr.iot.IOTMessageBean.iotMessageData;
import com.ntr.iot.device.IOTMessageData;
import javax.ejb.Stateless;

/**
 *
 * @author NUWAA
 */
@Stateless
public class IOTAnalyticsBean implements IOTAnalyticsBeanRemote {
    
    @Override
    public String analyze() {
        double averageVoltage = 0.0;
        double averageFrequency = 0.0;
        double averageCurrent = 0.0;

        double totalVoltage = 0.0;
        double totalFrequency = 0.0;
        double totalCurrent = 0.0;

        for (IOTMessageData message : iotMessageData) {
            totalVoltage = totalVoltage + message.getVoltage();
            totalFrequency = totalFrequency + message.getFrequency();
            totalCurrent = totalCurrent + message.getCurrent();
        }

        if (!iotMessageData.isEmpty()) {
            averageVoltage = totalVoltage / iotMessageData.size();
            averageFrequency = totalFrequency / iotMessageData.size();
            averageCurrent = totalCurrent / iotMessageData.size();
        }
        
        return "Average Voltage = "+averageVoltage+" V\n"
                + "Average Frequency = "+averageFrequency+" Hz\n"
                + "Average Current = "+averageCurrent+" A";
    }
}
