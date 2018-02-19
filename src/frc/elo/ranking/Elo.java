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
public class Elo {
    public static double redProb(Alliance red, Alliance blue){
        double kR = (blue.getRank() - red.getRank())/400;
        
        return 1 / (1 + Math.pow(10, kR));
    }
    
    public static double blueProb(Alliance red, Alliance blue){
        double kR = (red.getRank() - blue.getRank())/400;
        
        return 1 / (1 + Math.pow(10, kR));
    }
    
    public static void assignRanks(Alliance red, Alliance blue){
        int K = 20;
        double redP = redProb(red, blue);
        double blueP = blueProb(red, blue);
        double rankRed = 0;
        double rankBlue = 0;
        if (red.matchScore < blue.matchScore){
            rankRed = K * (1 - redP);
            rankBlue = K * (0 - blueP);
        }
        if (red.matchScore > blue.matchScore){
            rankRed = K * (0 - redP);
            rankBlue = K * (1 - blueP);
        }
        else if (red.matchScore == blue.matchScore){
            rankRed = K * (0.5 - redP);
            rankBlue = K * (0.5 - blueP);
        }
        red.team1.setRank(rankRed);
        red.team2.setRank(rankRed);
        red.team3.setRank(rankRed);
        blue.team1.setRank(rankBlue);
        blue.team2.setRank(rankBlue);
        blue.team3.setRank(rankBlue);
    }
}
