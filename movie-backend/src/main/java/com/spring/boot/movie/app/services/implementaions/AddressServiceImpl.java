package com.spring.boot.movie.app.services.implementaions;

import com.spring.boot.movie.app.model.Address;
import com.spring.boot.movie.app.repositories.AddressRepository;
import com.spring.boot.movie.app.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class AddressServiceImpl implements AddressService {

    private static final Logger logger = Logger.getLogger(AddressServiceImpl.class.getName());

    private final AddressRepository addressRepository;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public List<Address> findAll() {
        try {
            List<Address> addresses = (List<Address>) addressRepository.findAll();
            logger.info("Retrieved all addresses successfully.");
            return addresses;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error occurred while finding all addresses: " + e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public Address findById(Long id) {
        try {
            Address address = addressRepository.findById(id).orElse(null);
            if (address != null) {
                logger.info("Retrieved address by id " + id + " successfully.");
            } else {
                logger.warning("No address found for id " + id);
            }
            return address;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error occurred while finding address by id: " + id + ". " + e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public Address save(Address object) {
        try {
            Address savedAddress = addressRepository.save(object);
            logger.info("Saved address successfully: " + savedAddress);
            return savedAddress;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error occurred while saving address: " + object.toString() + ". " + e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public void delete(Address object) {
        try {
            addressRepository.delete(object);
            logger.info("Deleted address successfully: " + object);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error occurred while deleting address: " + object.toString() + ". " + e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public void deleteById(Long id) {
        try {
            addressRepository.deleteById(id);
            logger.info("Deleted address by id successfully: " + id);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error occurred while deleting address by id: " + id + ". " + e.getMessage(), e);
            throw e;
        }
    }
}
