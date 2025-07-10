package com.adorsys_gis.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
@RequiredArgsConstructor
public class TicketController {
    private final TicketRepository ticketRepository;

    @PostMapping
    public ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticket) {
        return ResponseEntity.ok(ticketRepository.save(ticket));
    }

    @GetMapping
    public ResponseEntity<List<Ticket>> getAllTickets() {
        return ResponseEntity.ok(ticketRepository.findAll());
    }

    @GetMapping("/search")
    public ResponseEntity<List<Ticket>> searchTickets(
            @RequestParam(required = false) String address,
            @RequestParam(required = false) String destinationAddress,
            @RequestParam(required = false) String kickoffAddress
    ) {
        if (address != null) {
            return ResponseEntity.ok(ticketRepository.findByAddressContainingIgnoreCase(address));
        } else if (destinationAddress != null) {
            return ResponseEntity.ok(ticketRepository.findByDestinationAddressContainingIgnoreCase(destinationAddress));
        } else if (kickoffAddress != null) {
            return ResponseEntity.ok(ticketRepository.findByKickoffAddressContainingIgnoreCase(kickoffAddress));
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
} 