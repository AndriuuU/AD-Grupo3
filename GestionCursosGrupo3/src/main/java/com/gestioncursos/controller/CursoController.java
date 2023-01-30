package com.gestioncursos.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gestioncursos.constantes.Constantes;
import com.gestioncursos.model.AccionesModels;
import com.gestioncursos.model.AlumnosModel;
import com.gestioncursos.model.CursosModel;
import com.gestioncursos.model.MatriculaModel;
import com.gestioncursos.repository.CursosRepository;
import com.gestioncursos.service.AlumnosService;
import com.gestioncursos.service.CursosService;
import com.gestioncursos.service.MatriculaService;
import com.gestioncursos.service.ProfesoresService;

@Controller
@RequestMapping("/cursos")
public class CursoController {

	@Autowired
	@Qualifier("cursosService")
	private CursosService cursoService;
	
	@Autowired
	@Qualifier("alumnoService")
	private AlumnosService alumnosService;
	
	@Autowired
	@Qualifier("cursosRepository")
	private CursosRepository cursosRepository;
	
	@Autowired
	@Qualifier("matriculaService")
	private MatriculaService matriculaService;


	@Autowired
	@Qualifier("profesoresService")
	private ProfesoresService profesorService;

//	@PreAuthorize("hasRole('ROLE_ADMIN')") NO BORRAR
	@GetMapping("/listCursos")
	public ModelAndView listCursos() {
		ModelAndView mav = new ModelAndView(Constantes.COURSES_VIEW);
		mav.addObject("cursos", cursoService.listAllCursos());
		return mav;	
	}
	
	@GetMapping("/listCursosAlumno")
	public ModelAndView listCursosAlumnos() {
		ModelAndView mav = new ModelAndView(Constantes.COURSES_ALUMNOS_VIEW);
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    String userEmail = authentication.getName();
	    int idAlumno = alumnosService.findByEmail(userEmail).getIdAlumno();
	    long millis=System.currentTimeMillis();  
		Date date = new Date(millis); 
	    List<CursosModel> listCursos = cursoService.listCursosAlumno(idAlumno);
	    List<CursosModel> listCursosFinalizados = new ArrayList<>();
	    
	    
	    for(CursosModel x : listCursos) {
	    	if(x.getFechaFin().before(date))
	    		listCursosFinalizados.add(x);
	    }
	    
		mav.addObject("cursos", listCursosFinalizados);
		mav.addObject("idAlumno", idAlumno);
		
		return mav;
	}

	@PostMapping("/addCurso")
	public String addCurso(@ModelAttribute("curso") CursosModel cursoModel, 
			RedirectAttributes flash) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    String userEmail = authentication.getName();
		if (cursoModel.getIdCurso() != 0) {
			cursoService.updateCurso(cursoModel);
			flash.addFlashAttribute("success", "Curso modificado con éxito");
			return "redirect:/profesores/listCursosEmail/"+userEmail;
		} else {
			cursoService.addCurso(cursoModel);
			flash.addFlashAttribute("success", "Curso insertado con éxito");
			return "redirect:/cursos/listCursos";
		}
		
	}

	@GetMapping(value = { "/formCurso", "/formCurso/{id}" })
	public String formCurso(@PathVariable(name = "id", required = false) Integer id, Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		model.addAttribute("profesores", profesorService.listAllProfesores());
		model.addAttribute("emailProfesor", authentication.getName());
		if (id == null) {
			model.addAttribute("curso", new CursosModel());
		}
		else {
			model.addAttribute("curso", cursoService.findCurso(id));
			System.out.println(id);
		}
		return Constantes.FORM_COURSE;
	}
	
	
	
	// Metodo de borrar
	@GetMapping("/listAlumnosOrdenados")
	public ModelAndView listAlumnosOrdenados() {
		ModelAndView mav = new ModelAndView(Constantes.NOTAS_CURSOS);
	    List<MatriculaModel> listMatriculas = cursoService.listMatriculasAcabadas();
	    List<AlumnosModel> listAlumnos = alumnosService.listAllAlumnos();
	    List<AccionesModels> mediasAlumno = new ArrayList<>();
	    
	    
	    for(AlumnosModel a: listAlumnos) {
	    	float nota = 0;
	    	int nMatriculas = 0;
	    	for(MatriculaModel m : listMatriculas){
	    		if(m.getIdAlumno() == a.getIdAlumno()) {
	    			nota+=m.getValoracion();
	    			nMatriculas++;
	    		}
	    	}
	    	if(nMatriculas!=0) {
	    		mediasAlumno.add(new AccionesModels(a.getNombre().toString(),(nota/nMatriculas)));
	    	}
	    }
	    
	    List<AccionesModels> listMediasOrdenadas= mediasAlumno.stream().sorted(Comparator.comparing(AccionesModels::getValoracion).reversed()).collect(Collectors.toList());

	    mav.addObject("alumnos", listMediasOrdenadas);
		
		return mav;
	}
	
	@GetMapping("/listaMejoresNotas/{idCurso}")
	public ModelAndView listMejoresNotas(@PathVariable(name = "idCurso") int idCurso) {
		ModelAndView mav = new ModelAndView(Constantes.NOTAS_CURSOS);
	    CursosModel curso = cursoService.findCurso(idCurso);
	    List<MatriculaModel> matri= matriculaService.listMatriculasCurso(idCurso);
	    List<AlumnosModel> listAlumnos = alumnosService.listAllAlumnos();
	    List<AccionesModels> mediasAlumno = new ArrayList<>();
	    
	    
	    for(AlumnosModel a: listAlumnos) {
	    	for(MatriculaModel m: matri) {
	    		if(m.getIdCurso() == curso.getIdCurso() && m.getIdAlumno() == a.getIdAlumno()) {
	    			
	    			mediasAlumno.add(new AccionesModels(a.getNombre().toString(),m.getValoracion()));
	    		}
	    	}
	    	
	    }
	    
	    List<AccionesModels> listMediasOrdenadas=mediasAlumno.stream().sorted(Comparator.comparing(AccionesModels::getValoracion).reversed()).limit(3).collect(Collectors.toList());

	    mav.addObject("alumnos", listMediasOrdenadas);
		
		return mav;
	}
	

}
