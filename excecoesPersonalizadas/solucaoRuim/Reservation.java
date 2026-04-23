package excecoesPersonalizadas.solucaoRuim;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {


    private Integer roomNumber;
    private Date checkIn;
    private Date checkOut;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation() {
    }

    public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getRoomNuber() {
        return roomNumber;
    }

    public void setRoomNuber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    //Calcular a diferença de datas em milissegundos
    public long duration() {
        long diff = checkOut.getTime() - checkIn.getTime();
        //Convertendo milissegundos para dias com base no checkIN e Checkout
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);


    }

    public String updateDates(Date checkIn, Date checkOut) {
        Date now = new Date();
        if (checkIn.before(now) || checkOut.before(now)) {
            return "Reservation for update must be future";
        } if (!checkOut.after(checkIn)) {
            return "Check-out date must be after check-in date";
        }
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        return null;
    }

    @Override
    public String toString() {
        return "Room: " + roomNumber +
                ", checkIn: " + sdf.format(checkIn) +
                ", checkOut: " + sdf.format(checkOut) +
                ", duration: " + duration() +
                " nights";
    }
}
