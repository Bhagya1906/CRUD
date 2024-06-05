package com.bhagya.learning.crud.service;

import com.bhagya.learning.crud.entity.Parts;
import com.bhagya.learning.crud.exception.PartAlreadyExistException;
import com.bhagya.learning.crud.exception.PartNotFoundException;
import com.bhagya.learning.crud.models.PartsDetails;
import com.bhagya.learning.crud.models.PartsInput;
import com.bhagya.learning.crud.repository.PartsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.bhagya.learning.crud.utils.PartsTransformers.*;

@Service
public class PartsService {

    @Autowired
    private final PartsRepository partsRepository;

    public PartsService(final PartsRepository partsRepository) {
        this.partsRepository = partsRepository;
    }

    /**
     * Function will create new Parts details and return saved parts details.
     *
     * @param partsInput - Contains details that need to be saved.
     * @return PartsDetails - Contains details that need to be response.
     * @throws PartAlreadyExistException if Part with this PartNumber already Exist.
     */
    public PartsDetails createPartsDetails(final PartsInput partsInput) {
        final Parts entityInput = validatePartNumberAndTransformDetails(partsInput);
        final Parts parts = partsRepository.save(entityInput);
        return transformEntityToResponse.apply(parts);
    }

    /**
     * Function will get all the parts from database and if no part is there
     * it will throw the exception.
     *
     * @return PartsDetails - Contains details that need to be response.
     * @throws ResponseStatusException if there are no parts to delete.
     */
    public List<PartsDetails> getPartDetails() {
        return partsRepository.findAll()
                .stream()
                .map(transformEntityToResponse)
                .collect(Collectors.toList());
    }

    /**
     * Function to find the specific parts with id.
     *
     * @param featureId - pass the id that need to be found.
     * @return PartsDetails - Contains details that need to be response.
     * @throws PartNotFoundException if there are no parts to delete.
     */
    public PartsDetails getPartById(final int featureId) {
       final Parts parts = validateAndGetPartDetails(featureId);
        return transformEntityToResponse.apply(parts);
    }

    /**
     * @param featureId    pass the id that need to be found.
     * @param newPartInput Contains details that need to be updated.
     * @return PartsDetails - Contains details that need to be response.
     * @throws PartNotFoundException if there are no parts to delete.
     */
    public PartsDetails updatePartById(final int featureId, final PartsInput newPartInput) {
        final Parts parts = validateAndGetPartDetails(featureId);
        final Parts updatedPart = transformInputAndEntity.apply(newPartInput, parts);
        partsRepository.save(updatedPart);
        return transformEntityToResponse.apply(updatedPart);
    }

    /**
     * Deletes all parts from the repository.
     *
     * @return A confirmation message stating that all parts have been deleted.
     * @throws ResponseStatusException if there are no parts to delete.
     */
    public String deleteAllParts() {
        partsRepository.deleteAll();
        return "All Parts are Deleted!!!";
    }

    /**
     * @param featureId pass the id that need to be found.
     * @return String message
     */
    public String deletePartById(final int featureId) {
        final Parts parts = validateAndGetPartDetails(featureId);
        partsRepository.delete(parts);
        return "Part with this id Deleted";
    }

    /**
     * Method for validate PartNumber And TransformDetails
     *
     * @param partsInput pass the part that have to create.
     * @return response or else throw PartAlreadyExistException
     *
     */
    private Parts validatePartNumberAndTransformDetails(final PartsInput partsInput) {
        final Optional<Parts> parts = partsRepository.findByPartNumber(partsInput.getPartNumber());

        if (parts.isPresent()) {
            throw new PartAlreadyExistException("Part with this PartNumber already Exist " + partsInput.getPartNumber());
        }
        return transformInputToEntity.apply(partsInput);
    }

    /**
     * Method for validate and Get PartDetails
     *
     * @param featureId pass the id that need to be found.
     * @return response or else throw PartNotFoundException
     *
     */

    private Parts validateAndGetPartDetails(final int featureId) {
       final Optional<Parts> partDetail = partsRepository.findById(featureId);
        if (partDetail.isEmpty()) {
            throw new PartNotFoundException("Part Not Found with this id " + featureId);
        }
        return partDetail.get();
    }
}
