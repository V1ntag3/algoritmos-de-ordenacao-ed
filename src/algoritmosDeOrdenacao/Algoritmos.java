package algoritmosDeOrdenacao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Algoritmos {

	public void InsertionSort(String nomeArq, int qnt) {
		String nomes[] = new String[qnt];
		int i, j;

		try {
			FileReader arq = new FileReader(nomeArq);
			@SuppressWarnings("resource")
			BufferedReader nomeAtual = new BufferedReader(arq);
			for (i = 0; i < qnt; i++) {
				nomes[i] = nomeAtual.readLine();
			}
			nomeAtual.close();
		} catch (Exception e) {
			System.out.println("Erro ao abrir o arquivo!");
		}

		for (i = 1; i < nomes.length; i++) {
			String key = nomes[i];
			for (j = i - 1; (j >= 0) && (nomes[j].compareTo(key) > 0); j--) {
				nomes[j + 1] = nomes[j];
			}
			nomes[j + 1] = key;
		}
	}

	public void MergeSort(String nomeArq, int tamanho) throws FileNotFoundException {
		String nomes[] = new String[tamanho];
		try {
			FileReader arq = new FileReader(nomeArq);
			BufferedReader nomeAtual = new BufferedReader(arq);
			for (int i = 0; i < tamanho; i++) {
				nomes[i] = nomeAtual.readLine();
			}
			nomeAtual.close();
		} catch (Exception e) {
			System.out.println("Erro ao abrir o arquivo!");
		}
		int elementos = 1;
		int inicio, meio, fim;

		while (elementos < tamanho) {
			inicio = 0;

			while (inicio + elementos < tamanho) {

				meio = inicio + elementos;
				fim = inicio + 2 * elementos;

				if (fim > tamanho)
					fim = tamanho;

				intercala(nomes, inicio, meio, fim);

				inicio = fim;
			}

			elementos = elementos * 2;
		}

	}

	private void intercala(String[] vetor, int inicio, int meio, int fim) {
		String novoVetor[] = new String[fim - inicio];
		int i = inicio;
		int m = meio;
		int pos = 0;
		while (i < meio && m < fim) {
			if (vetor[i].compareTo(vetor[m]) <= 0) {
				novoVetor[pos] = vetor[i];
				pos = pos + 1;
				i = i + 1;

			} else {

				novoVetor[pos] = vetor[m];
				pos = pos + 1;
				m = m + 1;
			}
		}

		while (i < meio) {
			novoVetor[pos] = vetor[i];
			pos = pos + 1;
			i = i + 1;
		}

		while (m < fim) {
			novoVetor[pos] = vetor[m];
			pos = pos + 1;
			m = m + 1;
		}

		for (pos = 0, i = inicio; i < fim; i++, pos++) {
			vetor[i] = novoVetor[pos];
		}
	}

	public void BubbleSort(String nomeArq, int qnt) {
		String nomes[] = new String[qnt];
		String aux = new String();

		try {
			FileReader arq = new FileReader(nomeArq);
			BufferedReader nomeAtual = new BufferedReader(arq);
			for (int i = 0; i < qnt; i++) {
				nomes[i] = nomeAtual.readLine();
			}
			nomeAtual.close();
		} catch (Exception e) {
			System.out.println("Erro ao abrir o arquivo!");
		}

		for (int i = 0; i < qnt; i++) {
			for (int j = 0; j < qnt - 1; j++) {
				if (nomes[j].compareTo(nomes[j + 1]) > 0) {
					aux = nomes[j];
					nomes[j] = nomes[j + 1];
					nomes[j + 1] = aux;
				}
			}
		}

	}

	public void QuickSort(String nome, int qnt) {
		String nomes[] = new String[qnt];

		try {
			FileReader arq = new FileReader(nome);
			BufferedReader nomeAtual = new BufferedReader(arq);
			for (int i = 0; i < qnt; i++) {
				nomes[i] = nomeAtual.readLine();
			}
			nomeAtual.close();
		} catch (Exception e) {
			System.out.println("Erro ao abrir o arquivo!");
		}
		quickSort(nomes, 0, qnt - 1);
	}

	private static void quickSort(String[] vetor, int inicio, int fim) {
		if (inicio < fim) {
			int posicaoPivo = separar(vetor, inicio, fim);
			quickSort(vetor, inicio, posicaoPivo - 1);
			quickSort(vetor, posicaoPivo + 1, fim);
		}
	}

	private static int separar(String[] vetor, int inicio, int fim) {
		String pivo = vetor[inicio];
		int i = inicio + 1, f = fim;
		while (i <= f) {
			if (vetor[i].compareTo(pivo) <= 0) {
				i++;
			} else if (pivo.compareTo(vetor[i]) <= 0) {
				f--;
			} else {
				String troca = vetor[i];
				vetor[i] = vetor[f];
				vetor[f] = troca;
				i++;
				f--;
			}
		}
		vetor[inicio] = vetor[f];
		vetor[f] = pivo;
		return f;
	}
}
