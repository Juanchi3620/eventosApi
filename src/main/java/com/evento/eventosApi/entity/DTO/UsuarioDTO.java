package com.evento.eventosApi.entity.DTO;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {
    private Long id;
    private String correo;
    private String contrasena;
    private RolDTO rolDTO;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public RolDTO getRolDTO() {
        return rolDTO;
    }

    public void setRolDTO(RolDTO rolDTO) {
        this.rolDTO = rolDTO;
    }

    @Override
    public String toString() {
        return "UsuarioDTO{" +
                "id=" + id +
                ", correo='" + correo + '\'' +
                ", contrasena='" + contrasena + '\'' +
                ", rolDTO=" + rolDTO +
                '}';
    }
}
