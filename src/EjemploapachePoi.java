import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;



public class EjemploapachePoi {
    public static void main(String[] args) {
        //1-Se crea un libro (Este libro se crea en la memoria del pc)
        Workbook libro = new XSSFWorkbook();
        //2- Se crea una hoja en el archivo de excel
        // para darle el nombre se ingresa dentro de los parente..Ejp datos
        Sheet hoja = libro.createSheet("datos");
        //3- crear las filas (las filas son de manera horizontal  y comienzan desde la poscion 0 como un array)
        Row cabecera = hoja.createRow(1);
        // se va a crear la segunda fila
        Row registro1 = hoja.createRow(2);
        //Se crea la tercera fila
        Row registro2 = hoja.createRow(3);

        //4- Crear las columnas
        Cell nombre = cabecera.createCell(1);
        Cell edad = cabecera.createCell(2);
        Cell ciudad = cabecera.createCell(3);

        // Crear las columnas de la segunda fila
        Cell nombreRegistro1 = registro1.createCell(1);
        Cell edadRegistro1 = registro1.createCell(2);
        Cell ciudadRegistro1 = registro1.createCell(3);

        // Crear las columnas de la Tercera fil

        Cell nombreRegistro2 = registro2.createCell(1);
        Cell edadRegistro2 = registro2.createCell(2);
        Cell ciudadRegistro2 = registro2.createCell(3);


        //  Se le envia el nombre de cada fila en las cordenas indicadas.
        nombre.setCellValue("Nombre");
        edad.setCellValue("Edad");
        ciudad.setCellValue("Ciudad");

        //  Se le envia la inf a la segunda fila
        nombreRegistro1.setCellValue("Francisco");
        edadRegistro1.setCellValue("25");
        ciudadRegistro1.setCellValue("Medellin");

        //  Se le envia la inf a la tercera fila
        nombreRegistro2.setCellValue("Paco");
        edadRegistro2.setCellValue("3");
        ciudadRegistro2.setCellValue("Bogota");


        try {
            //Exception para crear el archivo de excel.
            OutputStream output = new FileOutputStream("ArchivoExcel.xlsx ");
            libro.write(output);
            libro.close();//Se utiliza para eliminar los bit que se utilizan en Workbook libro = new XSSFWorkbook();
            output.close();
        }catch (Exception e){
            e.printStackTrace();

        }


    }

}
