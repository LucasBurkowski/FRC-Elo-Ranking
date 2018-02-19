/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frc.elo.ranking;

import java.util.Comparator;

/**
 *
 * @author lucas
 */
public class SortTeams implements Comparator<Team>{
    
    @Override
    public int compare(Team team1, Team team2){
        return (int) team2.rank - (int) team1.rank;
    }
}
