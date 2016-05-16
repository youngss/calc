package test88;

 


import java.util.EmptyStackException;
import java.util.Stack;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Calculator extends Application {
      
	GridPane g ;
	//label that show the result
	Label text ;
	// the equality'=' Button
	Button equal; 
	// numbers from 1 : 9 ;
	Button [] arr;
	// Operations {+,-,*,/,%,x^2,Sqrt}  ;
	Button [] arr2;
	// Trigonometric functions & x^y ;
	Button [] arr3;
	// {"0",".", "%" ,"+"};'
	Button []last_row;     
	
	Rectangle2D visualBounds = Screen.getPrimary().getVisualBounds();
    double width = visualBounds.getWidth();
    double height = visualBounds.getHeight();
    
    public static void main(String[] args) 
    {
    	
    	Application.launch(args);

    }

	//start methoed
	public void start(Stage st) throws Exception {
		
		   initialization();
		     AddToPane();
		     Trigger_event();
		     
		     g.setPadding(new Insets(5, 5, 5, 5));
	 		 g.setHgap(5);
	 	     g.setVgap(5);
	         st.setScene(new Scene(g,width , height));
	         st.setResizable(false);
             st.show();
		
	}

	//-------------------------DESING methods-------------------//
	
	//initialization of all buttons of calculator
	void initialization()
	{
		//set style & initiate "GradePane"
		g = new  GridPane();
		g.setStyle("-fx-background-color: rgb(0,0,0);");
		
		//set style & initiate "text"
		text = new Label();
		text.setPrefHeight(200);
		text.setPrefWidth(width);
		text.setStyle("-fx-background-color: rgb(0,0,0); -fx-font: 15pt Serif;"+""
				+ "-fx-text-fill: rgb(255,32,143);-fx-border-color: rgb(255,32,143);"+"-fx-font: 15pt Serif;");
		text.prefWidthProperty().bind(g.widthProperty());
		text.prefHeightProperty().bind(g.heightProperty().divide(3));
		
		//set style & initiate "the equality button'='"
		 equal = new Button("=");
		 equal.setShape(new Circle(1.5));
		 equal.setStyle(" -fx-background-color: rgb(255,32,143); -fx-font: 13pt Serif;-fx-text-fill: black;");
		 equal.prefWidthProperty().bind(g.widthProperty().divide(3.5));
		 equal.prefHeightProperty().bind(g.heightProperty().divide(6));
		 
		//set style & initiate "arr[]"
		 arr = new Button[10];
		 for(int i =1; i<10 ;i++)
		 {
			
		 	  arr[i]= new Button(Integer.toString(i));
		 	 arr[i].setShape(new Circle(1.5));
		 	  arr[i].setStyle("-fx-background-radius: "+
		   			"0;-fx-background-color: rgb(40, 40, 40); -fx-font: 13pt Serif;-fx-text-fill: rgb(255,32,143);");
		 	  arr[i].prefWidthProperty().bind(g.widthProperty().divide(7));
		 	  arr[i].prefHeightProperty().bind(g.heightProperty().divide(6)); 
		   }
		 
		//set style & initiate "arr2[]"
		 arr2 = new Button[10];
		 for(int i =0; i<10 ;i++)
		 {	
	    	  arr2[i]= new Button();
	    	  arr2[i].setShape(new Circle(1.5));
	    	  if(i==8)
	    		  arr2[8].setStyle("-fx-background-radius: "+
		       "0;-fx-background-color: rgb(40, 40, 40); -fx-text-fill: rgb(255,32,143);-fx-font: 7pt Serif;");
	    	  else
	    		  arr2[i].setStyle("-fx-background-radius: "+
	    			       "0;-fx-background-color: rgb(40, 40, 40); -fx-text-fill: rgb(255,32,143);");
	    	  arr2[i].prefWidthProperty().bind(g.widthProperty().divide(7));
	    	  arr2[i].prefHeightProperty().bind(g.heightProperty().divide(6));
	      } 
		     arr2[0].setText("/");
		     arr2[1].setText("C");        
		     arr2[2].setText("AC");     
		     arr2[3].setText("*");
		     arr2[4].setText("(");
		     arr2[5].setText(")");
		     arr2[6].setText("-");
		     arr2[7].setText("^2");      
		     arr2[8].setText("Sqrt");  
		     
		//set style & initiate "arr3[]"
		  arr3= new Button[4];
         for(int i =0; i<4 ;i++)
         {	
       	  arr3[i]= new Button();
       	arr3[i].setShape(new Circle(1.5));
       	  arr3[i].setStyle("-fx-background-radius: "+
   	      		"0;-fx-background-color: rgb(40, 40, 40); -fx-text-fill: rgb(255,32,143);-fx-font: 9pt Serif;");
       	  arr3[i].prefWidthProperty().bind(g.widthProperty().divide(7));
       	  arr3[i].prefHeightProperty().bind(g.heightProperty().divide(6));
         }
            arr3[0].setText("sin");
	        arr3[1].setText("cos");       
	        arr3[2].setText("tan");     
	        arr3[3].setText("x^y");
	        
	      //set style & initiate "last_row[]"
	        String [] str = {"0",".", "%" ,"+"};
		     last_row= new Button[4];
		     equal.setShape(new Circle(1.5));
		    	 for(int i=0;i<4;i++)
		    	 {
		    		 last_row[i]= new Button(str[i]);
		    		 last_row[i].setShape(new Circle(1.5));
		    		  last_row[i].prefWidthProperty().bind(g.widthProperty().divide(7));
		        	  last_row[i].prefHeightProperty().bind(g.heightProperty().divide(6));
		    		  last_row[i].setStyle("-fx-background-radius: "+
		    	 	"0;-fx-background-color: rgb(40, 40, 40); -fx-text-fill: rgb(255,32,143);");
		    				 
		    	 }   
	        
	}

	//Add button to Grid pane
	void AddToPane()

	{
		//Adding the component on GridePane 
		  g.add(text,0,0,8,1);
		  g.add(equal, 4, 5,2,1);
		
		//adding arr to the pane
		      int k=9;
		       for(int i =2 ;i<=4 ;i++)
		    	 for(int j=2;j>=0;j--)
		    		g.add(arr[k--], j, i);
		      
		//adding arr2 to the pane
		         int a=0;
			    for(int i =2 ;i<=4 ;i++)
			     for(int j=3;j<=5;j++)
			    	g.add(arr2[a++], j, i);  
			     
			    
		 //adding arr3 to the pane
			    for(int i =0; i<4 ;i++)
			    	// g.add(arr3[i], 7, i+2);
			           g.add(arr3[i], 6, i+2);
	    //adding last row to the pane
			    for(int i =0; i<4 ;i++)
			    g.add(last_row[i], i, 5);
		
	}

	//events handling method 
	void Trigger_event()
	{
		  //events for arr[].....
		
		   arr[1].setOnAction(e->{
				text.setText(text.getText()+arr[1].getText());
			});
			    
			arr[2].setOnAction(e->{
				text.setText((text.getText()+arr[2].getText()));
			});


			arr[3].setOnAction(e->{
				text.setText((text.getText()+arr[3].getText()));
			});

			arr[4].setOnAction(e->{
				text.setText((text.getText()+arr[4].getText()));
			});

			arr[5].setOnAction(e->{
				text.setText((text.getText()+arr[5].getText()));
			});

			arr[6].setOnAction(e->{
				text.setText((text.getText()+arr[6].getText()));
			});

			arr[7].setOnAction(e->{
				text.setText((text.getText()+arr[7].getText()));
			});

			arr[8].setOnAction(e->{
				text.setText((text.getText()+arr[8].getText()));
			});

			arr[9].setOnAction(e->{
				text.setText((text.getText()+arr[9].getText()));
				
				});
			
	                //events for arr2[].....	
			  
				arr2[0].setOnAction(e->{
					text.setText((text.getText()+" " +arr2[0].getText()+" "));
				
				});


				arr2[1].setOnAction(e->
				{
					String remind= text.getText();
					try
					{
					      if(Character.isDigit(remind.charAt(remind.length()-1)))
							text.setText(remind.substring(0, remind.length()-1));
					      
					      else
					    	  text.setText(remind.substring(0, remind.length()-3));  
					}
					catch(Exception ex)
					{
						text.setText("");
					}
				
				});	
			
				arr2[2].setOnAction(e->{
					text.setText("");
				
				});

				arr2[3].setOnAction(e->{
					text.setText((text.getText()+" "+arr2[3].getText()+" "));
				
				});

				arr2[4].setOnAction(e->{
					text.setText((text.getText()+arr2[4].getText())+" ");
				
				});

				arr2[5].setOnAction(e->{
					text.setText((text.getText()+" " +arr2[5].getText()));
				
				});

				arr2[6].setOnAction(e->{
					text.setText((text.getText()+" " +arr2[6].getText()+" "));
				
				});

				arr2[7].setOnAction(e->{
					text.setText((text.getText()+" " +"^ 2"));
				
				});

				arr2[8].setOnAction(e->{
					text.setText((text.getText()+arr2[8].getText()));
				
				});
			
				  	  //events for last_row[]....
				
				last_row[0].setOnAction(e->{
					text.setText((text.getText()+last_row[0].getText()));
				
				});
				last_row[1].setOnAction(e->{
					text.setText((text.getText()+" " +last_row[1].getText()));
				});
				
				last_row[2].setOnAction(e->{
					text.setText((text.getText()+" " +last_row[2].getText()+" "));
				
				});	
				last_row[3].setOnAction(e->{
					text.setText((text.getText()+" "+last_row[3].getText()+" "));
				
				});
			
				  //events for arr3[].....
				
			    arr3[0].setOnAction(e->{
				text.setText(text.getText()+arr3[0].getText()+"( ");
			});
			    arr3[1].setOnAction(e->{
			    	text.setText(text.getText()+arr3[1].getText()+"( ");
			    });
			    arr3[2].setOnAction(e->{
			    	text.setText(text.getText()+arr3[2].getText()+"( ");
			    });
			    arr3[3].setOnAction(e->{
			    	text.setText(text.getText()+" ^ ");
			    });
         
		
		           /*         event for the EQUALITY button "="    */
			    //add the 'expensive' function to thread
	new Thread(()->
	{
	    equal.setOnAction(e->{
		Boolean error=false;
			try
				 {	
					for(int i=0;i<text.getText().length();i++)
					 {
						//case: devision of 1/0 --->Error
						if(text.getText().charAt(i)=='/'&& text.getText().charAt(i+2) =='0')		
						{
							text.setText("Error! 'divison by zero'");
							error=true;
							break;
						}
												
			       	}
					if(error==false )
					   { 			
						  text.setText(compute_func(text.getText())+"");
					   }		
				}
		catch (Exception e1) 
			{
			     text.setText("wrong expression ! ");
			}
		});	}).start();			
	}	

	
	//-------------------------Implementations methods-------------------//
	
	//Distinguish operations from numbers	//is operator to check + || -|| *|| /

	public boolean isOperator(String token)  
	  {   return
	   (token.equals("+") || token.equals("-") ||token.equals("*") || token.equals("/") || token.equals("^") || token.equals("%"));            
	 }
   
	/* to know priority of each operation */
	    //evalut 1 and evalute 2 to compute priorites 
	public int evalute1(String token)
	{
		int precedence = 0;
		if(token.equals("+")|| token.equals("-")) {
		    precedence = 2;
		}
		else if(token.equals("/") || token.equals("*") || token.equals("%")) {
		    precedence = 4;
		}
		else if(token.equals("^")) {
		    precedence = 5;
		}
		else if(token.equals("(")) {
		    precedence = 0;
		}
		return precedence;
	}

	public int evalute2(String token) 
	{  
		int precedence = 0;
		if(token.equals("+")|| token.equals("-")) {
		    precedence = 1;
		}
		else if(token.equals("/") || token.equals("*") || token.equals("%")) {
		    precedence = 3;
		}
		else if(token.equals("^")) {
		    precedence = 6;
		}
		return precedence;
	}

	//this function change expression to string"using postfix to infix algorithm 
	 //this is methed depend on Infix Algorithem EX convert("3+5") return "53+"; 
public String Postfix_To_Infix (String expression)
{
	 expression=Sqrt(expression);
	 expression=Trigonometric_functions(expression);
	String [] str= expression.split(" ");
	String converted="";
	 Stack<String> st = new Stack<>();

	 for(int i=0 ; i<str.length ; i++)
     {
		 
	     String token = str[i];
	     if(token.equals("(")) {
	    	 st.push(new String(token));
	     }
	     else if(token.equals(")")) {
	         while(st.peek().equals("(") != true) {
	                 converted = converted + " " + st.pop();
	             }
	         if(st.peek().equals("(")) {
	        	 st.pop();
	         }
	     }
	     else if (isOperator(token)){
	         if(st.isEmpty() == true) {
	             st.push(new String(token));
	         }
	         else {
	             if(evalute2(token) < evalute1((String)st.peek())) {
	                 converted = converted + " " + st.pop();
	                 st.push(token);
	             }
	             else {
	                 st.push(new String(token));
	             }
	         }
	     }
	     else {
	         converted = converted + " " + new String(token);
	     }
	 }
	 while(st.isEmpty() != true) {
	     converted = converted + " " + st.pop();
	     }
    
	 return converted;
	 }

                         /* ......................... */
             //Evaluate infix  EX: 53+ return 8;
@SuppressWarnings({ "unchecked", "rawtypes" })   
double compute_func(String expression)   throws EmptyStackException{
	 {
	    double n1,n2;

		
		String[] tokens = Postfix_To_Infix(expression).split(" ");
	      Stack st=new Stack();
	    for(int i=0;i!= tokens.length;i++)
	    {
	  if(!isOperator(tokens[i]))
	        {
	            st.push( tokens[i]);
	        
	        }
     else 
	       {
	              
	            n1=Double.parseDouble((st.peek().toString()));
	            st.pop();
	            n2=Double.parseDouble((st.peek().toString()));
	            st.pop();
	 		switch (tokens[i]) {
	 		case "+":
	 			
	 			st.push(n2+n1);
	 			break;
	 			
	          case "-":
	 			
	        	  st.push(n2-n1);
	  			break;
	          case "*":
	  			
	        	  st.push(n1*n2);
	  			break;
	          case "/":
	  			
	        	  st.push(n2/n1);
	  			break;
	          case "%":
	        	  st.push(n2%n1);
	  			break;
	          case "^":
	        	  st.push(Math.pow(n2,n1));
	                break;
	          
	 		}
	        
	      }
	   }
	    return Double.parseDouble((st.pop().toString()));
    }

}


  //compute sqrt 
    // 3*5*2  
public String Sqrt(String finalexp)
{
	int firstDigitOfNumber;
	 String first="";
	String number="";
	String second="";
	String exp="";
	//handing the case of many  '('
	int count;
	char pract;
	for(int i=0;i<finalexp.length();i++)
	    {
		count=0;
	    	if(finalexp.charAt(i)=='S')
	    	{
	    		//case:expression with "("
	    		if(finalexp.charAt(i+4)=='(')
	    		{
	    			count++;
	    			for(int j=i+5;j<finalexp.length();j++)
	    			{
	    				pract=finalexp.charAt(j);
	    				if(pract==')') 
	    					{count--;}
	    				
	    				if(count==0)
	    					{
	    					exp=finalexp.substring(i+4,j+1);
	    			        number=compute_func(exp)+"";
	    			        number=Math.sqrt(Double.parseDouble(number))+"";
	    			        second=finalexp.substring(j+1, finalexp.length());
	    			          break;
	    					}
	    				if(pract=='(')
    					{count=count+1;}
    				
	    			}
	    		}
	    	else //case:expression without "("
	    		{
	    	  
		    		for(firstDigitOfNumber=i+4;firstDigitOfNumber<finalexp.length

  ()&&Character.isDigit(finalexp.charAt(firstDigitOfNumber));firstDigitOfNumber++)
		    		{
		    			//concatenate
		    			
		    			 number=number+finalexp.charAt(firstDigitOfNumber);
		    			
		    		}
		    
		    		 if(firstDigitOfNumber<finalexp.length())
			    		{
		 		    second=finalexp.substring(firstDigitOfNumber, finalexp.length());
			    		} 
		    	
		    		
	    			number=Math.sqrt(Double.parseDouble(number))+"";
	    		
	    		}
	    	
	    	
	    	 first=finalexp.substring(0, i);
	    	
	finalexp=first+number+second;
	    	}
	    
}
	
	  return finalexp;
}

//computing the Trigonometric functions
// 3*5*.5 
public String Trigonometric_functions(String finalexp)

{
	 String first="";
	 String number="";
	 String second="";
	 String exp="";
	 //to handle case of many practices '('
	int count;
	char pract;
	for(int i=0;i<finalexp.length();i++)
	    {
	    	if(finalexp.charAt(i)=='s' || finalexp.charAt(i)=='c' || finalexp.charAt(i)=='t')
	    	{
	    		count=0;
	    		char op=finalexp.charAt(i);
	    		if(finalexp.charAt(i+3)=='(')
	    		{
	    			count++;
	    			for(int j=i+4;j<finalexp.length();j++)
	    			{
	    				pract=finalexp.charAt(j);
	    				if(pract==')') 
	    					{count--;}
	    				
	    				if(count==0)
	    					{
	    					exp=finalexp.substring(i+3,j+1);
	    			        number=compute_func(exp)+"";
	    			        if(op=='s')
	    			      number=Math.sin(Double.parseDouble(number)*Math.PI/180)+"";
	    			        if(op=='c')
	    			         number=Math.cos(Math.toRadians(Double.parseDouble(number)))+"";
	    			        if(op=='t')
	    			        number=Math.tan(Double.parseDouble(number)*Math.PI/180.0)+"";
	    			        second=finalexp.substring(j+1, finalexp.length());
	    			          break;
	    					}
	    				if(pract=='(')
    					{count=count+1;}
	    			}
	    		}
	    	
	    	
	    	
	    	 first=finalexp.substring(0, i);
	    //re concatenating the expression 	
	finalexp=first+number+second;
	    	}
	    
    }
	// return the expression after computing Trigonometric_functions
	  return finalexp;
 }

}
	
//-------------------------------------------END-----------------------------------//
	



	





	
