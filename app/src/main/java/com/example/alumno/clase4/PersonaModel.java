package com.example.alumno.clase4;

public class PersonaModel {
    private String nombre;
    private String apellido;
    private String telefono;

    public PersonaModel(){

    }
    public PersonaModel(String nombre, String apellido, String telefono){
        this.apellido = apellido;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getApellido() {
        return apellido;
    }
    public void setSexo(String sexo) {
        this.telefono = sexo;
    }
    public String getSexo() {
        return telefono;
    }
    @Override
    public String toString() {
        return "PersonaModel{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", sexo='" + telefono + '\'' +
                '}';
    }

}
