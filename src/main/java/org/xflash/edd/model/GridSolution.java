package org.xflash.edd.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class GridSolution {
    private final List<GridPart> parts;

    public GridSolution(GridSolution gridSolution) {
        this.parts = new ArrayList<>(gridSolution.parts);
    }

    public GridSolution() {
        this.parts = new ArrayList<>();
    }

    public Collection<GridPart> getParts() {
        return parts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GridSolution that = (GridSolution) o;
        return Objects.equals(parts, that.parts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parts);
    }

    @Override
    public String toString() {
        return "GridSolution " + parts;
    }

    public void addPart(GridPart part) {
        this.parts.add(part);
    }
}
