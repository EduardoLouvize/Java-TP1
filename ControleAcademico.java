
import java.util.Scanner;

public class ControleAcademico {

	private static String opcao;
	private static Scanner in;
	private static String[] nomes;
	private static float[] notasAvaliacao1;
	private static float[] notasAvaliacao2;

	private static int index;

	private static final int QUANTIDADEALUNOS = 100;

	public static void main(String[] args) {

		in = new Scanner(System.in);

		nomes = new String[QUANTIDADEALUNOS];
		notasAvaliacao1 = new float[QUANTIDADEALUNOS];
		notasAvaliacao2 = new float[QUANTIDADEALUNOS];

		captarETratarOpcao();

		in.close();
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

		index = 0;

		do {
			exibirMenu();

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
				System.out.println("/\\/\\/\\/\\/\\/\\/\\");
				consultarNotasDaTurma(registro);
				System.out.println("/\\/\\/\\/\\/\\/\\/\\");
				break;
			case "3":
				System.out.println("NOTAS DA TURMA.");
				System.out.println("/\\/\\/\\/\\/\\/\\/\\");
				consultarNotasDaTurma();
				System.out.println("/\\/\\/\\/\\/\\/\\/\\");
				break;
			case "4":
				System.out.println("-------------------");
				System.out.println("Sistema finalizado.");
				System.out.println("-------------------");
				break;
			default:
				System.out.println("--------------");
				System.out.println("Opção inválida");
				System.out.println("--------------");
				System.out.println("/\\/\\/\\/\\/\\/\\/\\");
				break;
			}
		} while (!opcao.equals("4"));

		return opcao;
	}

	private static void registrarNota(int index) {

		if (index < QUANTIDADEALUNOS) {

			System.out.println("Informe o nome do aluno:");
			nomes[index] = in.next();
			
			System.out.println("Nota da avaliação 1:");
			notasAvaliacao1[index] = in.nextFloat();

			System.out.println("Nota da avaliação 2:");
			notasAvaliacao2[index] = in.nextFloat();

			System.out.println("Dados registrados:");
			consultarNotasDaTurma(index);

		} else {
			System.out.println("Não há espaó para novos registros.");
		}

	}

	private static void consultarNotasDaTurma() {
		for (int i = 0; i < index; i++) {
			consultarNotasDaTurma(i);
		}
	}

	private static void consultarNotasDaTurma(int index) {

		float media = calcularMediaFinal(notasAvaliacao1[index], notasAvaliacao2[index]);
		String situacaoFinal = verificarSituacao(media);

		if (nomes[index] != null) {
			System.out.printf("[%d] %s | Nota 1: %.2f | Nota 2: %.2f | Média Final: %.2f | %s\n", index, nomes[index],
					notasAvaliacao1[index], notasAvaliacao2[index], media, situacaoFinal);

		}
	}

	private static float calcularMediaFinal(float nota1, float nota2) {
		float media = (nota1 + nota2) / 2;
		return media;
	}

	private static String verificarSituacao(float media) {

		if (media < 4) {
			return "Reprovado";
		} else if (media >= 4 && media < 7) {
			return "Prova Final";
		} else {
			return "Aprovado";
		}

	}
}
