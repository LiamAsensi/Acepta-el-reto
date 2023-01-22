/*
 * Autor: Liam Alejo Asensi - https://github.com/LiamAsensi
 * Constante de Kaprekar
 */

import java.util.Scanner;
import java.util.Arrays;

public class Problema100 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int cantidadCasos = Integer.parseInt(entrada.nextLine());

        for (int i = 0; i < cantidadCasos; i++) {
            String entradaNumero = entrada.nextLine();
            
            System.out.println(pasosKeprekar (entradaNumero));
        }

        entrada.close();
    }

    public static int pasosKeprekar (String numeroTexto) {
        final int KEPRAKAR = 6174;
        int numero = Integer.parseInt(numeroTexto);

        if (numero == KEPRAKAR) {
            return 0;
        }

        while (numeroTexto.length() < 4) {
            numeroTexto = 0 + numeroTexto;
        }

        if (sonLosDigitosIguales(numeroTexto)) {
            return 8;
        }

        int diferencia = diferenciaDigitosAscendienteDescendiente(numeroTexto);

        return 1 + pasosKeprekar(String.valueOf(diferencia));
    }

    public static int diferenciaDigitosAscendienteDescendiente(String numeroTexto) {
        char[] digitosDescendente = numeroTexto.toCharArray();
        Arrays.sort(digitosDescendente);

        char[] digitosAscendente = new char[numeroTexto.length()];
        for (int i = digitosAscendente.length - 1, j = 0; i >= 0; i--, j++) {
            digitosAscendente[j] = digitosDescendente[i];
        }

        return Integer.parseInt(String.valueOf(digitosAscendente)) - Integer.parseInt(String.valueOf(digitosDescendente));
    }

    public static boolean sonLosDigitosIguales (String numeroTexto) {
        char[] digitos = numeroTexto.toCharArray();
        boolean sonIguales = true;
        for (int i = 1; i < digitos.length; i++) {
            if (digitos[i] != digitos[i - 1]) {
                sonIguales = false;
            }
        }
        return sonIguales;
    }
}