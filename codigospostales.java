import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class codigospostales {
    public static void main(String[] args) {
        //Nombre del archivo CSV
        String archivo = "codigos_postales_hmo.csv";
        
        //Cree un HashMap para almacenar
        //Key: El codigo postal
        //Value: Cantidad de asentamientos 
        HashMap<String, Integer> codigosPostales = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            
            //Descarta la primera línea asumiendo que es el encabezado para evitar imprimir numeros de columanas o titulos
            reader.readLine();
        
            //Leemos el archivo línea por línea hasta llegar al final
            while ((linea = reader.readLine()) != null) {

                //Divide cada linea usando la coma como separador
                String[] datos = linea.split(",");
                
                    String codigoPostal = datos[0].trim();
                    
                    //Actualiza el contador para este código postal:
                    //Si el código ya existe en el mapa, obtenemos su valor actual y sumamos 1
                    //Si no existe, usamos el valor por defecto 0 y luego sumamos 1
                    int conteo = codigosPostales.getOrDefault(codigoPostal, 0);
                    codigosPostales.put(codigoPostal, conteo + 1);
            }
            
            //Mostrar los resultados
            System.out.println();
            System.out.println("Códigos postales y número de asentamientos");
            System.out.println("----------------------------------------");
            
            // Iteramos sobre todas las entradas del HashMap para mostrar los resultados
            for (String codigo : codigosPostales.keySet()) {
                System.out.println("Codigo Postal: " + codigo + " - Asentamientos: " + codigosPostales.get(codigo));
            }
            System.out.println("----------------------------------------");
        } catch (IOException e) {
            //Mostramos mensaje si falla la lectura del archivo
            System.err.println("Error al leer el archivo:");
        }
    }
}
