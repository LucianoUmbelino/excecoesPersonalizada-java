package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservas {

    private Integer numeroQuarto;
    private Date checkIn;
    private Date checkOut;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYY");

    public Reservas(){
    }

    public Reservas(Integer numeroQuarto, Date checkIn, Date checkOut) {
        this.numeroQuarto = numeroQuarto;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getNumeroQuarto() {
        return numeroQuarto;
    }

    public void setNumeroQuarto(Integer numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public long duracaoDias(){
        long diferena = checkOut.getTime() - checkIn.getTime();
        return TimeUnit.DAYS.convert(diferena, TimeUnit.MILLISECONDS);
    }

    public void atualizarDatas(Date checkIn, Date checkOut){
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    @Override
    public String toString(){
        return "Quarto "
                + numeroQuarto
                + ", CheckIn: "
                + sdf.format(checkIn)
                + ", CheckOut: "
                + sdf.format(checkOut)
                + ", "
                + duracaoDias()
                + " noites";


    }

}
