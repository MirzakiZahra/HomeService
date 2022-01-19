package service.mapper;

import dto.OfferDto;
import dto.OrderDto;
import model.Offer;
import model.Order;

public class OfferMapper {
    public OfferDto convertOfferToOfferDto(Offer offer){
        OfferDto offerDto=OfferDto.builder()
                .id(offer.getId())
                .price(offer.getPrice())
                .creationDate(offer.getCreationDate())
                .startDate(offer.getStartDate())
                .durationOfWork(offer.getDurationOfWork())
                .explanation(offer.getExplanation())
                .build();
        return offerDto;
    }
}
