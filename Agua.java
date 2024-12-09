package controller.practica2;

import java.util.Scanner;

import controller.util.Utilidades;

public class Agua {
    // Metodo para calcular el descuento por discapacidad
    public static float descuentoDiscpacidad (float porcentaje, float rubro){
       float descuento_disca= 0;
        if (rubro <= 15) {
            descuento_disca = rubro *(porcentaje/100);
        }else{
            descuento_disca = (15 * 3) *(porcentaje/100);
        }
        return descuento_disca;
    }
    // Metodo para calcular el descuento por tercera Edad
    public static float descuentoEdad (float consumo){
        float descuentoTerceraEdad = 0.0f;
        if (consumo <= 15) {
            descuentoTerceraEdad = consumo * (float)(0.5);
        }else{
            descuentoTerceraEdad = (15 * 3) * (float)(0.3);
        }
        return descuentoTerceraEdad;
        }
    // Metodo para calcular el valor del rubro, basandose solo en el consumo
    public static float rubroaPagar (float consumo){
       float rubroApagar = 0.0f;
        if (consumo<=15) {
            rubroApagar = 3;
        }else if (consumo <=25) {
            rubroApagar = 3 + (consumo-15)*(float)(0.1);
        }else if (consumo <=40) {
            rubroApagar = (15 * 3) + 10 *(float)(0.1) + (consumo -25)*(float)(0.2);
        }else if (consumo <=60) {
            rubroApagar = (15 * 3) + 10 * (float)(0.1) + 15 *(float)(0.2) + (consumo - 40) * (float)(0.3);
        }else{
            rubroApagar = (15 * 3) + 10 * (float)(0.1) + 15 *(float)(0.2) + (consumo - 60) * (float)(0.35);
        }
        return rubroApagar;
    }
    // Metodo para calcular el impuesto por alcantarillado
    public static float impuestoAlcantarillado(float rubro){
        float alcantarillado = rubro * 35/100;
        return alcantarillado;
    }

    public void ejecutar() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el valor de consumo de m3: ");
        float consumo = sc.nextFloat();
        float rubro = rubroaPagar(consumo);
        System.out.println("Es de la tercera edad ¿Si o No?");
        String sinoterceraedadString= sc.next();

        // Si es persona de tercera edad desarrollar el if
        if (sinoterceraedadString.equalsIgnoreCase("si")) {
            rubro= rubro -descuentoEdad(consumo);
        }
        System.out.println("Tiene alguna discapacidad ¿Si o no?");
        String sinoDiscapacidadString = sc.next();
        
        // Si tiene discapacidad desarrollar el if
        if (sinoDiscapacidadString.equalsIgnoreCase("si")) {
            System.out.println("Ingrese el porcentaje de discapacidad: ");
            float porcentajeDisca = sc.nextFloat();
            rubro = rubro - descuentoDiscpacidad(porcentajeDisca, rubro);
        }
        float totalPagar = 0.0f;
        float alcantarillado = impuestoAlcantarillado(rubro);
        totalPagar= (rubro + alcantarillado + (float)(5.0/10 + 75.0/100)); 
        System.out.println("El valor a cancelar por "+ consumo+" de m3, es: $ "+ Utilidades.redondearFloat(totalPagar));
        sc.close();
    }
    
}
