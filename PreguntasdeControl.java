package controller.practica2;

import java.util.Scanner;

public class PreguntasdeControl {
    
    // Pregunta 2. Estructura condicional MIENTRAS con contadores 
    public static void pregunta2(){
        int cont = 1; 
        while (cont <= 4) {
            System.out.println("Contador: " + cont);
            System.out.println("Su doble: " + cont*2);
            cont++;
        }
    }
    // Pregunta 3. Estructura condicional HACER … MIENTRAS con BANDERAS
    public static int pregunta3(){
        boolean bandera = false; 
        Scanner scanner= new Scanner(System.in); 
        int num ;
        do {
            System.out.println("Escriba un número");
             num = scanner.nextInt();
            if (num >= 10) {
                bandera = true;
            } else{
                System.out.println("Número inválido, debe ser mayor o igual a 10.");
            }
        } while (!bandera);
        
        scanner.close();
        return num;
    }
    // Pregunta 7
    public static void pregunta7(int numero) {
        numero = numero + 5;
        System.out.println("El número dentro de la función es: " + numero);
    }
    // Pregunta 8
    // Clase 
    static class Edades { 
        public int valor; 
        public Edades(int valor) { 
        this.valor = valor; }
    }
    //Metodo - Pregunta 8
    public static void modificar(Edades ed) { 
        ed.valor = ed.valor + 5; // Modificamos el valor del atributo del objeto 
        System.out.println("Dentro del método modificar:"); 
        System.out.println("Edad = " + ed.valor); 
    }
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Indique el numero del item a desarrolar:");
    System.out.println("1. Mienntras con Contadores - Pregunta 2");
    System.out.println("2. Hacer - Mientras con Banderas- Pregunta 3");
    System.out.println("3. Funciones con paso de parámetros por valor - Pregunta 7");
    System.out.println("4. Funciones con paso de parámetros por referencia - Pregunta 8");
    int item = sc.nextInt();
    switch (item) {
        case 1:
           pregunta2();
            break;
        case 2:
        int numvalido = pregunta3();
        System.out.println("El numero valido ingresado es: "+ numvalido);
        break;
        case 3:
        System.out.println("Ingrese un número:");
        int miNumero = sc.nextInt();
        System.out.println("El número antes de llamar a la función es: " + miNumero);
        pregunta7(miNumero);
        System.out.println("El número después de llamar a la función sigue siendo: " + miNumero);
        break;
        case 4:
        // Pregunta 8
        System.out.println("Ingrese la edad:");
        int edad = sc.nextInt();
        Edades edades = new Edades(edad); 
        System.out.println("Antes de llamar al método modificar:"); 
        System.out.println("Edad = " + edades.valor);
        modificar(edades); 
        System.out.println("Después de llamar al método modificar:"); 
        System.out.println("Edad = " + edades.valor);
        break;
        default:
            break;
    }
    sc.close();
}


}
