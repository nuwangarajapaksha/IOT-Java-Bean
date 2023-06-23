/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntr.iot;

import com.ntr.iot.device.IOTMessageData;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 *
 * @author NUWAA
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "iotQueue"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class IOTMessageBean implements MessageListener {

    static final List<IOTMessageData> iotMessageData = new ArrayList<>();

    @Override
    public void onMessage(Message message) {
        try {
            IOTMessageData iOTMessageData = message.getBody(IOTMessageData.class);
            System.out.println("Message Received: " + iOTMessageData.getVoltage());
            iotMessageData.add(iOTMessageData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
