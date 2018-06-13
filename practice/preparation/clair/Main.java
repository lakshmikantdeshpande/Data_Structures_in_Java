import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Employee e1 = new Employee(1, "adfn", 5000);
        Employee e2 = new Employee(2, "lax", 6508440);
        Employee e3 = new Employee(3, "shirku", 9800);
        Employee e4 = new Employee(4, "sandy", 645600);

        Map<Integer, Employee> map = new HashMap<Integer, Employee>();
        map.put(1, e1);
        map.put(2, e2);
        map.put(3, e3);
        map.put(4, e4);

        Iterator<Map.Entry<Integer, Employee>> iterator = map.entrySet()
                .iterator();

        System.out.println(map.size());

        while (iterator.hasNext()) {
            Map.Entry<Integer, Employee> entry = iterator.next();
            if (entry.getKey() == 3)
                iterator.remove();
            else
                System.out.println("KEY: " + entry.getKey() + "Value: "
                        + entry.getValue());
        }

        System.out.println(map.size());
        ObjectInputStream oos = null;
        // try {
        // oos = new ObjectOutputStream(new FileOutputStream("hello.txt"));
        // oos.writeObject(e1);
        // System.out.println("Object written to disk");
        // } catch (Exception e) {
        // e.printStackTrace();
        // } finally {
        // oos.close();
        // }

        try {
            oos = new ObjectInputStream(new FileInputStream("hello.txt"));
            Employee temp = (Employee) oos.readObject();
            System.out.println("read object: " + temp.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            oos.close();
        }

        FileWriter fw = new FileWriter("out.txt");
        for (int i = 0; i < 10; i++)
            fw.write(i + "\n");
        fw.close();

        int c = 0;
        Scanner scanner = new Scanner(new File("out.txt"));
        while (scanner.hasNextLine()) {
            c++;
            String str = scanner.nextLine();
            if (c == 3)
                System.out.println(str);
        }

        // Collections.sort(list, new Comparator<Employee>() {
        // @Override
        // public int compare(Employee one, Employee two) {
        // if (one == null || two == null)
        // return -1;
        // if (one.getId() < two.getId())
        // return 1;
        // else if (one.getId() > two.getId())
        // return -1;
        // else
        // return 0;
        // }
        // });
        //
        // System.out.println(list.toString());

    }

}
