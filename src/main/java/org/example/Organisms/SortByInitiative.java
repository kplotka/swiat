package org.example.Organisms;

import java.util.Comparator;

public class SortByInitiative implements Comparator<Organism>
{
    public int compare(Organism a, Organism b)
    {
        if (a.initiative > b.initiative){
            return 1;
        }
        if (a.initiative < b.initiative){
            return -1;
        }
        return 0;
    }
}