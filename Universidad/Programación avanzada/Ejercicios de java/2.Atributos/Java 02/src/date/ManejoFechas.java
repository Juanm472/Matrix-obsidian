/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author user
 */
public class ManejoFechas {
    
    public static void main (String [] args) throws ParseException{
        
        Date hoy =  new Date();        
        System.out.println("Fecha Actual: "+hoy  );
        
        /*Convertir String a date*/
        String strFecha="2028/09/07";
        Date fecha=null;
        DateFormat df=null;
        try{
            df= new SimpleDateFormat("yyyy/MM/dd"); /*Ejemplo de polimorfismo*/
            fecha=df.parse(strFecha);
            System.out.println("Fecha :: "+fecha  );
        }
        catch (Exception ex){
            System.out.println("Error "+ex.toString());
        }
        
        //Adicionar dias a una fecha
        Calendar cal = new GregorianCalendar();
        cal.setTime(fecha);
        cal.add(Calendar.DATE , 5);
        fecha=cal.getTime();
        System.out.println("Nueva Fecha : "+fecha  );
        df= new SimpleDateFormat("yyyy/MMM/dd"); /*Ejemplo de polimorfismo*/
        strFecha=df.format(fecha);
        System.out.println("Nueva Fecha con formato: "+strFecha  );
        
        /*JDK 8 en adelante*/
        
        System.out.println("\n\nManejo de fechas con JDK 8 en adelante\n");
        
        LocalDate date1 = LocalDate.now();
        System.out.println("Local date :"+date1);
        
        LocalDate date2 = LocalDate.of(2024, 10, 05);
        System.out.println("Local date2 :"+date2);
        LocalDate date3 = LocalDate.parse("2022-10-04");
        System.out.println("Local date3 :"+date3);
        DayOfWeek dow = date1.getDayOfWeek();
        System.out.println("Dia de la semana:"+dow);
        int dom = date1.getDayOfMonth();
        System.out.println("Dia del mes:"+dom);

        LocalDate date4 = date1.plusDays(5);
        
        System.out.println("date1 + 5 :"+date4);
        
        /*Formatear fecha con LocalDate*/
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm");
        String strFecha2="2022/10/04 09:15";
        /*Convertir String a fecha*/
        LocalDate ldate= LocalDate.parse(strFecha2,dtf);
        System.out.println("ldate :"+ldate);
        /*Adicionar dias a una fecha*/
        ldate.plusDays(10);
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        //Convertir fecha a String
        strFecha2= ldate.format(dtf2);
        System.out.println("strFecha2 :"+strFecha2);
        
        //Fecha y hora
        System.out.println("\n\nManejo de fecha y hora \n\n");
        System.out.println("strFecha2 :"+strFecha2);
        /*Obtener fecha y hora actual*/
        LocalDateTime ldate1 = LocalDateTime.now();
        System.out.println("Local date :"+ldate1);
        
        DateTimeFormatter dtf3 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String strFecha3="2022/10/06 09:15:10";
        /*Adicionar meses a una fecha*/
        LocalDateTime ldate2 =ldate1.plusMonths(1);
        strFecha3=ldate2.format(dtf3);
        
        System.out.println("strFecha3 :"+strFecha3);
        /*Convertir String a fecha*/
        LocalDateTime ldate3 = LocalDateTime.parse(strFecha3,dtf3);
        System.out.println("ldate3:"+ldate3);
        
        System.out.println("Dia del mes:"+ldate3.getDayOfMonth());
        System.out.println("Dia de la semana:"+ldate3.getDayOfWeek());        
        System.out.println("Dia del año:"+ldate3.getDayOfYear());
        System.out.println("Mes:"+ldate3.getMonth());
        System.out.println("Nro. Mes:"+ldate3.getMonthValue());
        System.out.println("Año:"+ldate3.getYear());
        System.out.println("Hora:"+ldate3.getHour()+":"+ldate3.getMinute()+":"+ldate3.getSecond());
        
        /*Años entre dos fechas*/
        LocalDate fNacimiento = LocalDate.of(2002, Month.OCTOBER, 4);
        System.out.println("Tu edad es de " + ChronoUnit.YEARS.between(fNacimiento, LocalDate.now()) + " años.");
        System.out.println("Tu edad es de " + ChronoUnit.DAYS.between(fNacimiento, LocalDate.now()) + " dias.");
        
        
    }    
}
