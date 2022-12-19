
package ar.charlycimino.cac.crud.controlador;

import ar.charlycimino.cac.crud.modelo.Alumno;
import ar.charlycimino.cac.crud.modelo.Modelo;
import ar.charlycimino.cac.crud.modelo.ModeloHC;
import ar.charlycimino.cac.crud.modelo.ModeloMySQL;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author Charly Cimino Aprendé más Java en mi canal:
 * https://www.youtube.com/c/CharlyCimino Encontrá más código en mi repo de
 * GitHub: https://github.com/CharlyCimino
 */
@WebServlet(name = "AppServlet", urlPatterns = {"/app"})
public class AppServlet extends HttpServlet {
    
    private static final String URI_LIST = "WEB-INF/pages/alumnos/listadoAlumnos.jsp";
    private static final String URI_REMOVE = "WEB-INF/pages/alumnos/borrarAlumno.jsp";
    private static final String URI_EDIT = "WEB-INF/pages/alumnos/editarAlumno.jsp";
    private static final String URI_MOSTRAR = "WEB-INF/pages/alumnos/mostrarAlumno.jsp";

    
    private Modelo model;

    @Override
    public void init() throws ServletException {
        model = new ModeloMySQL();
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String laAccion = req.getParameter("accion");
        String idstr =req.getParameter("id");
        
        int id = (idstr == null ?-1 :Integer.parseInt(idstr) );
        laAccion=(laAccion==null?"":laAccion);
        
        switch(laAccion){
                case "remove":
                    req.setAttribute("alumnoABorrar", model.getAlumno(id));
                    req.getRequestDispatcher(URI_REMOVE).forward(req , resp);
                    //model.removeAlumno(id);
                break;
                
                case "edit":
                    req.setAttribute("alumnoAEditar", model.getAlumno(id));
                    req.setAttribute("yaTieneFoto", !model.getAlumno(id).getFoto().contains("no-face"));
                    req.getRequestDispatcher(URI_EDIT).forward(req , resp);
                   
                break; 
                
                case "mostrar":
                    req.setAttribute("alumnoAMostrar", model.getAlumno(id));
                    req.getRequestDispatcher(URI_MOSTRAR).forward(req , resp);
                    break;
                
                default:
        req.setAttribute("listaAlumnos", model.getAlumnos());
        req.getRequestDispatcher(URI_LIST).forward(req, resp);        
        }
    
    }
    
    
     @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String laAccion = req.getParameter("accion");
        String idstr =req.getParameter("id");
        
        int id = (idstr == null ?-1 :Integer.parseInt(idstr) );
        laAccion=(laAccion==null?"":laAccion);
        
        switch(laAccion){
                case "delete":
                    model.removeAlumno(id);
                    
                break;
                
                case "update":
                    Alumno alu = model.getAlumno(id);
                    cargarAlumnoSegunParams(alu,req);
                    model.updateAlumno(alu);
                    
                break; 
                
                case "add":
                    Alumno aluAgregar = new Alumno(); 
                    cargarAlumnoSegunParams(aluAgregar, req);
                    model.addAlumno(aluAgregar);
                    
                    break;
                
                default:       
        }
        resp.sendRedirect(getServletContext().getContextPath()+"/app");

        
        
    }
private void cargarAlumnoSegunParams(Alumno a, HttpServletRequest request)
        {
            
            a.setNombre(request.getParameter("nombre"));
            a.setApellido(request.getParameter("apellido"));
            a.setMail(request.getParameter("mail"));
            a.setFechaNacimiento(request.getParameter("fechaNac"));
            a.setFoto(request.getParameter("fotoBase64"));
        }
    
}