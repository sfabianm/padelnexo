package es.mdai.padelnexo.controller;

import es.mdai.padelnexo.model.Jugador;
import es.mdai.padelnexo.service.JugadorService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/jugadores")
public class JugadorRestController {

    private final JugadorService jugadorService;

    public JugadorRestController(JugadorService jugadorService) {
        this.jugadorService = jugadorService;
    }

    @GetMapping
    public List<Jugador> listar(
            @RequestParam(required = false) String nivel) {

        if (nivel != null && !nivel.isBlank()) {
            return jugadorService.buscarPorNivel(nivel);
        }

        return jugadorService.listarTodos();
    }

    @GetMapping("/destacados")
    public List<Jugador> destacados() {
        return jugadorService.buscarDestacados();
    }

    @GetMapping("/nivel/{nivel}")
    public List<Jugador> buscarPorNivel(
            @PathVariable String nivel) {

        return jugadorService.buscarPorNivel(nivel);
    }

    @GetMapping("/zona/{zona}")
    public List<Jugador> buscarPorZona(
            @PathVariable String zona) {

        return jugadorService.buscarPorZona(zona);
    }

    @GetMapping("/{id}")
    public Jugador obtener(@PathVariable Long id) {

        return jugadorService.buscarPorId(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Jugador no encontrado"));
    }
}