/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frc.elo.ranking;

/**
 *
 * @author lburkowski
 */
public class Team {
    public long number;
    public double rank;
    
    
    public Team(long number,double rank){
        this.number = number;
        this.rank = rank;
    }
    
    public void setRank(double rank){
        this.rank += rank;
    }
}
