package com.grande.app.rutas.controllers;

import com.grande.app.rutas.models.Chofer;
import com.grande.app.rutas.services.ChoferesService;
import com.grande.app.rutas.services.IServis;
import jakarta.jws.WebService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.imageio.spi.IIOServiceProvider;
import javax.swing.text.html.HTML;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet("/choferes/listar")

public class ListaChoferesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = (Connection)  req.getAttribute("conn");

        IServis<Chofer> servis = new ChoferesService(conn);
        List<Chofer> choferes = servis.listas();

        /*for (Chofer c: choferes){
            resp.getWriter().println("<h1>" + c.getId()+ "->"
            +c.getNombre()+ "->" + c.getApPaterno()+"</h1>");
        }*/
        req.setAttribute("choferes", choferes);
        getServletContext().getRequestDispatcher("/listaChoferes.jsp").forward(req, resp);
    }
}
