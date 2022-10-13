package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import entities.Item;

public class App {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		String arquivoEntrada = "entrada.csv";
		String diretorioSaida = ".\\out";
		String arquivoSaida = diretorioSaida + "\\summary.csv";
		
		List<Item> itens = new ArrayList<>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(arquivoEntrada))){			
			String line = br.readLine();			
			while (line != null) {				
				String[] dados = line.split(",");
				String nome = dados[0];
				double preco = Double.parseDouble(dados[1]);
				int quantidade = Integer.parseInt(dados[2]);				
				itens.add(new Item(nome, preco, quantidade));
				line = br.readLine();				
			}			
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		

		if (!new File(diretorioSaida).exists()) {
			new File(diretorioSaida).mkdir();		
		}
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivoSaida))) {
			for(Item item : itens) {
				String line = item.getNome() + "," + String.format("%.2f", item.valorTotal());
				bw.write(line);
				bw.newLine();
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

}
