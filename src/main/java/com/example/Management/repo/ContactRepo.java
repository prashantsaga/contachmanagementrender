package com.example.Management.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.Management.model.Contact;
@Repository
public interface ContactRepo extends JpaRepository<Contact, Long> {
    @Query("SELECT e FROM Contact e WHERE e.firstName "
    	   + "LIKE '%'||:search||'%' "
    	   + "OR e.lastName LIKE '%'||:search||'%' "
    	   + "OR e.email LIKE '%'||:search||'%' "
    	   + "OR e.phoneNumber LIKE '%'||:search||'%'")
    List<Contact> getAllSearchContact(@Param("search") String search);
}

