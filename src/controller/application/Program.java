package controller.application;

import model.entities.Reservas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Número do Quarto: ");
        int numQuarto = sc.nextInt();
        System.out.print("Data Check-In (dd/MM/yyyy): ");
        Date dtaCheckIn = sdf.parse(sc.next());
        System.out.print("Data Check-Out (dd/MM/yyyy): ");
        Date dtaCheckOut = sdf.parse(sc.next());

        if (!dtaCheckOut.after(dtaCheckIn)){
            System.out.println("Erro ao efetuar a reserva: Data de Check-Out deve ser posterior a data de Check-In.");
        }
        else {
            Reservas reserva = new Reservas(numQuarto, dtaCheckIn, dtaCheckOut);
            System.out.println("Reserva: " + reserva);

            System.out.println();
            System.out.println("Entre com os dados para atualização da reserva:");
            System.out.print("Data Check-In (dd/MM/yyyy): ");
            dtaCheckIn = sdf.parse(sc.next());
            System.out.print("Data Check-Out (dd/MM/yyyy): ");
            dtaCheckOut = sdf.parse(sc.next());

            String erro = reserva.atualizarDatas(dtaCheckIn, dtaCheckOut);
            if (erro != null){
                System.out.println("Erro ao efetuar a reserva: " + erro);

            }
            else {
                System.out.println("Reserva: " + reserva);
            }


        }



        sc.close();

    }

}
