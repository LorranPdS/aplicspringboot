package projeto.aplicspringboot.controller;

import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.stereotype.Component;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Component
public class ReportUtil<T> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public byte[] gerarRelatorio(List<T> listarDados, 
			String relatorio, ServletContext servletContext) throws Exception {
		
		JRBeanCollectionDataSource jrbcds = new JRBeanCollectionDataSource(listarDados);
		
		String caminhoJasper = servletContext.getRealPath("relatorios")
				+ File.separator + relatorio + ".jasper";
		
		JasperPrint impressoraJasper = JasperFillManager.fillReport(
				caminhoJasper, new HashMap<>(), jrbcds);
		
		return JasperExportManager.exportReportToPdf(impressoraJasper);		
	}

}
