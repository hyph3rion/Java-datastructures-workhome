package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;
 private int cedula;
 private String nombre;
 private long telefono;
 private String[] tipoDeCliente; //array
 private ArrayList<String> tipoDeAtencion = new ArrayList<String>(); //list
 private int cantidad;
 private String[] prioridadAtencion; //array
 private Date fechaCita;
 
 public Cliente(int cedulaP, String nombreP, long telefonoP, String[] tipoDeClienteP, ArrayList<String> tipoDeAtencionP, int cantidadP, String[] prioridadAtencionP, Date fechaCitaP) {
	 super();
	 this.cedula = cedulaP;
	 this.nombre = nombreP;
	 this.telefono = telefonoP;
	 this.tipoDeCliente = tipoDeClienteP;
	 this.tipoDeAtencion = tipoDeAtencionP;
	 this.cantidad = cantidadP;
	 this.prioridadAtencion = prioridadAtencionP;
	 this.fechaCita = fechaCitaP;
 }

 public int getCedula() {
	return cedula;
 }

 public void setCedula(int cedula) {
	this.cedula = cedula;
 }

 public String getNombre() {
	return nombre;
 }

 public void setNombre(String nombre) {
	this.nombre = nombre;
 }

 public long getTelefono() {
	return telefono;
 }

 public void setTelefono(long telefono) {
	this.telefono = telefono;
 }

 public String[] getTipoDeCliente() {
	return tipoDeCliente;
 }

 public void setTipoDeCliente(String[] tipoDeCliente) {
	this.tipoDeCliente = tipoDeCliente;
 }

 public ArrayList<String> getTipoDeAtencion() {
	return tipoDeAtencion;
 }

 public void setTipoDeAtencion(ArrayList<String> tipoDeAtencion) {
	this.tipoDeAtencion = tipoDeAtencion;
 }

 public int getCantidad() {
	return cantidad;
 }

 public void setCantidad(int cantidad) {
	this.cantidad = cantidad;
 }

 public String[] getPrioridadAtencion() {
	return prioridadAtencion;
 }

 public void setPrioridadAtencion(String[] prioridadAtencion) {
	this.prioridadAtencion = prioridadAtencion;
 }

 public Date getFechaCita() {
	return fechaCita;
 }

 public void setFechaCita(Date fechaCita) {
	this.fechaCita = fechaCita;
 }

 @Override
 public String toString() {
	return "Cliente [cedula=" + cedula + ", nombre=" + nombre + ", telefono=" + telefono + ", tipoDeCliente="
			+ tipoDeCliente + ", tipoDeAtencion=" + tipoDeAtencion + ", cantidad=" + cantidad + ", prioridadAtencion="
			+ Arrays.toString(prioridadAtencion) + ", fechaCita=" + fechaCita + "]";
 }
}




