package hello;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Radhakrishna A on 2/26/2017.
 */
public interface CustomerRepository extends MongoRepository<Customer, String> {

    public Customer findByName(String name);

    public List<Customer> findByCity(String city);

}