package com.grande.app.rutas.controllers;

import com.grande.app.rutas.models.Camion;
import com.grande.app.rutas.models.Chofer;
import com.grande.app.rutas.services.CamionesService;
import com.grande.app.rutas.services.ChoferesService;
import com.grande.app.rutas.services.IServis;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/camiones/alta")
public class AltaCamionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/altaCamion.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = (Connection) req.getAttribute("conn");
        IServis<Camion> service = new CamionesService(conn);

        String matricula = req.getParameter("matricula");
        String tipoCamion = req.getParameter("tipoCamion");
        String modelo = req.getParameter("modelo");
        String marca = req.getParameter("marca");
        String capacidad = req.getParameter("capacidad");
        String kilometro = req.getParameter("kilometro");



    }
}
