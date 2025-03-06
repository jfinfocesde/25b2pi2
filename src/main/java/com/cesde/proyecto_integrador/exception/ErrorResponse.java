package com.cesde.proyecto_integrador.exception;

public class ErrorResponse {
    private String mensaje;  // Mensaje legible para el usuario
    private int codigo;      // Código HTTP (ej. 404, 500)
    private String detalle;  // Detalle técnico del error (opcional)

    public ErrorResponse(String mensaje, int codigo, String detalle) {
        this.mensaje = mensaje;
        this.codigo = codigo;
        this.detalle = detalle;
    }

    // Getters y setters
    public String getMensaje() { return mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }
    public int getCodigo() { return codigo; }
    public void setCodigo(int codigo) { this.codigo = codigo; }
    public String getDetalle() { return detalle; }
    public void setDetalle(String detalle) { this.detalle = detalle; }
}
