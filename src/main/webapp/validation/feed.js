function feedback(){
		
		var name=document.getElementById('name');
		var email=document.getElementById('email');
		var msg=document.getElementById('msg');
		if(isAlphabet(name, "Please enter only letters for your name")) 
        {
					if(emailValidator(email, "Please enter a valid email address"))
                {
							
						if(msgmy(msg,"Please Enter The Message")){
							return true;
						}
						
                }
		
        }return false;
				
	
}
function isAlphabet(elem, helperMsg)
{
	var alphaExp = /^[a-zA-Z]+$/;
	 if(isNaN(elem.value))
            {
		return true;
	}      else
                  {
		alert(helperMsg);
		elem.focus();
		return false;
	      }
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

function msgmy(elem,helperMsg){
	
	  var a = elem.value;
	  
      if(a=="")
     {
    	 alert(helperMsg);
		elem.focus();
		return false;
		
	}else{
		return true;
		
	}
	
}
