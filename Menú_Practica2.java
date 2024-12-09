package controller.practica2;

import java.util.Scanner;

public class Menú_Practica2 {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int op;
        System.out.println("-----------------   Bienvenidoooooooo   ----------------");
        System.out.println("Ingrese el número de  lo que desea realizar: ");
        System.out.println("1.  Informe de los empleados por la venta de autos");
        System.out.println("2.  Cuanto tengo que cancelar por la llamada");
        System.out.println("3.  Valor a cancelar por el consumo de agua");
        System.out.println("4.  Generar y resolver una serie numérica");
        op = sc.nextInt();
        switch (op) {
            case 1:
                Autos autos = new Autos();
                autos.ejecutar();
                break;
            case 2:
                Llamadas llamada = new Llamadas();
                llamada.ejecutar();
                break;
            case 3:
                Agua agua = new Agua();
                agua.ejecutar();
                break;
            case 4:
                Serie serie = new Serie();
                serie.ejecutar();
                break;
            default:
                System.out.println("Ingrese un numero disponible");
                break;
        }

    }
}
