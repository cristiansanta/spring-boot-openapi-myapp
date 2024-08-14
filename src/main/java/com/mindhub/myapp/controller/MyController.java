package com.mindhub.myapp.controller;

import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

@RestController
public class MyController {

    @GetMapping("/api/greeting")
    @Operation(summary = "Get Greeting", description = "Returns a greeting message.")
    @ApiResponse(responseCode = "200", description = "Successful operation",
            content = @Content(schema = @Schema(implementation = String.class)))
    public String getGreeting() {
        return "Hello, World!";
    }

    @PostMapping("/api/submit")
    @Operation(summary = "Submit Data", description = "Receives data and returns a confirmation message.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Data successfully received."),
            @ApiResponse(responseCode = "400", description = "Bad request, invalid data.")
    })
    public String submitData(
            @RequestBody
            @Parameter(description = "The data to be submitted",
                    content = @Content(schema = @Schema(type = "string", example = "Sample data")))
            String data) {
        return "Data received: " + data;
    }

    @GetMapping("/api/user/{id}")
    @Operation(summary = "Get User by ID", description = "Returns a user based on the provided ID.")
    @ApiResponse(responseCode = "200", description = "Successful operation",
            content = @Content(schema = @Schema(implementation = String.class)))
    public String getUserById(
            @PathVariable("id")
            @Parameter(description = "ID of the user to retrieve")
            Long id) {
        return "User ID: " + id;
    }

    @GetMapping("/api/search")
    @Operation(summary = "Search", description = "Searches for items based on a query parameter.")
    @ApiResponse(responseCode = "200", description = "Successful operation",
            content = @Content(schema = @Schema(implementation = String.class)))
    public String search(
            @RequestParam(name = "query", defaultValue = "")
            @Parameter(description = "Search query")
            String query) {
        return "Search results for: " + query;
    }
}