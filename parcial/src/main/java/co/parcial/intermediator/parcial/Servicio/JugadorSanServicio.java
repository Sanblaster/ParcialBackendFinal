package co.parcial.intermediator.parcial.Servicio;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.parcial.intermediator.parcial.DTO.JugadorSanDTO;
import co.parcial.intermediator.parcial.Modelo.EquipoSan;
import co.parcial.intermediator.parcial.Modelo.JugadorSan;
import co.parcial.intermediator.parcial.Repositorio.EquipoSanRepositorio;
import co.parcial.intermediator.parcial.Repositorio.JugadorSanRepositorio;

@Service
public class JugadorSanServicio {

    @Autowired
    private JugadorSanRepositorio jugadorSanRepositorio;
    @Autowired
    private EquipoSanRepositorio equipoSanRepositorio;

    private JugadorSanDTO convertirDTO(JugadorSan jugador) {
        JugadorSanDTO dto = new JugadorSanDTO();
        dto.setId(jugador.getId());
        dto.setNombre(jugador.getNombre());
        dto.setApellido(jugador.getApellido());
        dto.setNumero(jugador.getNumero());
        if (jugador.getEquipoSan() != null) {
            dto.setEquipoSanId(jugador.getEquipoSan().getId());
        } else {
            dto.setEquipoSanId(null);
        }
        return dto;
    }

    public JugadorSan convertirJugador(JugadorSanDTO dto) {
        JugadorSan jugador = new JugadorSan();
        jugador.setId(dto.getId());
        jugador.setNombre(dto.getNombre());
        jugador.setApellido(dto.getApellido());
        jugador.setNumero(dto.getNumero());
        if (dto.getEquipoSanId() != null) {
            Optional<EquipoSan> equipo = equipoSanRepositorio.findById(dto.getId());
            if(equipo.isPresent())
            {
                EquipoSan agregar= equipo.get();
                jugador.setEquipoSan(agregar);
            }
            else
            {
               jugador.setEquipoSan(null);
            }
        }
        else
        {
            jugador.setEquipoSan(null);
        }
        return jugador;
    }

    public void crearJugador(JugadorSanDTO jugadorDTO) {
        JugadorSan agregar = convertirJugador(jugadorDTO);
        jugadorSanRepositorio.save(agregar);
    }

    public JugadorSanDTO buscarID(Long id) {
        Optional<JugadorSan> buscar = jugadorSanRepositorio.findById(id);
        if (buscar.isPresent()) {
            JugadorSan encontrado = buscar.get();
            JugadorSanDTO dto = convertirDTO(encontrado);
            return dto;
        }
        return null;
    }

    public void borrarJugador(Long id) {
        jugadorSanRepositorio.deleteById(id);
    }

    public void actualizarJugador(Long id, JugadorSanDTO jugadorDTO) {
        JugadorSan buscar=convertirJugador(jugadorDTO);
        Optional<JugadorSan> encontrado = jugadorSanRepositorio.findById(id);
        if(encontrado.isPresent())
        {
            jugadorSanRepositorio.save(buscar);
        }
   
    }

    public List<JugadorSanDTO> todos() {
        List<JugadorSan> jugadores = jugadorSanRepositorio.findAll();
        return jugadores.stream()
                .map(this::convertirDTO)
                .collect(Collectors.toList());

    }

}
