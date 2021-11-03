

import java.util.Calendar;
import java.util.Scanner;

public class ManipulaData {

	private static Scanner scan = new Scanner(System.in);

	public static Calendar LeData() {
	 	
		int dia, mes , ano;
		
		System.out.println("Entre com o dia:");
		dia  = scan.nextInt();
		System.out.println("Entre com o mes:");
		mes = scan.nextInt();
		System.out.println("Entre com o ano:");
		ano = scan.nextInt();
		Calendar data = Calendar.getInstance();
		//mes deve ser subtraido de um pq ele armazena os meses de 0   a 11
		data.set(ano, mes-1, dia);
		return data;
	}

	public Calendar LeDataString(String str) {
		
		Calendar data;
		String[] dado;
		
		int dia,mes,ano;
		
		dado = str.split("/");
		dia = Integer.parseInt(dado[0]);
		mes = Integer.parseInt(dado[1]);
		ano = Integer.parseInt(dado[2]);
		data = Calendar.getInstance();
		data.set(ano, mes-1, dia);
		return data;
	}
	
	public static String formatar (Calendar data) {
		String str = "";
		str += data.get(Calendar.DATE)+"/"+ 
			   data.get(Calendar.MONTH+1)+"/"+
			   data.get(Calendar.YEAR);
		return str;
	}
}
