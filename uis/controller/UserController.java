package com.vastika.uis.controller;

import java.util.List;

import javax.swing.JOptionPane;

import com.vastika.uis.model.User;
import com.vastika.uis.service.UserService;
import com.vastika.uis.service.UserServiceImpl;

public class UserController {

	public static void main(String[] args) {
		
		UserService userService = new  UserServiceImpl();
		
		String decision = ""; 

		do { 
			String choice = JOptionPane.showInputDialog("Enter choice: save|update|delete|list|getby");
			
			switch (choice ) {
			
			case "save":
				
				User user = getUser(); 
				int saved = userService.saveUserInfo(user); 
				if (saved>=1) {
					
					JOptionPane.showMessageDialog(null, "User info is saved successfully in db.");
				}
				else {
					JOptionPane.showMessageDialog(null, "Error in db.");
				}
			
				break;
			
			case "update":
				
				User updatedUser = getUser(); 
				
				int id = Integer.parseInt(JOptionPane.showInputDialog("Enter id: ")); 
				updatedUser.setId(id);
				
				int updated = userService.updateUserInfo(updatedUser); 
				if (updated>=1) {
					
					JOptionPane.showMessageDialog(null, "User info is updated successfully in db.");
				}
				else {
					JOptionPane.showMessageDialog(null, "Error in db.");
				}
				
				break; 
				
			case "delete":
				
							
				int id1 = Integer.parseInt(JOptionPane.showInputDialog("Enter id: ")); 
							
				int deleted = userService.deleteUserInfo(id1); 
				if (deleted>=1) {
					
					JOptionPane.showMessageDialog(null, "User info is deleted successfully in db.");
				}
				else {
					JOptionPane.showMessageDialog(null, "Error in db.");
				}
				
				break; 
				
			case "list":
				List<User> userList = userService.getAllUserInfo();
				for (User u : userList) {
					
					JOptionPane.showMessageDialog(null, "User Id is : " +u.getId());
					JOptionPane.showMessageDialog(null, "User name is : " +u.getUsername());
					JOptionPane.showMessageDialog(null, "User password is : " +u.getPassword());
					JOptionPane.showMessageDialog(null, "User Mobile no is : " +u.getMobileNo());
					JOptionPane.showMessageDialog(null, "User Id is : " +u.getSalary());
					JOptionPane.showMessageDialog(null, "User Id is : " +u.isActive());
					
					System.out.println("================================================");
								
				}
				
				break;
				
			case "getby":
				id = Integer.parseInt(JOptionPane.showInputDialog("Enter id: "));
				
				User u = userService.getUserById(id); 
									
					System.out.println("User Id is : " +u.getId());
					System.out.println("User name is : " +u.getUsername());
					System.out.println("User password is : " +u.getPassword());
					System.out.println("User Mobile no is : " +u.getMobileNo());
					System.out.println("User Id is : " +u.getSalary());
					System.out.println("User Id is : " +u.isActive());
					
					System.out.println("================================================");
					break;	
					default:		
					JOptionPane.showMessageDialog(null,"wrong choice");
					break;
				}
				
			decision  = JOptionPane.showInputDialog("do you want to perform next operation? Enter yes|no");
			
		} while (decision.equalsIgnoreCase("yes"));
		
		 
		JOptionPane.showMessageDialog(null,"Bye Bye !! Have a goood day.");
	}
	
	public static User getUser() {
		User user = new User();
		String user_name = JOptionPane.showInputDialog("Enter Username: "); 
		String password = JOptionPane.showInputDialog("Password: ");
		long mobile_no = Long.parseLong(JOptionPane.showInputDialog("Enter mobile number:  "));
		double salary = Double.parseDouble(JOptionPane.showInputDialog("Enter salary: "));
		boolean is_active = Boolean.parseBoolean(JOptionPane.showInputDialog("Enter if User is active: "));
		
		user.setUsername(user_name);
		user.setPassword(password);
		user.setMobileNo(mobile_no);
		user.setActive(is_active);
		user.setSalary(salary);
		
		return user; 
			
		
	}
	
	}


