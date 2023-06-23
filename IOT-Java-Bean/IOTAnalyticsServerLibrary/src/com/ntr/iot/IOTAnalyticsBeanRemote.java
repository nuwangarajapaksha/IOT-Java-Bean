/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ntr.iot;

import javax.ejb.Remote;

/**
 *
 * @author NUWAA
 */
@Remote
public interface IOTAnalyticsBeanRemote {
    String analyze();
}
