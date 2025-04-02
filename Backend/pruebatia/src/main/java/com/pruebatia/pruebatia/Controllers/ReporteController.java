package com.pruebatia.pruebatia.Controllers;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.pruebatia.pruebatia.Repositories.TropasRepository;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class ReporteController {

    @Autowired
    private TropasRepository tropasRepository;

    @GetMapping("/")
    public String vistaReporte() {
        return "reporte";
    }

    @GetMapping("/generar-reporte")
    public void generarReporte(HttpServletResponse response) throws IOException {
        List<Map<String, Object>> datos = tropasRepository.obtenerTotalTropasPorPotenciaYFrente();

        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=reporte_enemigo.xls");

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Resumen Tropas");

        HSSFRow header = sheet.createRow(0);
        header.createCell(0).setCellValue("potencia");
        header.createCell(1).setCellValue("frente");
        header.createCell(2).setCellValue("totalTropas");

        int fila = 1;
        for (Map<String, Object> filaData : datos) {
            HSSFRow row = sheet.createRow(fila++);
            row.createCell(0).setCellValue(filaData.get("potencia").toString());
            row.createCell(1).setCellValue(filaData.get("frente").toString());
            row.createCell(2).setCellValue(((Number) filaData.get("totalTropas")).intValue());
        }

        workbook.write(response.getOutputStream());
        workbook.close();
    }
}
