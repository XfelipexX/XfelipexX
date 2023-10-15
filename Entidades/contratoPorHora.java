package Entidades;

import java.sql.Date;

import javax.xml.crypto.Data;

public class contratoPorHora {
private Date data;
private double valorporhoras;
private int horas;

public contratoPorHora(Date data, double valorporhoras, int horas) {
    this.data = data;
    this.valorporhoras = valorporhoras;
    this.horas = horas;
}

public contratoPorHora() {
}

public Date getData() {
    return data;
}

public void setData(Date data) {
    this.data = data;
}

public double getValorporhoras() {
    return valorporhoras;
}

public int getHoras() {
    return horas;
}

public void setHoras(int horas) {
    this.horas = horas;
}

public void setValorporhoras(double valorporhoras) {
    this.valorporhoras = valorporhoras;
}

public Double valorTotal(){
    return valorporhoras*horas;
}
    
}