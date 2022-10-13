import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Program {

	public static void main(String[] args){
		
		System.out.println();;
		
	}
	
	public static void aula_File_e_Scanner(){
		
		File file = new File("in.txt");
		Scanner sc = null;
		try {
			sc = new Scanner(file);
			while(sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			if (sc != null) {
				sc.close();				
			}
		}
	}
		
	public static void aula_File_e_Scanner_com_try_with_resources(){
		try (Scanner sc = new Scanner(new File("in.txt"))){
			while(sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	public static void aula_FileReader_e_BufferedReader() {
		
		String path = "in.txt";
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader(path);
			br = new BufferedReader(fr);
			
			String line = br.readLine();			
			while (line != null) {
				System.out.println(line);
				line = br.readLine();
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			try {
				if (br != null) {
					br.close();
				}
				if (fr != null) {
					fr.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void aula_FileReader_e_BufferedReader_com_try_with_resources() {
		
		String path = "in.txt";		
		try (BufferedReader br = new BufferedReader(new FileReader(path))){
			
			String line = br.readLine();			
			while (line != null) {
				System.out.println(line);
				line = br.readLine();
			}
			
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
	}
	
	public static void aula_FileWriter_e_BufferedWriter() {
		
		String[] lines = new String[] {"Buenos dias",
				                       "Buenas tardes",
				                       "Buenas noches"};
		
		
		/*
		 * 
		 * SEMPRE DELETA E RECRIA O ARQUIVO QUE VAI ESCREVER
		 * BufferedWriter bw = new BufferedWriter(new FileWriter(path)
		 * 
		 * CRIA O ARQUIVO QUE VAI ESCREVER SE NÃO EXISTER
		 * SE EXISTE, ABRE E ESCREVE NO FINAL
		 * BufferedWriter bw = new BufferedWriter(new FileWriter(path,true)
		 * 
		 */
		
		String path = "out.txt";
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
			for(String line : lines) {
				bw.write(line);
				bw.newLine();
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public static void aula_manipulando_pastas_com_File() {
		
		String strPath = ".";
		
		File path = new File(strPath);
		
		File[] folders = path.listFiles(File::isDirectory);
		System.out.println("FOLDERS: ");
		for (File folder : folders) {
			System.out.println(folder);
		}
		
		File[] files = path.listFiles(File::isFile);
		System.out.println("FILES: ");
		for (File file : files) {
			System.out.println(file);
		}
		
		if (!new File(strPath + "\\subdir").exists()) {
			boolean sucess = new File(strPath + "\\subdir").mkdir();
			System.out.println("Criou");			
		} else {
			System.out.println("Já existia");
		}
	}
	
	public static void aula_infos_caminho_arquivo() {
		
		File path = new File("C:\\Users\\marca\\Repositorios\\curso_java\\ExemplosArquivos\\in.txt");
		
		System.out.println("getName: " + path.getName());
		System.out.println("getParent: " + path.getParent());
		System.out.println("getPath: " + path.getPath());
		
	}
	
	public static void pode_Ser_Util() throws IOException {
		System.out.println("/ -> " + new File("/").getCanonicalPath());
		System.out.println("… -> " + new File("…").getCanonicalPath());
		System.out.println(". -> " + new File(".").getCanonicalPath());
	}

}
