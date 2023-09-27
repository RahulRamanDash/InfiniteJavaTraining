package com.java.agent;
import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class AgentMain {

	static AgentBAL bal;
	static Scanner sc;
	
	static {
		bal = new AgentBAL();
		sc = new Scanner(System.in);
	}
	public static final Logger Log = Logger.getLogger("com.java.infinite.Calculation");
	public static void main(String[] args) throws AgentException {
		
		int choice;
		do {
			System.out.println("O P T I O N S");
			System.out.println("-------------");
			System.out.println("1. Add Agent");
			System.out.println("2. Show Agent");
			System.out.println("3. Search Agent");
			System.out.println("4. Delete Agent");
			System.out.println("5. Update Agent");
			System.out.println("6. write Agent In File");
			System.out.println("7. Read Agent Data From File");
			System.out.println("8. Exit");
			System.out.println("Enter Your Choice  ");
			choice = sc.nextInt();
			switch(choice) {
			
			case 1:
				try {
					addAgentMain();
					Log.info("Agent added with no Exception");
				} catch (AgentException e) {
					System.err.println(e.getMessage());
				}
				break;
			case 2 : 
				showAgentMain();
				break;
			case 3:
				searchEnployMain();
				break;
			case 4:
				deleteAgentMain();
				break;
			case 5:
				try {
					updateAgentMain();
					Log.info("Agent Updated with no Exception");
				} catch (Exception e) {
					e.printStackTrace();
					Log.error("Custom error Data not Updated");
				}
				break;
			case 6:
				try {
					writeAgentFileMain();
					Log.info("Agent Writen in file with no Exception");
				} catch (IOException e) {
					e.printStackTrace();
					Log.error("Custom error Data not writen to file");
				}
				break;
			case 7:
				
				try {
					ReadAgentFileMain();
					Log.info("Agent Readed from file with no Exception");
				} catch (ClassNotFoundException
						| IOException e) {
					e.printStackTrace();
					Log.error("Custom error Data not Readed from file");
				}
				break;
			case 8:
				return;
			default : 
				System.out.println("Invalid chocie (1 to 8 only)");
				break;
			}
			
		}while(choice!=6);
	}
	//all methods
	public static void ReadAgentFileMain() throws FileNotFoundException, IOException, ClassNotFoundException{
		System.out.println(bal.ReadAgentFileBal());
	}
	public static void writeAgentFileMain() throws FileNotFoundException, IOException{
		System.out.println(bal.writeAgentFileBal());
	}
	
	private static void updateAgentMain() throws Exception{
		Agent agentUpdated = new Agent();
		System.out.println("Enter First Name  ");
		agentUpdated.setFirstName(sc.next());
		System.out.println("Enter Last Name  ");
		agentUpdated.setLastName(sc.next());
		System.out.println("Enter Paymode (MONTHLY/HALFYEARLY/YEARLY/QUARTERLY)  ");
		agentUpdated.setPayMode(PayMode.valueOf(sc.next()));
		System.out.println("Enter City  ");
		agentUpdated.setCity(sc.next());
		System.out.println("Enter Premium  ");
		agentUpdated.setPremium(sc.nextDouble());
		System.out.println(bal.updateAgentBal(agentUpdated));
	}
	
	public static void searchEnployMain(){
		int agentno;
		System.out.println("Enter Agent no : ");
		agentno = sc.nextInt();
		Agent agent = bal.searchAgentBal(agentno);
		if(agent!=null){
			System.out.println(agent);
		}
		else{
			System.out.println("Record Not Found...");
		}
	}
	
	public static void deleteAgentMain(){
		int agentno;
		System.out.println("Enter Agent no : ");
		agentno = sc.nextInt();
		System.out.println(bal.deleAgentBal(agentno));
	}
	
	private static void showAgentMain() {
		List<Agent> agentList= bal.showAgentBal();
		for (Agent agent : agentList) {
			System.out.println(agent);
		}
	}
	public static void addAgentMain() throws AgentException {
		Agent agent = new Agent();
		System.out.println("Enter First Name  ");
		agent.setFirstName(sc.next());
		System.out.println("Enter Last Name  ");
		agent.setLastName(sc.next());
		System.out.println("Enter Paymode  ");
		agent.setPayMode(PayMode.valueOf(sc.next()));
		System.out.println("Enter City  ");
		agent.setCity(sc.next());
		System.out.println("Enter Premium  ");
		agent.setPremium(sc.nextDouble());
		System.out.println(bal.addAgentBal(agent));
	}
}
