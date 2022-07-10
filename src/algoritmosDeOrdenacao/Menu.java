package algoritmosDeOrdenacao;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Menu {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		Algoritmos a = new Algoritmos();
		String nomeArq = "arquivo1.000.000.txt";
		int qnt = 1;
		int op = 0;

		while (op != 5) {
			System.out.println(
					"\nMenu de Algoritmos:\n1.Insertion Sort\n2.Merge Sort\n3.Bubble Sort\n4.Quick Sort\n5.Sair\n");
			op = Integer.parseInt(sc.nextLine());
			switch (op) {

			case 1:
				System.out.println("Digite quantos nomes voce deseja ordenar: (Até 1.000.000)");
				qnt = Integer.parseInt(sc.nextLine());
				StopwatchCPU timer1 = new StopwatchCPU();
				a.InsertionSort(nomeArq, qnt);
				double tempInsertion = timer1.elapsedTime();
				System.out.println("Tamanho escolhido: " + qnt);
				System.out.println("Tempo decorrido em segundos: " + tempInsertion);
				break;

			case 2:
				System.out.println("Digite quantos nomes voce deseja ordenar: (Até 1.000.000)");
				qnt = Integer.parseInt(sc.nextLine());
				StopwatchCPU timer2 = new StopwatchCPU();
				a.MergeSort(nomeArq, qnt);
				double tempMerge = timer2.elapsedTime();
				System.out.println("Tamanho escolhido: " + qnt);
				System.out.println("Tempo decorrido em segundos: " + tempMerge);
				break;

			case 3:
				System.out.println("Digite quantos nomes voce deseja ordenar: (Até 1.000.000)");
				qnt = Integer.parseInt(sc.nextLine());
				StopwatchCPU timer3 = new StopwatchCPU();
				a.BubbleSort(nomeArq, qnt);
				double tempBubble = timer3.elapsedTime();
				System.out.println("Tamanho escolhido: " + qnt);
				System.out.println("Tempo decorrido em segundos: " + tempBubble);
				break;

			case 4:
				System.out.println("Digite quantos nomes voce deseja ordenar: (Até 1.000.000)");
				qnt = Integer.parseInt(sc.nextLine());
				StopwatchCPU timer4 = new StopwatchCPU();
				a.QuickSort(nomeArq, qnt);
				double tempQuick = timer4.elapsedTime();
				System.out.println("Tamanho escolhido: " + qnt);
				System.out.println("Tempo decorrido em segundos: " + tempQuick);
				break;

			case 5:
				break;

			}

		}
		sc.close();
		System.out.println("End of Program");
	}
}
