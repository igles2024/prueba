package com.example.demo.utilidades;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.models.Cliente;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;
public class CsvUtils {
	public static boolean isCsvFile(MultipartFile file) {
        return file.getContentType().equals("text/csv") || file.getContentType().equals("application/vnd.ms-excel");
    }

    public static byte[] clientesToCsvBytes(List<Cliente> clientes) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        CSVPrinter csvPrinter = new CSVPrinter(new OutputStreamWriter(out), CSVFormat.DEFAULT.withHeader("Documento", "Nombre Completo", "email"));
        for (Cliente cliente : clientes) {
            csvPrinter.printRecord(cliente.getDocumento(), cliente.getNombreCompleto(), cliente.getEmail());
        }
        csvPrinter.flush();
        return out.toByteArray();
    }
}
