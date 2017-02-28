package hello;

import org.springframework.data.annotation.Id;

/**
 * Created by Radhakrishna A on 2/26/2017.
 */
public class Customer {

    @Id
    public String id;

    public String name;
    public String city;

    public Customer() {}

    public Customer(String name, String city) {
        this.name = name;
        this.city = city;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%s, name='%s', city='%s']",
                id, name, city);
    }
}
