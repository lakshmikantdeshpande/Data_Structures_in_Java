package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class trainee {
    private String desg;
    private String nm;
    private float sal;

    public trainee(String desg, String nm, float sal) {
        super();
        this.desg = desg;
        this.nm = nm;
        this.sal = sal;
    }

    public static void main(String[] args) throws IOException {
        trainee t[] = new trainee[4];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 1; i++) {
            String tdesg = br.readLine();
            String tnm = br.readLine();
            float tsal = Float.parseFloat(br.readLine());
            t[i] = new trainee(tdesg, tnm, tsal);
        }

        for (int i = 0; i < 1; i++) {
            t[i].display();
        }

    }

    public void display() {
        System.out.println("Name: " + nm);
        System.out.println("Designation: " + desg);
        System.out.println("Salary: " + sal);
    }

}
