package nextstep.path.ui;


import nextstep.path.domain.dto.PathsDto;
import nextstep.path.domain.dto.StationDto;

import java.util.List;
import java.util.stream.Collectors;

public class PathsResponse {

    private int distance;
    private int duration;
    private List<StationDto> stationDtoList;

    public PathsResponse() {
    }

    public PathsResponse(int distance, List<StationDto> stationDtoList) {
        this.distance = distance;
        this.stationDtoList = stationDtoList;
    }

    public PathsResponse(int distance, int duration, List<StationDto> stationDtoList) {
        this.distance = distance;
        this.duration = duration;
        this.stationDtoList = stationDtoList;
    }

    public int getDistance() {
        return distance;
    }

    public List<StationDto> getStationDtoList() {
        return stationDtoList;
    }

    public int getDuration() {
        return duration;
    }

    public static PathsResponse from(PathsDto pathsDto) {
        return new PathsResponse(
                pathsDto.getDistance(),
                pathsDto.getDuration(),
                pathsDto.getPaths()
                .stream()
                .map(it -> new StationDto(it.getId(), it.getName()))
                .collect(Collectors.toList())
        );
    }
}
