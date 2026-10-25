package es.mdai.padelnexo.service;

import es.mdai.padelnexo.model.Jugador;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class JugadorService {

    private final AtomicLong siguienteId = new AtomicLong(9);

    private final List<Jugador> jugadores = new CopyOnWriteArrayList<>();

    private final String nombreAplicacion;
    private final String zonaDestacada;
    private final int minimoVictorias;

    public JugadorService(
            @Value("${padelnexo.nombre}") String nombreAplicacion,
            @Value("${padelnexo.zona-destacada}") String zonaDestacada,
            @Value("${padelnexo.minimo-victorias:20}") int minimoVictorias) {

        this.nombreAplicacion = nombreAplicacion;
        this.zonaDestacada = zonaDestacada;
        this.minimoVictorias = minimoVictorias;

        jugadores.add(new Jugador(
                1L,
                "Samuel",
                "Intermedio",
                "Drive",
                "Merida",
                40,
                25
        ));

        jugadores.add(new Jugador(
                2L,
                "Carlos",
                "Avanzado",
                "Reves",
                "Badajoz",
                65,
                45
        ));

        jugadores.add(new Jugador(
                3L,
                "Arantxa",
                "Iniciacion",
                "Drive",
                "Merida",
                15,
                7
        ));

        jugadores.add(new Jugador(
                4L,
                "Mario",
                "Intermedio",
                "Reves",
                "Caceres",
                30,
                18
        ));

        jugadores.add(new Jugador(
                5L,
                "Lucia",
                "Avanzado",
                "Drive",
                "Sevilla",
                55,
                38
        ));

        jugadores.add(new Jugador(
                6L,
                "David",
                "Intermedio",
                "Reves",
                "Cordoba",
                28,
                15
        ));

        jugadores.add(new Jugador(
                7L,
                "Paula",
                "Iniciacion",
                "Drive",
                "Merida",
                12,
                5
        ));

        jugadores.add(new Jugador(
                8L,
                "Javier",
                "Avanzado",
                "Reves",
                "Badajoz",
                80,
                60
        ));
    }

    public List<Jugador> listarTodos() {
        return List.copyOf(jugadores);
    }

    public Optional<Jugador> buscarPorId(Long id) {
        return jugadores.stream()
                .filter(jugador -> jugador.getId().equals(id))
                .findFirst();
    }

    public List<Jugador> buscarPorNivel(String nivel) {
        return jugadores.stream()
                .filter(jugador ->
                        jugador.getNivel().equalsIgnoreCase(nivel))
                .toList();
    }

    public List<Jugador> buscarPorZona(String zona) {
        return jugadores.stream()
                .filter(jugador ->
                        jugador.getZona().equalsIgnoreCase(zona))
                .toList();
    }

    public List<Jugador> buscarDestacados() {
        return jugadores.stream()
                .filter(jugador ->
                        jugador.getVictorias() >= minimoVictorias)
                .toList();
    }

    public String getNombreAplicacion() {
        return nombreAplicacion;
    }

    public String getZonaDestacada() {
        return zonaDestacada;
    }

    public int getMinimoVictorias() {
        return minimoVictorias;
    }
    public List<String> listarNiveles() {
        return jugadores.stream()
                .map(Jugador::getNivel)
                .distinct()
                .sorted()
                .toList();
    }
}