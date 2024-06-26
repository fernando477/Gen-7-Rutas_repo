package com.grande.app.rutas.filter;

import com.grande.app.rutas.utils.ConexionBD;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import javax.print.attribute.standard.PrinterURI;
import java.io.IOException;
import java.sql.Connection;

@WebFilter("/*")

public class ConexionFilter implements Filter {
    private Connection getConnetion(){
        return ConexionBD.getInstance();
    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
       Connection conn = this.getConnetion();

       servletRequest.setAttribute("conn", conn);
       try {
           filterChain.doFilter(servletRequest, servletResponse);
       }catch (IOException e){
           throw new RuntimeException(e);
       }

    }
}
