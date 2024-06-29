package com.grande.app.rutas.controllers;

import com.grande.app.rutas.models.Camion;
import com.grande.app.rutas.models.Chofer;
import com.grande.app.rutas.models.enums.Marcas;
import com.grande.app.rutas.models.enums.Tipos;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

        String checkbook[];
        checkbook = req.getParameterValues("disponibilidad");
        Boolean habilitar;

        if (checkbook != null){
            habilitar = true;
        }else {
            habilitar = false;
        }


        Map<String, String> errores = new HashMap<>();
        if (matricula == null || matricula.isBlank()){
            errores.put("matricula", "ingreda la matricula ");
        }if (tipoCamion == null || tipoCamion.isBlank()){
            errores.put("tipoCamion", "ingresa camion!");
        }if (modelo == null || modelo.isBlank()){
            errores.put("modelo", "ingresa el modelo!");
        }if (marca == null || marca.isBlank()){
            errores.put("marca ", "ingresa la marca!");
        }if (capacidad == null || capacidad.isBlank()){
            errores.put("capacidad", "ingresa la capacidad!");
        }if (kilometro == null || kilometro.isBlank()){
            errores.put("kilometro", "te falto ingresar el kilometro!");
        }

        if (errores.isEmpty()){
            Camion camion = new Camion();
            camion.setId(0L);
            camion.setMatricula(matricula);
            camion.setTipoCamion(Tipos.valueOf(tipoCamion));
            camion.setModelo(Integer.valueOf(modelo));
            camion.setMarca(Marcas.valueOf(marca));
            camion.setCapacidad(Integer.valueOf(capacidad));
            camion.setKilometro(Double.valueOf(kilometro));
            camion.setDisponibilidad(habilitar);
            service.guardar(camion);

            resp.sendRedirect(req.getContextPath()+ "/camiones/alta");

        }else{
            req.setAttribute("error", errores);
            getServletContext().getRequestDispatcher("/altaCamion.jsp").forward(req,resp);
        }



    }
}
