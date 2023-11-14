package co.parcial.intermediator.parcial.DTO;

public class EquipoSanDTO {
    private Long id;
    private String nombre;
    private String ciudad;
    private int copasInternacionales;
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    public void setCopasInternacionales(int copasInternacionales) {
        this.copasInternacionales = copasInternacionales;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCiudad() {
        return ciudad;
    }
    public int getCopasInternacionales() {
        return copasInternacionales;
    }
    public Long getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    } 
}
