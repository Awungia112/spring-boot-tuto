package com.adorsys_gis.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findByAddressContainingIgnoreCase(String address);
    List<Ticket> findByDestinationAddressContainingIgnoreCase(String destinationAddress);
    List<Ticket> findByKickoffAddressContainingIgnoreCase(String kickoffAddress);
} 