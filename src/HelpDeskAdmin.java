import employees.Employee;
import employees.ServiceEmployee;
import exceptions.HelpDeskException;
import org.json.JSONArray;
import org.json.JSONObject;
import tickets.HardwareTicket;
import tickets.SoftwareTicket;
import tickets.Ticket;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;

public class HelpDeskAdmin {
    private ArrayList<Employee> employees = new ArrayList<>();
    private ArrayList<Ticket> tickets = new ArrayList<>();

    public HelpDeskAdmin(){};

    public Employee findEmployeeByName(String name){
        for (Employee employee :employees){
            if(employee.getName().equals(name)){
                return employee;
            }
        }
        return null;
    }

    public void addEmployee(String name, String password, String department) throws HelpDeskException {
        if(findEmployeeByName(name) != null){
            throw new HelpDeskException("Employee with that name already exists");
        }
        Employee em = new Employee(name, password,department);
        employees.add(em);
    }

    public void addServiceEmployee(String name,String password, String department, String expertise) throws HelpDeskException{
        if(findEmployeeByName(name) != null){
            throw new HelpDeskException("Employee with that name already exists");
        }
        ServiceEmployee em = new ServiceEmployee(name,password,department,expertise);
        employees.add(em);
    }

    public void addSoftwareTicket(LocalDate date, String name, String tDescription, String softwareName) throws HelpDeskException{
        Employee em = findEmployeeByName(name);
        if(em == null){
            throw new HelpDeskException("Employee not found");
        }
        SoftwareTicket ti = new SoftwareTicket(date,em,tDescription,softwareName);
        tickets.add(ti);
    }

    public void addHardwareTicket(LocalDate date, String name, String tDescription, int machineCode) throws HelpDeskException {
        Employee em = findEmployeeByName(name);
        if(em == null){
            throw new HelpDeskException("Employee not found");
        }
        HardwareTicket ti = new HardwareTicket(date,em,tDescription,machineCode);
        tickets.add(ti);
    }

    public void load(String fileName) throws HelpDeskException,IOException{
        String jsonString = new String(Files.readAllBytes(Paths.get(fileName)));
        JSONArray jsonArray = new JSONArray(jsonString);
        for (int i = 0; i <jsonArray.length() ; i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            if(findEmployeeByName(jsonObject.getString("name"))!=null) {
                throw new HelpDeskException("Employee with that name already exists");
            }
            Employee em = new Employee(jsonObject);
            employees.add(em);
        }
    }

    public Ticket findTicket(int ticketNr){
        for(Ticket ticket :tickets){
            if(ticket.getTicketNumber()==ticketNr){
                return ticket;
            }
        }
        return null;
    }

    public void solveTicket(int ticketNr, String solver, String solution) throws HelpDeskException{
        Ticket t = findTicket(ticketNr);
        if(t == null){
            throw new HelpDeskException("Ticket not found");
        }
        if(findEmployeeByName(solver)==null){
            throw new HelpDeskException("Employee not found");
        }
        if(!( findEmployeeByName(solver) instanceof ServiceEmployee)){
            throw new HelpDeskException("Employee found. But only service employee can solve it");
        }
        t.setSolver((ServiceEmployee) findEmployeeByName(solver));
        t.setSolution(solution);

    }

    public String printTickets(){
        String result ="Tickets: \n";
        for (Ticket t :tickets){
            result += t.toString() +"\n";
        }
        return result;
    }

    public String printEmployees(){
        String result ="Employees: \n";
        for (Employee e : employees){
            result += e.toString() +"\n";
        }
        return result;
    }


}
