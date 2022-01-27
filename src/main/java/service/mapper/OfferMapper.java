package service.mapper;

import dto.OfferDto;
import model.Offer;

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

   /* public List<Offer> convertOfferDtoToOffer(List<OfferDto> offerDtoList) {
        List<Offer> offerList = new ArrayList<>();
        for (OfferDto offerDto : offerDtoList) {
            Offer offer=Offer.builder()
                    .price(offerDto.getPrice())
                    .startDate(offerDto.getStartDate())
                    .creationDate(offerDto.getCreationDate())
                    .durationOfWork(offerDto.getDurationOfWork())
                    .build();
            offerList.add(offer);
        }
        return offerList;
    }*/
}
