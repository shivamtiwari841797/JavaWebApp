package com.company;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/userTracker"})
public class UserRequestTrackerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession(true);
        Object reqCountObject = httpSession.getAttribute("reqCount");
        if(reqCountObject == null) {
            httpSession.setAttribute("reqCount", 1);
        } else {
            httpSession.setAttribute("reqCount", (int)reqCountObject + 1);
        }
        PrintWriter out = resp.getWriter();
        out.print("Total request count by you: " + httpSession.getAttribute("reqCount"));
    }
}