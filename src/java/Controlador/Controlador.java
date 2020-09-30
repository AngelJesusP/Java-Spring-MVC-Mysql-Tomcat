/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import org.springframework.stereotype.Controller;
import Conexion.ConexionMysql;
import Entidad.PersonaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMethod;
import java.sql.Timestamp;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author angel
 */
@Controller
public class Controlador {

    private ConexionMysql conexion = new ConexionMysql();
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(conexion.getConexion());
    private ModelAndView modelAndView = new ModelAndView();

    private String SELECT = "SELECT * FROM personaTest";
    private String INSERT = "INSERT INTO personaTest(codigoId, nombre, apellido, sueldo, fechaIngreso)"
            + "VALUES(?,?,?,?,?)";
    private String DELETE = "DELETE FROM personaTest WHERE codigoId = ?";
    private String UPDATE = "UPDATE personaTest SET nombre = ?, apellido = ?, sueldo = ? WHERE codigoId = ?";

    @RequestMapping(value = "index.htm", method = RequestMethod.GET)
    public ModelAndView getListar() {
        List lista = this.jdbcTemplate.queryForList(SELECT);
        this.modelAndView.addObject("persona", lista);
        this.modelAndView.setViewName("index");
        return this.modelAndView;
    }

    @RequestMapping(value = "index.htm", method = RequestMethod.POST)
    public ModelAndView setAgregar(PersonaTest persona) {

        if (this.getIdExistente(persona.getCodigoId()) == 0) {
            Date fecha = new Date();
            Timestamp timestamp = new Timestamp(fecha.getTime());
            Timestamp myTimeStamp = timestamp;
            this.jdbcTemplate.update(INSERT,
                    persona.getCodigoId(),
                    persona.getNombre(),
                    persona.getApellido(),
                    persona.getSueldo(),
                    myTimeStamp
            );
        } else {
            this.jdbcTemplate.update(UPDATE,
                    persona.getNombre(),
                    persona.getApellido(),
                    persona.getSueldo(),
                    persona.getCodigoId()
            );
        }
        return new ModelAndView("redirect:/index.htm");
    }

    @RequestMapping(value = "delete.htm")
    public ModelAndView setEliminarTest(HttpServletRequest request) {
        int codigoId = Integer.parseInt(request.getParameter("id"));
        this.jdbcTemplate.update(DELETE, codigoId);
        return new ModelAndView("redirect:/index.htm");
    }

    public int getIdExistente(int id) {
        String SQL = "SELECT * FROM personaTest WHERE codigoId = " + id;
        List lista = this.jdbcTemplate.queryForList(SQL);
        return lista.size();
    }
}
