package tickets;

import employees.Employee;

import java.time.LocalDate;

public class HardwareTicket extends Ticket {
    private int machineCode;

    public HardwareTicket(LocalDate date, Employee tCreator, String tDescription, int tMachineCode){
        super(date,tCreator,tDescription);
        this.machineCode = tMachineCode;
    }

    public int getMachineCode() {
        return machineCode;
    }

    @Override
    public String toString(){
        String result = "Ticket "+super.getTicketNumber()+" (Hardwareticket, computerId: "+machineCode+"): \n";
        result += super.toString();
        return result;
    }
}
