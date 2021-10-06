package training.proj.mobilele.services;

import training.proj.mobilele.models.views.OfferSummaryViewModel;

import java.util.List;

public interface OffersService {
    public List<OfferSummaryViewModel> getAllOffers();
}
