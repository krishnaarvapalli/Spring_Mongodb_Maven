package hello;

/**
 * Created by Radhakrishna A on 2/26/2017.
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;


@SpringBootApplication(exclude = {MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
public class Application implements CommandLineRunner {

    @Autowired
    private CustomerRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        repository.deleteAll();

        // save a couple of customers
        repository.save(new Customer("krishna", "DesMoines"));
        repository.save(new Customer("Bob", "DesMoines"));

        // fetch all customers
        System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");
        for (Customer customer : repository.findAll()) {
            System.out.println(customer);
        }
        System.out.println();

        // fetch an individual customer
        System.out.println("Customer found with findByName('Krishna'):");
        System.out.println("--------------------------------");
        System.out.println(repository.findByName("Krishna"));

        System.out.println("Customers found with findByCity('DesMoines'):");
        System.out.println("--------------------------------");
        for (Customer customer : repository.findByCity("DesMoines")) {
            System.out.println(customer);
        }

    }

}
