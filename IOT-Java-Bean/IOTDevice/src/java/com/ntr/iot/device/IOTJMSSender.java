/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntr.iot.device;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author NUWAA
 */
public class IOTJMSSender {
    private final QueueConnectionFactory queueConnectionFactory;
    private final Queue queue;

    public IOTJMSSender(String connectionFactory, String destination) throws NamingException {
        Context context = new InitialContext();
        queueConnectionFactory = (QueueConnectionFactory) context.lookup(connectionFactory);
        queue = (Queue) context.lookup(destination);
    }

    public void sendMessage(IOTMessageData obj) throws JMSException {
        QueueConnection queueConnection = null;
        QueueSession queueSession = null;
        QueueSender queueSender = null;
        try {
            queueConnection = queueConnectionFactory.createQueueConnection();
            queueSession = queueConnection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
            queueSender = queueSession.createSender(queue);
            ObjectMessage message = queueSession.createObjectMessage();
            message.setObject(obj);
            queueSender.send(message);
        } finally {
            if (queueSender != null) {
                queueSender.close();
            }
            if (queueSession != null) {
                queueSession.close();
            }
            if (queueConnection != null) {
                queueConnection.close();
            }
        }
    }
}
