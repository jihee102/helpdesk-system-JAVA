package tickets;

import employees.Employee;
import employees.ServiceEmployee;

import java.time.LocalDate;

public abstract class Ticket {
    private int ticketNumber;
    private static int count =1;
    private LocalDate createdDate;
    private Employee creator;
    private String description;

    private ServiceEmployee solver;
    private String solution;

    public Ticket(LocalDate date, Employee tCreator, String tDescription){
        this.ticketNumber = count;
        count++;
        this.createdDate = date;
        this.creator = tCreator;
        this.description = tDescription;
    }

    public void setSolver(ServiceEmployee solver) {
        this.solver = solver;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public Employee getCreator() {
        return creator;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public ServiceEmployee getSolver() {
        return solver;
    }

    public String getDescription() {
        return description;
    }

    public String getSolution() {
        return solution;
    }

    public boolean isSolved(){
        return solver!=null;
    }

    @Override
    public String toString(){
        String result ="";
        if(isSolved()){
            result += "Status: Solved \n";
            result += creator +": "+description+"\n";
            result += solver +": "+solution+"\n";
        }else{
            result+= "Status: Open \n";
            result += creator +": "+description+"\n";
    }
     return result;
    }
}
