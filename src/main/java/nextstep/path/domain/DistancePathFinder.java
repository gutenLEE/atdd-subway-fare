package nextstep.path.domain;

import nextstep.line.domain.Line;
import nextstep.line.domain.Section;

import java.util.List;

public class DistancePathFinder extends PathFinder {
    public DistancePathFinder(List<Line> lines) {
        super(lines);
    }

    @Override
    public void addEdge(Section section) {
        SectionEdge sectionEdge = new SectionEdge(section);
        graph.addEdge(section.getUpStation(), section.getDownStation(), sectionEdge);
        graph.setEdgeWeight(sectionEdge, section.getDistance());
    }
}