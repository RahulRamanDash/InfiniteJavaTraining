package com.java.agent;

import java.util.List;
import java.util.Scanner;


public class AgentMain {

	static AgentBAL bal;
	static Scanner sc;
	
	static {
		bal = new AgentBAL();
		sc = new Scanner(System.in);
	}
	public static void main(String[] args) throws AgentException {
		int choice;
		do {
			System.out.println("O P T I O N S");
			System.out.println("-------------");
			System.out.println("1. Add Agent");
			System.out.println("2. Show Agent");
			System.out.println("6. Exit");
			System.out.println("Enter Your Choice  ");
			choice = sc.nextInt();
			switch(choice) {
			
			case 1:
				try {
					addAgentMain();
				} catch (AgentException e) {
					System.err.println(e.getMessage());
				}
			case 2 : 
				showAgentMain();
				break;
			case 6:
				return;
			default : 
				System.out.println("Invalid chocie (1 to 6 only)");
				break;
			}
			
		}while(choice!=6);
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
		System.out.println("Enter Last Namet  ");
		agent.setLastName(sc.next());
		System.out.println("Enter Paymode)  ");
		agent.setPayMode(PayMode.valueOf(sc.next()));
		System.out.println("Enter City  ");
		agent.setCity(sc.next());
		System.out.println(bal.addAgentBal(agent));
	}
}
