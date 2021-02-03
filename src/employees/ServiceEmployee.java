package employees;

public class ServiceEmployee extends Employee {
    private String expertise;

    public ServiceEmployee(String eName, String ePassword, String eDepartment, String eExpertise){
        super(eName,ePassword,eDepartment);
        this.expertise = eExpertise;
    }

    public String getExpertise() {
        return expertise;
    }

    @Override
    public String toString(){
        return name+" (Helpdesk, Expertise: "+expertise+")";
    }
}
