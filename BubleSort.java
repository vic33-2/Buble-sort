import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BubleSort {

    public static void main(String[] args) {
    String archivoEntrada = "numeros1.txt";
    String archivoSalida = "numerosBubleSort_ordenados.txt";

        int[] numeros = leerArchivo(archivoEntrada);

        if (numeros != null) {
            System.out.println("Numeros originales:");
            imprimirArray(numeros);

            bubbleSort(numeros);

            System.out.println("\n Numeros ordenados (Bubble Sort):");
            imprimirArray(numeros);

            escribirArchivo(numeros, archivoSalida);
            System.out.println("\n Archivo generado exitosamente: " + archivoSalida);
        } else {
            System.out.println("No se pudo leer el archivo.");
        }  
    }

    public static int[] leerArchivo(String nombreArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            int count = 0;


            while ((linea = br.readLine()) != null) {
                count++;
            }

            int[] numeros = new int[count];
            br.close();

            BufferedReader br2 = new BufferedReader(new FileReader(nombreArchivo));
            int i = 0;
            while ((linea = br2.readLine()) != null) {
                numeros[i] = Integer.parseInt(linea.trim());
                i++;
            }
            br2.close();

            return numeros;

        } catch (IOException | NumberFormatException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
            return null;
        }
    }


    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean intercambio;

        for (int i = 0; i < n - 1; i++) {
            intercambio = false;

            for (int j = 0; j < n - 1 - i; j++) {

                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    intercambio = true;
                }
            }

            if (!intercambio) break;
        }
    }
 public static void escribirArchivo(int[] arr, String nombreArchivo) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (int num : arr) {
                bw.write(num + "");
                bw.newLine();
            }
        } catch (IOException e) { // catch por algun error en el archivo
            System.out.println("Error al escribir el archivo: " + e.getMessage());
        }
    }
}
