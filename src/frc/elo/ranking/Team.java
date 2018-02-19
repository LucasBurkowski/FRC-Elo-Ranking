/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frc.elo.ranking;

import java.util.Comparator;
/**
 *
 * @author lburkowski
 */
public class Team{
    public String number;
    public double rank;
    
    
    public Team(String number,double rank){
        this.number = number;
        this.rank = rank;
    }
    
    public void setRank(double rank){
        this.rank += rank;
    }
    
    public double compare(Team t1){
        return this.rank - t1.rank;
    }
}
