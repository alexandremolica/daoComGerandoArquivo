package application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.MaterialPermanenteDao;
import model.entities.MaterialPermanente;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		long soma = 0; 
		long qtdLinhaDetail = 0;
		
		System.out.println("==== Inicio ====");
		MaterialPermanenteDao materialPermanenteDao = new DaoFactory().createMaterialPermanenteDao();
		
		System.out.println("==== Criado Fabrica ====");

		
		System.out.println("====  MaterialPermanente findAll ====");

		
		List<MaterialPermanente> list = new ArrayList<>();
		list = materialPermanenteDao.findAll();

		//imprime obj no console
		for(MaterialPermanente obj : list) {
			System.out.println(obj);
		}		


		System.out.println("==== GERAR ARQUIVO LAYOUT ====");

		String path = "c:\\temp\\SIGINPIoutXXXXX.csv";
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(path))){
			
			for(MaterialPermanente obj : list) {
				//
				if (qtdLinhaDetail == 0) {
					bw.write(setHeaderFileLine (obj));
					bw.newLine();
					System.out.println("---- header gerado ---");
				}
				soma = soma + Long.parseLong(obj.getValorBem());
				qtdLinhaDetail = qtdLinhaDetail + 1;
				bw.write(setDetailFileLine(obj));
				bw.newLine();
			}
			System.out.println("---- dados gerado ---");

			bw.write(setTrailFileLine(qtdLinhaDetail, soma));
			System.out.println("---- trilha gerada ---");
			
		}
		catch(IOException e) {
			e.printStackTrace();
			sc.close();
		}
		System.out.println("Quantidades de registros de Dados="+qtdLinhaDetail);
		System.out.println("Somatorio de valor bem="+soma);
		System.out.println("==== FIM ARQUIVO LAYOUT ====");
		
		///////////////////////////////////////////////////////////////////////////////////
		// Parte feita com linha de titulo para conferencia no departamento de patrimonion
		///////////////////////////////////////////////////////////////////////////////////
		System.out.println();
		System.out.println("== GERAR ARQUIVO COM TITULOS PARA VISUALIZACAO ==");
		
		String path2 = "c:\\temp\\Extracao-com-titutlo-SIGINPI-1.csv";
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(path2))){
			//Linha de titulos do arquivo
			bw.write(
					"D¥CodigoMaterial¥Descricao¥CodigoConta¥Endereco¥Uorg¥Tipo¥Situacao¥TipoPlaqueta¥DataTombamento¥ValorBem¥"
					+"FormaDeAquisicao¥Especificacao¥DataDevolucao¥Serie¥Patrimonio¥Marca¥Modelo¥Fabricante¥Garantidor¥"
					+"Contrato¥InicioGarantia¥FimGarantia¥CpfCorresponsavel¥NomeCorresponsavel¥"
					+"almoxarifado¥£" 		
					);
			bw.newLine();
			
			//Linha de dados
			for(MaterialPermanente obj : list) {
				bw.write(setDetailFileLine(obj));
				bw.newLine();
			}

			
		}
		catch(IOException e) {
			e.printStackTrace();
			sc.close();
		}
		System.out.println("==== FIM ARQUIVO PARA VISUALIZACAO ====");

		/////////////////
		
		sc.close();
		System.out.println("==== SUCESSO ====");

	}
	
	public static String setHeaderFileLine (MaterialPermanente mat){
		String line;
		line =  "H¥"
				+"PE"+"¥"
				+"001"+"¥"
				+ mat.getUorg()+"¥"
				+ mat.getCodigoUg()+"¥"
				+"14495756257"+"¥"
				+ "Ges??"+"¥"
				+"£";
				//gestao duvida, que numeror é esse?????
				//colocar cpf de quem???
		
		return line;

	}
	
	public static String setDetailFileLine (MaterialPermanente mat){
		String line;
		line =  "D¥"
		+ convertNotNull(mat.getCodigoMaterial())+"¥"
		+ convertNotNull(mat.getDescricao())+"¥" 
		+ convertNotNull(mat.getCodigoConta())+"¥"
		+ convertNotNull(mat.getEnderecoLocalizacaoMaterial())+"¥"
		+ convertNotNull(mat.getUorg())+"¥"
		+ convertNotNull(mat.getTipo())+"¥"
		+ convertNotNull(mat.getSituacao())+"¥"
		+ convertNotNull(mat.getTipoPlaqueta())+"¥"
		+ convertNotNull(mat.getDataTombamento())+"¥"
		+ convertNotNull(mat.getValorBem())+"¥"
		+ convertNotNull(mat.getFormaDeAquisicao())+"¥"
		+ convertNotNull(mat.getEspecificacao())+"¥"
		+ convertNotNull(mat.getDataDevolucao())+"¥"
		+ convertNotNull(mat.getNumSerie())+"¥"
		+ convertNotNull(mat.getPatrimonio())+"¥"
		+ convertNotNull(mat.getMarca())+"¥"
		+ convertNotNull(mat.getModelo())+"¥"
		+ convertNotNull(mat.getFabricante())+"¥"
		+ convertNotNull(mat.getGarantidor())+"¥"
		+ convertNotNull(mat.getNumContrato())+"¥"
		+ convertNotNull(mat.getInicioGarantia())+"¥"
		+ convertNotNull(mat.getFimGarantia())+"¥"
		+ convertNotNull(mat.getCpfCorresponsavel())+"¥"
		+ convertNotNull(mat.getNomeCorresponsavel())+"¥"
//almoxarifado
		+ "FALSE"+"¥"
		+"£" ;
		
		line = line.replaceAll("\r", "");
		line = line.replaceAll("\t", "");
		line = line.replaceAll("\n", "");
				
		return line;
	}
	
	public static String setTrailFileLine (long qtd, long soma){
		String line;
		GregorianCalendar calendario = new GregorianCalendar();
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyyHHmmss");
		String dataHoraFinal = sdf.format(calendario.getTime());

		line =  "T¥"
		+dataHoraFinal+"¥" 
		+qtd+"¥"
		+soma+"¥" 
		+"FIM¥£";
		
		return line;
	}
	
	private static String convertNotNull(String atributo) {
		return atributo != null ? atributo : "";
		
	}

}
