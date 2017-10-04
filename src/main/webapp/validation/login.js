function formValidator(){

	var pass=document.getElementById('pass');
	var email=document.getElementById('email');
	var typ=document.getElementById('type');


			if(emailValidator(email, "Please enter a valid email address")){
						
					if(madeSelection(typ, "Please Select a Account Type"))
	                										{
	                											return true;
	                										}
				
			}

return false;
}

              function emailValidator(elem, helperMsg)
             {
	   var emailExp = /^[\w\-\.\+]+\@[a-zA-Z0-9\.\-]+\.[a-zA-z0-9]{2,4}$/;
	   if(elem.value.match(emailExp))
                {
		return true;
	  }
                   else
                  {
		alert(helperMsg);
		elem.focus();
		return false;
	   }
        }


         function madeSelection(elem, helperMsg)
             {
	      if(elem.value == "Select")
                   {
		alert(helperMsg);
		elem.focus();
		return false;
	     }
                      else
                    {
		return true;
	      }
	}      
