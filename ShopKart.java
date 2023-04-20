import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.*;
class priceComparator implements Comparator
{
	//@override
	public int compare(Object o1, Object o2)
	{
		Product temp1 = (Product) o1;
		Product temp2 = (Product) o2;
		if (temp1.getprice()>temp2.getprice())
		{return 1;
		}
		if (temp1.getprice() < temp2.getprice())
		{
			return -1;
		}
		return 0;
}
}

class  nameComparator implements Comparator
{
	//@override
	public int compare(Object o1, Object o2)
	{
		Product temp1 = (Product) o1;
		Product temp2 = (Product) o2;
		return (temp1.getname()).compareTo(temp2.getname());
	}
}

class Product 
{
  private String name;
  private double price;
  private int rating;

 public void setname(String name) throws IllegalArgumentException
	{
        for(int i=0; i<name.length();i++)
		{
			if ((name.charAt(i)>= 65 && name.charAt(i) <=90) || (name.charAt(i)>= 97 && name.charAt(i) <=122))
			{
				continue;
			}
			else 
			{
				throw new IllegalArgumentException("Please enter valid name");
			}
		}
		this.name=name;
	}

	public String getname()
	{
		return this.name;
	}

public void setprice(double price) throws IllegalArgumentException
	{
	if ( price >= 0000.00 && price <= 1000.00)
	{
		this.price=price;
	}
		else
		{
			throw new  IllegalArgumentException ("Please enter price between 0000.00 to 1000.00 range only.");
		}

	}

public double getprice()
	{
	return this.price;
	}

	public void setrating( int rating) throws IllegalArgumentException,InputMismatchException
	{
      if (rating >=0 && rating <=5)
      {
		  this.rating = rating;
      }
	  else
		{
		  throw new IllegalArgumentException("Pls Enter Rating Between range 0 to 5 only") ;
		}
	}

	
public String toString()
	{
	   return "Name: "+name+" ,Price: "+price+",Rating: "+rating;
	}
}

//ShopKart

class ShopKart
{
	public static void main(String[]args)
	{
        ArrayList <Product> product1= new ArrayList<Product> ();
		int choice =0;
		Scanner inp = new Scanner (System.in);

		do{
			System.out.println("\n==============================================");
			System.out.println("\t\tHello Welcome to ShopKArt");
				System.out.println("==============================================");
			System.out.println(" 1.Press one to add product");
            System.out.println("2.Press Two to Delete product");
			System.out.println("3.Press Three to Update the Product Details ");
			System.out.println("4.press Four to sort the Product");
			System.out.println("5.Press Five to view product list");
			System.out.println("6.Press Six to Exit");

			try
			{
				choice= inp.nextInt();
			}
			catch (InputMismatchException e)
			{
				System.out.println("Pls Enter Choice From Above List");
				inp.nextLine();
				continue;
			}
			switch(choice)
			{
				case 1: System.out.println("Enter name of product");
				            String name= inp.next();
							Product product = new Product();
				          try
				          {
							product.setname(name);
				          }
				          catch ( IllegalArgumentException e)
				          {
							  System.out.println(e.getMessage());
							  continue;
				          }

				          System.out.println("Enter price of product");
                           double price =0.0;
						  try{
						   price= inp.nextDouble();
						      
						  }
						  catch(InputMismatchException e)
				          {
							 System.out.println("pls Enter Valid Price");
							 inp.nextLine();
							 continue;
						  }


						  try
						  {
							product.setprice(price);
						  }

						  catch (IllegalArgumentException e)
						  {
							  System.out.println(e.getMessage());
							  continue;
						  }
						  
						  System.out.println("Enter rating of product");
						  int rating = 0;
						  try {
						  rating= inp.nextInt();
						  }
						  catch(InputMismatchException e)
				          {
							  System.out.println("Pls Enter rating Between 0 to 5");
							  inp.nextLine();
						  }
						  try
						  {
							product.setrating(rating);
						  }
						  catch (IllegalArgumentException e)
						  {
							  System.out.println(e.getMessage());
							  continue;
						  }

						  product1.add(product);
						  System.out.println("Product Added.");
						  break;
             case 2:  System.out.println("Enter the product name ");
			            String delname = inp.next();
						boolean found=false;
						for( Product p1:product1)
				{
							if (delname.equals(p1.getname()))
						{
								product1.remove(p1);
								System.out.println("Product Removed");
								found= true;
								break;
						}
				}
				if(!found)
				{System.out.println("Product not found");
				}
				break;
				case 3: System.out.println("Enter the product name to update the details");
				         String upname= inp.next();
						 boolean found2=false;
                         for( Product p1: product1)
				{
							 if (upname.equals(p1.getname()))
							 {   found2 =true;
                                  int choice2 = 0;
								  do 
								 {
									  System.out.println("press 1 to edit name");
									  System.out.println("press 2 to edit price");
									  System.out.println("press 3 to edit ratings");
									  System.out.println("press 4 to exit");
								  try
								  {
									choice2= inp.nextInt();
								  }
								  catch (InputMismatchException e)
								  {
                                     System.out.println("Enter the valid Choice");
									 inp.nextLine();
									 continue;
								  }
								  switch(choice2)
									 {
								  case 1: System.out.println("enter name");
                                
								  	           String upname2= inp.next();
											   try{
										   p1.setname(upname2);
											   }
											   catch(IllegalArgumentException e)
										 {
												   System.out.println("pls enter valid name");
												   inp.nextLine();
												   continue;
										 }
										   break;
								  case 2: System.out.println("enter price");
								  double price2= 0.0;
								  try{
								            price2 = inp.nextDouble();
								  }  catch(InputMismatchException e)
										 {  System.out.println("Enter valid price which range between 0.0 to 1000.0");
								              inp.nextLine();
											  continue;
										 }
										   p1.setprice(price2);
										   break;
								 case 3:System.out.println("enter ratings ");
								 int rating2=0;
								 try{
								          rating2= inp.nextInt();
								 }catch(InputMismatchException e)
										 { System.out.println("you can rate only  Between 0 to 5");
								             inp.nextLine();
										 }
										 try{
										 p1.setrating(rating2);
										 }
										 catch(IllegalArgumentException e)
										 {  System.out.println("enter valid rating ");
										     continue;
										 }
											
										  break;
                                  case 4: System.out.println("Exiting...");
								            break;
                                     default : 
										 System.out.println("pls enter valid choice");
									      break;
									 }
								 }while(choice2 != 4);
								 break;
							 }
							 if (!found2)
					{ System.out.println("Product not found");
					}
				}
					break;
					case 4: System.out.println("enter the state for sorting");
					           String inpsort = inp.next();
							        inpsort= inpsort.toLowerCase();
							   switch(inpsort){
								    case "price": Collections.sort(product1, new priceComparator());
									       for(Product p1: product1)
								   {   System.out.println(p1);
								   }
								     break; 

									 case "name" :  Collections.sort(product1,new nameComparator());
									  for(Product p1: product1)
								   {   System.out.println(p1);
								   }
								   break;

									 default :
										    System.out.println("pls enter valid choice");
									 break;

				                 }
								 break;
                        
                   case 5:  System.out.println("\t\tALL Range Of Products");
				                System.out.println("=======================================");
				                 for(Product p1: product1)
								   {   System.out.println(p1);
								   }
								   break;
				           
                     case 6: System.out.println("Exiting....");
					          break;

                  default : 
					         System.out.println("pls Enter valid choice");
				  break;
				         
				}
		}while(choice != 6);
	}
	
}

