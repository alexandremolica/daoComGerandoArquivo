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


		System.out.println("====  Gerar Arquivo ====");

		String path = "c:\\temp\\outTest.txt";
		
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
		System.out.println("==== FIM ARQUIVO ====");
		System.out.println("==== SUCESSO ====");

		sc.close();

	}
	
	public static String setHeaderFileLine (MaterialPermanente mat){
		String line;
		line =  "Hе"
				+"PE"+"е"
				+"001"+"е"
				+ mat.getUorg()+"е"
				+ mat.getCodigoUg()+"е"
				+"14495756257"+"е"
				+ "Ges??"+"е"
				+"г";
				//gestao duvida, que numeror щ esse?????
				//colocar cpf de quem???
		
		return line;

	}
	public static String setDetailFileLine (MaterialPermanente mat){
		String line;
		line =  "Dе"
		+ mat.getCodigoMaterial()+"е"
		+ mat.getDescricao()+"е" 
		+ mat.getCodigoConta()+"е"
		+ mat.getEnderecoLocalizacaoMaterial()+"е"
		+"г" ;
		return line;
	}
	public static String setTrailFileLine (long qtd, long soma){
		String line;
		GregorianCalendar calendario = new GregorianCalendar();
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyyHHmmss");
		String dataHoraFinal = sdf.format(calendario.getTime());

		line =  "Tе"
		+dataHoraFinal+"е" 
		+qtd+"е"
		+soma+"е" 
		+"FIMег";
		
		return line;
	}

}
