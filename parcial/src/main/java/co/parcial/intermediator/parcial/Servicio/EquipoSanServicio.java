package co.parcial.intermediator.parcial.Servicio;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.parcial.intermediator.parcial.DTO.EquipoSanDTO;
import co.parcial.intermediator.parcial.Modelo.EquipoSan;
import co.parcial.intermediator.parcial.Repositorio.EquipoSanRepositorio;;

@Service
public class EquipoSanServicio {

    @Autowired
    private EquipoSanRepositorio equipoSanRepositorio;

    private EquipoSanDTO ConvertirDto(EquipoSan equipo) {
        EquipoSanDTO Dto = new EquipoSanDTO();
        Dto.setCiudad(equipo.getCiudad());
        Dto.setCopasInternacionales(equipo.getCopasInternacionales());
        Dto.setNombre(equipo.getNombre());
        Dto.setId(equipo.getId());
        return Dto;
    }

    private EquipoSan convertirEquipo(EquipoSanDTO dto) {
        EquipoSan equipo = new EquipoSan();
        equipo.setId(dto.getId());
        equipo.setNombre(dto.getNombre());
        equipo.setCiudad(dto.getCiudad());
        equipo.setCopasInternacionales(dto.getCopasInternacionales());
        return equipo;
    }

    public void crearEquipo(EquipoSanDTO equipoDTO) {
        EquipoSan equipo = convertirEquipo(equipoDTO);
        equipoSanRepositorio.save(equipo);
    }

    public EquipoSanDTO buscarIDEquipo(Long id) {
        Optional<EquipoSan> buscar = equipoSanRepositorio.findById(id);
        if(buscar.isPresent())
        {
            return ConvertirDto(buscar.get());
        }
        return null;
    }

    public void borrarEquipo(Long id) {
        equipoSanRepositorio.deleteById(id);
    }

    public void actualizarEquipo(Long id, EquipoSanDTO equipoDTO) {
        Optional<EquipoSan> encontrado = equipoSanRepositorio.findById(id);
        if(encontrado.isPresent())
        {
          equipoSanRepositorio.save(encontrado.get());  
        }
    }

    public List<EquipoSanDTO> todosEquipos() {
        List<EquipoSan> equipos = equipoSanRepositorio.findAll();
        return equipos.stream()
                .map(this::ConvertirDto)
                .collect(Collectors.toList());
    }

}
