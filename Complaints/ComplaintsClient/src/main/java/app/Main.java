/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.util.List;
import java.util.Optional;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

/**
 *
 * @author stani
 */
public class Main {
    
    public static void main(String[] args) {
        Client client = ClientBuilder.newClient();
        String count = client
                .target("http://localhost:8080/Complaints/resources/complaints/count")
                .request(MediaType.TEXT_PLAIN)
                .get(String.class);

        System.out.println("Count: " + count);

        List<Complaint> complaints = client
                .target("http://localhost:8080/Complaints/resources/complaints")
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<Complaint>>() {
                });

        System.out.println("\nComplaints:");
        complaints.forEach(System.out::println);

        Optional<Complaint> complaint = complaints.stream()
                .filter(item -> "open".equalsIgnoreCase(item.getStatus()))
                .findFirst();

        Complaint searchedComplaint = client
                .target("http://localhost:8080/Complaints/resources/complaints")
                .path(complaint.orElse(new Complaint(1)).getId().toString())
                .request(MediaType.APPLICATION_JSON)
                .get(Complaint.class);

        System.out.println("\nComplaint:");
        System.out.println(searchedComplaint);

        searchedComplaint.setStatus("closed");
        
        Response response = client
                .target("http://localhost:8080/Complaints/resources/complaints")
                .path(searchedComplaint.getId().toString())
                .request(MediaType.APPLICATION_JSON)
                .put(Entity.entity(searchedComplaint, MediaType.APPLICATION_JSON),
                    Response.class);

        System.out.println("\nEdited complaint:");
        System.out.println(response.getStatus() == Status.NO_CONTENT.getStatusCode()
                ? "Updated"
                : "Error");

        List<Complaint> openedComplaints = client
                .target("http://localhost:8080/Complaints/resources/complaints")
                .queryParam("status", "open")
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<Complaint>>() {
                });

        System.out.println("\nOpened complaints:");
        openedComplaints.forEach(System.out::println);

        client.close();
    }
}
