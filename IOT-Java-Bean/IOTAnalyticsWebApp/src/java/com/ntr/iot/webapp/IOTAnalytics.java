/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.ntr.iot.webapp;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ntr.iot.IOTAnalyticsBeanRemote;

/**
 *
 * @author NUWAA
 */
@WebServlet(name = "IOTAnalytics", urlPatterns = {"/IOTAnalytics"})
public class IOTAnalytics extends HttpServlet {

    @EJB
    IOTAnalyticsBeanRemote IOTAnalyticsBeanRemote;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write(IOTAnalyticsBeanRemote.analyze());
    } 
}
