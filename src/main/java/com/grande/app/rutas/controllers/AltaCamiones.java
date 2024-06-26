package com.grande.app.rutas.controllers;

import com.grande.app.rutas.models.Camion;
import com.grande.app.rutas.models.Chofer;
import com.grande.app.rutas.services.CamionesService;
import com.grande.app.rutas.services.ChoferesService;
import com.grande.app.rutas.services.IServis;
import com.sun.net.httpserver.HttpsParameters;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;

@WebServlet("/camiones/alta")
public class AltaCamiones extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/altaCamion.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = (Connection) req.getAttribute("conn");
        IServis<Camion> service = new CamionesService(conn);


    }
}
