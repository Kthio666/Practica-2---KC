package controller.practica2;

import java.util.Scanner;

public class Llamadas {
    // Catalogo de las Zonas Geográficas
    enum ZonaGeografica {
        AMERICA_DEL_NORTE(12, 2.75),
        AMERICA_CENTRAL(15, 1.89),
        AMERICA_DEL_SUR(18, 1.60),
        EUROPA(19, 3.50),
        ASIA(23, 4.50),
        AFRICA(25, 3.10),
        OCEANIA(29, 3.00),
        RESTO_DEL_MUNDO(31, 6.00);

        // Se le agrega final porque constantes
        private final int clave;
        private final double precioMinuto;

        ZonaGeografica(int clave, double precioMinuto) {
            this.clave = clave;
            this.precioMinuto = precioMinuto;
        }
        public int getClave() {
            return clave;
        }
        public double getPrecioPorMinuto() {
            return precioMinuto;
        } 
        public static ZonaGeografica fromClave (int clave) {
            for (ZonaGeografica zona : values()) {
                if (zona.getClave() == clave)
                    return zona;
            }
            throw new IllegalArgumentException("Clave de zona desconocida: " + clave);
        }

    }
    // Metodo calcula el costo
    public static double calcularCosto(ZonaGeografica zona, int minutos) { 
        return zona.getPrecioPorMinuto() * minutos; 
    } 
    public void ejecutar() { 
        Scanner sc = new Scanner(System.in); 
        System.out.println("Zonas geográficas disponibles:"); 
        System.out.println("Ingrese la clave de la zona geográfica del pais al que llamó:");
        for (ZonaGeografica zona : ZonaGeografica.values()) { 
            System.out.println(zona.getClave() + " - " + zona.name()); 
        }
        int claveZona = sc.nextInt(); 
        ZonaGeografica zona = ZonaGeografica.fromClave(claveZona); 
        System.out.println("Ingrese el número de minutos hablados:"); 
        int minutos = sc.nextInt(); 
        double costoTotal = calcularCosto(zona, minutos); 
        System.out.println("El costo total de la llamada es: $" + costoTotal); 
        sc.close();
    } 
}
   

