import exceptions.HelpDeskException;

import java.io.IOException;
import java.time.LocalDate;

public class Aplication {

    public static void main(String[] args) {
        HelpDeskAdmin admin = new HelpDeskAdmin();
        try{
            admin.load("employees.json");
        }catch(IOException e){
            System.out.println(e);
        }catch (HelpDeskException e){
            System.out.println(e);
        }

        try {
            admin.addServiceEmployee("gerralt", "jihee", "Helpdesk", "Mice");
        } catch (HelpDeskException e) {
            e.printStackTrace();
        }

        System.out.println(admin.printEmployees());

        try{
            admin.addSoftwareTicket(LocalDate.of(2018,01,15), "ruud", "Excel can't calculate the number of days in a year", "Office 365");
            admin.addHardwareTicket(LocalDate.of(2018,01,16), "jeroen", "My mouse doesn't work!", 5);
            admin.addSoftwareTicket(LocalDate.of(2018,01,17), "ruud", "MacOS won't boot on my system", "MacOS X");
        } catch (HelpDeskException e) {
            e.printStackTrace();
        }

        try{
            admin.solveTicket(2, "gerralt", "Try putting it into the USB port instead of the HDMI port.");
            admin.solveTicket(3, "gerralt", "Please replace your Dell laptop with a real system");
        } catch (HelpDeskException e) {
            e.printStackTrace();
        }

        System.out.println(admin.printTickets());

    }
}
