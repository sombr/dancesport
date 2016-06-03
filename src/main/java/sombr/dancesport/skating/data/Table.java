package sombr.dancesport.skating.data;

public interface Table<R, C, V> {
    void put( R row, C col, V value );

    V get( R row, C col );
}
