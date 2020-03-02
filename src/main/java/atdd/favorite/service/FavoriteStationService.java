package atdd.favorite.service;

import atdd.favorite.application.dto.FavoriteStationListResponseVIew;
import atdd.favorite.application.dto.FavoriteStationRequestView;
import atdd.favorite.application.dto.FavoriteStationResponseView;
import atdd.favorite.domain.FavoriteStation;
import atdd.favorite.domain.FavoriteStationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class FavoriteStationService {
    private FavoriteStationRepository favoriteStationRepository;

    public FavoriteStationService(FavoriteStationRepository favoriteStationRepository) {
        this.favoriteStationRepository = favoriteStationRepository;
    }

    public FavoriteStationResponseView create(FavoriteStationRequestView requestView) {
        Optional<FavoriteStation> existingFavoriteStation
                = favoriteStationRepository.findByStationId(requestView.getStationId());
        if (existingFavoriteStation.isPresent()) {
            return null;
        }
        FavoriteStation savedFavoriteStation
                = favoriteStationRepository.save(FavoriteStation.of(requestView));
        return FavoriteStationResponseView.of(savedFavoriteStation);
    }

    public void delete(FavoriteStationRequestView requestView) throws Exception {
        Optional<FavoriteStation> stationFindById
                = favoriteStationRepository.findById(requestView.getId());
        if (!stationFindById.isPresent()) {
            stationFindById.orElseThrow(IllegalArgumentException::new);
        }
        if (requestView.getEmail() == stationFindById.get().getEmail()) {
            favoriteStationRepository.delete(stationFindById.get());
        }
    }

    public FavoriteStationListResponseVIew showAllFavoriteStations(FavoriteStationRequestView requestView) {
        Optional<List<FavoriteStation>> allByEmail
                = favoriteStationRepository.findAllByEmail(requestView.getEmail());
        if(Optional.empty().isPresent()){
            throw new NoSuchElementException("등록된 지하철역이 없습니다.");
        }
        return new FavoriteStationListResponseVIew(requestView.getEmail(), allByEmail.get());
    }
}
