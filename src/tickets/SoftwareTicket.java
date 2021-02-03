package tickets;

import employees.Employee;

import java.time.LocalDate;

public class SoftwareTicket extends Ticket {
    private String softwareName;

    public SoftwareTicket(LocalDate date, Employee tCreator, String tDescription, String tSoftwareName){
        super(date,tCreator,tDescription);
        this.softwareName = tSoftwareName;
    }

    public String getSoftwareName() {
        return softwareName;
    }

    @Override
    public String toString(){
        String result = "Ticket "+super.getTicketNumber()+" (Softwareticket, Application: "+softwareName+"): \n";
        result += super.toString();
        return result;
    }
}
