package
{
	import flash.events.MouseEvent;
	import flash.display.MovieClip;
	import flash.display.SimpleButton;
	
	public class docclass extends MovieClip 
	{
		var Cartopdown:btnClass = new btnClass; 
		public function docclass()
		{
			
			trace("Docclass constructor created!!");
   
			var btnArcBlue:btnMoving = new btnMoving;
			var btnArcGreen:btnMovingDown = new btnMovingDown; 
			
			
			
			Cartopdown.x =200;
			Cartopdown.y = 200;
			
		    btnArcBlue.x =150;
			btnArcBlue.y = 550;
			
			btnArcGreen.x = 150;
			btnArcGreen.y = 650;
			
			stage.addChild(Cartopdown);
			stage.addChild(btnArcBlue);
			stage.addChild(btnArcGreen);
			
			
			btnArcBlue.addEventListener(MouseEvent.CLICK, ClickHandlerUP);
			btnArcGreen.addEventListener(MouseEvent.CLICK, ClickHandlerDOWN);

			

		}
	     function ClickHandlerUP(e:MouseEvent):void
		 {
				trace("Up button has been actuated");
				
				Cartopdown.y -= 10;
		 }
		 
		  function ClickHandlerDOWN(e:MouseEvent):void
		 {
				trace("Down button has been actuated");
				
				Cartopdown.y += 10;
		 }
//		 
//		  function ClickHandlerLEFT(e:MouseEvent):void
//		 {
//				trace("Left button has been actuated");
//				btnArcGreen.buttonMode = true;
//				Cartopdown.x += 10;
//				
//		 }
//		
//		 function ClickHandlerRIGHT(e:MouseEvent):void
//		 {
//				trace("Right button has been actuated");
//				btnArcYellow.buttonMode = true;
//				Cartopdown.x -= 10;
//				
//		 }
//		
		// here put your event handler.
		
	}
	
}