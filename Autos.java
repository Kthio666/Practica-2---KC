package controller.practica2;

import java.util.Scanner;

public class Autos {
    // Metodo para calcular la utilidad
    public static float calcularUtilidad (float totalVentas){
        return totalVentas*(0.05f);
    }

    // Metodo para mostrar el informe
    public static void mostrarInformes (int autosVendidos, float totalVentas, float sueldoBasico, float comision, float utilidad, float sueldoTotal ){
        System.out.println("------------------INFORME-----------------------");
        System.out.println("Número de autos vendidos: " + autosVendidos); 
        System.out.println("Valor total de los autos vendidos: $" + totalVentas); 
        System.out.println("Sueldo mensual: $" + sueldoBasico); 
        System.out.println("Comisión por autos vendidos: $" + comision); 
        System.out.println("Valor de utilidad por ventas: $" + utilidad); 
        System.out.println("TOTAL A PAGAR AL FINAL DE MES: $" + sueldoTotal);
    }

    // Calcula el sueldo total
    public static float sueldoTotal ( float comision, float utilidad){
        float sueldoBasico = 2500.0f;
        return sueldoBasico + comision + utilidad;
    }
    // Metodo para calcular lo que se pide pero como para un empleado
    public static void pagarEmpleado (Scanner sc){
        System.out.println("Ingrese el numero de autos que vendio : ");
        int num_autos = sc.nextInt();
            float comision= 0.0f, utilidad= 0.0f, totalVentas = 0.0f;
            int autosVendidos = 0;
            if (num_autos >=1) {
                for(int i =1; i<=num_autos;i++){
                    System.out.println("Ingrese el valor del auto # "+i);
                    double precio = sc.nextDouble();
                    // Para determinar el valor de comision
                    if (precio > 10000) {
                        comision += 250;
                    }
                    totalVentas += precio;
                    autosVendidos ++;
                    }
            } 
            utilidad = calcularUtilidad(totalVentas);
            float sueldoBasico = 2500.0f;
            float sueldoTotal = sueldoTotal(comision, utilidad);
            // Imprimir el informe con uso del metodo
            mostrarInformes(autosVendidos, totalVentas, sueldoBasico, comision, utilidad, sueldoTotal);
    }   

    public void ejecutar() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el número de empleados:"); 
        int numEmpleados = sc.nextInt(); 
        for (int i = 1; i <= numEmpleados; i++) { 
            System.out.println("-------------------EMPLEADO " + i); 
            pagarEmpleado(sc); }
        sc.close();
        }
    }
