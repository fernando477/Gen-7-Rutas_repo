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

@WebServlet("/choferes/eliminar")
public class EliminarChoferServlet extends HttpServlet {
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
                service.eliminar(id);
                resp.sendRedirect(req.getContextPath()+ "/choferes/listar");

             }else {
                resp.sendError(HttpServletResponse.SC_NOT_FOUND, "no existe el chofer de la base de datps!");
            }
        }else {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND,"Error el id es null, se debe enviar como parametro en el url!");
        }
    }

}
