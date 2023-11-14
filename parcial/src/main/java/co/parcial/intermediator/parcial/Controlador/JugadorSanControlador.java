package co.parcial.intermediator.parcial.Controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import co.parcial.intermediator.parcial.DTO.JugadorSanDTO;
import co.parcial.intermediator.parcial.Servicio.JugadorSanServicio;

@RestController
@RequestMapping("/jugador")
public class JugadorSanControlador {
    @Autowired
    private JugadorSanServicio jugadorSanServicio;

    @PostMapping
    public void crearJugador(@RequestBody JugadorSanDTO jugadorDTO) {
        jugadorSanServicio.crearJugador(jugadorDTO);
    }
    @GetMapping("/{id}")
    public JugadorSanDTO buscarID(@PathVariable Long id) {
        return jugadorSanServicio.buscarID(id);
    }
    @GetMapping
    public List<JugadorSanDTO> todos() {
        return jugadorSanServicio.todos();
    }
    @DeleteMapping("/{id}")
    public void borrarJugador(@PathVariable Long id) {
        jugadorSanServicio.borrarJugador(id);
    }
    @PutMapping("/{id}")
    public void actualizarJugador(@PathVariable Long id, @RequestBody JugadorSanDTO jugadorDTO) {
        jugadorSanServicio.actualizarJugador(id, jugadorDTO);
    }
    
}
