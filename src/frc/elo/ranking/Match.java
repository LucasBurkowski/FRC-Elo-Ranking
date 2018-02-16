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
public class Match {
    Alliance red;
    Alliance blue;
    
    long redScore;
    long blueScore;
    
    public Match(Alliance red, Alliance blue, long redScore, long blueScore){
        this.red = red;
        this.blue = blue;
        this.redScore = redScore;
        this.blueScore = blueScore;
    }
    
}
