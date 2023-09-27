package com.java.agent;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;


public class AgentMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		
		int choice;
		do {
			System.out.println("O P T I O N S");
			System.out.println("-------------");
			System.out.println("1. Show Agent Details ");
			System.out.println("2. Add Agent Details ");
			System.out.println("3. Search Agent Details ");
			System.out.println("4. Update Agent Details ");
			System.out.println("5. Delete Agent Details ");
			System.out.println("6. Exit");
			
			choice = sc.nextInt();
			
			switch (choice) {
			case 1:
				showAgentMain();
				break;
			case 2:
				addAgentMain();
				break;
			case 3:
				searchAgentMain();
				break;
			case 4:
				updateAgentMain();
				break;
			case 5:
				deleteAgentMain();
				break;
			case 6:
				System.out.println("Exiting....");
				return;
			default:
				System.out.println("Enter a Valid Option...");
				return;
				
					
			}
			
			
		}while(choice!=6);
		
		
		

}

	private static void updateAgentMain() {
		Agent agent = new Agent();
		Scanner sc = new Scanner(System.in);
		//Agent Record Not Found
		System.out.println("Enter Agent Number ");
		agent.setAgentID(sc.nextInt());
		System.out.println("Enter Name");
		agent.setName(sc.next());
		System.out.println("Enter City");
		agent.setCity(sc.next());
		System.out.println("Enter Gender ");
		agent.setGENDER(Gender.valueOf(sc.next()));
		System.out.println("Enter MaritalStatus");
		agent.setMaritalStatus(sc.nextInt());
		System.out.println("Enter Basic");
		agent.setPremium(sc.nextDouble());
		AgentDAO dao = new AgentDAOImpl();
		try {
			System.out.println(dao.updateAgentDao(agent));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		
		}
	
		


	private static void deleteAgentMain() {
		AgentDAO dao = new AgentDAOImpl();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter AgentID ");
		int AgentID = sc.nextInt();
		try {
			System.out.println(dao.deleteAgentDao(AgentID));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		}

	private static void addAgentMain() {
		AgentDAO dao = new AgentDAOImpl();
		Agent agent = new Agent();
		Scanner sc = new Scanner(System.in);
	
		System.out.println("Enter Name");
		agent.setName(sc.next());
		System.out.println("Enter City");
		agent.setCity(sc.next());
		System.out.println("Enter Gender ");
		agent.setGENDER(Gender.valueOf(sc.next()));
		System.out.println("Enter MaritalStatus");
		agent.setMaritalStatus(sc.nextInt());
		System.out.println("Enter Basic");
		agent.setPremium(sc.nextDouble());
		
		try {
			System.out.println(dao.addAgentDao(agent));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		}
	
	private static void searchAgentMain() {
		AgentDAO dao = new AgentDAOImpl();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Agent Number ");
		int AgentID = sc.nextInt();
		try {
			Agent agent =dao.searchAgentDao(AgentID);
			if(agent!=null) {
				System.out.println(agent);
			}
			else {
				System.out.println("Record Not Found");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		}
		private static void showAgentMain() {
			AgentDAO dao = new AgentDAOImpl();
			try {
				List<Agent> agentlist = dao.showAgentDao();
				for(Agent agent :agentlist) {
					System.out.println(agent);
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	

}
