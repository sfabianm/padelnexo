package es.mdai.padelnexo.controller;

import es.mdai.padelnexo.model.Jugador;
import es.mdai.padelnexo.service.JugadorService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Controller
public class JugadorController {

    private final JugadorService jugadorService;

    public JugadorController(JugadorService jugadorService) {
        this.jugadorService = jugadorService;
    }

    @GetMapping("/jugadores")
    public String listar(
            @RequestParam(required = false) String nivel,
            Model model) {

        List<Jugador> jugadores = (nivel != null && !nivel.isBlank())
                ? jugadorService.buscarPorNivel(nivel)
                : jugadorService.listarTodos();

        model.addAttribute("jugadores", jugadores);
        model.addAttribute("nivel", nivel);
        model.addAttribute("niveles",
                jugadorService.listarNiveles());

        return "jugadores";
    }

    @GetMapping("/jugadores/{id}")
    public String detalle(
            @PathVariable Long id,
            Model model) {

        Jugador jugador = jugadorService.buscarPorId(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Jugador no encontrado"));

        model.addAttribute("jugador", jugador);

        return "detalle_jugador";
    }
}