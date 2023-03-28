package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 객체연습 {



    public static class Person{
        int age;
        String name;
        public Person(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader sb = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(sb.readLine());
        ArrayList<Person> list = new ArrayList<>();
        int n = Integer.parseInt(st.nextToken());
        Person[] arr = new Person[n];


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(sb.readLine(), " ");
            int age  = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            Person temp = new Person(age,name);
            list.add(temp);

        }
        Collections.sort(list, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if(o1.age<o2.age){
                    return -1;
                }
                else if(o1.age>o2.age){
                    return 1;
                }
                else
                return 0;
            }
        });
        for (Person person : list) {
            System.out.println(person.age+" "+person.name);
        }






    }
}
