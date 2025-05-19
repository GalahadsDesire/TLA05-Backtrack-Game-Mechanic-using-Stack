package testoftest;
import java.util.Scanner;

import java.util.Stack;
import java.util.Random;
public class game {

	public static void main(String[] args) {
		 Stack<Integer> gala = new Stack <>();
	        
	        Random random = new Random();
	        
	        int game = 2;
	        
	        int playerHP = 100;
	        int enemy = 100;
	        int playerhp= 100;
	        int monsterhp=100;
	        int playerdmg = 25;
	        int monsterdmg = 20;
	        boolean checks;
	       
	        
	        String choice;
	        
	        Scanner scanner = new Scanner(System.in);
	        
	      
	       
	        
	        while (true){
	        if (checker(game)){
	        	
	            System.out.println("==============");
	            System.out.println("Player Vs Monster");
	            
	            System.out.println("player HP: " + playerhp );
	            System.out.println("Monster HP: " + monsterhp);
	            
	            System.out.println("What would you like to do?");
	            System.out.println(">>> ATTACK ");
	            System.out.println(">>> STUN (50/50 Chance)");
	            
	            
	             choice = scanner.nextLine();
	             
	             if (choice.equalsIgnoreCase("ATTACK")){
	                 
	                 
	                 
	                 monsterhp -= playerdmg;
	                 System.out.println("Damaged the monster");
	                 System.out.println("HP OF MONSTER: " + monsterhp);
	                 
	                 gala.push(playerdmg);
	                 System.out.println(gala.peek() + "Stack HP");
	                 
	                 game ++;
	                 
	                 
	             }
	            if(choice.equalsIgnoreCase("STUN")){
	                
	                if(stun()){
	                    
	                    
	                    
	                    
	                    System.out.println("Stunned the monster");
	                    
	                    
	                } else{
	                    System.out.println("You failed to stun the monster");
	                    game ++;
	                }
	                
	               
	            }
	             
	             
	        }  else {
	        	playerhp = monsterattk(playerhp, monsterdmg, monsterhp, gala, game);
	        	monsterhp = PassiveSystem(gala, monsterhp);
	            game ++;
	        }
	        if (playerhp <= 0) {
                System.out.println("Player Dead");
                break;
            } else if (monsterhp <= 0) {
                System.out.println("Ggs bro you won");
                break;
            }
	        }
	        
	        
	        
	    }

	 static boolean checker(int game)
	    {
	        
	        
	        if (game % 2 == 0){
	            
	                return true;
	                
	                
	        } else { return false;}
	        
	       
	    }
	 
	 
	 
	 static int monsterattk(int playerhp, int monsterdmg,int monsterhp, Stack gala, int game){
	     
	     int NO = (int)(Math.random() * 2);
	     
	    
	     
	     
	     if (NO == 0){
	         System.out.println("The Monster attacked!");
	         
	         playerhp -= monsterdmg;
	         
	         
	         
	         
	     } else{
	    	 
	    	 System.out.println("Monster missed his attack");
	         
	     }
	     game +=1;
	 
	     return playerhp;
	 }
	 
	 static void isMonsterStunned(){
	     
	 }
	 
	 static boolean  stun (){
	     
	    int gala = (int)(Math.random() * 4);
	    
	    boolean outcome = false;
	    
	     
	     
	     
	     switch (gala){
	         
	         case 0:
	             outcome = true;
	              break;
	         case 1:
	             outcome = false;
	              break;
	             
	         case 2:
	             outcome = false;
	              break;
	             
	         case 3 :
	             
	             outcome = true;
	             break;
	             
	     }
	     return outcome;
	             
	             
	     
	 
	     
	 
	     }
	 
	 static int PassiveSystem (Stack <Integer>gala,int monsterhp) {
		 
 int passive = (int)(Math.random()* 3);
	     
	     if (passive == 1){
	         
	         System.out.println("PASSIVE HAS BEEN INVOKED");
	         
	       
	       if(!gala.isEmpty()) {
	    	   
	    	   
	    	   int healpassive = gala.pop();
	    	   monsterhp += healpassive;
	    	   
	    	   System.out.println("HEALED");
	       } else {
	    	   
	    	   System.out.println("There is no HP that was lost, passive failed");
	       }
	       
	        
	         
	     }  
	     return monsterhp;
	 }
	 }
	 