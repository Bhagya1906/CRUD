package com.bhagya.learning.crud.utils;

import com.bhagya.learning.crud.entity.Parts;
import com.bhagya.learning.crud.models.PartsDetails;
import com.bhagya.learning.crud.models.PartsInput;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 *Class used to transform the input details into entity
 * and entity class to response class.
 *
 */

public class PartsTransformers {

    /**
     * Method for transforming PartsInput to Parts
     *
     */
    public static final Function<PartsInput, Parts> transformInputToEntity =
            (partsInput) -> {
                final Parts partEntity = new Parts();
                partEntity.setPartNumber(partsInput.getPartNumber());
                partEntity.setNameDE(partsInput.getNameDE());
                partEntity.setNameEn(partsInput.getNameEn());
                partEntity.setNoOfDS(partsInput.getNoOfDS());
                partEntity.setNoOfDZ(partsInput.getNoOfDZ());
                return partEntity;
            };

    /**
     * Method for transforming PartsInput to Parts
     *
     */

    public static final BiFunction<PartsInput, Parts, Parts> transformInputAndEntity =
            (partsInput, partEntity) -> {
                partEntity.setNameDE(partsInput.getNameDE());
                partEntity.setNameEn(partsInput.getNameEn());
                partEntity.setNoOfDS(partsInput.getNoOfDS());
                partEntity.setNoOfDZ(partsInput.getNoOfDZ());
                return partEntity;
            };

    /**
     * Method for transforming Parts to PartsDetails
     *
     */

    public static final Function<Parts, PartsDetails> transformEntityToResponse =
            (parts) -> {
                final PartsDetails partsDetails = new PartsDetails();
                partsDetails.setFeatureId(parts.getFeatureId());
                partsDetails.setPartNumber(parts.getPartNumber());
                partsDetails.setNameDE(parts.getNameDE());
                partsDetails.setNameEn(parts.getNameEn());
                partsDetails.setNoOfDS(parts.getNoOfDS());
                partsDetails.setNoOfDZ(parts.getNoOfDZ());
                return partsDetails;
            };
}
