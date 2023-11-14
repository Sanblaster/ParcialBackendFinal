package co.parcial.intermediator.parcial.Controlador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import co.parcial.intermediator.parcial.DTO.EquipoSanDTO;
import co.parcial.intermediator.parcial.Servicio.EquipoSanServicio;

import java.util.List;

@RestController
@RequestMapping("/equipo")
public class EquipoSanControlador {

    @Autowired
    private EquipoSanServicio equipoSanServicio;

    @PostMapping
    public void crearEquipo(@RequestBody EquipoSanDTO equipoDTO) {
        equipoSanServicio.crearEquipo(equipoDTO);
    }

    @GetMapping("/{id}")
    public EquipoSanDTO buscarIDEquipo(@PathVariable Long id) {
        return equipoSanServicio.buscarIDEquipo(id);
    }

    @GetMapping
    public List<EquipoSanDTO> todosEquipos() {
        return equipoSanServicio.todosEquipos();
    }

    @DeleteMapping("/{id}")
    public void borrarEquipo(@PathVariable Long id) {
        equipoSanServicio.borrarEquipo(id);
    }

    @PutMapping("/{id}")
    public void actualizarEquipo(@PathVariable Long id, @RequestBody EquipoSanDTO equipoDTO) {
        equipoSanServicio.actualizarEquipo(id, equipoDTO);
    }
}
