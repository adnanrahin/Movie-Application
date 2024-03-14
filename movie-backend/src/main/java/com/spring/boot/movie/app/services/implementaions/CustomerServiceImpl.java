package com.spring.boot.movie.app.services.implementaions;

import com.spring.boot.movie.app.model.Customer;
import com.spring.boot.movie.app.repositories.CustomerRepository;
import com.spring.boot.movie.app.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class CustomerServiceImpl implements CustomerService {

    private static final Logger logger = Logger.getLogger(CustomerServiceImpl.class.getName());

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> findAll() {
        try {
            List<Customer> customers = (List<Customer>) customerRepository.findAll();
            logger.info("Retrieved all customers successfully.");
            return customers;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error occurred while finding all customers: " + e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public Customer findById(Long id) {
        try {
            Customer customer = customerRepository.findById(id).orElse(null);
            if (customer != null) {
                logger.info("Retrieved customer by id " + id + " successfully.");
            } else {
                logger.warning("No customer found for id " + id);
            }
            return customer;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error occurred while finding customer by id: " + id + ". " + e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public Customer save(Customer object) {
        try {
            Customer savedCustomer = customerRepository.save(object);
            logger.info("Saved customer successfully: " + savedCustomer);
            return savedCustomer;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error occurred while saving customer: " + object.toString() + ". " + e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public void delete(Customer object) {
        try {
            customerRepository.delete(object);
            logger.info("Deleted customer successfully: " + object);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error occurred while deleting customer: " + object.toString() + ". " + e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public void deleteById(Long id) {
        try {
            customerRepository.deleteById(id);
            logger.info("Deleted customer by id successfully: " + id);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error occurred while deleting customer by id: " + id + ". " + e.getMessage(), e);
            throw e;
        }
    }
}
