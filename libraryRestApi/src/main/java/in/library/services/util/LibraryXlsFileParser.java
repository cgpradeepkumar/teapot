package in.library.services.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import in.library.services.util.model.Data;

@Component
public class LibraryXlsFileParser {
	
	private static final Logger LOGGER = Logger.getLogger(LibraryXlsFileParser.class);
	
	@Value("classpath:Library.xlsx")
	Resource resourceFile;
	
	public List<Data> parse() {
		FileInputStream inputStream = null;
		Workbook workbook = null;
		List<Data> dataList = new ArrayList<Data>();
		try {
			inputStream = new FileInputStream(resourceFile.getFile());
			workbook = new XSSFWorkbook(inputStream);
			Sheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rowIterator = sheet.iterator();
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				if (isRowEmpty(row)) {
					continue;
				}
				Data data = new Data();
				Iterator<Cell> cellIterator = row.cellIterator();
				while(cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					if (cell.getCellType() != Cell.CELL_TYPE_BLANK) {
						String cellData = getCellData(cell);
						if (cell.getColumnIndex() == 0) {
							//skip first row
							if (!cellData.equals("#")) {
								data.setId(Integer.parseInt(cellData));
							}
						}
						if (cell.getColumnIndex() == 1) {
							//skip first row
							if (!cellData.equals("Title")) {
								data.setTitle(cellData);
							}
						}
						if (cell.getColumnIndex() == 2) {
							//skip first row
							if (!cellData.equals("Author")) {
								data.setAuthor(cellData);
							}
						}
						if (cell.getColumnIndex() == 3) {
							//skip first row
							if (!cellData.equals("Publisher")) {
								data.setPublisher(cellData);
							}
						}
						if (cell.getColumnIndex() == 4) {
							//skip first row
							if (!cellData.equals("Price")) {
								String value = cellData.substring(2);
								data.setPrice(Double.parseDouble(value));
							}
						}
						if (cell.getColumnIndex() == 5) {
							//skip first row
							if (!cellData.equals("Language")) {
								data.setLanguage(cellData);
							}
						}
						if (cell.getColumnIndex() == 5) {
							//skip first row
							if (!cellData.equals("Language")) {
								data.setLanguage(cellData);
							}
						}
					}
				}
				if (data.getId() != 0)
					dataList.add(data);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return dataList;
	}
	
	private String getCellData(Cell cell) {
		DataFormatter formatter = new DataFormatter();
		String cellData = formatter.formatCellValue(cell);
		LOGGER.info(cell.getColumnIndex() +" - "+ cellData);
		return cellData;
	}
	
	private static boolean isRowEmpty(Row row) {
	    for (int c = row.getFirstCellNum(); c < row.getLastCellNum(); c++) {
	        Cell cell = row.getCell(c);
	        if (cell != null && cell.getCellType() != Cell.CELL_TYPE_BLANK)
	            return false;
	    }
	    return true;
	}
}
