package
{
	import flash.events.MouseEvent;
	import flash.display.MovieClip;
	import flash.display.SimpleButton;
	
	
	public class docclass extends MovieClip 
	{
		var Car:symCar = new symCar; 
		var btnArcBlue:btnLeft = new btnLeft;
		var btnArcGreen:btnRight = new btnRight;
		var counter = new int;
		var Moving = new int;
		var changer = new int;
		
		public function docclass()
		{
			Moving = 5;
			changer = 5;
			counter = 0;
		    
			trace("Docclass constructor created!!");
			
			
			Car.x = 10;
			Car.y = 400;
			
		    btnArcBlue.x = 100;
			btnArcBlue.y = 750;
			
			btnArcGreen.x = 500;
			btnArcGreen.y = 750;
			
			stage.addChild(Car);
			stage.addChild(btnArcBlue);
			stage.addChild(btnArcGreen);
			
			
			btnArcBlue.addEventListener(MouseEvent.CLICK, ClickHandlerLEFT);
			btnArcGreen.addEventListener(MouseEvent.CLICK, ClickHandlerRIGHT);

			

		}
	     function ClickHandlerLEFT(e:MouseEvent):void
		 {
				trace("moving by initial amount");
				Car.x += changer;
				
		 }
		 
		  function ClickHandlerRIGHT(e:MouseEvent):void
		 {
				trace("Changing the move by 5");
				changer = Moving + changer;
				counter++;
				if ( counter > 5)
				{
					btnArcGreen.visible = false;
				}
		 }
	}
}