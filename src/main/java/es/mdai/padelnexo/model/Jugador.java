package es.mdai.padelnexo.model;

public class Jugador {

    private Long id;
    private String nombre;
    private String nivel;
    private String posicion;
    private String zona;
    private int partidosJugados;
    private int victorias;

    public Jugador(Long id,
                   String nombre,
                   String nivel,
                   String posicion,
                   String zona,
                   int partidosJugados,
                   int victorias) {

        this.id = id;
        this.nombre = nombre;
        this.nivel = nivel;
        this.posicion = posicion;
        this.zona = zona;
        this.partidosJugados = partidosJugados;
        this.victorias = victorias;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNivel() {
        return nivel;
    }

    public String getPosicion() {
        return posicion;
    }

    public String getZona() {
        return zona;
    }

    public int getPartidosJugados() {
        return partidosJugados;
    }

    public int getVictorias() {
        return victorias;
    }

    public double getPorcentajeVictorias() {

        if (partidosJugados == 0) {
            return 0;
        }

        return (victorias * 100.0) / partidosJugados;
    }
}