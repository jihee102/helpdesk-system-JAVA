package employees;

import org.json.JSONObject;

public class Employee {
    protected String name;
    private String password;
    protected String department;

    public Employee(String eName, String ePassword, String eDepartment){
       this.name = eName;
       this.password = ePassword;
       this.department =eDepartment;
    }

    public Employee(JSONObject jo){
        this.name = jo.getString("name");
        this.password = jo.getString("password");
        this.department = jo.getString("department");
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString(){
        return name+" ("+department+") ";
    }
}
