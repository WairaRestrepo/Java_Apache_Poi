import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class EstilosExcel {
    public static void main(String[] args) {

        // crear libro
        XSSFWorkbook libro = new XSSFWorkbook();
        //Crear la hoja
        XSSFSheet hoja = libro.createSheet();
        //Crear filas
        XSSFRow fila = hoja.createRow(1);
        //Crear celdas
        XSSFCell celda = fila.createCell(1);

        //Los estilos siempre se crean a nivel de celda
        try {
            OutputStream output = new FileOutputStream("EstilosExcel.xlsx");
            libro.write(output);

            libro.close();
            output.close();

        }catch (Exception e){
            e.printStackTrace();

        }

    }
}
