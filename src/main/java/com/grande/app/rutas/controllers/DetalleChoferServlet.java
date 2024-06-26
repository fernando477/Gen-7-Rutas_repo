package com.grande.app.rutas.controllers;

import com.grande.app.rutas.models.Chofer;
import com.grande.app.rutas.services.ChoferesService;
import com.grande.app.rutas.services.IServis;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.util.Optional;

@WebServlet("/choferes/detalle")
public class DetalleChoferServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = (Connection) req.getAttribute("conn");

        IServis<Chofer> service = new ChoferesService(conn);

        long id;
        try {
            id = Long.parseLong(req.getParameter("id"));

        }catch (NumberFormatException e){
            id = 0L;
        }
        Chofer chofer = new Chofer();

        if (id > 0 ){
            Optional<Chofer> o = service.getById(id);
            if (o.isPresent()){
                chofer = o.get();
                req.setAttribute("chofer", chofer);
                getServletContext().getRequestDispatcher("/detalleChofer.jsp").forward(req,resp);
            }else {
                resp.sendError(HttpServletResponse.SC_NOT_FOUND, "no existe el chofer de la base de datps!");
            }
        }else {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND,"Error el id es null, se debe enviar como parametro en el url!");
        }
    }
}
