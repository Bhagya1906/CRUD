package com.bhagya.learning.crud.controller;


import com.bhagya.learning.crud.exception.NoPartsFoundException;
import com.bhagya.learning.crud.models.PartsDetails;
import com.bhagya.learning.crud.models.PartsInput;
import com.bhagya.learning.crud.service.PartsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * controller class for handling requests
 * This class provides RESTful endpoints for creating and handling Parts
 *
 */

@RestController
@RequestMapping("/parts")
public class PartsController {

    @Autowired
    private final PartsService partsService;

    public PartsController(final PartsService partsService) {
        this.partsService = partsService;
    }

    /**
     * getting all the parts.
     * This method handles GET requests to getting all the parts.
     *
     * @return a ResponseEntity with a success message.
     *
     */

    @GetMapping
    public ResponseEntity<List<PartsDetails>> getAllParts() {
        return ResponseEntity.ok(partsService.getPartDetails());
    }

    /**
     * getting a part with featureId.
     * This method handles GET requests to getting a part with featureId.
     *
     * @param featureId the part to be found.
     * @return a ResponseEntity with a success message.
     *
     */

    @GetMapping("/{id}")
    public ResponseEntity<PartsDetails> getPartById(@PathVariable final int featureId) {
        return ResponseEntity.ok(partsService.getPartById(featureId));
    }

    /**
     * Creates a new Part.
     * This method handles POST requests to create a new Part.
     * It validates the user input and returns an appropriate response.
     *
     * @param partsInput the part to be created, validated
     * @return a ResponseEntity with a success message if valid, otherwise error messages.
     *
     */

    @PostMapping
    public ResponseEntity<PartsDetails> createPartsDetails(@Valid @RequestBody final PartsInput partsInput) {
        return ResponseEntity.ok(partsService.createPartsDetails(partsInput));
    }

    /**
     * updating a part with featureId.
     * This method handles PUT requests to updating a part with featureId.
     *
     * @param updatePart the part to be updated.
     * @param featureId the part to be found.
     * @return a ResponseEntity with a success message.
     *
     */

    @PutMapping("/{id}")
    public ResponseEntity<PartsDetails> updateParts(@Valid @RequestBody final PartsInput updatePart,@PathVariable final int featureId) {
        return ResponseEntity.ok(partsService.updatePartById(featureId, updatePart));
    }

    /**
     * deleting all the parts.
     * This method handles DELETE requests to deleting all the parts.
     * @return a ResponseEntity with a success message.
     *
     */

    @DeleteMapping
    public ResponseEntity<String> deleteAllParts() {
        return ResponseEntity.ok(partsService.deleteAllParts());
    }

    /**
     * Handles exception.
     * This method handles NoPartsFoundException and constructs an error message.
     *
     * @return a ResponseEntity with a string of error messages
     *
     */

    @ExceptionHandler(NoPartsFoundException.class)
    public ResponseEntity<String> NoPartsFoundExceptionHandler(NoPartsFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.OK);
    }

    /**
     * deleting a part with featureId.
     * This method handles DELETE requests to deleting a part with featureId.
     * @return a ResponseEntity with a success message.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePartById(@PathVariable final int featureId) {
        return ResponseEntity.ok(partsService.deletePartById(featureId));
    }
}
