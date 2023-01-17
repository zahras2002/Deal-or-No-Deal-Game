package application;

import java.util.Optional;
import java.util.Random;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Main extends Application {

	//Create image objects for the cases and the value on the side panels 
	private ImageView ivPlayersCase;	
	private ImageView[][] ivAmounts;
	private Label lblMessage;
	//Create an array of string to store the values of the side panels
	private String[] amounts;
	
	//Create a int to store the amount of cases that have been selected 
	int casespicked=0;
	//Create integer to store the amount of cases left in a round
	int picks1=5;
	int picks2=5;
	int picks3=4;
	int picks4=3;
	int picks5=2;
	int picks6=1;
	
	//Create a button object to store the button that is selected
	Button btnSelected;
	Double[] amountsd;
	//Create a new random object
	Random rand = new Random();
	//Create an array to store the cases 
	Button[][] cases= new Button[5][];
	//Create strings to store various values assigned to each case
	String [] caseNumb;
	String firstCase;
	String caseValue;
	String caseNumber;
	String case1;
	String case3;
	String case3Text;
	
	Boolean playAgain=false;
	
	//Create doubles to store the offer, round number, etc.
	Double offer=0.00;
	Double roundNumber=0.00;
	Double increaseRoundNumber=6.00;
	Double averageValue=0.00;
	Double averageValue1=0.00;
	Double doubcase=0.00;
	Double totalDub=0.00;
	Double first;
	Double total;
	
	public void start(Stage primaryStage) {
		
		try {
			//Initialize and set parameters of the image
			ivPlayersCase = new ImageView();
			ivPlayersCase.setFitWidth(50);
			ivPlayersCase.setFitHeight(50);

			//Set the array to have 13 rows and 2 columns
			ivAmounts = new ImageView[13][2];
			//Assign values to array
			amounts = new String[] {"0.01", "1", "5", "10", "25", "50", "75", "100", "200", "300", "400",
					"500", "750", "1000", "5000", "10000", "25000", "50000", "75000", "100000",
					"200000", "300000", "400000", "500000", "750000", "1000000"};
			
			amountsd = new Double[] {0.01, 1.00, 5.00, 10.00, 25.00, 50.00, 75.00, 100.00, 200.00, 300.00, 400.00,
					500.00, 750.00, 1000.00, 5000.00, 10000.00, 25000.00, 50000.00, 75000.00, 100000.00,
					200000.00, 300000.00, 400000.00, 500000.00, 750000.00, 1000000.00};
			
			//Assign values to array
			caseNumb= new String[] {"1","2","3","4","5","6","7","8","9","10","11","12",
			"13","14","15","16","17","18","19","20","21","22","23","24","25","26"};
			  
			//Set image for the title
			ImageView ivTitle = new ImageView(new Image("file:images/dond_logo.png"));
			
			//Create vboxes for values
			VBox westPanel = new VBox();
			westPanel.setAlignment(Pos.TOP_CENTER);
			westPanel.setSpacing(10);

			VBox eastPanel = new VBox();
			eastPanel.setAlignment(Pos.TOP_CENTER);
			eastPanel.setSpacing(10);
			
			//Create a label for the stack pane
			lblMessage = new Label();
			lblMessage.setPrefSize(692, 50);
			lblMessage.setAlignment(Pos.CENTER);
			lblMessage.setFont(Font.font("System", FontWeight.BOLD, 18));
			lblMessage.setTextFill(Color.rgb(252, 234, 151));
			lblMessage.setText("\t\t\tChoose one of the briefcases!");
			
			int count = 0;
			//Cycle through the ivAmounts array and set the pictures and give a value
			for (int cols = 0; cols < ivAmounts[0].length; cols++)
			{
				for (int rows = 0; rows < ivAmounts.length; rows++)
				{
					ivAmounts[rows][cols] = new ImageView(new Image("file:images/money/" + 
							amounts[count] + ".png"));
					ivAmounts[rows][cols].setFitHeight(18);
					ivAmounts[rows][cols].setFitWidth(127);
					ivAmounts[rows][cols].setId(amounts[count]);
					
					//Add the images for the first column
					if (cols == 0)
					{
						westPanel.getChildren().add(ivAmounts[rows][cols]);
					}
					//Add the images for the second column
					else
					{
						eastPanel.getChildren().add(ivAmounts[rows][cols]);
					}
					count++;
				}
			}
			
			if(playAgain==true) {
				
			}
			
			//Create a flow pane to store the cases 
			FlowPane centerPanel = new FlowPane(Orientation.HORIZONTAL);
			centerPanel.setPadding(new Insets(0, 10, 0, 10));
			centerPanel.setHgap(10);
			centerPanel.setVgap(10);
			centerPanel.setAlignment(Pos.TOP_CENTER);
			centerPanel.setPrefWrapLength(250);
			
			//Create an array for images for cases
			ImageView[] imgcases= new ImageView[26];
			//Set the amount of columns for each row
			cases[0]= new Button[5];
			cases[1]=new Button[5];
			cases[2]=new Button[5];
			cases[3]=new Button[5];
			cases[4]=new Button[6];
				
			//Create a grid pane to store the flow pane and HBox
			GridPane center= new GridPane();
			center.setPadding(new Insets(10, 10, 10, 10));
			center.setAlignment(Pos.CENTER);
			
			//Create HBox to store the cases
			HBox last= new HBox(10);
			last.setAlignment(Pos.BOTTOM_CENTER);
			
			int casescount=1;
			int index=0;
			int picture=1;
			//Cycle through the cases array and create a button and image for each 
			for (int rows = 0; rows < cases.length; rows++) {
				for (int cols = 0; cols < cases[rows].length; cols++) {
					
					//Set the image of the case
					imgcases[index]= new ImageView();
					imgcases[index].setImage(new Image("file:images/suitcases/case"+picture+".png", 
							50, 50, true, true));
						
						cases[rows][cols] = new Button();
						cases[rows][cols].setPrefSize(50, 50);
						cases[rows][cols].setStyle("-fx-background-color:black");
						cases[rows][cols].setGraphic(imgcases[index]);
						Canvas canvas=new Canvas(800,800);
						GraphicsContext gc = canvas.getGraphicsContext2D();
						gc.setFill(Color.BLACK);
						cases[rows][cols].setTextFill(Color.BLACK);
						cases[rows][cols].setText(caseNumb[index]);
						
						index++;
						picture++;
						
						//Check if the cases are less that 20
						if(casescount<=20) {
							//Add to the FlowPane
							centerPanel.getChildren().addAll(cases[rows][cols]);
						}
						//Check if the cases are between 21 and 26
					else if(casescount>20&&casescount<=26) {
						
							//Add to HBox
							last.getChildren().addAll(cases[rows][cols]);
						}
						//Increase by one
						casescount++;
						
				}}
			//Clone the amounts array
			String [] temp= amounts.clone();
			//Cycle through cases array and assign a random number
			for (int rows = 0; rows < cases.length; rows++) {
				for (int cols = 0; cols < cases[rows].length; cols++) {
						//ASSIGN VALUES TO CASES
						int number; 
						do {
							number=rand.nextInt(temp.length);
							}
						while(temp[number].contentEquals(""));
							//Set the ID to the random index of the temp array
							cases[rows][cols].setId(temp[number]);
							//Set random index of the temp array to nothing
							temp[number]="";  
				}
			}		
			
			//Cycle through the cases array and check if each index has been clicked 
			for (int rows = 0; rows < cases.length; rows++) {
				for (int cols = 0; cols < cases[rows].length; cols++) {
						
							//Create event handler for buttons
						    cases[rows][cols].setOnAction(new EventHandler<ActionEvent>() {
							public void handle(ActionEvent e) {
							totalDub=0.00;
							//Get the source of the button selected
							btnSelected = (Button) e.getSource();
							//Disable the button 
							btnSelected.setDisable(true);	
							//Make the button invisible
							btnSelected.setVisible(false);
							
							//FIRST CASE
							if(casespicked==0) {
								//Create a double to store the cases value
								
								//Get the ID
								case1=btnSelected.getId();
								
								//Change the ID to double
								first=Double.parseDouble(case1);
								//Get the text of the button
								firstCase=btnSelected.getText(); 
								//Set the image to the first case
								ivPlayersCase.setImage(new Image("file:images/suitcases/case"+firstCase+".png"));
								lblMessage.setText("\t\t\tOpen 6 briefcase(s)!");								
							}
							
							//ROUND 1
							if(casespicked>0&&casespicked<=6) {
								//Get the IDs of the button
								String btnString=btnSelected.getId();
								//Set the round number to one 
								roundNumber=1.00;
								
								//Change the text of the label according to how many cases are left in the round
								lblMessage.setText("\t\t\tOpen "+ picks1+ " briefcase(s)!");
								if(casespicked==6) {
									lblMessage.setText("\t\t\tOpen "+ picks2+ " briefcase(s)!");
								}
			
									//Cycle through the array, get the ID and text of the button
									for (int cols = 0; cols < ivAmounts[0].length; cols++)
									{
										for (int rows = 0; rows < ivAmounts.length; rows++)
										{		
									
									if(btnString.equals(ivAmounts[rows][cols].getId())) {
									ivAmounts[rows][cols].setImage(null);
									caseValue=btnSelected.getId(); 
									caseNumber=btnSelected.getText();
									Double dc=Double.parseDouble(caseValue);
									if(casespicked>0) {
										//Create an alert and inform the player of the amount in the case
										Alert alert2 = new Alert(AlertType.INFORMATION); 
								    	alert2.setHeaderText(null); 
								    	if(dc==0.01){
									    	alert2.setContentText("Case #"+ caseNumber+" contains $"+ dc+"!");
									    	}
									    	else {
									    	alert2.setContentText("Case #"+ caseNumber+" contains $"+ String.format("%,.0f",dc)+"!");
									    	}
								    	alert2.setTitle("Case #"+ caseNumber);
								    	alert2.setGraphic(new ImageView(new Image("file:images/suitcases/case"+caseNumber+".png",50,50,true,true)));
								    	alert2.showAndWait();
										}
									
									}
										}
										
								}
									//Get the value of the remaining cases
									for (int rows = 0; rows < cases.length; rows++) {
										for (int cols = 0; cols < cases[rows].length; cols++) {
											
											//If button is disabled
											if(cases[rows][cols].isDisabled()==false) {
												String case2=cases[rows][cols].getId();
												doubcase =Double.parseDouble(case2);
												totalDub+=doubcase; 
											}
										}
										
									}
									//If the user has picked six cases, give the player the banker's offer
									if(casespicked==6) {
										total=totalDub+first;
										averageValue=total/19;
										offer=(averageValue*roundNumber)/10;
										
										ButtonType btdeal = new ButtonType("DEAL"); 
										ButtonType btnodeal = new ButtonType("NO DEAL");
										
										Alert alert = new Alert(AlertType.CONFIRMATION); 
										alert.setContentText("The banker's offer is $"+String.format("%,.2f", offer)+"!\n Deal or no Deal?"); 
										alert.setHeaderText(null);
										alert.setTitle("Banker's offer");
										alert.getButtonTypes().clear();
										alert.getButtonTypes().addAll(btdeal, btnodeal);
										Optional<ButtonType> result = alert.showAndWait();
										//If the user accepts the deal
										if (result.get() == btdeal) {
											Alert alert1 = new Alert(AlertType.INFORMATION); 
									    	 alert1.setHeaderText(null); 
									    	 alert1.setContentText("Congradulations...you're going home with $"+ String.format("%,.0f", offer)+"!");
									    	 alert1.setTitle("It's a deal!");
									    	 alert1.setGraphic(new ImageView(new Image("file:images/moneybag.png",50,50,true,true)));
									    	 alert1.showAndWait();
									    	 //Inform the player of the value of their first case
									    	 Alert alert3 = new Alert(AlertType.INFORMATION); 
									    	 alert3.setHeaderText(null);
									    	 alert3.setContentText("You could have gone home with $"+String.format("%,.0f", first)+"!");
									    	 alert3.setTitle("Deal or No Deal");
									    	 alert3.setGraphic(new ImageView(new Image("file:images/suitcases/case"+
									    	 firstCase+".png",50,50,true,true)));
									    	 alert3.showAndWait();
									    	 //Thank the user for playing
									    	 Alert alert4 = new Alert(AlertType.INFORMATION); 
									    	 alert4.setHeaderText(null); 
									    	 alert4.setContentText("Thank you for playing Deal or No Deal!");
									    	 alert4.setTitle("Game over");
									    	 alert4.setGraphic(new ImageView(new Image("file:images/dond_icon.png",50,50,true,true)));
									    	 alert4.showAndWait();
									    	 primaryStage.close();
									    	 
									    	//Ask if they would like to play again
									    	 Alert alert6 = new Alert(AlertType.CONFIRMATION); 
												alert6.setContentText("Would you like to play again?"); 
												alert6.setHeaderText(null);
												alert6.setTitle("Deal or No Deal");
												alert6.getButtonTypes().clear(); 
												alert6.getButtonTypes().addAll(ButtonType.YES, ButtonType.NO);
												Optional<ButtonType> result2 = alert6.showAndWait();
												//if the user wants to play again
												if (result2.get() == ButtonType.YES) {
												//Set casespicked to -1
													 casespicked=-1;
													//initialize integers again
													 picks1=5;
													 picks2=5;
													 picks3=4; 
													 picks4=3;
													 picks5=2;
													 picks6=1;
													 start(primaryStage);
												}
												//If they do not want to play again
												else if(result2.get() == ButtonType.NO) {
													//if the user selects NO, end the game										
													primaryStage.close();
												}			    	 
										}
										//If the user does not accept the deal
										else if (result.get() == btnodeal) {
										     e.consume();
										}

									}
							//Decrease by one
							picks1--;		
							}
							
							//ROUND 2
							if(casespicked>6&&casespicked<=11) {
								//Get the IDs of the button
								String btnString=btnSelected.getId();
								//Set the round number to two 
								roundNumber=2.00;
								
								//Change the text of the label according to how many cases are left in the round
								 lblMessage.setText("\t\t\tOpen "+ picks3+ " briefcase(s)!");
								 if(casespicked==11) {
										lblMessage.setText("\t\t\tOpen "+ 4+ " briefcase(s)!");
									}
								
									//Cycle through the array, get the ID and text of the button
									for (int cols = 0; cols < ivAmounts[0].length; cols++)
									{
										for (int rows = 0; rows < ivAmounts.length; rows++)
										{		
									if(btnString.equals(ivAmounts[rows][cols].getId())) {
									ivAmounts[rows][cols].setImage(null);
									caseValue=btnSelected.getId();  
									caseNumber=btnSelected.getText();
									Double dc=Double.parseDouble(caseValue);
									if(casespicked>0) {
										//Create an alert and inform the player of the amount in the case
										Alert alert2 = new Alert(AlertType.INFORMATION); 
								    	alert2.setHeaderText(null); 
								    	if(dc==0.01){
									    	alert2.setContentText("Case #"+ caseNumber+" contains $"+ dc+"!");
									    	}
									    	else {
									    	alert2.setContentText("Case #"+ caseNumber+" contains $"+ String.format("%,.0f",dc)+"!");
									    	}
								    	alert2.setTitle("Case #"+ caseNumber);
								    	alert2.setGraphic(new ImageView(new Image("file:images/suitcases/case"+caseNumber+".png",50,50,true,true)));
								    	alert2.showAndWait();
										}
									}
										}
								}
									//Get the value of the remaining cases
									for (int rows = 0; rows < cases.length; rows++) {
										for (int cols = 0; cols < cases[rows].length; cols++) {
											
											//If button is disabled
											if(cases[rows][cols].isDisabled()==false) {
												String case2=cases[rows][cols].getId();
												doubcase =Double.parseDouble(case2);
												totalDub+=doubcase; 
											}
										}
										
									}
									//If the user has picked five cases, give the player the banker's offer
									if(casespicked==11) {
										total=totalDub+first;
										averageValue=total/14;
										offer=(averageValue*roundNumber)/10;
										
										ButtonType btdeal = new ButtonType("DEAL"); 
										ButtonType btnodeal = new ButtonType("NO DEAL");
										
										Alert alert = new Alert(AlertType.CONFIRMATION); 
										alert.setContentText("The banker's offer is $"+String.format("%,.2f", offer)+"!\n Deal or no Deal?"); 
										alert.setHeaderText(null);
										alert.setTitle("Banker's offer");
										alert.getButtonTypes().clear();
										alert.getButtonTypes().addAll(btdeal, btnodeal);
										Optional<ButtonType> result = alert.showAndWait();
										//If the user accepts the deal
										if (result.get() == btdeal) {
											Alert alert1 = new Alert(AlertType.INFORMATION); 
									    	 alert1.setHeaderText(null); 
									    	 alert1.setContentText("Congradulations...you're going home with $"+ String.format("%,.0f", offer)+"!");
									    	 alert1.setTitle("It's a deal!");
									    	 alert1.setGraphic(new ImageView(new Image("file:images/moneybag.png",50,50,true,true)));
									    	 alert1.showAndWait();
									    	 //Inform the player of the value of their first case
									    	 Alert alert3 = new Alert(AlertType.INFORMATION); 
									    	 alert3.setHeaderText(null); 
									    	 alert3.setContentText("You could have gone home with $"+ String.format("%,.0f", first)+"!");
									    	 alert3.setTitle("Deal or No Deal");
									    	 alert3.setGraphic(new ImageView(new Image("file:images/suitcases/case"+
									    	 firstCase+".png",50,50,true,true)));
									    	 alert3.showAndWait();
									    	 Alert alert4 = new Alert(AlertType.INFORMATION); 
									    	 alert4.setHeaderText(null); 
									    	 //Thank the user for playing
									    	 alert4.setContentText("Thank you for playing Deal or No Deal!");
									    	 alert4.setTitle("Game over");
									    	 alert4.setGraphic(new ImageView(new Image("file:images/dond_icon.png",50,50,true,true)));
									    	 alert4.showAndWait();
									    	//Ask if they would like to play again
									    	 Alert alert6 = new Alert(AlertType.CONFIRMATION); 
												alert6.setContentText("Would you like to play again?"); 
												alert6.setHeaderText(null);
												alert6.setTitle("Deal or No Deal");
												alert6.getButtonTypes().clear(); 
												alert6.getButtonTypes().addAll(ButtonType.YES, ButtonType.NO);
												Optional<ButtonType> result2 = alert6.showAndWait();
												 //if the user wants to play again
												if (result2.get() == ButtonType.YES) {
												//Set casespicked to -1
													 casespicked=-1;
													//initialize integers again
													 picks1=5;
													 picks2=5;
													 picks3=4; 
													 picks4=3;
													 picks5=2;
													 picks6=1;
												  start(primaryStage);
												}
												//If they do not want to play again
												else if(result2.get() == ButtonType.NO) {
													//if the user selects NO, end the game										
													primaryStage.close();
												}				    	 
										}
										//If the user does not select the deal
										else if (result.get() == btnodeal) {
										     e.consume();
										}

									}
									//Decrease by one
									picks3--;
								}	
								
							//ROUND 3
							if(casespicked>11&&casespicked<=15) {
								//Get the IDs of the button
								String btnString=btnSelected.getId();
								//Set the round number to three
								roundNumber=3.00;
								
								//Change the text of the label according to how many cases are left in the round
								 lblMessage.setText("\t\t\tOpen "+ picks4+ " briefcase(s)!");
								 if(casespicked==15) {
										lblMessage.setText("\t\t\tOpen "+ 3+ " briefcase(s)!");
									}
								
									//Cycle through the array, get the ID and text of the button
									for (int cols = 0; cols < ivAmounts[0].length; cols++)
									{
										for (int rows = 0; rows < ivAmounts.length; rows++)
										{	
									if(btnString.equals(ivAmounts[rows][cols].getId())) {
									ivAmounts[rows][cols].setImage(null);
									caseValue=btnSelected.getId();  
									caseNumber=btnSelected.getText();
									Double dc=Double.parseDouble(caseValue);
									//Create an alert and inform the player of the amount in the case
									if(casespicked>0) {
										Alert alert2 = new Alert(AlertType.INFORMATION); 
								    	alert2.setHeaderText(null); 
								    	if(dc==0.01){
									    	alert2.setContentText("Case #"+ caseNumber+" contains $"+ dc+"!");
									    	}
									    	else {
									    	alert2.setContentText("Case #"+ caseNumber+" contains $"+ String.format("%,.0f",dc)+"!");
									    	}
								    	alert2.setTitle("Case #"+ caseNumber);
								    	alert2.setGraphic(new ImageView(new Image("file:images/suitcases/case"+caseNumber+".png",50,50,true,true)));
								    	alert2.showAndWait();
										}
									}
										}
								}
									//Get the value of the remaining cases
									for (int rows = 0; rows < cases.length; rows++) {
										for (int cols = 0; cols < cases[rows].length; cols++) {
											
											//If button is disabled
											if(cases[rows][cols].isDisabled()==false) {
												String case2=cases[rows][cols].getId();
												//case2=cases[rows][cols].getId().replaceAll(",","");
												doubcase =Double.parseDouble(case2);
												totalDub+=doubcase; 
											}
										}
										
									}
									//If the user has picked four cases, give the player the banker's offer
									if(casespicked==15) {
										total=totalDub+first;
										averageValue=total/10;
										offer=(averageValue*roundNumber)/10;
										
										ButtonType btdeal = new ButtonType("DEAL"); 
										ButtonType btnodeal = new ButtonType("NO DEAL");
										
										Alert alert = new Alert(AlertType.CONFIRMATION); 
										alert.setContentText("The banker's offer is $"+String.format("%,.2f", offer)+"!\n Deal or no Deal?"); 
										alert.setHeaderText(null);
										alert.setTitle("Banker's offer");
										alert.getButtonTypes().clear();
										alert.getButtonTypes().addAll(btdeal, btnodeal);
										Optional<ButtonType> result = alert.showAndWait();
										//If the user accepts the deal
										if (result.get() == btdeal) {
											Alert alert1 = new Alert(AlertType.INFORMATION); 
									    	 alert1.setHeaderText(null); 
									    	 alert1.setContentText("Congradulations...you're going home with $"+ String.format("%,.0f", offer)+"!");
									    	 alert1.setTitle("It's a deal!");
									    	 alert1.setGraphic(new ImageView(new Image("file:images/moneybag.png",50,50,true,true)));
									    	 alert1.showAndWait();
									    	 Alert alert3 = new Alert(AlertType.INFORMATION); 
									    	 alert3.setHeaderText(null); 
									    	//Inform the player of the value of their first case
									    	 alert3.setContentText("You could have gone home with $"+ String.format("%,.0f", first)+"!");
									    	 alert3.setTitle("Deal or No Deal");
									    	 alert3.setGraphic(new ImageView(new Image("file:images/suitcases/case"+
									    	 firstCase+".png",50,50,true,true)));
									    	 alert3.showAndWait();
									    	 //Thank the player for playing 
									    	 Alert alert4 = new Alert(AlertType.INFORMATION); 
									    	 alert4.setHeaderText(null); 
									    	 alert4.setContentText("Thank you for playing Deal or No Deal!");
									    	 alert4.setTitle("Game over");
									    	 alert4.setGraphic(new ImageView(new Image("file:images/dond_icon.png",50,50,true,true)));
									    	 alert4.showAndWait();
									    	//Ask if they would like to play again
									    	 Alert alert6 = new Alert(AlertType.CONFIRMATION); 
												alert6.setContentText("Would you like to play again?"); 
												alert6.setHeaderText(null);
												alert6.setTitle("Deal or No Deal");
												alert6.getButtonTypes().clear(); 
												alert6.getButtonTypes().addAll(ButtonType.YES, ButtonType.NO);
												Optional<ButtonType> result2 = alert6.showAndWait();
												 //if the user wants to play again
												if (result2.get() == ButtonType.YES) {
												//Set casespicked to -1
													 casespicked=-1;
													//initialize integers again
													 picks1=5;
													 picks2=5;
													 picks3=4; 
													 picks4=3;
													 picks5=2;
													 picks6=1;
												  start(primaryStage);
												}
												//If they do not want to play again
												else if(result2.get() == ButtonType.NO) {
													//if the user selects NO, end the game										
													primaryStage.close();
												}	 			    	 
										}
										//If the user does not select the deal
										else if (result.get() == btnodeal) {
										     e.consume();
										}

									}
									//Decrease by one
								picks4--;				
								}	
								
							
							//ROUND 4
							if(casespicked>15&&casespicked<=18) {
								//Get the ID of the button that was selected and store it
								String btnString=btnSelected.getId();
								//Set the round number to four
								roundNumber=4.00;
								
								//Change the text of the label according to how many cases are left in the round
								 lblMessage.setText("\t\t\tOpen "+ picks5+ " briefcase(s)!");
								 if(casespicked==18) {
										lblMessage.setText("\t\t\tOpen "+ 2+ " briefcase(s)!");
									}
								 
								//Cycle through the array, get the ID and text of the button
									for (int cols = 0; cols < ivAmounts[0].length; cols++)
									{
										for (int rows = 0; rows < ivAmounts.length; rows++)
										{		
									if(btnString.equals(ivAmounts[rows][cols].getId())) {
									ivAmounts[rows][cols].setImage(null);
									caseValue=btnSelected.getId();  
									caseNumber=btnSelected.getText();
									Double dc=Double.parseDouble(caseValue);
									//Create an alert and inform the player of the amount in the case
									if(casespicked>0) {
										Alert alert2 = new Alert(AlertType.INFORMATION); 
								    	alert2.setHeaderText(null); 
								    	if(dc==0.01){
									    	alert2.setContentText("Case #"+ caseNumber+" contains $"+ dc+"!");
									    	}
									    	else {
									    	alert2.setContentText("Case #"+ caseNumber+" contains $"+ String.format("%,.0f",dc)+"!");
									    	}
								    	alert2.setTitle("Case #"+ caseNumber);
								    	alert2.setGraphic(new ImageView(new Image("file:images/suitcases/case"+caseNumber+".png",50,50,true,true)));
								    	alert2.showAndWait();
										}
									}
										}
								}
									//Get the value of the remaining cases
									for (int rows = 0; rows < cases.length; rows++) {
										for (int cols = 0; cols < cases[rows].length; cols++) {
											
											//If button is disabled
											if(cases[rows][cols].isDisabled()==false) {
												String case2=cases[rows][cols].getId();
												doubcase =Double.parseDouble(case2);
												totalDub+=doubcase; 
											}
										}
										
									}
									//If the user has picked three cases, give the player the banker's offer
									if(casespicked==18) {
										total=totalDub+first;
										averageValue=total/7;
										offer=(averageValue*roundNumber)/10;
										
										ButtonType btdeal = new ButtonType("DEAL"); 
										ButtonType btnodeal = new ButtonType("NO DEAL");
										
										Alert alert = new Alert(AlertType.CONFIRMATION); 
										alert.setContentText("The banker's offer is $"+String.format("%,.2f", offer)+"!\n Deal or no Deal?"); 
										alert.setHeaderText(null);
										alert.setTitle("Banker's offer");
										alert.getButtonTypes().clear();
										alert.getButtonTypes().addAll(btdeal, btnodeal);
										Optional<ButtonType> result = alert.showAndWait();
										if (result.get() == btdeal) {
											Alert alert1 = new Alert(AlertType.INFORMATION); 
									    	 alert1.setHeaderText(null); 
									    	 alert1.setContentText("Congradulations...you're going home with $"+ String.format("%,.0f", offer)+"!");
									    	 alert1.setTitle("It's a deal!");
									    	 alert1.setGraphic(new ImageView(new Image("file:images/moneybag.png",50,50,true,true)));
									    	 alert1.showAndWait();
									    	//Inform the player of the value of their first case
									    	 Alert alert3 = new Alert(AlertType.INFORMATION); 
									    	 alert3.setHeaderText(null); 
									    	 alert3.setContentText("You could have gone home with $"+ String.format("%,.0f", first)+"!");
									    	 alert3.setTitle("Deal or No Deal");
									    	 alert3.setGraphic(new ImageView(new Image("file:images/suitcases/case"+
									    	 firstCase+".png",50,50,true,true)));
									    	 alert3.showAndWait();
									    	//Thank the player for playing 
									    	 Alert alert4 = new Alert(AlertType.INFORMATION); 
									    	 alert4.setHeaderText(null); 
									    	 alert4.setContentText("Thank you for playing Deal or No Deal!");
									    	 alert4.setTitle("Game over");
									    	 alert4.setGraphic(new ImageView(new Image("file:images/dond_icon.png",50,50,true,true)));
									    	 alert4.showAndWait();
									    	//Ask if they would like to play again
									    	 Alert alert6 = new Alert(AlertType.CONFIRMATION); 
												alert6.setContentText("Would you like to play again?"); 
												alert6.setHeaderText(null);
												alert6.setTitle("Deal or No Deal");
												alert6.getButtonTypes().clear(); 
												alert6.getButtonTypes().addAll(ButtonType.YES, ButtonType.NO);
												Optional<ButtonType> result2 = alert6.showAndWait();
												 //if the user wants to play again
												if (result2.get() == ButtonType.YES) {
												//Set casespicked to -1
													 casespicked=-1;
													//initialize integers again
													 picks1=5;
													 picks2=5;
													 picks3=4; 
													 picks4=3;
													 picks5=2;
													 picks6=1;
												  start(primaryStage);
												}
												//If they do not want to play again
												else if(result2.get() == ButtonType.NO) {
													//if the user selects NO, end the game										
													primaryStage.close();
												}	 			    	 
										}
										//If the user does not select the deal
										else if (result.get() == btnodeal) {
										     e.consume();
										}

									}
									//Decrease by one
									picks5--;
								}	
							//ROUND 5
							if(casespicked>18&&casespicked<=20) {
								//Get the ID of the button that is selected
								String btnString=btnSelected.getId();
								//Set round number to five
								roundNumber=5.00;
								
								//Change the text of the label according to how many cases are left in the round
								 lblMessage.setText("\t\t\tOpen "+ picks6+ " briefcase(s)!");
								 if(casespicked==20) {
										lblMessage.setText("\t\t\tOpen "+ 1+ " briefcase(s)!");
									}
								 
								//Cycle through the array, get the ID and text of the button
									for (int cols = 0; cols < ivAmounts[0].length; cols++)
									{
										for (int rows = 0; rows < ivAmounts.length; rows++)
										{	
									if(btnString.equals(ivAmounts[rows][cols].getId())) { 
									ivAmounts[rows][cols].setImage(null);
									caseValue=btnSelected.getId();  
									caseNumber=btnSelected.getText();
									Double dc=Double.parseDouble(caseValue);
									//Create an alert and inform the player of the amount in the case
									if(casespicked>0) {
										Alert alert2 = new Alert(AlertType.INFORMATION); 
								    	alert2.setHeaderText(null); 
								    	if(dc==0.01){
									    	alert2.setContentText("Case #"+ caseNumber+" contains $"+ dc+"!");
									    	}
									    	else {
									    	alert2.setContentText("Case #"+ caseNumber+" contains $"+ String.format("%,.0f",dc)+"!");
									    	}
								    	alert2.setTitle("Case #"+ caseNumber);
								    	alert2.setGraphic(new ImageView(new Image("file:images/suitcases/case"+caseNumber+".png",50,50,true,true)));
								    	alert2.showAndWait();
										}
									}
										}
								}
									//Get the value of the remaining cases
									for (int rows = 0; rows < cases.length; rows++) {
										for (int cols = 0; cols < cases[rows].length; cols++) {
											
											//If button is disabled
											if(cases[rows][cols].isDisabled()==false) {
												String case2=cases[rows][cols].getId();
												//case2=cases[rows][cols].getId().replaceAll(",","");
												doubcase =Double.parseDouble(case2);
												totalDub+=doubcase; 
											}
										}	
									}
									//If the user has picked two cases, give the player the banker's offer
									if(casespicked==20) {
										total=totalDub+first;
										averageValue=total/5;
										offer=(averageValue*roundNumber)/10;
										
										ButtonType btdeal = new ButtonType("DEAL"); 
										ButtonType btnodeal = new ButtonType("NO DEAL");
										
										Alert alert = new Alert(AlertType.CONFIRMATION); 
										alert.setContentText("The banker's offer is $"+String.format("%,.2f", offer)+"!\n Deal or no Deal?"); 
										alert.setHeaderText(null);
										alert.setTitle("Banker's offer");
										alert.getButtonTypes().clear();
										alert.getButtonTypes().addAll(btdeal, btnodeal);
										Optional<ButtonType> result = alert.showAndWait();
										if (result.get() == btdeal) {
											Alert alert1 = new Alert(AlertType.INFORMATION); 
									    	 alert1.setHeaderText(null); 
									    	 alert1.setContentText("Congradulations...you're going home with $"+ String.format("%,.0f", offer)+"!");
									    	 alert1.setTitle("It's a deal!");
									    	 alert1.setGraphic(new ImageView(new Image("file:images/moneybag.png",50,50,true,true)));
									    	 alert1.showAndWait();
									    	//Inform the player of the value of their first case
									    	 Alert alert3 = new Alert(AlertType.INFORMATION); 
									    	 alert3.setHeaderText(null); 
									    	 alert3.setContentText("You could have gone home with $"+ String.format("%,.0f", first)+"!");
									    	 alert3.setTitle("Deal or No Deal");
									    	 alert3.setGraphic(new ImageView(new Image("file:images/suitcases/case"+
									    	 firstCase+".png",50,50,true,true)));
									    	 alert3.showAndWait();
									    	//Thank the player for playing 
									    	 Alert alert4 = new Alert(AlertType.INFORMATION); 
									    	 alert4.setHeaderText(null); 
									    	 alert4.setContentText("Thank you for playing Deal or No Deal!");
									    	 alert4.setTitle("Game over");
									    	 alert4.setGraphic(new ImageView(new Image("file:images/dond_icon.png",50,50,true,true)));
									    	 alert4.showAndWait();
									    	//Ask if they would like to play again
									    	 Alert alert6 = new Alert(AlertType.CONFIRMATION); 
												alert6.setContentText("Would you like to play again?"); 
												alert6.setHeaderText(null);
												alert6.setTitle("Deal or No Deal");
												alert6.getButtonTypes().clear(); 
												alert6.getButtonTypes().addAll(ButtonType.YES, ButtonType.NO);
												Optional<ButtonType> result2 = alert6.showAndWait();
												 //if the user wants to play again
												if (result2.get() == ButtonType.YES) {
												//Set casespicked to -1
													 casespicked=-1;
													//initialize integers again
													 picks1=5;
													 picks2=5;
													 picks3=4; 
													 picks4=3;
													 picks5=2;
													 picks6=1;
												  start(primaryStage);
												}
												//If they do not want to play again
												else if(result2.get() == ButtonType.NO) {
													//if the user selects NO, end the game										
													primaryStage.close();
												}	 			    	 
										}
										//If the user does not select the deal
										else if (result.get() == btnodeal) {
										     e.consume();
										}
									}
									//Decrease by one
									picks6--;
								}	
								
							//ROUND 6-9
							if(casespicked>20&&casespicked<=24) {
								
								//Get and store the ID of the button selected
								String btnString=btnSelected.getId(); 
								
								//Change the text of the label according to how many cases are left in the round
								lblMessage.setText("\t\t\tOpen "+ 1+ " briefcase(s)!");								 
								
								//Cycle through the array, get the ID and text of the button
									for (int cols = 0; cols < ivAmounts[0].length; cols++)
									{
										for (int rows = 0; rows < ivAmounts.length; rows++)
										{		
									if(btnString.equals(ivAmounts[rows][cols].getId())) {
									ivAmounts[rows][cols].setImage(null);
									caseValue=btnSelected.getId();  
									caseNumber=btnSelected.getText();
									Double dc=Double.parseDouble(caseValue);
									if(casespicked>0) {
										//Create an alert and inform the player of the amount in the case
										Alert alert2 = new Alert(AlertType.INFORMATION); 
								    	alert2.setHeaderText(null); 
								    	if(dc==0.01){
								    	alert2.setContentText("Case #"+ caseNumber+" contains $"+ dc+"!");
								    	}
								    	else {
								    	alert2.setContentText("Case #"+ caseNumber+" contains $"+ String.format("%,.0f",dc)+"!");
								    	}
								    	alert2.setTitle("Case #"+ caseNumber);
								    	alert2.setGraphic(new ImageView(new Image("file:images/suitcases/case"+caseNumber+".png",50,50,true,true)));
								    	alert2.showAndWait();
									}
									}
										}
								}
									//Get the value of the remaining cases
									for (int rows = 0; rows < cases.length; rows++) {
										for (int cols = 0; cols < cases[rows].length; cols++) {
											
											//If button is disabled
											if(cases[rows][cols].isDisabled()==false) {
												String case2=cases[rows][cols].getId();
												doubcase =Double.parseDouble(case2);
												totalDub+=doubcase; 
											}
										}										
									}
									if(casespicked>=20) {
										int leftover=26-casespicked;
										total=totalDub+first;
										averageValue=total/leftover;
										offer=(averageValue*increaseRoundNumber)/10;
										
										ButtonType btdeal = new ButtonType("DEAL"); 
										ButtonType btnodeal = new ButtonType("NO DEAL");
										
										//Give the user the banker's offer
										Alert alert = new Alert(AlertType.CONFIRMATION); 
										alert.setContentText("The banker's offer is $"+String.format("%,.2f", offer)+"!\n Deal or no Deal?"); 
										alert.setHeaderText(null);
										alert.setTitle("Banker's offer");
										alert.getButtonTypes().clear();
										alert.getButtonTypes().addAll(btdeal, btnodeal);
										Optional<ButtonType> result = alert.showAndWait();
										if (result.get() == btdeal) {
											Alert alert1 = new Alert(AlertType.INFORMATION); 
									    	 alert1.setHeaderText(null); 
									    	 alert1.setContentText("Congradulations...you're going home with $"+ String.format("%,.0f", offer)+"!");
									    	 alert1.setTitle("It's a deal!");
									    	 alert1.setGraphic(new ImageView(new Image("file:images/moneybag.png",50,50,true,true)));
									    	 alert1.showAndWait();
									    	 Alert alert3 = new Alert(AlertType.INFORMATION); 
									    	 alert3.setHeaderText(null); 
									    	//Inform the player of the value of their first case
									    	 alert3.setContentText("You could have gone home with $"+ String.format("%,.0f", first)+"!");
									    	 alert3.setTitle("Deal or No Deal");
									    	 alert3.setGraphic(new ImageView(new Image("file:images/suitcases/case"+
									    	 firstCase+".png",50,50,true,true)));
									    	 alert3.showAndWait();
									    	//Thank the player for playing 
									    	 Alert alert4 = new Alert(AlertType.INFORMATION); 
									    	 alert4.setHeaderText(null); 
									    	 alert4.setContentText("Thank you for playing Deal or No Deal!");
									    	 alert4.setTitle("Game over");
									    	 alert4.setGraphic(new ImageView(new Image("file:images/dond_icon.png",50,50,true,true)));
									    	 alert4.showAndWait();
									    	//Ask if they would like to play again
									    	 Alert alert6 = new Alert(AlertType.CONFIRMATION); 
												alert6.setContentText("Would you like to play again?"); 
												alert6.setHeaderText(null);
												alert6.setTitle("Deal or No Deal");
												alert6.getButtonTypes().clear(); 
												alert6.getButtonTypes().addAll(ButtonType.YES, ButtonType.NO);
												Optional<ButtonType> result2 = alert6.showAndWait();
												 //if the user wants to play again
												if (result2.get() == ButtonType.YES) {
												//Set casespicked to -1
													 casespicked=-1;
													//initialize integers again
													 picks1=5;
													 picks2=5;
													 picks3=4; 
													 picks4=3;
													 picks5=2;
													 picks6=1;
												  start(primaryStage);
												}
												//If they do not want to play again
												else if(result2.get() == ButtonType.NO) {
													//if the user selects NO, end the game										
													primaryStage.close();
												}	 			    	 
										}
										//If the user does not select the deal
										else if (result.get() == btnodeal) {
										     e.consume();
										}

									}
									increaseRoundNumber++;
									roundNumber++;
								}
							
								if(casespicked==24) {							
									//Output message to inform the user to choose a case
									lblMessage.setText("\t\t\tChoose a case!");
									
									//Get the value of the remaining case
									for (int rows = 0; rows < cases.length; rows++) {
										for (int cols = 0; cols < cases[rows].length; cols++) {
											
											//If button is disabled
											if(cases[rows][cols].isDisabled()==false) {
												case3=cases[rows][cols].getId();
												case3Text=cases[rows][cols].getText();
												doubcase =Double.parseDouble(case3);
											}
										}	
									}
									
									//Ask the player if they would like to switch the cases
									Alert alert5 = new Alert(AlertType.CONFIRMATION); 
									alert5.setContentText("There is only one case left!\nWould you like to keep your case?"); 
									alert5.setHeaderText(null);
									alert5.setTitle("Deal or No Deal");
									alert5.getButtonTypes().clear(); 
									alert5.getButtonTypes().addAll(ButtonType.YES, ButtonType.NO);
									Optional<ButtonType> result4 = alert5.showAndWait();
									
									//If they want to keep their case
									if (result4.get() == ButtonType.YES) {
									    //if the user selects YES
										Alert alert3 = new Alert(AlertType.INFORMATION); 
								    	 alert3.setHeaderText(null); 
								    	 alert3.setContentText("Congradulations...you're going home with $"+ String.format("%,.0f", first)+"!");
								    	 alert3.setTitle("Deal or No Deal");
								    	 alert3.setGraphic(new ImageView(new Image("file:images/suitcases/case"+
								    	 firstCase+".png",50,50,true,true))); 
								    	 alert3.showAndWait();
								    	 
								    	 //Ask if they would like to play again
								    	 Alert alert6 = new Alert(AlertType.CONFIRMATION); 
											alert6.setContentText("Would you like to play again?"); 
											alert6.setHeaderText(null);
											alert6.setTitle("Deal or No Deal");
											alert6.getButtonTypes().clear(); 
											alert6.getButtonTypes().addAll(ButtonType.YES, ButtonType.NO);
											Optional<ButtonType> result2 = alert6.showAndWait();
											 //if the user wants to play again
											if (result2.get() == ButtonType.YES) {
											//Set casespicked to -1
												 casespicked=-1;
												//initialize integers again
												 picks1=5;
												 picks2=5;
												 picks3=4; 
												 picks4=3;
												 picks5=2;
												 picks6=1;
											  start(primaryStage);
											}
											//If they do not want to play again
											else if(result2.get() == ButtonType.NO) {
												//if the user selects NO, end the game										
												primaryStage.close();
											}
										
									} 
									//If they want to switch the cases
									else if (result4.get() == ButtonType.NO){
									     //if the user selects NO
										//The user wants the last case instead
										Alert alert7 = new Alert(AlertType.INFORMATION); 
								    	 alert7.setHeaderText(null); 
								    	 alert7.setContentText("Congradulations...you're going home with $"+ case3+"!");
								    	 alert7.setTitle("Deal or No Deal");
								    	 alert7.setGraphic(new ImageView(new Image("file:images/suitcases/case"+
								    		case3Text+".png",50,50,true,true)));
								    	 alert7.showAndWait();
								    	 
										 //Ask the user if they want to play again
										 Alert alert8 = new Alert(AlertType.CONFIRMATION); 
											alert8.setContentText("Would you like to play again?"); 
											alert8.setHeaderText(null);
											alert8.setTitle("Deal or No Deal");
											alert8.getButtonTypes().clear(); 
											alert8.getButtonTypes().addAll(ButtonType.YES, ButtonType.NO);
											Optional<ButtonType> result7 = alert8.showAndWait();
											//if the user wants to play again
											if (result7.get() == ButtonType.YES) {
												//Set casespicked to -1
												 casespicked=-1;
												//Initialize integers again
												 picks1=5;
												 picks2=5;
												 picks3=4;
												 picks4=3;
												 picks5=2;
												 picks6=1;
												//Start the game again
												start(primaryStage);
												
											}
											//If they do not want to play again
											else if(result7.get() == ButtonType.NO) {
												//End the game
												primaryStage.close();
												
											}
									}
									}	
							//Increase casespicked by one	
							casespicked++;		
							} 
							}
							);						
					 }
			}		
			//Add the HBox and the FlowPane to the center
			center.add(centerPanel, 0, 0);
			center.add(last, 0, 1);

			//Add a label to the pane 
			StackPane southPanel = new StackPane();
			southPanel.setAlignment(Pos.CENTER_LEFT);
			southPanel.setPadding(new Insets(10, 0, 0, 0));
			StackPane.setMargin(ivPlayersCase, new Insets(0, 0, 0, 40));
			southPanel.getChildren().addAll(lblMessage, ivPlayersCase);

			//Create the border pane 
			BorderPane root = new BorderPane();
			root.setPadding(new Insets(0, 0, 10, 0));
			root.setStyle("-fx-background-color: black");

			//Add the Panes to the BoderPane
			BorderPane.setAlignment(ivTitle, Pos.CENTER);
			BorderPane.setMargin(ivTitle, new Insets(10, 10, 10, 10));
			root.setTop(ivTitle);
			root.setLeft(westPanel);
			root.setRight(eastPanel);
			BorderPane.setAlignment(centerPanel, Pos.TOP_CENTER);
			root.setCenter(center);
			root.setBottom(southPanel);

			//Create a new scene
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			//Set the primaryStage to the scene and set the title
			primaryStage.setTitle("Deal or No Deal");
			primaryStage.setScene(scene);
			primaryStage.show();	
		} 
		catch(Exception e) {
			e.printStackTrace();
		}
	}	
		public static void main(String[] args) {
		launch(args);
	}
}
	