package sombr.dancesport.skating.data;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class RatingTable<R, C> implements Table<R, C, Integer> {
    private final Set<R> rowIds;
    private final Set<C> colIds;
    private final Map<R, Map<C, Integer>> values;

    public RatingTable( final Set<R> rowIds, final Set<C> colIds ) {
        this.rowIds = rowIds;
        this.colIds = colIds;
        this.values = new HashMap<>();
    }

    @Override
    public void put( R row, C col, Integer value ) {
        if ( rowIds.contains(row) && colIds.contains(col) ) {
            if ( !values.containsKey(row) ) {
                values.put(row, new HashMap<>());
            }

            values.get(row).put(col, value);
        } else {
            throw new IllegalArgumentException("No such index (" + row + ", " + col + ") in the table " + this);
        }
    }

    @Override
    public Integer get( R row, C col ) {
        if ( rowIds.contains(row) && colIds.contains(col) ) {
            final Map<C, Integer> rowCols = values.get(row);
            if ( rowCols == null ) {
                return null;
            }

            return rowCols.get(col);
        }
        throw new IllegalArgumentException("No such index (" + row + ", " + col + ") in the table " + this);
    }

    @Override
    public String toString() {
        return "<RatingTable rows=" + rowIds + " cols=" + colIds + " />";
    }
}
