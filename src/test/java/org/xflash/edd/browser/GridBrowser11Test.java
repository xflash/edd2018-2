package org.xflash.edd.browser;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.xflash.edd.model.Coord;
import org.xflash.edd.model.Grid;
import org.xflash.edd.model.GridPart;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

@RunWith(Parameterized.class)
public class GridBrowser11Test {

    private final GridPart[] gridParts;
    private final Grid grid;
    private final Coord coord;

    public GridBrowser11Test(final String name, final int[][] cells, final Coord coord, final GridPart[] gridParts) {
        this.grid = new Grid(cells);
        this.coord = coord;
        this.gridParts = gridParts;

    }

    @Parameterized.Parameters(name = "{0}")
    public static Collection<Object[]> data() {
        return Collections.singletonList(

                new Object[]{
                        "checkForFull",
                        new int[][]{
                                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 11, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        },
                        new Coord(5, 5),
                        new GridPart[]{
                                //CROSS
                                //1x11
                                GridPart.build(0, 5, 10, 5),
                                GridPart.build(1, 5, 11, 5),
                                GridPart.build(2, 5, 12, 5),
                                //11x1
                                GridPart.build(5, 0, 5, 10),
                                GridPart.build(5, 1, 5, 11),
                                GridPart.build(5, 2, 5, 12),
                        }
                }
        );
    }

    @Test
    public void checking() throws Exception {
        ArrayList<GridPart> gridParts = new ArrayList<>();
        new GridBrowser(grid).forEachGridParts(coord, gridParts::add);
        Assert.assertEquals("gridparts size should be of size: " + this.gridParts.length, this.gridParts.length, gridParts.size());
        for (GridPart gridPart : this.gridParts) {
            Assert.assertTrue("grid part " + gridPart + " should be present", gridParts.contains(gridPart));
        }
    }


}