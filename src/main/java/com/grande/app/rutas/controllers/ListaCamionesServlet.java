package com.grande.app.rutas.controllers;

import com.grande.app.rutas.models.Camion;
import com.grande.app.rutas.services.CamionesService;
import com.grande.app.rutas.services.IServis;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;
@WebServlet ("/camiones/listar")
public class ListaCamionesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = (Connection)  req.getAttribute("conn");
        IServis<Camion> servis = new CamionesService(conn);
        List<Camion> camiones = servis.listas();

        req.setAttribute("camiones",camiones);
        getServletContext().getRequestDispatcher("/listaCamiones.jsp").forward(req,resp);



    }
}
