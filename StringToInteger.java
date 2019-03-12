import java.util.regex.Matcher;
import java.util.regex.Pattern;
class StringToInteger{
 public  int myAtoi(String str) {
    	    	
boolean char2_flag = false;
           boolean char1_flag = false;
           String temp_str =null;
           String temp_str2 = null;
    	
       str  = str.trim();
       int  dot_index = 0;
       
       int return_int = 0;
       if(str.length()<1)
       {
           return 0;
       }

       else
       {
    	dot_index  = str.indexOf('.');
    	str  = str.trim();
    	if(dot_index != -1)
        {
           str = (str.substring(0,dot_index));
        }
    	if(str.length()<1)
        {
            return 0;
        }
    	
         temp_str = String.valueOf(str.charAt(0));
        if(str.length()>1){ temp_str2 = String.valueOf(str.charAt(1));}
        else{
        	char2_flag = true;
        }
        
     
        if(str.length()>1)
        {
         if(temp_str.matches("[0-9]")){
        	 char2_flag = true;
        	 char1_flag = true;
         }
         else if (temp_str.matches("[+-]") && !char2_flag && temp_str2.matches("[0-9]"))
         {
        	 char2_flag = true;
        	 char1_flag = true;
         }
        	
        }
        else if(temp_str.matches("[0-9]")  ){
        	char2_flag = true;
       	 char1_flag = true;
        }
        
           if(char1_flag && char2_flag )
           {
        	   Matcher matcher = Pattern.compile("[+-]?[0-9]+").matcher(str);
               if(matcher.find())
               {
                  String  g1 = matcher.group(0);
                  if (temp_str.equalsIgnoreCase("+"))
                  {
                	  try{
                		  return_int = Integer.parseInt(g1);
                	  }
                	  catch(Exception e)
                	  {
                		  return Integer.MAX_VALUE;
                	  }
                  }
                  else if (temp_str.equalsIgnoreCase("-"))
                      {
                	  try{
                		  return_int = Integer.parseInt(g1);
                	  }
                	  catch(Exception e)
                	  {
                		  return Integer.MIN_VALUE;
                	  }
                    	  
                      }
                	  else{
                		  try{
                    		  return_int = Integer.parseInt(g1);
                    	  }
                    	  catch(Exception e)
                    	  {
                    		  return Integer.MAX_VALUE;
                    	  }
                		  
                	  }
                  return_int = Integer.parseInt(g1);
                  
               }
               
           }
           
       }
	return return_int;
   }
}