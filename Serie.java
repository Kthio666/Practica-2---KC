package controller.practica2;

import java.util.Scanner;

import controller.util.Utilidades;

public class Serie {
    // Metodo para generar el denominador
    public static int imparDenominador(int numero) {
        int denominador = 1;
        if (numero > 1) {
            for (int i = 1; i < numero; i++) {
                denominador += 2;
            }
        }
        return denominador;
    }

    // Metodo para generar el exponente
    public static int generarExponente(int numero) {
        int exponente = 2;
        if (numero > 1) {
            for (int i = 1; i < numero; i++) {
                exponente += 2;
            }
        }
        return exponente;
    }

    // Metodo para generar el numerador
    public static int generateNumerador(int numero) {
        int numerador = 0;
        int num1 = 1, num2 = 1;
        if (numero == 1 || numero == 2) {
            return 1;
        }
        for (int i = 3; i <= numero; i++) {
            numerador = num1 + num2;
            num1 = num2;
            num2 = numerador;
        }
        return numerador;
    }

    public void ejecutar() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese numero de terminos de la serie: ");
        int numeroserie = sc.nextInt();
        String serie = "";
        float suma = 0.0f;
        if (numeroserie > 0) {
            for (int i = 0; i < numeroserie; i++) {
                //
                int denomi = imparDenominador(i + 1);
                int exponente = generarExponente(i + 1);
                int numerador = generateNumerador(i + 1);
                // Aqui se calcula el signo
                int signo = (i % 4 == 0 || i % 4 == 1) ? 1 : -1;
                // Solo para el primer signo, que no salga con el signo
                if (i == 0) { 
                    serie += " (" + numerador + "/" + denomi + ")^" + exponente;
                    suma += (Math.pow(((float) numerador / (float) denomi), exponente));
                } else {
                    // Para el resto de la serie
                    switch (signo) {
                        case 1:
                            serie += " + (" + numerador + "/" + denomi + ")^" + exponente;
                            suma += (Math.pow(((float) numerador / (float) denomi), exponente));
                            break;
                        case -1:
                            serie += " - (" + numerador + "/" + denomi + ")^" + exponente;
                            suma -= (Math.pow(((float) numerador / (float) denomi), exponente));
                            break;
                        default:
                            break;
                    }
                }
            }
            System.out.println("La serie es:");
            System.out.println(serie);
            System.out.println("Resultado de la serie:");
            System.out.println(Utilidades.redondearFloat(suma));
        } else {
            System.out.println("Ingrese un numero mayor a 0");
        }
        sc.close();
    }
}
