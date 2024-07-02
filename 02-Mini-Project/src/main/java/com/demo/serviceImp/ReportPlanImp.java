package com.demo.serviceImp;

import java.io.IOException;
import java.util.List;

import javax.swing.text.Document;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.demo.entity.CitizenPlan;
import com.demo.entity.SearchRequest;
import com.demo.repo.CitizenPlanRepository;
import com.demo.service.ReportService;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class ReportPlanImp implements ReportService {

	
	@Autowired
	private CitizenPlanRepository cpRepo;
	
	@Override
	public List<String> getPlanNames() {
		
		return cpRepo.getPlanNames();

	}

	@Override
	public List<String> getPlanStatuses() {
		
		return cpRepo.getPlanStatuses();
	}

	@Override
	public List<CitizenPlan> getCitizenPlans(SearchRequest request) {
		
		CitizenPlan entity = new CitizenPlan();
		if(request.getPlanName() !=null && request.getPlanName().equals("")) {

			entity.setPlanName(request.getPlanName());	
		}
		
		if(request.getPlanStatus() !=null && request.getPlanStatus().equals("")) {

			entity.setPlanStatus(request.getPlanStatus());	
		}
		
		Example<CitizenPlan> example = Example.of(entity);
		
		List<CitizenPlan> records = cpRepo.findAll(example);
			
		return records;
	}

	@Override
	public void exportExcel(HttpServletResponse response) throws IOException {
		
//		List<CitizenPlan> findAll = cpRepo.findAll();
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		
		XSSFSheet sheet = workbook.createSheet("Citizens Info");
		
		XSSFRow headerRow = sheet.createRow(0);
		
		headerRow.createCell(0).setCellValue("Id");
		headerRow.createCell(1).setCellValue("Name");
		headerRow.createCell(2).setCellValue("SSN");
		headerRow.createCell(3).setCellValue("Gender");
		headerRow.createCell(4).setCellValue("Plan Name");
		headerRow.createCell(5).setCellValue("Plan SStatus");
		
		List<CitizenPlan> records = cpRepo.findAll();
		
		 int dataRowIndex=1;
		 
		for(CitizenPlan record:records)
		{
		  XSSFRow	dataRow = sheet.createRow(dataRowIndex);
		  
		  dataRow.createCell(0).setCellValue(record.getCid());
		  dataRow.createCell(1).setCellValue(record.getCname());
		  dataRow.createCell(2).setCellValue(record.getSsn());
		  dataRow.createCell(3).setCellValue(record.getGender());
		  dataRow.createCell(4).setCellValue(record.getPlanName());
		  dataRow.createCell(5).setCellValue(record.getPlanStatus());
		  
		  dataRowIndex++;
		  
		}
		
		ServletOutputStream ops = response.getOutputStream();
		workbook.write(ops);
		workbook.close();
		ops.close();
	}

	@Override
	public void exportPdf(HttpServletRequest response) throws Exception{
		
		List<CitizenPlan> records = cpRepo.findAll();
		
//		Document document = new Document(PageSize.A4)
				
	}

}
