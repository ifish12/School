package  {
	
	import flash.display.MovieClip;
	import flash.events.*;

	public class Car extends MovieClip {
		
		var dir:int = new int;
		
		public function Car()
		{
			// constructor code
			trace("Car!");
			
			this.addEventListener(Event.ENTER_FRAME ,Go);
		}
		function Move(w:int)
		{
			dir = w;
			
		}
		
		 function Go (e:Event):void
		 {
			 switch(dir)
			 {
				 
				 case 1:
				 	this.y--;
				 	break;
				 case 2:
				 	this.y++;
					break;
				case 3:
					this.x++;
					break;
				case 4:
					this.x--;
					break;
					
				default:
					trace("This is the default");
					break;
				 
				 
			 }
		 }
		
	}
	
}
