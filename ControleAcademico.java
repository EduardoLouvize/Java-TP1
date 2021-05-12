import java.util.Iterator;
import java.util.Scanner;

public class ControleAcademico {
	
	private static String opcao;
	static Scanner in = new Scanner(System.in);
	private static String[] nomes;
	private static float[] notasAvaliacao1;
	private static float[] notasAvaliacao2;
	
	private static final int QUANTIDADEALUNOS = 5;
	
	
	public static void main(String[] args) {
		nomes = new String[QUANTIDADEALUNOS];
		notasAvaliacao1 = new float[QUANTIDADEALUNOS];
		notasAvaliacao2 = new float[QUANTIDADEALUNOS];
		
		
		captarETratarOpcao();
		
		
	}
	
	private static void exibirMenu() {
		
		System.out.println("---------------------------------");
		System.out.println("--Sistema de Controle Acadêmico--");
		System.out.println("---------------------------------");		
		System.out.println("[1] Registrar as notas de um novo aluno.");
		System.out.println("[2] Consultar boletim de um aluno.");
		System.out.println("[3] Consultar notas da turma.");
		System.out.println("[4] Sair.");		
			
		
	}
	
	
	
	private static String captarETratarOpcao() {
		
		exibirMenu();
		
		int index = 0;
		
		
		do {
			System.out.print("Informe a opção desejada: ");
			opcao = in.next();
			
			
			switch (opcao) {
			case "1":				
				registrarNota(index);
				index++;
				break;
			case "2":
				System.out.println("Informe o registro a ser consultado:");
				int registro = in.nextInt();
				consultarNotasDaTurma(registro);
				break;
			case "3":
				System.out.println("[3] Consultar notas da turma.");
				consultarNotasDaTurma();
				break;
			case "4":
				System.out.println("Saindo.");
				break;
			default:
				System.out.println("Opção inválida");
				captarETratarOpcao();
				break;
			}			
		} while (!opcao.equals("4"));	
		
		
		return opcao;
	}

	private static void registrarNota(int index) {
		
		
		System.out.println("Informe o nome do aluno:");
		nomes[index] = in.next();
		
		System.out.println("Nota da avaliação 1:");
		notasAvaliacao1[index] = in.nextFloat();
		
		System.out.println("Nota da avaliação 2:");
		notasAvaliacao2[index] = in.nextFloat();
		
		System.out.println("Dados registrados:");
		System.out.printf("[%d] - %s - Nota 1: %f - Nota 2: %.2f\n", index, nomes[index], notasAvaliacao1[index], notasAvaliacao2[index]);
	}
	
	private static void consultarNotasDaTurma() {
			for (int i = 0; i < QUANTIDADEALUNOS; i++) {
				consultarNotasDaTurma(i);
			}	
		}
		
	
	
	private static void consultarNotasDaTurma(int index) {		
		
			if (nomes[index] != null) {
				System.out.printf("[%d] - %s - Nota 1: %f - Nota 2: %.2f\n", index, nomes[index], notasAvaliacao1[index], notasAvaliacao2[index]);
				
				index++;
			}			
		
		
	}
}
