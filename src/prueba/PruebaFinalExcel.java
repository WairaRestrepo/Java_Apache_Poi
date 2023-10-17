package prueba;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PruebaFinalExcel {
    public static void main(String[] args) {

        List<Cliente> listadoCliente = obtenerlistado();

        /*Cliente.class = para acceder a las propiedades de la clase
        * luego de esto se pone el . para buscar los metodos a utilizar y se busca el metodo getDeclaredFields()
        * getDeclaredFields()--> este metodo puede devolver un arreglo
        * se crea un arreglo de tipo Field  con  nombre campo.
        * Nota = De Field se debe importar el paquete java.lang.reflect  */

       Field[] campos = Cliente.class.getDeclaredFields();

        XSSFWorkbook libro = new XSSFWorkbook();
        XSSFSheet hoja = libro.createSheet("Clientes");

        XSSFRow fila = null;
        XSSFCell celda = null;

        for (int i = 0; i < listadoCliente.size();i++ ) {
            //  i es el contador de las filas
            if(i ==0){
                fila = hoja.createRow(0);// se esta generando el encabezado
                //Este for es para los campos de la clase (cabeceros )
                for (int j=0; j < campos.length; j++ ){
                   celda = fila.createCell(j);
                   celda.setCellValue(campos[j].getName());

                }

            }

        }
        try {
            OutputStream output = new  FileOutputStream("PruebaFinalExcel.xlsx");
            libro.write(output);
            libro.close();
            output.close();

        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("Error al crear documento");
        }
    }

    public static List<Cliente> obtenerlistado(){
        List<Cliente> listadoCliente = new ArrayList<>();
        listadoCliente.add(new Cliente(1L,"Pablo","Perez","123","pablo@gmail.com", LocalDate.of(1993,11,14)));
        listadoCliente.add(new Cliente(2L,"Simon","Perea","456","Simon@gmail.com", LocalDate.of(1995,05,15)));
        listadoCliente.add(new Cliente(3L,"Marian","Lopez","789","Marian@gmail.com", LocalDate.of(1999,06,16)));
        listadoCliente.add(new Cliente(4L,"Ana","Ramirez","1011","Ana@gmail.com", LocalDate.of(1997,07,17)));
        listadoCliente.add(new Cliente(5L,"Sofia","Gomez","1213","Sofia@gmail.com", LocalDate.of(1992,12,18)));
        return listadoCliente;
    }
}
