package org.grupo4.practica_integradora_g4.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebFilter("/*")
public class PageVisitCounterFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            Integer visitCount = (Integer) session.getAttribute("pageVisitCount");
            if (visitCount != null) {
                session.setAttribute("pageVisitCount", visitCount + 1);
            }
        }

        // Actualizar el valor de la cookie
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("userData".equals(cookie.getName())) {
                    String[] userData = cookie.getValue().split(":");
                    int currentPageCount = Integer.parseInt(userData[1]);
                    cookie.setValue(userData[0] + ":" + (currentPageCount + 1));
                    response.addCookie(cookie);
                    break;
                }
            }
        }

        chain.doFilter(request, response);
    }
}
