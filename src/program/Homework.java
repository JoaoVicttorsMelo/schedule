package program;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Work;

public class Homework {

	public static void main(String[] args) throws ParseException, IOException {
		Locale.setDefault(Locale.US);
		String nameDir = System.getProperty("user.name");
		int i = 0;
		int rp = 0;
		char resp;
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf1 = new SimpleDateFormat("mm/DD");
		String path = "C:\\Users\\" + nameDir + "\\HomeWork.csv";
		List<Work> work = new ArrayList<>();

		do {
			i++;
			System.out.print("enter your " + i + " Homework: ");
			String subject = sc.next();

			System.out.print("enter the deadline (mm/dd): ");
			Date moment = sdf1.parse(sc.next());
			Work wk = new Work(subject, moment);
			work.add(wk);

			System.out.print("Do you wanna add a new Homework? [Y/N]: ");
			resp = sc.next().charAt(0);
			resp = Character.toUpperCase(resp);
			if (resp == 'Y') {

				i++;
				System.out.print("enter your " + i + " grade: ");
				subject = sc.next();
				System.out.print("enter the deadline (mm/dd): ");
				moment = sdf1.parse(sc.next());
				wk = new Work(subject, moment);
				work.add(wk);
				System.out.print("do you have another Homework? [Y/N]: ");
				resp = sc.next().charAt(0);
				resp = Character.toUpperCase(resp);

				if (resp == 'N') {
					rp = 1;
				}
			} else {
				rp = 1;
			}

		} while (rp == 0);

		System.out.println("Results:");
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {

			for (Work obj : work) {
				System.out.println(obj);
				bw.write(String.valueOf(obj));
				bw.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		sc.close();
	}

}
