package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Lesson;
import entities.Task;
import entities.Video;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Lesson> lesson = new ArrayList<>();

		System.out.print("Quantas aulas tem o curso? ");
		int n = sc.nextInt();
		sc.nextLine();
		System.out.println();
		for (int i = 0; i < n; i++) {
			System.out.print("Dados da " + (i + 1) + "a aula: ");
			System.out.println();
			System.out.print("Conteúdo ou tarefa (c/t)? ");
			char typeLesson = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("Título: ");
			String title = sc.nextLine();
			if (typeLesson == 'c') {
				System.out.print("URL do vídeo: ");
				String url = sc.nextLine();
				System.out.print("Duração em segundos: ");
				int seconds = sc.nextInt();
				sc.nextLine();
				lesson.add(new Video(title, url, seconds));
			} else {
				System.out.print("Descrição: ");
				String description = sc.nextLine();
				System.out.print("Quantidade de questões: ");
				int questionCount = sc.nextInt();
				sc.nextLine();
				lesson.add(new Task(title, description, questionCount));
			}
			System.out.println();

		}

		int totalDuration = 0;
		for (Lesson lessons : lesson) {
			totalDuration += lessons.duration();
		}

		System.out.print("DURAÇÃO TOTAL DO CURSO " + totalDuration + " segundos");

		sc.close();
	}

}